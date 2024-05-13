package mediatheque;

import java.util.ArrayList;

import model.Cd;
import model.Dvd;
import model.Livre;
import model.Media;

public class Mediatheque {

	ArrayList<Media> alMedia = new ArrayList<Media>();
	Media l1 = new Livre(1, "Les portes de la Terre", "L01", false, "Farmer", null, 240);
	Media d1 = new Dvd(2, "Star Wars", "D01", false, "SpaceOpera", null);
	Media c1 = new Cd(3, "Demons&Wizards", "C01", false, "D&W","");
	String title;
	public Mediatheque(String title) {
		this.title = title;
	}
	
	public void ouvertureMediatheque(){

		alMedia.add(l1.getId()-1, l1);
		alMedia.add(d1.getId()-1, d1);
		alMedia.add(c1.getId()-1, c1);
					
		Menu.menuPrincipal(alMedia);
	}
	
	
}
