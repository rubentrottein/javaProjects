package model;

import java.util.ArrayList;

public class Festival extends Entity{
	
	ArrayList<Scene> festivalScenes = new ArrayList<Scene>();

	public Festival(String name) {
		super(name);
	}

	public ArrayList<Scene> getFestivalScenes() {
		return festivalScenes;
	}

	public void setFestivalScenes(ArrayList<Scene> festivalScenes) {
		this.festivalScenes = festivalScenes;
	}

	@Override
	public String toString() {
		return "Festival [festivalScenes=" + festivalScenes + "]";
	}
	
}