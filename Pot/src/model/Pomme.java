package model;

public class Pomme extends Fruit{
			
	public Pomme() {
		super("Pomme", 2, 2, 2, 3);
		
	}

	@Override
	public String toString() {
		return "Pomme [nom=" + Nom + ", dureeDeLaPoussePourMaturite=" + dureeDeLaPoussePourMaturite
				+ ", quantiteObtenuLorsDeLaRecolte=" + quantiteObtenuLorsDeLaRecolte + ", niveauDeMaturite="
				+ niveauDeMaturite + ", prixDeVente=" + prixdevente + ", prixPourPlanter=" + prixpourplanter + "]";
	}

	
	
	
}
