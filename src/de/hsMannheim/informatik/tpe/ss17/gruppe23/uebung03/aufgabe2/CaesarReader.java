package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.aufgabe2;

import java.io.*;

public class CaesarReader extends FilterReader {

	private int shift;
	private char[] alphabet;
	
	/**
	 * Creates a new FilterReader that decrypts the input stream.
	 * @param in The input reader that should be decrypted.
	 * @param shift Specifies how often a character is moved. Acts like the decryption key.
	 */
	public CaesarReader(Reader in, int shift) {
		super(in);
		this.shift = shift;
		
		alphabet = new char[58];
		
		int counter = 0;
		
		// Create alphabet
		
		// Add upper case characters
		for(int i = 'A'; i <= 'Z'; i++) {
			alphabet[counter] = (char)i;
			counter++;
		}
		
		// Add lower case characters
		for(int i = 'a'; i <= 'z'; i++) {
			alphabet[counter] = (char)i;
			counter++;
		}

		alphabet[counter++] = 'Ä';
		alphabet[counter++] = 'Ö';
		alphabet[counter++] = 'Ü';
		alphabet[counter++] = 'ä';
		alphabet[counter++] = 'ö';
		alphabet[counter++] = 'ü';
	}
	
	/**
	 * Reads a single character, decrypts it and returns the character as an integer value.
	 */
	@Override
	public int read() throws IOException{
		int val = super.read();
		
		if(val == -1) {
			return -1;
		}
		else {
			return decrypt((char) val);
		}
	}
	
	/**
	 * Reads chars into a char array in the specified range and decrypts them.
	 * @param cbuf The array to store the decrypted chars in.
	 * @param off The number of array positions to skip.
	 * @param len The number of characters to read.
	 * @return Returns the number of read characters, -1 if the input stream has ended.
	 */
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int nr = 0;
		
		for(int i = 0; i < len; i++) {
			int val = in.read();
			
			if(val == -1) {
				return -1;
			}
			else {
				cbuf[off + i] = (char) nr;
			}
		}
		
		return nr;
	}
	
	/**
	 * Decrypts a char with the caesar encryption method.
	 * @param message The char to decrypt.
	 * @return The decrypted char.
	 */
	private char decrypt(char message) {
		for(int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] == message) {
				int newPos = i - shift;
				
				while(newPos < 0) {
					newPos += alphabet.length;
				}
				
				newPos %= alphabet.length;
				
				return alphabet[newPos];
			}
		}
		
		return message; // special characters are not encrypted
	}
	
	/**
	 * A simple test method for the caesar reader. test.txt has to contain an encrypted message.
	 */
	public static void main(String[] args) {
		try {
			CaesarReader c = new CaesarReader(new FileReader("test.txt"), 3);
			int i = c.read();
			while(i != -1) {
				System.out.print((char)i);
				
				i = c.read();
			}
			
			c.close();
		}
		catch (IOException e) {
			System.out.println("Ein Fehler beim entschlüsseln ist aufgetreten.");
		}
	}

}
