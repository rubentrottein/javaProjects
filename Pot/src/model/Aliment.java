package model;

public class Aliment {

	String Nom;
	int dureeDeLaPoussePourMaturite;
	int quantiteObtenuLorsDeLaRecolte;
	int niveauDeMaturite;
	float prixdevente;
	float prixpourplanter;

	public Aliment(String nom, int dureePousse, int recoltePousse, float prix, float prixPourPlanter) {
		super();
		this.Nom = nom;
		this.dureeDeLaPoussePourMaturite = dureePousse;
		this.quantiteObtenuLorsDeLaRecolte = recoltePousse;
		this.prixdevente = prix;
		this.prixpourplanter = prixPourPlanter;
		this.niveauDeMaturite = 0;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		this.Nom = nom;
	}

	public int getDureePousse() {
		return dureeDeLaPoussePourMaturite;
	}

	public void setDureePousse(int dureePousse) {
		this.dureeDeLaPoussePourMaturite = dureePousse;
	}

	public int getRecoltePousse() {
		return quantiteObtenuLorsDeLaRecolte;
	}

	public void setRecoltePousse(int recoltePousse) {
		this.quantiteObtenuLorsDeLaRecolte = recoltePousse;
	}

	public int getMomentPousse() {
		return niveauDeMaturite;
	}

	public void setMomentPousse(int momentPousse) {
		this.niveauDeMaturite = momentPousse;
	}
}
