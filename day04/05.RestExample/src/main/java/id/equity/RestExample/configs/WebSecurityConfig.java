package id.equity.RestExample.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Pasang Filter
		http.cors().and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/api/v1/roles").permitAll()
		.antMatchers(HttpMethod.GET,"/api/v1/roles").permitAll()
		.anyRequest().authenticated();
		//.anyRequest().permitAll();
//		//Exclude Swagger 
//		.antMatchers(
//                HttpMethod.GET,
//                "/v2/api-docs",
//                "/swagger-resources/**",
//                "/swagger-ui.html**",
//                "/webjars/**",
//                "favicon.ico").permitAll()
//		//Exclude Register user
//		.antMatchers(HttpMethod.POST,"/api/v1/users").permitAll()
//		.anyRequest()
//		.authenticated().and()
//		//.addFilter(new JWTAuthenticationFilter(authenticationManager()))
//		//.addFilter(new JWTAuthorizationFilter(authenticationManager()))
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		//Get Username and password From DB
//	}

	
	
	
}
