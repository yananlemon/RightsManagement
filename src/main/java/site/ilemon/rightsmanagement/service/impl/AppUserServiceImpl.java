package site.ilemon.rightsmanagement.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import site.ilemon.rightsmanagement.entity.Permission;
import site.ilemon.rightsmanagement.entity.User;
import site.ilemon.rightsmanagement.service.IUserService;

@Service
public class AppUserServiceImpl implements UserDetailsService{

	@Autowired
	private IUserService service;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDetails userDetails =service.getUserByName(username);
		if (userDetails != null) {
			int userId = ((User)userDetails).getId();
			HashSet<Permission> permissions = service.listPermissionOfUser(userId);
			List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			for (Permission permission : permissions) {
				if (permission != null && permission.getPermissionCode()!=null) {
					GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getPermissionCode());
					grantedAuthorities.add(grantedAuthority);
				}
			}
			return userDetails;
		}
		throw new UsernameNotFoundException("User '" + username + "' not found.");
	}

}
