package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02.aufgabe2;

/**
 * This class contains an implementation of a large ice cream shop only selling ice cream cups.
 * 
 * Gruppe 2-3:
 * @author Joshua Joost(1626034)
 * @author Max Granzow(1624770)
 */
public abstract class Eisdiele {
	
	private String[] eissorten = new String[0];
	
	/**
	 * Adds a specific ice cream to the menu of the ice cream shop.
	 * @param name Name of the new ice cream.
	 * @param preis Price of the new ice cream.
	 * @param behaeltnis Vessel of the new ice cream.
	 * @param art Form factor of the new ice cream.
	 * @param sorten Sorts of ice cream.
	 * @param extras Extras of the new ice cream.
	 */
	public void addIceCreamToMenu(String name) {
		String[] newEisSorten = new String[this.eissorten.length + 1];
		for(int i = 0; i < this.eissorten.length; i++) {
			newEisSorten[i] = this.eissorten[i];
		}
		newEisSorten[newEisSorten.length - 1] = name;
		this.eissorten = newEisSorten;
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
