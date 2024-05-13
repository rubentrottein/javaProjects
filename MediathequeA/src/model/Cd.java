package model;

public class Cd extends Media{

	String musicien;
	String genre;
	
	public Cd(int id, String nom, String emplacement, boolean disponible, String musicien, String genre) {
		super(id, nom, emplacement);
		this.musicien = musicien;
		this.genre = genre;
	}
	public String getMusicien() {
		return musicien;
	}
	public void setMusicien(String musicien) {
		this.musicien = musicien;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return "Cd [musicien=" + musicien + ", genre=" + genre + ", id=" + id + ", nom=" + nom + ", emplacement="
				+ emplacement + ", disponible=" + disponible + "]";
	}


	
}
