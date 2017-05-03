package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02.aufgabe2;

import static gdi.MakeItSimple.*;

/**
 * Gruppe 2-3:
 * @author Joshua Joost(1626034)
 * @author Max Granzow(1624770)
 */
public class MannheimerEisdiele extends Eisdiele {
	
	public MannheimerEisdiele() {
		addIceCreamToMenu("Spaghettieis");
		addIceCreamToMenu("Bananasplit");
		addIceCreamToMenu("Schokoteller");
		addIceCreamToMenu("Eiskaffee");
	}
	
	@Override
	public Eis erstellen(String typ) {
		if(typ.equals("Spaghettieis")) {
			return new MannheimerSpaghettieis();
		}
		else if(typ.equals("Bananasplit")) {
			return new MannheimerBananasplit();
		}
		else if(typ.equals("Schokoteller")) {
			return new MannheimerSchokoteller();
		}
		else if(typ.equals("Eiskaffee")) {
			return new MannheimerEiskaffee();
		}
		else {
			throw new GDIException("Eissorte unbekannt!");
		}
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
	public void verabschieden(boolean eisGekauft) {
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
