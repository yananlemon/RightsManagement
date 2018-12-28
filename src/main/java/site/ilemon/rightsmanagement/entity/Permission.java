package site.ilemon.rightsmanagement.entity;

public class Permission implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5247775994316687796L;

	private String permissionCode;
	
	private String parentPermissionCode;
	
	private String permissionType;
	
	private String permissionText;
	
	private String permissionUrl;
	
	

	public Permission() {
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getParentPermissionCode() {
		return parentPermissionCode;
	}

	public void setParentPermissionCode(String parentPermissionCode) {
		this.parentPermissionCode = parentPermissionCode;
	}

	public String getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	public String getPermissionText() {
		return permissionText;
	}

	public void setPermissionText(String permissionText) {
		this.permissionText = permissionText;
	}

	public String getPermissionUrl() {
		return permissionUrl;
	}

	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}
	
	
}
