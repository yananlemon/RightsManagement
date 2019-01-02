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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((parentPermissionCode == null) ? 0 : parentPermissionCode
						.hashCode());
		result = prime * result
				+ ((permissionCode == null) ? 0 : permissionCode.hashCode());
		result = prime * result
				+ ((permissionText == null) ? 0 : permissionText.hashCode());
		result = prime * result
				+ ((permissionType == null) ? 0 : permissionType.hashCode());
		result = prime * result
				+ ((permissionUrl == null) ? 0 : permissionUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permission other = (Permission) obj;
		if (parentPermissionCode == null) {
			if (other.parentPermissionCode != null)
				return false;
		} else if (!parentPermissionCode.equals(other.parentPermissionCode))
			return false;
		if (permissionCode == null) {
			if (other.permissionCode != null)
				return false;
		} else if (!permissionCode.equals(other.permissionCode))
			return false;
		if (permissionText == null) {
			if (other.permissionText != null)
				return false;
		} else if (!permissionText.equals(other.permissionText))
			return false;
		if (permissionType == null) {
			if (other.permissionType != null)
				return false;
		} else if (!permissionType.equals(other.permissionType))
			return false;
		if (permissionUrl == null) {
			if (other.permissionUrl != null)
				return false;
		} else if (!permissionUrl.equals(other.permissionUrl))
			return false;
		return true;
	}
	
	
}
