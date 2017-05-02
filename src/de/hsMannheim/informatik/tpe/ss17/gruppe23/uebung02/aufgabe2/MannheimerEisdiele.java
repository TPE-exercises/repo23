package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02.aufgabe2;

import static gdi.MakeItSimple.*;

public class MannheimerEisdiele extends Eisdiele {
	
	public MannheimerEisdiele() {
		addIceCreamToMenu("Spaghettieis", 4.00, "Becher", "Mannheimer Spaghettis",
				new String[]{"Vanille"}, new String[]{"Sahne", "Erdbeersoße", "Kokosraspeln"});
		addIceCreamToMenu("Bananasplit", 3.00, "Teller", "Kleckse",
				new String[]{"Banane", "Vanille"}, new String[]{"Banane", "Keks"});
		addIceCreamToMenu("Schokoteller", 6.00, "Teller", "Bällchen",
				new String[]{"Schokolade", "Weisse Schokolade"}, new String[]{"Schokoladensoße", "Schokostreusel"});
		addIceCreamToMenu("Eiskaffee", 4.00, "Glas", "Kugeln",
				new String[]{"Vanille"}, new String[]{"Kaffee", "Sahne"});
	}
	
	@Override
	public Eis erstellen(String typ) {
		if(!eisVerfuegbar(typ)) {
			throw new GDIException("Eissorte unbekannt!");
		}
		
		return new MannheimerEis(typ, getPreis(typ), getBehaeltnis(typ), getArt(typ), getSorten(typ), getExtras(typ));
	}
	
	@Override
	public void begruessen(String name) {
		println("Herzlich Willkommen in Mannheim. Sie haben gerade ein " + name + " bestellt.");
	}

	@Override
	public void kassieren(double preis) {
		println("Das Eis kostet " + preis + "€.");
		println("Vielen Dank fuer ihren Einkauf in Mannheim.");
	}

	@Override
	public void verbschieden(boolean eisGekauft) {
		print("Auf Wiedersehen in Mannheim!");
		if(eisGekauft) {
			println(" Und lassen Sie sich ihr Eis schmecken!");
		}
	}

	@Override
	public void entschuldigen() {
		println("Das gewünschte Eis ist in Mannheim leider nicht verfügbar. Versuchen Sie es doch mit einem anderen.");
	}

}
