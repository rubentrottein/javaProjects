package game;

import model.Joueur;

import java.util.ArrayList;
import java.util.Scanner;

import model.Element;
import model.Enemy;
import model.Item;

public class Game {

	String[][] carte = new String[15][30];
	Joueur link = new Joueur(5,5,"L",3, 0);
	ArrayList<Element> enemyList = new ArrayList<Element>();
	ArrayList<Element> itemsList = new ArrayList<Element>();
	boolean gameOn = true;
	
	public void launch() {
		createMap();
		updateMapWithElement(link);
		createElements();
		addElementsOnMap(enemyList);
		addElementsOnMap(itemsList);
		while(gameOn) {
			System.out.println("⚔ x " + link.getNbItems() + "			❤ x " + link.getPv());
			printTab();
			handleMovement();
			updateMapWithElement(link);
		}
		
	}
	
	private void handleMovement() {
		// TODO Auto-generated method stub
		System.out.println("zqsd + entrée pour se deplacer");
		Scanner sc = new Scanner(System.in);
		String direction = sc.nextLine();
		carte[link.getX()][link.getY()]= " ";
		switch(direction) {
			case "z":
				int movement = link.getX()-1;
				if(check(movement, link.getY())) {
					link.setX(movement);				
				};
				break;
			case "s":
				if(check(link.getX()+1, link.getY())) {
					link.setX(link.getX()+1);				
				};
				break;
			case "q":
				if(check(link.getX(), link.getY()-1)) {
					link.setY(link.getY()-1);				
				};
				break;
			case "d":
				if(check(link.getX(), link.getY()+1)) {
					link.setY(link.getY()+1);
				};
				break;
		}
	}

	private boolean check(int x, int y) {
		if (carte[x][link.getY()] == "I" || carte[link.getX()][y] == "I"){
			return takeItem(x, y);
		} else if (carte[x][link.getY()] == "E" || carte[link.getX()][y] == "E"){
			return fight(x, y);
		} else if (carte[x][link.getY()] == "M" || carte[link.getX()][y] == "M"){
			return false;
		} else {
			return true;
		}
	}

	private boolean fight(int x, int y) {
		if(link.getNbItems()==0) {
			link.setPv(link.getPv() -1);
			System.out.println("Link perd un point de vie !" + link.getPv() + "❤ restants");
			if(link.getPv()<0) {
				System.out.println("☠ Link n'a plus de points de vie! Game Over!! 💀");
				gameOn = false;
			}
			return false;
		} else {
			link.setNbItems(link.getNbItems()-1);
			
			deleteElement(x, y, enemyList);
			
			System.out.println("L'ennemi est vaincu! Mais 1 épée est cassée!");
			return true;
		}
	}

	private boolean takeItem(int x, int y) {
		link.setNbItems(link.getNbItems()+1);

		deleteElement(x, y, itemsList);
		
		System.out.println("Link obtient une épée !");
		return true;
	}
	
	private void deleteElement(int x, int y, ArrayList<Element> list) {
		Element tempElement = null;
		for(Element element : list) {
			if(element.getX() == x && element.getY() ==y) tempElement = element;
		}
		itemsList.remove(tempElement);
	}
	
	private String[][] addElementsOnMap(ArrayList<Element> list){
		for(Element element : list) {
			carte = updateMapWithElement(element);
		}
		/* version for
		for(int i=0; i<enemyList.size();i++) {
			carte = updateTabWithPerso(carte, enemyList.get(i));			
		}
		*/
		return carte;
	}
	public void createElements() {
		//Ennemis
		enemyList.add(new Enemy(2,8,"E"));
		enemyList.add(new Enemy(3,2,"E"));
		enemyList.add(new Enemy(8,1,"E"));
		
		//Objets
		itemsList.add(new Item(12,7,"I"));
		itemsList.add(new Item(2,2,"I"));
		itemsList.add(new Item(11,11,"I"));
	}
	
	
	private String[][] updateMapWithElement(Element link) {
		carte[link.getX()][link.getY()] = link.getSprite();
		return carte;
	}
	private void printTab() {
		for(int i = 0; i<carte.length; i++) {
			System.out.println();
			for(int j = 0; j<carte[i].length; j++) {
				System.out.print(carte[i][j]);
			}
		}
		System.out.println();
	}
	
	private String[][] createMap(){
		for(int i = 0; i < carte.length; i++) {
			for(int j = 0; j < carte[i].length; j++) {
				if(j == 0 || j == carte[i].length-1 || i == 0 || i == carte.length-1) {
					carte[i][j] = "M";
				}
				//if (j != 0 || j != carte[i].length-1 || i != 0 || i != carte.length-1)
				else {
					carte[i][j] = " ";
				}
			}
		}
		return carte;
	}
}
