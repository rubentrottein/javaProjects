package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import content.TextContent;
import menu.Menu;

public class Game {
	static boolean running = true;
	static int victoryCount = 0;
	static int failCount = 0;
	static int turn = 0;
	
	public static void main (String [] args) {
		readSave();
		Menu menu = new Menu();
		do {
			menu.launch();
			String resume = menu.resume(turn, victoryCount, failCount);
			save(resume);
		} while (running);
		System.out.println(TextContent.GOODBYETEXT);
	}
	
	public void game() {
		int computerChoice = setComputerChoice();
		int playerChoice = ask(TextContent.CHOICETEXT) -1;
		turn ++;
		System.out.println(TextContent.PLAYER + show(playerChoice));
		System.out.println(TextContent.COMPUTER + show(computerChoice));
		if ( playerChoice == computerChoice) {
			System.out.println(TextContent.DRAW);
		} else if (playerChoice == 3){
			running = false;
		} else if (play(playerChoice, computerChoice) == true){
			System.out.println(TextContent.WIN);
			victoryCount++;
		} else {
			System.out.println(TextContent.LOSE);
			failCount++;
			
		}
	}

	private static void save(String resume) {
		// TODO Auto-generated method stub
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter("save.txt"));
			bf.write(resume);
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void readSave() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("save.txt"));
			String victories = String.valueOf(br.readLine());
			String defeats = br.readLine();
			System.out.println(victories + "\n" + defeats);
		} catch (IOException e) { 
			e.printStackTrace();
		} catch (NumberFormatException  e) {
			e.printStackTrace();
		}
			
		finally {
			try {	
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String show(int choice) {
		switch (choice) {
			case 0 :
				return "Pierre";
			case 1 :
				return "Papier";
			case 2 :
				return "Ciseaux";
			case 3 :
				return "Sortie";
			default :
				System.out.println(TextContent.ERRORTEXT);
				System.out.println(choice);
				return "Erreur";
		}
	}
	private boolean play(int playerChoice, int computerChoice) {
		boolean result = false;
		switch (playerChoice) {
		case 0 :
			if (computerChoice == 2){result = true;};
			break;
		case 1 :
			if(computerChoice == 0) {result = true;};
			break;
		case 2 :
			if(computerChoice == 1) {result = true;};
			break;
		default :
			result = false;
		}
		return result;
	}
	
	private int ask(String question) {
		Scanner sc = new Scanner(System.in);
		System.out.println(question);
		return sc.nextInt();
	}

	private int setComputerChoice() {
		Random random = new Random();
		return random.nextInt(3);
	}
}
