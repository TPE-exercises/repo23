package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.aufgabe3;

import java.io.*;

public interface IFileEncrypter {
	
	/**
	 * Encrypts a whole directory (with all included text files) and returns the encrypted directory.
	 * @param sourceDirectory The directory to encrypt.
	 * @return The new folder containing the encrypted files.
	 * @throws IOException Throws IOException if the access to the file system is not properly possible.
	 */
	public File encrypt(File sourceDirectory) throws IOException;
	
	/**
	 * Decrypts a whole encrypted directory, considering only text files.
	 * @param sourceDirectory The directory to decrypt.
	 * @return The new decrypted folder.
	 * @throws IOException Throws IOException if the access to the file system is not properly possible.
	 */
	public File decrypt(File sourceDirectory) throws IOException;
}
