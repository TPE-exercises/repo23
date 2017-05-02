package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02T2.aufgabe1;

/**
 * This class contains an implementation of the caesar encryption. It works by shifting
 * the letters in a message by a specific range. The range acts like the key and is used
 * to decrypt the cypher text.
 */
public class CrypterCaesar implements Crypter {

	private int shift; // number of shifts in the alphabet
	
	/**
	 * Creates a new CrypterCaesar object and initializes the letter shift.
	 * @param shift number of letter shifts
	 */
	public CrypterCaesar(int shift) {
		this.shift = shift;
	}
	
	/**
	 * Encrypts a message by shifting the letters by a given number of times.
	 */
	@Override
	public String encrypt(String message) {
		return shiftCharValues(message, shift, true);
	}

	/**
	 * Decrypts a message by shifting the letters backwards by a given number of times.
	 */
	@Override
	public String decrypt(String cypherText) {
		return shiftCharValues(cypherText, -shift, false);
	}
	
	/**
	 * Shifts each letter in a message by a given range in the alphabet and converts it into upper-/lowercase.
	 * @param message The message to en-/decrypt.
	 * @param range Number of shifts that are performed on each letter.
	 * @param uppercase Specifies if the result should be in uppercase (or lowercase).
	 * @return Returns the en-/decrypted message.
	 */
	private String shiftCharValues(String message, int range, boolean uppercase) {
		char[] chars = message.toCharArray();
		String cypher = "";
		
		for(int i = 0; i < chars.length; i++) {
			char curr = chars[i];
			
			if((curr >= 'a' && curr <= 'z') || (curr >= 'A' && curr <= 'Z')) {
				if(curr >= 'A' && curr <= 'Z') {
					curr -= 'A';
				}
				else {
					curr -= 'a';
				}
				
				curr += range;
				while(curr <= 0) {
					curr += 26;
				}
				curr = (char)(curr % 26);
				
				if(uppercase) {
					curr += 'A';
				}
				else {
					curr += 'a';
				}
			}
			
			cypher += curr;
		}
		
		return cypher;
	}
	
}