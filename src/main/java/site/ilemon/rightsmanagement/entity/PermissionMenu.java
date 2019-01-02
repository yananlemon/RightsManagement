package site.ilemon.rightsmanagement.entity;

import java.util.ArrayList;
import java.util.List;

public class PermissionMenu {

	private int nodeId;
	
	private String parentCode;
	
	private String code;
	
	private String text;
	
	
	private State state = new State(false, false);
	
	private List<PermissionMenu> nodes;

	public PermissionMenu() {
	}
	public PermissionMenu(String text,String code,String parentCode) {
		this.text = text;
		this.code = code;
		this.parentCode = parentCode;
	}
	
	

	public int getNodeId() {
		return nodeId;
	}
	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<PermissionMenu> getNodes() {
		return nodes;
	}
	
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public void addChild(PermissionMenu menu){
		if( nodes == null )
			nodes = new ArrayList<PermissionMenu>();
		this.nodes.add(menu);
	}
}
