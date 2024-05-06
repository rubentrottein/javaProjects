package model;

public class Voiture {
	
	private String model;
	private int annee;
	private boolean premiereMain;
	int fuel;
	boolean power;
	private int nbRoues;
	

	public Voiture(String model, int annee, boolean premiereMain, int fuel, boolean power){
		this.model = model;
		this.annee = annee;
		this.premiereMain = premiereMain;
		this.power = power;
		this.fuel = fuel;
		this.nbRoues = 4;
	}
	
	public void description() {
		System.out.print("Cette voiture est une " + this.model);
		System.out.print("Sortie d'usine en " + + this.annee);
		if(premiereMain) {System.out.print(". Etat Neuf .")};
		if(power) {System.out.print(". Véhicule démarré .")};
		System.out.println("Le réservoir d'essence contient " + this.fuel);
		System.out.println("Cette voiture est une " + this.model);
	}
	
	public String getModel() {
		return model;
	}

	public void setmodel(String model) {
		this.model = model;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getFuel() {
		return annee;
	}
	
	public void setFuel(int annee) {
		this.annee = annee;
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
		return "Voiture [model=" + model /*+ ", annee=" + annee + ", premiereMain=" + premiereMain*/ + ", fuel=" + fuel
				+ ", power=" + power + ", nbRoues=" + nbRoues + "]";
	}
	
	
}
