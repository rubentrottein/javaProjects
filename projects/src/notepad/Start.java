package notepad;


import content.TextContent;
import menu.Menu;

public class Start {

	public static boolean running= true;

	public static void main(String[] args) {
		do {
			Menu.launch(Menu.ask(TextContent.WELCOMETEXT));
			
		}while(running);
		/*Fonction d'enregistrement
		 * -Un nouveau fichier txt avec Date en titre par note  - Done
		 * 
		 * Bonus
		 * Fonction de lecture de la liste des notes - TODO
		 * récupération du titre et de la date - Done
		 * lvl1 un Hashmap <Title, Note> - Done
		 * lvl2 un fichier d'index  - TODO
		 */
	}

}
