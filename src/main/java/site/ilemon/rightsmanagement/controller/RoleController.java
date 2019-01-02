package site.ilemon.rightsmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import site.ilemon.rightsmanagement.entity.Role;
import site.ilemon.rightsmanagement.entity.User;
import site.ilemon.rightsmanagement.service.IRoleService;
import site.ilemon.rightsmanagement.util.Pagination;
import site.ilemon.rightsmanagement.util.SearchCondition;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private IRoleService service;
	
	@GetMapping("/roles")
	public String listUser(@RequestParam(value="currentPage",defaultValue = "1") Integer currentPage,Model model){
		SearchCondition condition = new SearchCondition(currentPage);
		Pagination<Role> users =service.listRole(condition);
		model.addAttribute("roles", users);
		return "rolelist";
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
		//service.insert(user);
		return "redirect:/user/users";
	}
}
