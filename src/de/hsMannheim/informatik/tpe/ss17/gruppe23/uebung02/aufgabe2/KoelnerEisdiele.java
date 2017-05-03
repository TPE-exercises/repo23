package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02.aufgabe2;

import static gdi.MakeItSimple.*;

/**
 * Gruppe 2-3:
 * @author Joshua Joost(1626034)
 * @author Max Granzow(1624770)
 */
public class KoelnerEisdiele extends Eisdiele {

	public KoelnerEisdiele() {
		addIceCreamToMenu("Spaghettieis");
		addIceCreamToMenu("Bananasplit");
		addIceCreamToMenu("Kinderteller");
	}
	
	@Override
	public Eis erstellen(String typ) {
		if(typ.equals("Spaghettieis")) {
			return new KoelnerSpaghettieis();
		}
		else if (typ.equals("Bananasplit")) {
			return new KoelnerBananasplit();
		}
		else if(typ.equals("Kinderteller")) {
			return new KoelnerKinderteller();
		}
		else {
			throw new GDIException("Eissorte unbekannt!");
		}
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
