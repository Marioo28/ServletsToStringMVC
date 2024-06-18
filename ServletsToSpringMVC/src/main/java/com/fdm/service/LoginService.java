package com.fdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdm.model.User;
import com.fdm.repository.UserRepository;

@Service
public class LoginService {

	private final UserRepository userRepository;

	@Autowired
	public LoginService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public boolean verifyUser(String username, String password) {
		User user = userRepository.getUser(username);

		if (user != null) {
			if (password.equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
