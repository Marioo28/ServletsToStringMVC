package com.fdm.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdm.model.User;
import com.fdm.service.UserService;

@Controller
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/add-user")
	public String addUser() {
		return "addUser";
	}

	@RequestMapping("/user")
	public ModelAndView addUser(HttpServletRequest request, @RequestParam("username") String username,
			@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
			@RequestParam("password") String password, @RequestParam("age") int age,
			@RequestParam("type") String type) {
		
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String language = (String) session.getAttribute("language");
		
		User newUser = new User(username, firstname, lastname, password, age, type);
		String checkMessage = userService.checkNewUser(newUser, language);
		if (!checkMessage.equals("Utilizator valid")) {
			mv.addObject("message", checkMessage);
			mv.setViewName("addUser");
			return mv;
		}

		userService.addUser(newUser);

		Set<User> users = userService.getAllUsers();

		mv.addObject("users", users);
		mv.addObject("message", "Utilizator adaugat");
		mv.setViewName("users");
		return mv;
	}

	@RequestMapping("/update-user")
	public ModelAndView getUserForm(@RequestParam("username") String username) {
		User user = userService.getUser(username);

		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("update-user");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "update-user")
	public ModelAndView updateUser(@RequestParam("username") String username,
			@RequestParam("newFirstName") String newFirstName, @RequestParam("newLastName") String newLastName,
			@RequestParam("newPassword") String newPassword, @RequestParam("newAge") int newAge,
			@RequestParam("newType") String newType) {

		User user = userService.getUser(username);
		user.setFirstName(newFirstName);
		user.setLastName(newLastName);
		user.setPassword(newPassword);
		user.setAge(newAge);
		user.setType(newType);

		userService.updateUser(user);

		Set<User> users = userService.getAllUsers();
		ModelAndView mv = new ModelAndView();
		mv.addObject("users", users);
		mv.addObject("message", "Utilizator actualizat");
		mv.setViewName("users");
		return mv;
	}

	@RequestMapping("/delete-user")
	public ModelAndView deleteUser(@RequestParam("username") String username) {
		userService.deleteUser(username);
		Set<User> users = userService.getAllUsers();

		ModelAndView mv = new ModelAndView();
		mv.addObject("users", users);
		mv.addObject("message", "Utilizator sters");
		mv.setViewName("users");

		return mv;
	}

	@RequestMapping("/users")
	public ModelAndView getAllPieces() {

		Set<User> users = userService.getAllUsers();
		ModelAndView mv = new ModelAndView();
		mv.addObject("users", users);
		mv.setViewName("users");

		return mv;
	}

}
