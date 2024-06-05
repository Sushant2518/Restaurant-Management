package com.masai.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.RolesAndAuthorityRepository;
import com.masai.Services.RolesAndAuthorityService;
import com.masai.model.RolesAndAuthority;


@Service
public class RolesAndAuthorityServiceImpl implements RolesAndAuthorityService {
	@Autowired
    private RolesAndAuthorityRepository rar;
	@Override
	public RolesAndAuthority findByName(String name) {
		// TODO Auto-generated method stub
		return rar.findByName(name).orElseThrow(()->new RuntimeException("Role Not Found"));
	}

}
