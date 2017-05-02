package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02T2.aufgabe1;

/**
 * Gruppe 2-3:
 * @author Joshua Joost(1626034)
 * @author Max Granzow(1624770)
 */
public interface Crypter {
	/**
	 * Encrypts a message to a cypher.
	 * @param message The message to encrypt.
	 * @return Returns the encrypted message.
	 */
	public String encrypt(String message);
	
	/**
	 * Decrypts a cypher to it's original message.
	 * @param cypherText The text that should be decrypted.
	 * @return Returns the decrypted cypher, the original message.
	 */
	public String decrypt(String cypherText);
	
}