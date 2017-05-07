package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.aufgabe2;

import java.io.*;

public class CaesarReader extends FilterReader {

	private int shift;
	private char[] alphabet;
	
	protected CaesarReader(Reader in, int shift) {
		super(in);
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
	public int read() throws IOException{
		int val = super.read();
		
		if(val == -1) {
			return -1;
		}
		else {
			return decrypt((char) val);
		}
	}
	
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int nr = 0;
		
		for(int i = 0; i < len; i++) {
			int val = read();
			
			if(val == -1) {
				nr = -1;
			}
			else {
				cbuf[off + i] = (char) nr;
			}
		}
		
		return nr;
	}
	
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
		
		return message;
	}
	
	public static void main(String[] args) {
		try {
			CaesarReader c = new CaesarReader(new FileReader("test.txt"), 3);
			int i = c.read();
			while(i != -1) {
				System.out.print((char) i);
				
				i = c.read();
			}
			
			c.close();
		}
		catch (IOException e) {
			System.out.println("Ein Fehler beim entschlüsseln ist aufgetreten.");
		}
	}

}
