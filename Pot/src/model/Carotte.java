package model;

public class Carotte extends Legume{

	
	public Carotte() {
		super("Carotte", 4, 2, 10, 2);
		
	}

	@Override
	public String toString() {
		return "Carotte [nom=" + Nom + ", dureeDeLaPoussePourMaturite=" + dureeDeLaPoussePourMaturite
				+ ", quantiteObtenuLorsDeLaRecolte=" + quantiteObtenuLorsDeLaRecolte + ", niveauDeMaturite="
				+ niveauDeMaturite + ", prixDeVente=" + prixdevente + ", prixPourPlanter=" + prixpourplanter + "]";
	}
	

	
	
}
