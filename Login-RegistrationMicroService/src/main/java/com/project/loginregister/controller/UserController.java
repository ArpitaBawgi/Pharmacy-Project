package com.project.loginregister.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.loginregister.model.User;
import com.project.loginregister.service.UserDAO;

@RestController
public class UserController {
	@Autowired
	UserDAO dao_object;

	List<User> list = new ArrayList<User>();


	@RequestMapping("login/{emailId}/{uname}/{upass}")
	public String userLogin(@PathVariable String emailId, @PathVariable String uname, @PathVariable String upass) {
		String exitPoint = "User not there ";
		boolean value = dao_object.isPresent(emailId);
		list = dao_object.searchAll();
		for (User index : list) {
			if (value && uname.equals(index.getUserName()) && upass.equals(index.getPassword())) {
			exitPoint= "User successfully logged in";
			}

		}
		return exitPoint;
		
	}


	@RequestMapping(method=RequestMethod.POST,value="register/{emailId}/{uname}/{upass}")
	public String userRegister(@PathVariable String emailId,  @PathVariable String uname, @PathVariable String upass) {
	
		User user=new User(emailId, uname, upass);
		dao_object.create(user);
		return "User Successfully registered"+"  "+"with emailId:   "+emailId;
		
	}
	
	
	/*	@RequestMapping(method=RequestMethod.POST,value="register/{emailId}/{uname}/{upass}")
		public String userRegister(@PathVariable emailId  @PathVariable String uname, @PathVariable String upass) {
		
			User user=new User(emailId, uname, upass);
			dao_object.create(user);
			return "User Successfully registered"+"  "+"with emailId:   "+emailId;
		}*/
	
	
	
	
}
