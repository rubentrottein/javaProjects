package menu;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Scanner;

import model.Garage;
import model.Voiture;
import content.TextContent;

public class Menu {
	
	boolean running = true;
	Garage garage = new Garage();

	public void launch(){
		
		do {
			printMenuInitial();
			useFuel();
		} while(running);
	}
	
	private void printMenuInitial() {
		System.out.println("** Jazz Music plays **");
		System.out.println("Bonjour, Et bienvenue sur notre système?");
		System.out.println(TextContent.TEXTACCUEIL);

		choice(ask("\nVotre choix? [1 - 5]"));
	}

	public void choice(String userChoice) {
		switch(userChoice) {
		case "1":
			createCar();
			break;
		case "2":
			startCar();
			break;
		case "3":
			fillTank();
			break;
		case "4":
			System.out.println(garage);
			break;
		case "5":
			saveGarage();
			break;
		case "6":
			exit();
			break;
		default:
			System.out.println("Saisie incorrecte. Retour au menu principal");
		}
	}

	
	//User Input
	public String ask (String question) {
		System.out.println(question);
		Scanner sc = new Scanner(System.in);
		try {
			return String.valueOf(sc.nextInt());		
		} catch (InputMismatchException e) {
			return sc.nextLine();
		}
		
	}
	
	private void exit() {
		System.out.println("Merci d'avoir fait appel a nos services \b ** La musique Jazz s'arrête **");
	}

	private void fillTank() {
		Voiture voiture = selectCar();
		int remainingFuel = voiture.getFuel();
		if(voiture.getFuel()==100) {
			System.out.println("Le Reservoir est déjà plein!");
		} else {
			System.out.println("reste " + remainingFuel + "% de carburant dans " + voiture.getModel());
			voiture.setFuel(100);
			System.out.println("Plein effectué : " + voiture.getModel() + " Essence : " + voiture.getFuel() + "%");
		}
	}

	private Voiture selectCar() {
		Object saisieUtilisateur = ask("Numéro ou Modèle de la voiture");
		return garage.getGarage().get(saisieUtilisateur);
	}

	private void startCar() {
		Voiture voiture = selectCar();
		boolean demarrage = voiture.getPower();
		if(demarrage) {
			demarrage = false;
			System.out.println("La voiture est en marche. Arrêt en cours...");
		} else if(voiture.getFuel()>0) {
			System.out.println("Voiture démarrée");
		} else {
			System.out.println("Le reservoir de cette voiture est vide. Veuillez faire le plein pour démarrer.");
		}
		voiture.setPower(demarrage);
	}

	private void createCar() {
		String model = ask("Modèle de la nouvelle voiture");
		if(garage.getGarage().containsKey(model)) {
			Voiture voiture = new Voiture(model, 2024, true, 100, false);			
			garage.getGarage().put(voiture.getModel(), voiture);
		} else {
			Voiture voiture = new Voiture(model, 2024, true, 100, false);			
			garage.getGarage().put(voiture.getModel(), voiture);
			System.out.println("Gourmand, Vous avez déjà une " + model);			
		}
		System.out.println(garage.toString());			
	}


	private void useFuel() {
		
		for(Entry<String, Voiture>voitureSet: garage.getGarage().entrySet()) {
			Voiture voiture = voitureSet.getValue();
			if(voiture != null && voiture.getPower() == true) { 
				voiture.setFuel(voiture.getFuel()-20);
				System.out.println(voiture.getModel() + " fuel restant " + voiture.getFuel());
				
			}
		}
	}
	
	public void saveGarage() {
		
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter("garage.txt"));
			bf.write(garage.toString());
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}