package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02;

import static gdi.MakeItSimple.*;

/**
 * This class contains an implementation of the reverse encryption. It works by changing the
 * order of the letters around.
 */
public class CrypterReverse implements Crypter {

	/**
	 * Encrypts a message by changing the order of the letters around.
	 */
	@Override
	public String encrypt(String message) {
		char[] chars = message.toCharArray();
		
		String cypher = "";
		for(int i = chars.length - 1; i >= 0; i--) {
			cypher += chars[i];
		}
		
		return cypher;
	}

	/**
	 * Decrypts a message in the same way as it is encrypted, by changing the order of the
	 * letters around.
	 */
	@Override
	public String decrypt(String cypherText) {
		return encrypt(cypherText);
	}
	
}
