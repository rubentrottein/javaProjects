package model;

public class Element {
	private int y; 
	private int x; 
	String sprite;
	
	public Element(int x, int y, String sprite) {
		this.y = y;
		this.x = x;
		this.sprite = sprite;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public String getSprite() {
		return sprite;
	}
	public void setSprite(String sprite) {
		this.sprite = sprite;
	}
}
