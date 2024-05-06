package menu;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Garage;
import model.Voiture;

public class Menu {
	
	boolean running = true;
	Garage garage = new Garage(10);

	public void launch(){
		
		do {
			printMenuInitial();
			
		} while(running);
	}
	
	private void printMenuInitial() {
		System.out.println("** Jazz Music plays **");
		System.out.println("Bonjour, Et bienvenue sur notre système?");
		System.out.println("\nQue souhaitez vous faire?");
		
		
		System.out.println("1. Créer une voiture?");
		System.out.println("2. Démarrer une voiture?");
		System.out.println("3. Faire le plein");
		System.out.println("4. Afficher le Garage");
		System.out.println("4. Quitter");

		choice(ask("\nVotre choix? [1 - 5]"));
	}

	public void choice(int userChoice) {
		switch(userChoice) {
		case 1:
			createCar();
			break;
		case 2:
			startCar();
			break;
		case 3:
			fillTank();
			break;
		case 4:
			System.out.println(garage);
			break;
		case 5:
			exit();
			break;
		default:
			System.out.println("Saisie incorrecte. Retour au menu principal");
		}
	}

	
	//User Input
	public int ask (String question) {
		System.out.println(question);
		Scanner sc = new Scanner(System.in);
		try {
			return sc.nextInt();			
		} catch (InputMismatchException e) {
			return 0;
		}
		
	}
	public String askModel (String question) {
		System.out.println(question);
		Scanner sc = new Scanner(System.in);
		try {
			return sc.nextLine();
		} catch (InputMismatchException e) {
			return "" + e;
		}
	}
	
	
	private void exit() {
		System.out.println("Merci d'avoir fait appel a nos services");
		System.out.println("** Jazz Music Stops **");
	}

	private void fillTank() {
		selectCar().setFuel(100);
		// TODO Auto-generated method stub
		
	}

	private Voiture selectCar() {
		Voiture voiture = garage.getGarage()[ask("Index de la voiture")];
		return voiture;
	}

	private void startCar() {
		selectCar().setPower(true);
		if(selectCar().getPower()) {
			System.out.println("Voiture démarrée");
		}
	}

	private void createCar() {
		Voiture voiture = new Voiture(askModel("Modèle de la voiture"), 2024, true, 100, false);
		int slot = nextEmptySpaceFromGarage();
		if(slot == -1) {
			System.out.println("Garage Plein. Impossible d'ajouter un autre vehicule");
		} else {
			garage.getGarage()[slot] = voiture;			
		}
		System.out.println(garage.toString());
	}

	private int nextEmptySpaceFromGarage() {
		for(int i=0; i < garage.getGarage().length; i++) {
			if(garage.getGarage()[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
}