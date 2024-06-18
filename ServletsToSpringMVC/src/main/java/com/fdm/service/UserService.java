package com.fdm.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdm.model.User;
import com.fdm.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final TranslationService translationService;

	@Autowired
	public UserService(UserRepository userRepository, TranslationService translationService) {
		this.userRepository = userRepository;
		this.translationService = translationService;
	}

	public Set<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	public void addUser(User user) {
		userRepository.addUser(user);
	}

	public void updateUser(User user) {
		userRepository.updateUser(user);
	}

	public User getUser(String username) {
		return userRepository.getUser(username);
	}

	public void deleteUser(String username) {
		userRepository.deleteUser(username);
	}

	public String checkNewUser(User newUser, String language) {

		if (newUser.getUsername() == null || newUser.getUsername().trim().isEmpty()
				|| newUser.getUsername().trim().length() < 3) {
			return translationService.getTranslation(Message.USER_MINIMUM_5_CHARACTERS, language);
		}

		if (newUser.getFirstName() == null || newUser.getFirstName().trim().isEmpty()
				|| newUser.getFirstName().trim().length() < 3) {
			return "Prenumele este gol sau contine doar spatii sau are mai putin de 3 caractere";
		}
		if (newUser.getLastName() == null || newUser.getLastName().trim().isEmpty()
				|| newUser.getLastName().trim().length() < 3) {
			return "Numele de familie este gol sau contine doar spatii sau are mai putin de 3 caractere";
		}
		if (newUser.getPassword() == null || newUser.getPassword().trim().isEmpty()
				|| newUser.getPassword().trim().length() < 4) {
			return "Parola nu poate fi goala, necesar 4 caractere";
		}
		if (newUser.getAge() <= 18 || newUser.getAge() > 100) {
			return "Vârsta invalida, limita este între 18-100 ani";
		}
		return "Utilizator valid";
	}
}
