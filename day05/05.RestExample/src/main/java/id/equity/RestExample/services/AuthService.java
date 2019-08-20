package id.equity.RestExample.services;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import id.equity.RestExample.Repository.UserRepository;
@Service
public class AuthService implements UserDetailsService {
	
	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		id.equity.RestExample.models.User user  = UserRepository.findByUserName(username);
		if (user==null) {
			throw new UsernameNotFoundException(username);
		}
		//import org.springframework.security.core.userdetails.User;
		return new User(
				user.getUserName(),
				user.getPassword(),
				Collections.emptyList()
		);
	}

}
