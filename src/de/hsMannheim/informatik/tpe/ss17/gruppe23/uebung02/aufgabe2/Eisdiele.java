package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02.aufgabe2;

import static gdi.MakeItSimple.*;

/**
 * This class contains an implementation of a large ice cream shop only selling ice cream cups.
 * 
 * Gruppe 2-3:
 * @author Joshua Joost(1626034)
 * @author Max Granzow(1624770)
 */
public abstract class Eisdiele {
	
	private String[] eissorten = new String[0];
	private double[] preise = new double[0];
	private String[] behaeltnis = new String[0];
	private String[] art = new String[0];
	private String[][] sorten = new String[0][];
	private String[][] extras = new String[0][];
	
	/**
	 * Adds a specific ice cream to the menu of the ice cream shop.
	 * @param name Name of the new ice cream.
	 * @param preis Price of the new ice cream.
	 * @param behaeltnis Vessel of the new ice cream.
	 * @param art Form factor of the new ice cream.
	 * @param sorten Sorts of ice cream.
	 * @param extras Extras of the new ice cream.
	 */
	public void addIceCreamToMenu(String name, double preis, String behaeltnis, String art, String[] sorten, String[] extras) {
		String[] newEisSorten = new String[this.eissorten.length + 1];
		for(int i = 0; i < this.eissorten.length; i++) {
			newEisSorten[i] = this.eissorten[i];
		}
		newEisSorten[newEisSorten.length - 1] = name;
		this.eissorten = newEisSorten;
		
		double[] newPreise = new double[this.preise.length + 1];
		for(int i = 0; i < this.preise.length; i++) {
			newPreise[i] = this.preise[i];
		}
		newPreise[newPreise.length - 1] = preis;
		this.preise = newPreise;
		
		String[] newBehaeltnis = new String[this.behaeltnis.length + 1];
		for(int i = 0; i < this.behaeltnis.length; i++) {
			newBehaeltnis[i] = this.behaeltnis[i];
		}
		newBehaeltnis[newBehaeltnis.length - 1] = behaeltnis;
		this.behaeltnis = newBehaeltnis;
		
		String[] newArt = new String[this.art.length + 1];
		for(int i = 0; i < this.art.length; i++) {
			newArt[i] = this.art[i];
		}
		newArt[newArt.length - 1] = art;
		this.art = newArt;
		
		String[][] newSorten = new String[this.sorten.length + 1][];
		for(int i = 0; i < this.sorten.length; i++) {
			newSorten[i] = this.sorten[i];
		}
		newSorten[newSorten.length - 1] = sorten;
		this.sorten = newSorten;
		
		String[][] newExtras = new String[this.extras.length + 1][];
		for(int i = 0; i < this.extras.length; i++) {
			newExtras[i] = this.extras[i];
		}
		newExtras[newExtras.length - 1] = extras;
		this.extras = newExtras;
		
	}
	
	/**
	 * Executes the process of buying a cup of ice cream.
	 * @param typ Sort of the ordered ice cream.
	 */
	public void bestellen(String typ) {
		begruessen(typ);
		
		boolean eisVerfuegbar = eisVerfuegbar(typ);
		
		if(!eisVerfuegbar) {
			entschuldigen();
		}
		else {
			// Eis erstellen
			Eis eis = erstellen(typ);
			
			eis.vorbereiten();
			eis.fuellen();
			eis.dekorieren();
			
			kassieren(eis.getPreis());
		}
		
		verabschieden(eisVerfuegbar);
	}
	
	/**
	 * Returns if a specific type of ice cream is available.
	 * @param typ Type of the ice cream to search for.
	 * @return Returns if this type of ice cream is available.
	 */
	public boolean eisVerfuegbar(String typ) {
		for(int i = 0; i < eissorten.length; i++) {
			if(typ.equals(eissorten[i])) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Returns all ice cream cups that are currently offered.
	 * @return Array of all ice cream types.
	 */
	public String[] getEissorten() {
		return eissorten;
	}
	
	/**
	 * Calculates the index position of a specific ice cream type in the list of ice cream types.
	 * @param typ Name of the ice cream cup.
	 * @return Returns the index position.
	 * @throws GDIException if the ice cream type is unknown.
	 */
	private int getTypeIndex(String typ) {
		for(int i = 0; i < eissorten.length; i++) {
			if(eissorten[i].equals(typ)) {
				return i;
			}
		}
		
		throw new GDIException("Eissorte unbekannt!");
	}
	
	/**
	 * Returns the price of a specific type of ice cream.
	 * @param typ Type to filter for.
	 * @return The price of the ice cream.
	 */
	protected double getPreis(String typ) {
		return preise[getTypeIndex(typ)];
	}
	
	/**
	 * Returns the vessel of a specific type of ice cream.
	 * @param typ Type to filter for.
	 * @return The vessel of the ice cream cup.
	 */
	protected String getBehaeltnis(String typ) {
		return behaeltnis[getTypeIndex(typ)];
	}
	
	/**
	 * Returns the style of a specific type of ice cream.
	 * @param typ Type to filter for.
	 * @return The style of the ice cream.
	 */
	protected String getArt(String typ) {
		return art[getTypeIndex(typ)];
	}
	
	/**
	 * Returns the sorts of ice cream the cup of a specific type contains.
	 * @param typ Type to filter for.
	 * @return Sorts of ice cream.
	 */
	protected String[] getSorten(String typ) {
		return sorten[getTypeIndex(typ)];
	}
	
	/**
	 * Returns the extras the ice cream is decorated with.
	 * @param typ Type to filter for.
	 * @return Extras the ice cream is decorated with.
	 */
	protected String[] getExtras(String typ) {
		return extras[getTypeIndex(typ)];
	}
	
	/**
	 * Creates a cup of ice cream of a given type customized to the local circumstances.
	 * @param typ Type of the cup of ice cream to create.
	 * @return Returns the created cup of ice cream.
	 */
	public abstract Eis erstellen(String typ);
	
	/**
	 * Welcomes the customer in the ice cream shop.
	 * @param name Name of the ice cream the customer ordered.
	 */
	public abstract void begruessen(String name);
	
	/**
	 * Takes the money of the customer.
	 * @param preis Price to pay for the ordered ice cream.
	 */
	public abstract void kassieren(double preis);
	
	/**
	 * Says goodbye to the customer.
	 */
	public abstract void verabschieden(boolean eisGekauft);
	
	/**
	 * Says sorry to the customer for not having the desired sort of ice cream.
	 */
	public abstract void entschuldigen();
	
}
