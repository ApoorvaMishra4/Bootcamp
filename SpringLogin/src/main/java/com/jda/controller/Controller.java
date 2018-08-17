package com.jda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jda.model.Model;
import com.jda.service.IUserService;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	IUserService userService;

	@RequestMapping(value = "/registration")
	public ModelAndView regPage() {
		ModelAndView model = new ModelAndView("Registration");
		return model;
	}

	@RequestMapping(value = "/forgot")
	public ModelAndView forgotPage() {
		ModelAndView model = new ModelAndView("Forgot");
		return model;
	}

	@RequestMapping(value = "/registerUser")
	public ModelAndView registerUser(@ModelAttribute("user") Model user) {
		if (userService.registerUser(user)) {
			ModelAndView mav = new ModelAndView("../index");
			return mav;
		}
		return null;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(@ModelAttribute("User") Model model) {
		System.out.println(model.getEmail());
		return new ModelAndView("Home");
	}

}
