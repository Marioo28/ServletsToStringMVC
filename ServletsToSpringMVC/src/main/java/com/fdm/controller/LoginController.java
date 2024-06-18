package com.fdm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdm.model.User;
import com.fdm.service.LoginService;
import com.fdm.service.UserService;

@Controller
public class LoginController {

	private final LoginService loginService;
	private final UserService userService;

	@Autowired
	public LoginController(LoginService loginService, UserService userService) {
		this.loginService = loginService;
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ModelAndView login(HttpServletRequest request, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("language") String language) {

		User user = userService.getUser(username);

		ModelAndView mv = new ModelAndView();
		if (!loginService.verifyUser(username, password)) {
			mv.setViewName("login");
			mv.addObject("message", "Username or Password invalid.");
			return mv;
		}
		request.getSession().setAttribute("language", language);

		if (user.getType().equals("admin")) {
			request.getSession().setAttribute("auth", "admin");
		} else {
			request.getSession().setAttribute("auth", "user");
		}
		request.getSession().setAttribute("user", user);
		mv.addObject("message", "Login successful");
		mv.setViewName("welcomeAdministrator");
		return mv;
	}

	@RequestMapping("/welcomeAdministrator")
	public String welcomeAdministrator() {
		return "welcomeAdministrator";
	}

	@RequestMapping("/logout")
	public ModelAndView logoutUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("auth");
		session.removeAttribute("user");
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "Logout successful");
		mv.setViewName("login");
		return mv;
	}

}
