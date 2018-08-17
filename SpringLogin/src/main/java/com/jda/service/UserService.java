package com.jda.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.jda.dao.IUserDao;
import com.jda.model.Model;

public class UserService implements IUserService {
	@Autowired
	IUserDao dao;

	public boolean registerUser(Model model) {
		if (dao.registerUser(model)>0)
		{
			return true;
		}
		return false;
	}

}