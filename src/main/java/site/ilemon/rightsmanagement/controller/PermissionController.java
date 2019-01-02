package site.ilemon.rightsmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import site.ilemon.rightsmanagement.entity.PermissionMenu;
import site.ilemon.rightsmanagement.service.IRoleService;

@Controller
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private IRoleService service;
	
	@GetMapping("/permission")
	public String redirectAddUser(@RequestParam(value="roleId",defaultValue = "1") Integer roleId,Model model){
		List<PermissionMenu> permissions = service.getPermissionOfRole(roleId);
		model.addAttribute("permissions", permissions);
		return "distributionpermission.html";
	}
	
}
