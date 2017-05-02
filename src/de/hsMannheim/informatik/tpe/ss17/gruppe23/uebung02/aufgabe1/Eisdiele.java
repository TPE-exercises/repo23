package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02.aufgabe1;

import static gdi.MakeItSimple.*;

/**
 * This class contains an implementation of a large ice cream shop only selling ice cream cups.
 */
public class Eisdiele {

	private String[] eissorten = new String[0];
	private double[] preise = new double[0];
	private String[] behaeltnis = new String[0];
	private String[] art = new String[0];
	private String[][] sorten = new String[0][];
	private String[][] extras = new String[0][];	


	public Eisdiele() {
		addIceCreamToMenu("Spaghettieis", 5.00, "Becher", "Spaghettis", new String[]{"Vanille"}, new String[]{"Sahne", "Erdbeersoße", "Kokosraspeln"});
		addIceCreamToMenu("Schokoteller", 4.00, "Teller", "Bällchen", new String[]{"Schokolade", "Weisse Schokolade"}, new String[]{"Schokoladensoße", "Schokostreusel"});
		addIceCreamToMenu("Bananasplit", 3.00, "Becher", "Kleckse", new String[]{"Banane", "Vanille"}, new String[]{"Banane", "Keks"});
	}

	/**
	 * Adds a specific ice cream to the menu of the ice cream shop.
	 * @param name Name of the new ice cream.
	 * @param preis Price of the new ice cream.
	 * @param behaeltnis Vessel of the new ice cream.
	 * @param art Form factor of the new ice cream.
	 * @param sorten Sorts of ice cream.
	 * @param extras Extras of the new ice cream.
	 */
	private void addIceCreamToMenu(String name, double preis, String behaeltnis, String art, String[] sorten, String[] extras) {
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
		bestellen(typ, 1);
	}

	/**
	 * Executes the process of buying a cup of ice cream.
	 * @param typ Sort of the ordered ice cream.
	 * @param orders Number of orders, 1 for the first one.
	 */
	public void bestellen(String typ, int orders) {
		if(orders == 1){
			begruessen(typ);
		}
		boolean exit = true;

		boolean eisVerfuegbar = false;
		int eisIndex = 0;
		for(int i = 0; i < eissorten.length; i++) {
			if(typ.equals(eissorten[i])) {
				eisVerfuegbar = true;
				eisIndex = i;
			}
		}

		if(!eisVerfuegbar) {
			entschuldigen();
			exit = false;
		}
		else {
			// Eis erstellen
			Eis eis = new Eis(eissorten[eisIndex], preise[eisIndex], behaeltnis[eisIndex], art[eisIndex], sorten[eisIndex], extras[eisIndex]);

			eis.vorbereiten();
			eis.fuellen();
			eis.dekorieren();

			kassieren(eis.getPreis());
		}

		if(!exit){
			println("Welches Eis möchten Sie bestellen?");
			String orderIce = readLine();
			bestellen(orderIce, (orders + 1));
		}
		else{
			verabschieden(eisVerfuegbar);
		}
	}

	/**
	 * Welcomes the customer in the ice cream shop.
	 * @param name Name of the ice cream the customer ordered.
	 */
	public void begruessen(String name) {
		println("Guten Tag. Sie haben gerade ein " + name + " bestellt.");
	}

	/**
	 * Takes the money of the customer.
	 * @param preis Price to pay for the ordered ice cream.
	 */
	public void kassieren(double preis) {
		println("Das Eis kostet " + preis + "€.");
		println("Vielen Dank für ihren Einkauf.");
	}

	/**
	 * Says goodbye to the customer.
	 */
	public void verabschieden(boolean eisGekauft) {
		print("Auf Wiedersehen!");
		if(eisGekauft) {
			println(" Und lassen Sie sich ihr Eis schmecken!\n\n");
		}
	}

	/**
	 * Says sorry to the customer for not having the desired sort of ice cream.
	 */
	public void entschuldigen() {
		println("Das gewünschte Eis ist leider nicht verfügbar. Versuchen Sie es doch mit einem anderen.");
		
		print("Im Angebot habe wir: ");
		for(int i = 0; i < eissorten.length; i++){
			print(eissorten[i]);
			if(i < eissorten.length - 2){
				print(", ");
			}
			else if(i == eissorten.length - 2){
				print(" und ");
			}
		}
		print("\n");
	}

	public static void main(String[] args) {
		Eisdiele diele = new Eisdiele();

		diele.bestellen("Spaghettieis");
		
		diele.bestellen("Späg");
		
		
	}
}
