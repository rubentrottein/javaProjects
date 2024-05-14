package menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import content.TextContent;
import model.Aliment;
import model.Pdt;
import model.Carotte;
import model.Poireau;
import model.Pomme;
import tools.Utilitaires;

public class Potager {

	//A la bonne place?
	HashMap<Aliment, Integer> gardeManger = new HashMap<Aliment, Integer>();
	ArrayList<Aliment> potager = new ArrayList<Aliment>();
	float argentDisponible = 10;
	
	
	
	
	public void launch() {
		
		System.out.println("Bonjour");
		System.out.println("Bienvenue dans votre potager!");
		
		/*System.out.println("Souhaitez vous restaurer une sauvegarde?");
		
		if(Utilitaires.readString().equals("oui")) {
			//TODO
			//Lecture d'un fichier txt contenant les informations normalisés du potager
			Utilitaires.restaurationData();
		}*/
		
		
		boolean appliOn = true;
		
		do {
			//DONE a la bonne place???
			System.out.println(TextContent.MAINMENU);

			int action = Utilitaires.readInt();
			
			switch (action) {
			case 1:
				System.out.println("Que voulez-vous planter?/n" + TextContent.FRUITNUMBERS);
				plantAliment(Utilitaires.readInt());
				/*DONE
				* Gestion saisie utilisateur : ajout d'un des fruits/legumes saisie dans le potager
				* On plante une unité.
				*/
				break;
			case 2:
				Utilitaires.printPotager(potager);
				Utilitaires.printGardeManger(gardeManger);
				time();
				break;
			case 3:
				System.out.print("Quel fruit ou legume voulez vous recolter?");
				boolean harvest = true;
				//Boucle de récolte
				do{
					System.out.println(Utilitaires.printPotager(potager));
					System.out.print("0. Annuler");
					int userInput = Utilitaires.readInt();
					if (userInput == 0) {
						System.out.println("Retour au menu principal ... ");
						harvest = false;
						break;
					}else {
						Aliment alimentToHarvest = potager.get(userInput-1);
						System.out.println("Sélection" + alimentToHarvest.getNom());
						if(alimentToHarvest.getMomentPousse() == alimentToHarvest.getDureePousse()) {
							//TODO
							//On peut recolter l'un des fruits/legumes à maturité (ni trop tôt, ni trop tard)
							System.out.println("Recolte de " + alimentToHarvest.getNom());
							harvestAliment(alimentToHarvest);
							potager.remove(userInput-1);
						} 
						else {
							System.out.println("Rien à récolter ... ");
							harvest = false;
						}
					}
				} while (harvest);
				break;
			case 4 : 
				System.out.println("Vente au marché");
				//TODO
				//Quel fruit/legume vendre ?
				break;
			
			case 5:
				System.out.println("Sauvegarde dans un fichier");
				savePotager();
				saveGardeManger();
				//TODO
				//On sauvegarde ce qui est dans le potager, ainsi que l'argent courant
				break;
			case 6:
				System.out.println(TextContent.EXIT);
				appliOn = false;
				break;
			default:
				System.out.println(TextContent.ERROR);
			}
		}
		
		/*TODO
		*ajout : la pousse de chaque fruit/legume du potager 
		*(il faut qu'à chaque action, tous les fruits et légumes poussent)
		*les fruits et légumes trop mûr sont perdus et retirés du potager
		*/
		
		while(appliOn);
	}




	private void saveGardeManger() {
		// TODO Auto-generated method stub
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter("Garde-Manger.txt"));
			bf.write("Garde-manger : \n" + Utilitaires.printGardeManger(gardeManger));
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Etat du gardeManger actuel sauvegardé dans le fichier Garde-Manger.txt (dossier racine)");
	}




	private void savePotager() {
		// TODO Auto-generated method stub
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter("Potager.txt"));
			bf.write("\n" + potager.toString());
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Etat du potager actuel sauvegardé dans le fichier potager.txt (dossier racine)");
	}

	private void harvestAliment(Aliment aliment) {
		if(gardeManger.get(aliment) == null) {
			gardeManger.put(aliment, aliment.getRecoltePousse());
		} else {
			System.out.println("trying " + aliment + " , " + gardeManger.get(aliment)+aliment.getRecoltePousse());
			gardeManger.put(aliment, gardeManger.get(aliment)+aliment.getRecoltePousse());
		}
		System.out.println("Etat du garde-manger : \n" + Utilitaires.printGardeManger(gardeManger));
	}




	private void time() {
		// TODO Auto-generated method stub
		for(int i=0;i<potager.size(); i++) {
			Aliment aliment = potager.get(i);
			aliment.setMomentPousse(aliment.getMomentPousse()+ 1);
			if(aliment.getMomentPousse()>aliment.getDureePousse()+1) {
				System.out.println("\n☠ Un(e) " + aliment.getNom() + " a pourri pendant la nuit 😭😭😭 ! Paix à son âme ! On l'envoie a la fosse sceptique.");
				potager.remove(i);
			}
		}
		System.out.println("Le temps passe ... \n " + Utilitaires.printPotager(potager));
	}




	private void plantAliment(int aliment) {
		switch (aliment){
		case 1 :
			Pdt pdt = new Pdt();
			potager.add(pdt);
			break;
		case 2 : 
			Carotte carrot = new Carotte();
			potager.add(carrot);
			break;
		case 3 :
			Poireau leek = new Poireau(); 
			potager.add(leek);
			break;
		case 4 :
			Pomme apple = new Pomme();
			potager.add(apple);
			break;
		default : System.out.println(TextContent.ERROR);
		}
		time();
	}
	

}
