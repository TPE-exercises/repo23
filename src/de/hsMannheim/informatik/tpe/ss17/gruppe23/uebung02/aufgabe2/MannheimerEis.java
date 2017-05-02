package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02.aufgabe2;

import static gdi.MakeItSimple.*;

public class MannheimerEis extends Eis {
	public MannheimerEis(String typ, double preis, String behaeltnis, String art, String[] sorten, String[] extras) {
		super(typ, preis, behaeltnis, art, sorten, extras);
	}
	
	/**
	 * Prepares the vessel.
	 */
	@Override
	public void vorbereiten() {
		print("Mannheimerisch: ");
		println(getBehaeltnis() + " nehmen.");
	}
	
	/**
	 * Fills the vessel with the specified sorts of ice cream.
	 */
	@Override
	public void fuellen() {
		print("Mannheimerisch: ");
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
		print("Mannheimerisch: ");
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
