package id.equity.RestExample.configs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import id.equity.RestExample.dto.user.LoginDTO;
import io.swagger.models.Response;



public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	@Autowired
	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, 
			HttpServletResponse response)
			throws AuthenticationException {
		try {
			LoginDTO loginDTO = new ObjectMapper().
					readValue(request.getInputStream(), LoginDTO.class);
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							loginDTO.getUsername(),
							loginDTO.getPassword(),
							new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, 
			HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		//Generate Token
		
		//String Token
		//import org.springframework.security.core.userdetails.User;
		String token = JWT.create()
				.withSubject(((User) authResult.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+ SecurityConstants.EXPIRED_TIME ))
                .sign(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()));
		//Responde Header
		//response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
		//Body 
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(
	                "{\"" + SecurityConstants.HEADER_STRING + "\":\"" + SecurityConstants.TOKEN_PREFIX+ token + "\"}"
	        );
	}
	
	
	
	
}
