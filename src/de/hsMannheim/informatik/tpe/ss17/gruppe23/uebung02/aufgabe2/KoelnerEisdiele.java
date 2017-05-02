package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02.aufgabe2;

import static gdi.MakeItSimple.*;

public class KoelnerEisdiele extends Eisdiele {

	public KoelnerEisdiele() {
		addIceCreamToMenu("Spaghettieis", 5.00, "Becher", "Kölner Spaghettis",
				new String[]{"Vanille"}, new String[]{"Sahne", "Erdbeersoße"});
		addIceCreamToMenu("Bananasplit", 6.00, "Bierteig-Waffeln", "Kleckse",
				new String[]{"Banane", "Vanille"}, new String[]{"Banane", "Keks", "Schokoladen-Kokos-Soße"});
		addIceCreamToMenu("Kinderteller", 3.00, "Teller", "Bällchen",
				new String[]{"Erdbeer", "Zitrone"}, new String[]{"Waffel", "Bunte Soße"});
	}
	
	@Override
	public Eis erstellen(String typ) {
		if(!eisVerfuegbar(typ)) {
			throw new GDIException("Eissorte unbekannt!");
		}
		
		return new KoelnerEis(typ, getPreis(typ), getBehaeltnis(typ), getArt(typ), getSorten(typ), getExtras(typ));
	}
	
	@Override
	public void begruessen(String name) {
		println("Herzlich Willkommen in Köln. Sie haben gerade ein " + name + " bestellt.");
	}

	@Override
	public void kassieren(double preis) {
		println("Das Eis kostet " + preis + "€.");
		println("Vielen Dank fuer ihren Einkauf in Köln.");
	}

	@Override
	public void verabschieden(boolean eisGekauft) {
		print("Auf Wiedersehen in Köln!");
		if(eisGekauft) {
			println(" Und lassen Sie sich ihr Eis schmecken!");
		}
	}

	@Override
	public void entschuldigen() {
		println("Das gewünschte Eis ist in Köln leider nicht verfügbar. Versuchen Sie es doch mit einem anderen.");
	}
	
}
