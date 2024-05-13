package tools;

import java.util.ArrayList;
import java.util.Scanner;
import model.Media;

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
	
	public static String saisieString() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		return s;
	}
	
	public static int returnMaxIndexFromAL(ArrayList<Media> alMedia) {
		int max = 0;
		for (Media media : alMedia) {
			max = media.getId();
		}
		
		return max;
	}

	public static void readArrayList(ArrayList<Media> alMedia) {
		for (Media media : alMedia) {
			System.out.println(media);
		}
		
		
		
		
		
	}
}
