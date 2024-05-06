package menu;

import content.TextContent;
import game.Game;

public class Menu {
	public void launch(){
		System.out.println(TextContent.WELCOMETEXT);
		Game game = new Game();
		game.game();
	}
	public String resume(int turn, int victoryCount, int failCount) {
		String resume = "Nombre de parties jouées : " + turn
		+ "\nNombre de victoires : " + victoryCount
		+ "\nNombre de défaites : " + failCount;
		return resume;
	}
}
