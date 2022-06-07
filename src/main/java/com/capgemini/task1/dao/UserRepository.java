package com.capgemini.task1.dao;

import java.util.List;

import com.capgemini.task1.dto.UserDTO;
import com.capgemini.task1.entity.User;

public interface UserRepository {
	int createUser(User user);
	List<User> getUsers();
	User getUserById(int id);
}
