package model;

public class Joueur extends Character {
	private int pv;
	private int nbItems;
	
	public Joueur(int y, int x, String sprite, int pv, int nbItems) {
		super(y, x, sprite);
		this.pv = pv;
		this.nbItems = nbItems;
	}
	
	public int getNbItems() {
		return nbItems;
	}
	public void setNbItems(int nbItems) {
		this.nbItems = nbItems;
	}
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
}