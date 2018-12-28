package site.ilemon.rightsmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		List<User> users =service.listUser();
		model.addAttribute("users", users);
		model.addAttribute("username", ((User)auth.getPrincipal()).getUsername());
		return "userlist";
	}
	
	@GetMapping("/redirectAddUser")
	public String redirectAddUser(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if( auth != null && auth.getPrincipal() instanceof User){
			model.addAttribute("createBy", ((User)auth.getPrincipal()).getUsername());
		}else{
			System.out.println("error");
		}
		return "user";
	}
	
	@PostMapping("/create")
	public String create(User user){
		service.insert(user);
		return "redirect:/user/users";
	}
}
