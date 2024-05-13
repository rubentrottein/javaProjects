package model;

import java.util.ArrayList;


public class Scene extends Entity{
	
	int capacite;
	
	ArrayList<Groupe> Groupes;
	
	public Scene(String name) {
		super(name);
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public ArrayList<Groupe> getGroupes() {
		return Groupes;
	}

	public void setGroupes(ArrayList<Groupe> groupes) {
		this.Groupes = groupes;
	}
	
}
