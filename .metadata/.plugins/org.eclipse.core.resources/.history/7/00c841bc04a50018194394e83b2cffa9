package com.jda.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jda.dao.UserDao;
import com.jda.service.UserService;

@org.springframework.context.annotation.Configuration
@ComponentScan("com.jda.controller")
@EnableWebMvc
public class Configuration {
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

	@Bean
	public DataSource getDataSource() throws ClassNotFoundException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://" + System.getenv("DBHOST") + "/" + System.getenv("DBNAME"));
		dataSource.setUsername(System.getenv("DBUSER"));
		dataSource.setPassword(System.getenv("DBPASSWORD"));
		return dataSource;
	}

	@Bean
	public UserDao getUserDao() {
		return new UserDao();
	}

	@Bean
	public UserService getUserService() {
		return new UserService();
	}
}