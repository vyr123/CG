package com.capgemini.task1.service;

import java.util.List;

import com.capgemini.task1.dto.UserDTO;
import com.capgemini.task1.entity.User;

public interface UserService {

	int createUser(UserDTO user);
	List<User> getUsers();
	User getUserById(int id);
}
