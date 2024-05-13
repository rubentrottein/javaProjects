package model;

public class Media {
	int id;
	String nom;
	String emplacement;
	Boolean disponible;
	
	public Media(int id, String nom, String emplacement) {
		super();
		this.id = id;
		this.nom = nom;
		this.emplacement = emplacement;
		this.disponible = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public void invertDisponible() {
		// TODO Auto-generated method stub
		boolean choice = true;
		if(disponible == true) {choice = false;}
		System.out.println("Disponible = " + choice);
		setDisponible(choice);
	}
	
}