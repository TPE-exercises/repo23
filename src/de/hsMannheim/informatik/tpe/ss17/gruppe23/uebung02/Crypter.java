package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02;

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