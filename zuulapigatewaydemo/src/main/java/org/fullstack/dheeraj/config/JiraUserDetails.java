package org.fullstack.dheeraj.config;

import java.util.List;

import org.fullstack.dheeraj.model.SecurityUser;
import org.fullstack.dheeraj.model.User;
import org.fullstack.dheeraj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JiraUserDetails implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> customer = userRepository.findByEmail(username);
		if(customer.size()==0) {
			throw new UsernameNotFoundException("username not found "+username);
		}
		return new SecurityUser(customer.get(0));
	}
	
	
}
