package site.ilemon.rightsmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import site.ilemon.rightsmanagement.entity.User;
import site.ilemon.rightsmanagement.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;
	
	@GetMapping("/users")
	public String listUser(Model model){
		List<User> users =service.listUser();
		model.addAttribute("users", users);
		return "userlist";
	}
}
