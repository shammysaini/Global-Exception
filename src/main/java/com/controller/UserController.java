package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.InvalidInputException;
import com.exception.ResourceNotFoundException;
import com.model.User;
import com.repository.UserRepository;

@RestController
public class UserController {
	
	private UserRepository userRepository;
	@Autowired
	UserController(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(value = "id") Long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
	}

	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		if (user.getName() == null || user.getName().isEmpty()) {
			throw new InvalidInputException("User name is required");
		}
		return userRepository.save(user);
	}

}
