package menu;

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
			//a la bonne place???
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
				break;
			case 3:
				System.out.print("Quel fruit ou legume voulez vous recolter?");
				boolean harvest = true;
				do{
					Utilitaires.printPotager(potager);
					int userInput = Utilitaires.readInt();
					Aliment alimentToHarvest = potager.get(userInput);
					if(alimentToHarvest.getMomentPousse() == alimentToHarvest.getDureePousse() && userInput != 0) {
						harvestAliment(alimentToHarvest);
					} else {
						System.out.println("Rien a récolter !");
						harvest = false;
					}
				} while (harvest);
				//TO DO
				//On peut recolter l'un des fruits/legumes à maturité (ni trop tôt, ni trop tard)
				break;
			case 4 : 
				System.out.println("Vente au marché");
				//TO DO
				//Quel fruit/legume vendre ?
				break;
			
			case 5:
				System.out.println("Sauvegarde dans un fichier");
				//TO DO
				//On sauvegarde ce qui est dans le potager, ainsi que l'argent courant
				break;
			case 6:
				System.out.println(TextContent.EXIT);
				appliOn = false;
				break;
			default:
				System.out.println(TextContent.ERROR);
			}
			time();
		}
		
		/*TO DO
		*ajout : la pousse de chaque fruit/legume du potager 
		*(il faut qu'à chaque action, tous les fruits et légumes poussent)
		*les fruits et légumes trop mûr sont perdus et retirés du potager
		*/
		
		while(appliOn);
	}




	private void harvestAliment(Aliment aliment) {
		potager.remove(aliment);
		if(gardeManger.get(aliment) != null) {
			gardeManger.put(aliment, 0);
		} else {
			gardeManger.put(aliment, gardeManger.get(aliment)+1);
			System.out.println("Etat du garde-manger : n");
			Utilitaires.printGardeManger(gardeManger);
		}
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
	}
	

}
