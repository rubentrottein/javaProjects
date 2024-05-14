package tools;

import java.util.ArrayList;
import java.util.HashMap;

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

	/*DONE 
	* le truc qui print le potager doit indiquer par une lettre minuscule
	* ce qui n'est pas mûr, et par une majuscule ce qui est prêt à être recolté
	* donc, pas ce qui est en dessous!
	*/
	public static String printPotager(ArrayList<Aliment> potager) {
		String resume = "";
		int elementNumber = 0;
		for(Aliment aliment : potager) {
			elementNumber++;
			if(aliment.getMomentPousse() >= aliment.getDureePousse()) {
				resume += "(Prêt a récolter)";
			} else {
				resume+= "(En croissance)";
			}
			resume += "\n" + elementNumber + " " + aliment.toString();
		}
		return resume;
	}

	public static String readString() {
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

	public static String printGardeManger(HashMap<Aliment, Integer> gardeManger) {
		String resume = "";
		for (Aliment aliment : gardeManger.keySet()) {
	      resume += "\nName: " + aliment.getNom() + " Nombre: " + gardeManger.get(aliment);
	    }
	    return resume;
	}
}