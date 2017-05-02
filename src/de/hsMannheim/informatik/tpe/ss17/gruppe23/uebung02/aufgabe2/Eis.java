package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02.aufgabe2;

import static gdi.MakeItSimple.*;

/**
 * This class contains an abstract implementation of an ice cream cup.
 * 
 * Gruppe 2-3:
 * @author Joshua Joost(1626034)
 * @author Max Granzow(1624770)
 */
public abstract class Eis {

	private String name;		// Bezeichnung des Eises 
	private double preis;		// Preis des Eises
	private String behaeltnis;	// Waffel/Becher/Teller/Schuessel/Glas/etc.
	private String art;			// Baellchen/Bälle/Spaghettis/Klekse/etc.
	private String[] sorten;	// Vanille/Schokolade/Straciatella/Zitrone/etc.
	private String[] extras;	// Sahne/Schokostraeusel/Keks/Sosse/etc.
	
	/**
	 * Creates a new ice cream of a given type.
	 * @param typ Type (name) of the ice cream.
	 */
	public Eis(String typ, double preis, String behaeltnis, String art, String[] sorten, String[] extras) {
		this.name = typ;
		this.preis = preis;
		this.behaeltnis = behaeltnis;
		this.art = art;
		this.sorten = copyArray(sorten);
		this.extras = copyArray(extras);
	}
	
	/**
	 * Creates a copy of an array.
	 * @param array Array to copy.
	 * @return Copy of the array.
	 */
	private String[] copyArray(String[] array) {
		if(array == null) {
			return null;
		}
		
		String[] copy = new String[array.length];
		for(int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		
		return copy;
	}
	
	/**
	 * Prepares the vessel.
	 */
	public abstract void vorbereiten();
	
	/**
	 * Fills the vessel with the specified sorts of ice cream.
	 */
	public abstract void fuellen();
	
	/**
	 * Decorates the ice cream with the specified extras.
	 */
	public abstract void dekorieren();
	
	/**
	 * Returns the current price of the ice cream.
	 * @return The price of the ice cream.
	 */
	public  double getPreis() {
		return preis;
	}
	
	/**
	 * Returns the name of the ice cream cup.
	 * @return Name of the ice cream cup.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the vessel the ice cream is in.
	 * @return The vessel the ice cream is in.
	 */
	public String getBehaeltnis() {
		return behaeltnis;
	}
	
	/**
	 * Returns the type of the ice cream.
	 * @return Type of the ice cream.
	 */
	public String getArt() {
		return art;
	}
	
	/**
	 * Returns the sorts of ice cream in the cup.
	 * @return Sorts of ice cream.
	 */
	public String[] getSorten() {
		return sorten;
	}
	
	/**
	 * Returns the extras the ice cream is decorated with.
	 * @return Extras, the ice cream is decorated with.
	 */
	public String[] getExtras() {
		return extras;
	}
	
}
