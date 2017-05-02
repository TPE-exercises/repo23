package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02.aufgabe2;

import static gdi.MakeItSimple.*;

public class BerlinerEisdiele extends Eisdiele {

	public BerlinerEisdiele() {
		addIceCreamToMenu("Spaghettieis", 8.00, "Becher", "Spaghettis",
				new String[]{"Vanille"}, new String[]{"Erdbeersoße", "Kokosraspeln"});
		addIceCreamToMenu("Berliner Burger", 14.00, "Schale", "Berge",
				new String[]{"Schoko", "Pistazie", "Ergbeer", "Zitrone", "Nuss"}, new String[]{"Schokosoße", "Erdbeersoße"});
		addIceCreamToMenu("Fruchtbecher", 10.00, "Becher", "Kugeln",
				new String[]{"Erdbeer", "Banane", "Himbeer", "Banane", "Kirsche"}, new String[]{"Eiswafel"});
	}
	
	@Override
	public Eis erstellen(String typ) {
		if(!eisVerfuegbar(typ)) {
			throw new GDIException("Eissorte unbekannt!");
		}
		
		return new BerlinerEis(typ, getPreis(typ), getBehaeltnis(typ), getArt(typ), getSorten(typ), getExtras(typ));
	}
	
	@Override
	public void begruessen(String name) {
		println("Herzlich Willkommen in Berlin. Sie haben gerade ein " + name + " bestellt.");
	}

	@Override
	public void kassieren(double preis) {
		println("Das Eis kostet " + preis + "€.");
		println("Vielen Dank fuer ihren Einkauf in Berlin.");
	}

	@Override
	public void verabschieden(boolean eisGekauft) {
		print("Auf Wiedersehen in Berlin!");
		if(eisGekauft) {
			println(" Und lassen Sie sich ihr Eis schmecken!");
		}
	}

	@Override
	public void entschuldigen() {
		println("Das gewünschte Eis ist in Berlin leider nicht verfügbar. Versuchen Sie es doch mit einem anderen.");
	}

}
