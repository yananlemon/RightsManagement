package site.ilemon.rightsmanagement.entity;

import java.util.List;

public class UserRoleInput {

	private Integer userId;

	private List<String> roles;

	public UserRoleInput() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
}
