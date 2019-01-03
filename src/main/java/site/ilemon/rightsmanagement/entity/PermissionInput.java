package site.ilemon.rightsmanagement.entity;

import java.util.List;

public class PermissionInput {

	private Integer roleId;

	private List<String> codes;

	public PermissionInput() {
		super();
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public List<String> getCodes() {
		return codes;
	}

	public void setCodes(List<String> codes) {
		this.codes = codes;
	}
	
	
	
}
