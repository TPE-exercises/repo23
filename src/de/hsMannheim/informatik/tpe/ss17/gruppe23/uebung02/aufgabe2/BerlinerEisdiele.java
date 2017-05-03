package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02.aufgabe2;

import static gdi.MakeItSimple.*;

/**
 * Gruppe 2-3:
 * @author Joshua Joost(1626034)
 * @author Max Granzow(1624770)
 */
public class BerlinerEisdiele extends Eisdiele {

	public BerlinerEisdiele() {
		addIceCreamToMenu("Spaghettieis");
		addIceCreamToMenu("Berliner Burger");
		addIceCreamToMenu("Fruchtbecher");
	}
	
	@Override
	public Eis erstellen(String typ) {
		if(typ.equals("Spaghettieis")) {
			return new BerlinerSpaghettieis();
		}
		else if(typ.equals("Fruchtbecher")) {
			return new BerlinerFruchtbecher();
		}
		else if(typ.equals("Berliner Burger")) {
			return new BerlinerBurger();
		}
		else {
			throw new GDIException("Eissorte unbekannt!");
		}
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
