package com.fdm.service;

import org.springframework.stereotype.Service;

@Service
public class TranslationService {

	public String getTranslation(Message message, String language) {
		switch (message) {
		case USER_MINIMUM_5_CHARACTERS:
			if (language.equalsIgnoreCase("ro")) {
				return "Numele de utilizator trebuie sa aibe minim 5 caractere";
			} else {
				return "Username must have minimum 5 characters";
			}
		default:
			return "Nu exista traducere";
		}
	}

}
