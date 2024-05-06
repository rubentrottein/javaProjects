package model;

public class Voiture {
	
	private final String MODEL;
	private int annee;
	private boolean premiereMain;
	int fuel;
	boolean power;
	private int nbRoues;

	public Voiture(String model, int annee, boolean premiereMain, int fuel, boolean power){
		this.MODEL = model;
		this.annee = annee;
		this.premiereMain = premiereMain;
		this.power = power;
		this.fuel = fuel;
		this.nbRoues = 4;
	}
	
	public void description() {
		System.out.print("Cette voiture est une " + this.MODEL);
		System.out.print("Sortie d'usine en " + + this.annee);
		if(premiereMain) {System.out.print(". Etat Neuf .");}
		if(power) {System.out.print(". Véhicule démarré .");}
		System.out.println("Le réservoir d'essence contient " + this.fuel);
	}
	
	public String getModel() {
		return MODEL;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getFuel() {
		return fuel;
	}
	
	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	public boolean isPremiereMain() {
		return premiereMain;
	}

	public void setPremiereMain(boolean premiereMain) {
		this.premiereMain = premiereMain;
	}
	public boolean getPower() {
		return power;
	}
	
	public void setPower(boolean power) {
		this.power = power;
	}

	public int getNbRoues() {
		return nbRoues;
	}
	
	public void setNbRoues(int nbRoues) {
		this.nbRoues = nbRoues;
	}

	@Override
	public String toString() {
		return "Voiture [model=" + MODEL /*+ ", annee=" + annee + ", premiereMain=" + premiereMain*/ + ", fuel=" + fuel
				+ ", power=" + power + ", nbRoues=" + nbRoues + "]";
	}
}
