package model;

public class Joueur extends Character {
	private int pv;
	public Joueur(int y, int x, String sprite, int pv) {
		super(y, x, sprite);
		this.pv = pv;
	}
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	
	
	
}