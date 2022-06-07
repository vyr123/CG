package com.capgemini.task1.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.task1.dto.UserDTO;
import com.capgemini.task1.entity.User;
import com.capgemini.task1.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class CustomerController {
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	UserServiceImpl userServiceImpl;
	@PostMapping("create-user")
	public ResponseEntity<Integer> createUser(@RequestBody Map<String,Object> user)
	{
		try {
			logger.info("createUser method ca {}");
			UserDTO userDTO=new UserDTO();
			userDTO.setFirstName(null);
		      return new ResponseEntity<>(userServiceImpl.createUser(userDTO), HttpStatus.CREATED);
		    } catch (Exception e) {

				logger.info("createUser exception {}", e.getMessage());
		      return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@GetMapping("list-users")
	public ResponseEntity<List<User>> getUsers()
	{
		try {
			logger.info("getUsers method ca {}");
		      return new ResponseEntity<>(userServiceImpl.getUsers(), HttpStatus.CREATED);
		    } catch (Exception e) {

				logger.info("createUser exception {}", e.getMessage());
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
}
