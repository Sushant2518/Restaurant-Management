package com.masai.Services;

import java.util.List;

import com.masai.dto.LoginDTO;
import com.masai.model.User;



public interface UserService {
	public User addUser(User user);
	public User update(User user) ;
	public List<User> findAllUser();
	public User findByEmail(String email);
	public User deletUser(String email);
	public String login(LoginDTO logindto);
}
