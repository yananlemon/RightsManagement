package site.ilemon.rightsmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import site.ilemon.rightsmanagement.entity.Role;
import site.ilemon.rightsmanagement.entity.User;
import site.ilemon.rightsmanagement.entity.UserRoleInput;
import site.ilemon.rightsmanagement.service.IRoleService;
import site.ilemon.rightsmanagement.service.IUserService;
import site.ilemon.rightsmanagement.util.Pagination;
import site.ilemon.rightsmanagement.util.SearchCondition;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private IRoleService service;
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/roles")
	public String listUser(@RequestParam(value="currentPage",defaultValue = "1") Integer currentPage,Model model){
		SearchCondition condition = new SearchCondition(currentPage);
		Pagination<Role> users =service.listRole(condition);
		model.addAttribute("roles", users);
		return "rolelist";
	}
	
	@GetMapping("/role")
	@ResponseBody
	public List<Role> listRole(){
		List<Role> roles =service.listRole();
		return roles;
	}
	
	
	@GetMapping("/getRolesByUserId")
	@ResponseBody
	public List<Role> getRolesByUserId(@RequestParam(value="userId",required = true) Integer userId){
		List<Role> list = service.listRoleByUserId(userId);
		return list;
	}
	
	@PutMapping("/updateUserRole")
	@ResponseBody
	public int updateUserRole(@RequestBody UserRoleInput param){
		int result = 0;
		try {
			result = service.saveUserRole(param);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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
