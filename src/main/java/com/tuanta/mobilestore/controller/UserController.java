package com.tuanta.mobilestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tuanta.mobilestore.repository.UserRepository;
import com.tuanta.mobilestore.repository.UserRepositoryImpl;

@Controller
public class UserController {

	@Autowired
	UserRepositoryImpl repo;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String loginPage(Model model) {

		return "login";
	}

	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String homePage(@RequestParam(name = "username") String userName,
			@RequestParam(name = "password") String password, Model model) {
		boolean result = repo.checkLogin(userName, password);
		if (result) {
			return "productList";
		} else {
			return "login";
		}

	}
}
