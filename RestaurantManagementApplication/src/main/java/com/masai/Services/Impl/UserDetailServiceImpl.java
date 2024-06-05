package com.masai.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.Repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
    private UserRepository ur;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return ur.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("userNotFound"));
	}

}
