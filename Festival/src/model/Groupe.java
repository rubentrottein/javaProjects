package model;

public class Groupe extends Entity{

	String style;
	
	public Groupe(String name, String style) {
		super(name);
		this.style = style;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Override
	public String toString() {
		return "[Goupe name=" + name + ", style=" + style + "]";
	}
	
	
	
}
