package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02T2.aufgabe1;

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
		return changeLetterOrder(message);
	}

	/**
	 * Decrypts a message in the same way as it is encrypted, by changing the order of the
	 * letters around.
	 */
	@Override
	public String decrypt(String cypherText) {
		return changeLetterOrder(cypherText);
	}
	
	private String changeLetterOrder(String message) {
		char[] chars = message.toCharArray();
		
		String changed = "";
		for(int i = chars.length - 1; i >= 0; i--) {
			changed += chars[i];
		}
		
		return changed;
	}
	
}
