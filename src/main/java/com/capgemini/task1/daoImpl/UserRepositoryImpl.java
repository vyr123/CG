package com.capgemini.task1.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.task1.dao.UserRepository;
import com.capgemini.task1.dto.UserDTO;
import com.capgemini.task1.entity.User;
@Repository
public class UserRepositoryImpl implements UserRepository{

	  @Autowired
	  private JdbcTemplate jdbcTemplate;
	@Override
	public int createUser(User user) {
		 return jdbcTemplate.update("INSERT INTO users (firstName, lastName, email,password) VALUES(?,?,?,?)",
			        new Object[] { user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword() });
			 
	}

	@Override
	public List<User> getUsers() {
		 return jdbcTemplate.query("SELECT * from users", BeanPropertyRowMapper.newInstance(User.class));
		 
	}

	@Override
	public User getUserById(int id) {
		  try {
		      User tutorial = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?",
		          BeanPropertyRowMapper.newInstance(User.class), id);
		      return tutorial;
		    } catch (IncorrectResultSizeDataAccessException e) {
		      return null;
		    }
	}



}
