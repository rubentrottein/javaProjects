package tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import model.Aliment;

import java.util.Scanner;

public class Utilitaires {
	
	public static int readInt() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		try{
			i = sc.nextInt();
		}
		catch(Exception e) {	
		}
		return i;
	}	

	//le truc qui print le potager doit indiquer par une lettre minuscule
	//ce qui n'est pas mûr, et par une majuscule ce qui est prêt à être recolté
	//donc, pas ce qui est en dessous!

	public static void printPotager(ArrayList<Aliment> potager) {
		for(Aliment aliment : potager) {
			int elementNumber = 1;
			if(aliment.getDureePousse() == aliment.getMomentPousse()) {
				System.out.println("(Prêt a récolter)");				
			} else {
				System.out.println("(En croissance)");								
			}
			System.out.print(elementNumber + " " + aliment.toString());
		}
	}

	public static String readStr() {
		// TODO Supprimer si pas nécessaire
		Scanner sc = new Scanner(System.in);
		String i = "";
		try{
			i = sc.nextLine();
		}
		catch(Exception e) {	
		}
		return i;
	}

	public static void printGardeManger(HashMap<Aliment, Integer> gardeManger) {
	    for (Aliment aliment : gardeManger.keySet()) {
	      System.out.println("Name: " + aliment.getNom() + " Nombre: " + gardeManger.get(aliment));
	    }
	}
	
	
	
	
	
	
	
}
