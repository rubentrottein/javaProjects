package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import data.Data;
import data.TxtConst;
import model.Groupe;
import model.Scene;
import utilitaires.Utilitaires;

public class Launch {

	Data data;

	public void launch() {
		data = new Data();
	}
	
	public void lancement() {
		do {
			int choiceMainMenu = mainMenu();
			level2Menu(choiceMainMenu);
		} while (Data.isMenuOn());
	}

			private int mainMenu() {
				System.out.println(TxtConst.BONJOUR);
				System.out.println(TxtConst.MENUQUESTION);
				return Utilitaires.retourneunchiffre();
			}

	private void level2Menu(int i) {
		Data.setSubPartOn(true);
		switch (i) {
		case 1:
			menuGroupe();
			break;
		case 2:
			menuScene();
			break;
		case 3:
			menuFestival();
			break;
		case 4:
			menuSave();
			break;
		case 5:
			System.out.println(TxtConst.AUREVOIR);
			Data.setMenuOn(false);
			break;
		default:
			System.out.println(TxtConst.ERREUR);
			break;
		}

	}

	// Le code de la fonction menuGroupe semble fonctionnel, même s'il ne respecte pas assez les normes.
	private void menuGroupe() {
		do {
			System.out.println(TxtConst.MENUGROUPE);
			System.out.println(TxtConst.MENUGROUPECHOICE);
			System.out.println(TxtConst.MENUGROUPMANAGEMENT);

			switch (Utilitaires.retourneunchiffre()) {
			case 1:
				Utilitaires.printGroupes(Data.getGroupes());
				break;
			case 2:
				System.out.println("Quel groupe voulez vous créer");
				System.out.println("Nom :");
				String nomToAdd = Utilitaires.getStringFromUser();
				System.out.print("Style :");
				String styleToAdd = Utilitaires.getStringFromUser();
				Data.getGroupes().put(nomToAdd, new Groupe(nomToAdd, styleToAdd));
				break;
			case 3:
				System.out.println("Quel groupe voulez vous supprimer ?");
				Utilitaires.printGroupes(Data.getGroupes());
				System.out.println("Nom :");
				String nomToRemove = Utilitaires.getStringFromUser();
				if (Data.getGroupes().containsKey(nomToRemove)) {
					Data.getGroupes().remove(nomToRemove);
				} else {
					System.out.println("Erreur saisie");
				}
				break;
			case 4:
				Data.setSubPartOn(false);
				break;
			default:
				System.out.println(TxtConst.ERREUR);
				break;
			}

		} while (Data.isSubPartOn());

	}

	private void menuScene() {
		do {
			System.out.println(TxtConst.MENUSCENE);
			System.out.println(TxtConst.MENUSCENECHOICE);
			System.out.println(TxtConst.MENUSCENEMANAGEMENT);

			// TODO
			// CRUD - Améliorer la définition de scène*
			
			switch (Utilitaires.retourneunchiffre()) {
			case 1:
				Utilitaires.printScenes(Data.getScenes());
				break;
			case 2:
				System.out.println("Quel scène voulez vous créer");
				System.out.println("Nom :");
				String nomToAdd = Utilitaires.getStringFromUser();
				Data.getScenes().put(nomToAdd, new Scene(nomToAdd));
				break;
			case 3:
				System.out.println("Quel scène voulez vous supprimer ?");
				Utilitaires.printScenes(Data.getScenes());
				System.out.println("Nom :");
				String nomToRemove = Utilitaires.getStringFromUser();
				if (Data.getScenes().containsKey(nomToRemove)) {
					Data.getScenes().remove(nomToRemove);
				} else {
					System.out.println("Erreur saisie");
				}
				break;
			case 4:
				Data.setSubPartOn(false);
				break;
			default:
				System.out.println(TxtConst.ERREUR);
				break;
			}

		} while (Data.isSubPartOn());

	}

	private void menuFestival() {
		do {
			System.out.println(TxtConst.MENUFESTIVAL);
			System.out.println(TxtConst.MENUFESTIVALMANAGEMENT);

			// TODO
			// CRUD - s'inspirer de menuGroupe
			switch (Utilitaires.retourneunchiffre()) {
			case 1:
				System.out.println(Data.getFestival().getFestivalScenes().toString());
				break;
			case 2:
				System.out.println("Quel scène voulez vous ajouter");
				Utilitaires.printScenes(Data.getScenes());
				System.out.println("Nom :");
				String nomToGet = Utilitaires.getStringFromUser();
				if(Data.getScenes().containsKey(nomToGet)) {
					Data.getFestival().getFestivalScenes().add(Data.getScenes().get(nomToGet));
				};
				System.out.println("Nom :");
				break;
			case 3:
				System.out.println("Quel scène voulez vous supprimer du festival?");
				System.out.println(Data.getFestival().getFestivalScenes().toString());
				System.out.println("Index :");
				int idToRemove = Utilitaires.retourneunchiffre();
				Scene sceneToRemove = Data.getFestival().getFestivalScenes().get(idToRemove);
				if (Data.getFestival().getFestivalScenes().contains(sceneToRemove)) {
					Data.getFestival().getFestivalScenes().remove(sceneToRemove);
					System.out.println("Element Supprimé : " + idToRemove);
				} else {
					System.out.println("Erreur saisie");
				}
				break;
			case 4:
				System.out.println("Sauvegarde en cours. . .");
				menuSave();
				break;
			case 5:
				Data.setSubPartOn(false);
				break;
			default:
				System.out.println(TxtConst.ERREUR);
				break;
			}
		} while (Data.isSubPartOn());
	}

	private void menuSave() {
		System.out.println(TxtConst.MENUSAVE);
		BufferedWriter bf;
		try {
			bf = new BufferedWriter(new FileWriter("festival.txt"));
			bf.write(Data.getFestival().toString());
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO
		// Enregistrer les données du festival dans un fichier, quel qu'il soit
		// pas de mise en forme particulière, on veut juste que toutes les données y soit :
		// les scènes en place dans le festival, et les groupes jouant sur les scènes.
		// pas besoin d'enregistrer les groupes qui ne sont pas liés à des scènes et les scènes qui ne sont pas liées au festival
		
	}
}
