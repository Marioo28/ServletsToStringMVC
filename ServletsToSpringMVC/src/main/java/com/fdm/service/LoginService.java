package com.fdm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdm.model.User;
import com.fdm.repository.UserRepo;

@Service
public class LoginService {

	private final UserRepo userRepository;

	@Autowired
	public LoginService(UserRepo userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public boolean verifyUser(String username, String password) {
		User user = userRepository.getByUsername(username);

		if (user != null) {
			if (password.equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
