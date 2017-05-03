package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02T2.aufgabe1;

import static gdi.MakeItSimple.*;

/**
 * Gruppe 2-3:
 * @author Joshua Joost(1626034)
 * @author Max Granzow(1624770)
 */
public class CrypterMain {
	
	private static int CAESAR = 0, REVERSE = 1;

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
		
		println();
		println();
		
		while(true) {
			println("Welches Verschlüsselungsverfahren soll verwendet werden?");
			int method = -1;
			while(method < 0 || method > 1) {
				println("0 = Caesar, 1 = Reverse");
				method = readInt();
			}
			
			int versatz = 0;
			if(method == CAESAR) {
				println("Welcher Versatz soll verwendet werden?");
				versatz = readInt();
			}
			
			int crypt = -1;
			boolean encrypt = true;
			println("Soll der Text ver- oder entschlüsselt werden?");
			while(crypt != 0 && crypt != 1) {
				println("0 = verschlüsseln, 1 = entschlüsseln");
				crypt = readInt();
			}
			if(crypt == 1) {
				encrypt = false;
			}
			readLine();
			
			print("Geben sie die zu ");
			if(encrypt) {
				print("verschlüsselnde ");
			}
			else {
				print("entschlüselnde ");
			}
			println("Nachricht ein.");
			String message = readLine();
			println();
			
			if(method == CAESAR) {
				if(encrypt) {
					println(new CrypterCaesar(versatz).encrypt(message));
				}
				else {
					println(new CrypterCaesar(versatz).decrypt(message));
				}
			}
			else if(method == REVERSE) {
				if(encrypt) {
					println(new CrypterReverse().encrypt(message));
				}
				else {
					println(new CrypterReverse().decrypt(message));
				}
			}
			
			println("\n\n");
			
		}
		
	}

}
