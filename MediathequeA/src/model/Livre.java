package model;

public class Livre extends Media{
	
	String auteur;
	String genre;
	int nbPage;
	
	
	public Livre(int id, String nom, String emplacement, boolean disponible, String auteur, String genre, int nbPage) {
		super(id, nom, emplacement);
		this.auteur = auteur;
		this.genre = genre;
		this.nbPage = nbPage;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public int getNbPage() {
		return nbPage;
	}


	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}


	@Override
	public String toString() {
		return "Livre [auteur=" + auteur + ", genre=" + genre + ", nbPage=" + nbPage + ", id=" + id + ", nom=" + nom
				+ ", emplacement=" + emplacement + ", disponible=" + disponible + "]";
	}



	
	
	
}
