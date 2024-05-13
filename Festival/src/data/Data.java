package data;

import java.util.ArrayList;
import java.util.HashMap;

import model.Festival;
import model.Groupe;
import model.Scene;

public class Data {

	static boolean MenuOn = true;

	static boolean submenuon;
	
	static Festival festival = new Festival("DeathMetal et Accordéon");
	static HashMap<String, Scene> scenes = new HashMap<String, Scene>();
	static HashMap<String, Groupe> groupes = new HashMap<String, Groupe>();
	
	public static boolean isMenuOn() {
		return MenuOn;
	}
	public static void setMenuOn(boolean menuOn) {
		Data.MenuOn = menuOn;
	}
	public static boolean isSubPartOn() {
		return submenuon;
	}
	public static void setSubPartOn(boolean subPartOn) {
		Data.submenuon = subPartOn;
	}
	public static Festival getFestival() {
		return festival;
	}
	public static void setFestival(Festival festival) {
		Data.festival = festival;
	}
	public static HashMap<String, Scene> getScenes() {
		return scenes;
	}
	public static void setScenes(HashMap<String, Scene> scenes) {
		Data.scenes = scenes;
	}
	public static HashMap<String, Groupe> getGroupes() {
		return groupes;
	}
	public static void setGroupes(HashMap<String, Groupe> groupes) {
		Data.groupes = groupes;
	}
}