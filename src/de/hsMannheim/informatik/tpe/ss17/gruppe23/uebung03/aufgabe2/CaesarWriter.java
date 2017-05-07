package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.aufgabe2;

import java.io.*;

public class CaesarWriter extends FilterWriter {

	private int shift;
	private char[] alphabet;// = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
//							   'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
//							   'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
//							   'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
//							   'Ä', 'Ö', 'Ü', 'ä', 'ö', 'ü'};
	
	public CaesarWriter(Writer out, int shift) {
		super(out);
		this.shift = shift;
		
		alphabet = new char[58];
		
		int counter = 0;
		
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
	
	@Override
	public void write(int c) throws IOException {
		super.write(encrypt((char)c));
	}
	
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		for(int i = 0; i < len; ++i) {
			write(cbuf[off + i]);
		}
	}
	
	@Override
	public void write(String str, int off, int len) throws IOException {
		write(str.toCharArray(), off, len);
	}
	
	private char encrypt(char message) {
		for(int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] == message) {
				int newPos = i + shift;
				
				while(newPos < 0) {
					newPos += alphabet.length;
				}
				
				newPos %= alphabet.length;
				
				return alphabet[newPos];
			}
		}
		
		return message;
	}
	
	public static void main(String[] args) {
		try {
			PrintWriter c = new PrintWriter(new CaesarWriter(new FileWriter("test.txt"), 3));
			c.write(new char[]{'c', 'a', 'e', 's', 'a', 'r'});
			c.println();
			c.write(new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
					   'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
					   'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
					   'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
					   'Ä', 'Ö', 'Ü', 'ä', 'ö', 'ü'});
			c.close();
		}
		catch (IOException e) {
			System.out.println("Ein Fehler beim verschlüsseln ist aufgetreten.");
		}
	}

}
