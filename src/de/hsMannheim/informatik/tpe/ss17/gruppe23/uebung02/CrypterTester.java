package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02;

import static gdi.MakeItSimple.*;

public class CrypterTester {

	public static void main(String[] args) {
		CrypterCaesar caesar = new CrypterCaesar(3);
		CrypterReverse reverse = new CrypterReverse();
		
		println("Caesar encrypt: caesar => \"" + caesar.encrypt("caesar") + "\"");
		println("Caesar decrypt: FDHVDU => \"" + caesar.decrypt("FDHVDU") + "\"");

		println("Reverse encrypt: UMKEHR => \"" + reverse.encrypt("UMKEHR") + "\"");
		println("Reverse decrypt: RHEKMU => \"" + reverse.encrypt("RHEKMU") + "\"");
		
		// Übungsblatt 2 Teil 2 Aufgabe 1 Teil d)
		String cypher = "XHMSNYYXYJQQJS", result;
		
		caesar = new CrypterCaesar(5);
		reverse = new CrypterReverse();
		
		println();
		result = reverse.decrypt(cypher);
		result = caesar.decrypt(result);
		result = reverse.decrypt(result);
		
		println("\"" + cypher + "\" => \"" + result + "\"");
		
	}

}
