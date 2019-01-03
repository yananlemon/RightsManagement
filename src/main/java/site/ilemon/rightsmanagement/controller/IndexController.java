package site.ilemon.rightsmanagement.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import site.ilemon.rightsmanagement.entity.Permission;
import site.ilemon.rightsmanagement.entity.User;
import site.ilemon.rightsmanagement.service.IUserService;

@Controller
public class IndexController {

	@Autowired
	private IUserService service;

	@GetMapping("/index")
	public String index(HttpServletRequest request,Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if( auth != null && auth.getPrincipal() instanceof User){
			int userId = ((User)auth.getPrincipal()).getId();
			List<Permission> permissions = service.listPermissionOfUser(userId);
			request.getSession().setAttribute("permissions", permissions);
			request.getSession().setAttribute("username", ((User)auth.getPrincipal()).getUsername());
			request.getSession().setAttribute("currUser", ((User)auth.getPrincipal()));
			List<Map<String,Object>> list = service.getFreqOfCreateUser();
			model.addAttribute("list", list);
		}
		return "index";
	}

	@GetMapping("/login")
	public String login(){
		return "login";
	}

	@PostMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("currUser");
		session.removeAttribute("username");
		session.removeAttribute("permissions");
		return "redirect:/login";
	}
}
