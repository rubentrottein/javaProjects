package model;

public class Dvd extends Media{

	String realisateur;
	String genre;
	
	public Dvd(int id, String nom, String emplacement, Boolean disponible, String realisateur, String genre) {
		super(id, nom, emplacement);
		this.realisateur = realisateur;
		this.genre = genre;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Dvd [realisateur=" + realisateur + ", genre=" + genre + ", id=" + id + ", nom=" + nom + ", emplacement="
				+ emplacement + ", disponible=" + disponible + "]";
	}	
}
