package model;

public class Pdt extends Legume{
	
	public Pdt() {
		super("Pomme de terre", 3, 4, 8, 1);
	}

	@Override
	public String toString() {
		return "Pdt [nom=" + Nom + ", dureeDeLaPoussePourMaturite=" + dureeDeLaPoussePourMaturite
				+ ", quantiteObtenuLorsDeLaRecolte=" + quantiteObtenuLorsDeLaRecolte + ", niveauDeMaturite="
				+ niveauDeMaturite + ", prixDeVente=" + prixdevente + ", prixPourPlanter=" + prixpourplanter + "]";
	}
}
