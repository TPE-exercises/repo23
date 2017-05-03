package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02.aufgabe2;

import static gdi.MakeItSimple.*;

public class BerlinerFruchtbecher extends Eis {
	
	public BerlinerFruchtbecher() {
		super("Fruchtbecher", 10.00, "Becher", "Kugeln",
				new String[]{"Erdbeer", "Banane", "Himbeer", "Banane", "Kirsche"}, new String[]{"Eiswafel"});
	}
	
	/**
	 * Prepares the vessel.
	 */
	@Override
	public void vorbereiten() {
		print("Berlinerisch: ");
		println(getBehaeltnis() + " nehmen.");
	}

	/**
	 * Fills the vessel with the specified sorts of ice cream.
	 */
	@Override
	public void fuellen() {
		print("Berlinerisch: ");
		print(getBehaeltnis() + " mit " + getArt() + " von ");
		for(int i = 0; i < getSorten().length; i++) {
			if(i > 0) {
				print (", "); 
			}
			print(getSorten()[i]);
		}
		print (" füllen.\n");
	}
	
	/**
	 * Decorates the ice cream with the specified extras.
	 */
	@Override
	public void dekorieren() {
		print("Berlinerisch: ");
		print("Das Eis mit");
		if(getExtras().length == 0) {
			print(" nichts");
		}
		
		for(int i = 0; i < getExtras().length; i++) {
			if(i > 0) {
				print(",");
			}
			print(" " + getExtras()[i]);
		}
		println(" dekorieren.");
	}

}
