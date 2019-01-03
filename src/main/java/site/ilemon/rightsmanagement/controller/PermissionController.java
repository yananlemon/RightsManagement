package site.ilemon.rightsmanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

import site.ilemon.rightsmanagement.entity.PermissionInput;
import site.ilemon.rightsmanagement.entity.PermissionMenu;
import site.ilemon.rightsmanagement.entity.User;
import site.ilemon.rightsmanagement.service.IRoleService;

@Controller
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private IRoleService service;
	
	@GetMapping("/permission")
	public String redirectAddUser(@RequestParam(value="roleId",defaultValue = "1") Integer roleId,HttpServletRequest request,Model model){
		Object obj = request.getSession().getAttribute("currUser");
		if( obj == null)
			return "error";
		
		List<PermissionMenu> permissions = service.getPermissionOfRole(roleId);
		model.addAttribute("permissions", permissions);
		model.addAttribute("roleId", roleId);
		if( obj instanceof User ){
			model.addAttribute("userId",((User)(obj)).getId());
			
		}
		return "distributionpermission.html";
	}
	
	@PutMapping("/permission")
	@ResponseBody
	public Map<String,Integer> updatePermission(@RequestBody PermissionInput param){
		Map<String,Integer> rs = new HashMap<String, Integer>();
		try {
			int result = service.savePerission(param);
			rs.put("result", result);
			rs.put("roleId", param.getRoleId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
