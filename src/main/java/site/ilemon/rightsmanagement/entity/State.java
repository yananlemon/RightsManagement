package site.ilemon.rightsmanagement.entity;

public class State {

	private boolean checked = false;
	
	private boolean selected = false;
	
	public State(boolean checked,boolean selected) {
		super();
		this.checked = checked;
		this.selected = selected;
	}

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
	
}
