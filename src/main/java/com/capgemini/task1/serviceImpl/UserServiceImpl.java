package com.capgemini.task1.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.task1.daoImpl.UserRepositoryImpl;
import com.capgemini.task1.dto.UserDTO;
import com.capgemini.task1.entity.User;
import com.capgemini.task1.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepositoryImpl userRepositoryImpl;
	@Override
	public int createUser(UserDTO userDTO) {
		User user=new User();
		user.setId(userDTO.getId());
		user.setEmail(userDTO.getEmail());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPassword(userDTO.getPassword());
		return userRepositoryImpl.createUser(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepositoryImpl.getUsers();
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
