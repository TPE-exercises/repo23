package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.aufgabe3;

import java.io.*;

import de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.aufgabe2.CaesarWriter;

public class CaesarFileEncryptor implements IFileEncrypter {

	private int shift;
	
	public CaesarFileEncryptor(int shift) {
		this.shift = shift;
	}
	
	
	@Override
	public File encrypt(File sourceDirectory) throws IOException {
		if(!sourceDirectory.exists() || !sourceDirectory.isDirectory()) {
			throw new FileNotFoundException("File not found.");
		}
		
		File parent = sourceDirectory.getParentFile();
		
		if (parent == null) {
			throw new IOException("No parent directory available.");
		}
		
		String newFolderPath = parent.getAbsolutePath() + "\\" + sourceDirectory.getName() + "_encrypted";
		int counter = 0;
		File newFolder = new File(newFolderPath);
		while(newFolder.exists()) {
			counter++;
			newFolder = new File(newFolderPath + "(" + counter + ")");
		}
		
		if(!newFolder.mkdirs()) {
			throw new IOException("UnableToCreateFile.");
		}
		
		File[] subFolders = sourceDirectory.listFiles();
		
		for(File currentFile : subFolders) {
			if(currentFile.isDirectory()) {
				createEncryptedDirectory(currentFile, newFolder.getAbsolutePath());
			}
			else {
				createEncryptedFile(currentFile, newFolder.getAbsolutePath());
			}
		}
		
		return newFolder;
	}
	
	private void createEncryptedDirectory(File folder, String targetPath) throws IOException {
		File newFolder = new File(targetPath + "\\" + folder.getName());
		newFolder.mkdir();
		
		File[] subFolders = folder.listFiles();
		
		for(File currentFile : subFolders) {
			if(currentFile.isDirectory()) {
				createEncryptedDirectory(currentFile, newFolder.getAbsolutePath());
			}
			else {
				createEncryptedFile(currentFile, newFolder.getAbsolutePath());
			}
		}
	}
	
	private void createEncryptedFile(File file, String targetPath) throws IOException {
		File newFile = new File(targetPath + "\\" + file.getName());
		newFile.createNewFile();
		
		PrintWriter writer = new PrintWriter(new CaesarWriter(new FileWriter(newFile), shift));
		
		InputStreamReader reader = new InputStreamReader(new FileInputStream(file.getAbsolutePath()));
		
		while ( reader.ready() ) {
			writer.write((char)reader.read());
		}
		
		reader.close();
		writer.close();
	}

	@Override
	public File decrypt(File sourceDirectory) throws IOException {
		if(!sourceDirectory.exists() || !sourceDirectory.isDirectory()) {
			throw new FileNotFoundException("File not found.");
		}
		
		File parent = sourceDirectory.getParentFile();
		
		if (parent == null) {
			throw new IOException("No parent directory available.");
		}
		
		String newFolderPath = parent.getAbsolutePath() + "\\" + sourceDirectory.getName() + "_decrypted";
		int counter = 0;
		File newFolder = new File(newFolderPath);
		while(newFolder.exists()) {
			counter++;
			newFolder = new File(newFolderPath + "(" + counter + ")");
		}
		
		if(!newFolder.mkdirs()) {
			throw new IOException("UnableToCreateFile.");
		}
		
		File[] subFolders = sourceDirectory.listFiles();
		
		for(File currentFile : subFolders) {
			if(currentFile.isDirectory()) {
				createEncryptedDirectory(currentFile, newFolder.getAbsolutePath());
			}
			else {
				createEncryptedFile(currentFile, newFolder.getAbsolutePath());
			}
		}
		
		return newFolder;
	}
	
	
	public static void main(String[] args) {
		// TODO
		// Pfad zu Ordner einlesen
		String path = "";
		System.out.println("Geben Sie den Namen des Verzeichnisses an:");
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			path = br.readLine(); 
		}
		catch(IOException e) {
			System.out.println("Eingabe fehlgeschlagen.");
		}
		
		// Ver- / Entschlüsseln eingeben
		boolean encrypt = false, found = false;
		String value;
		System.out.println("Soll der Ordner 0 = verschlüsselt oder 1 = entschlüsselt werden?");
		while(!found) {
			try{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				value = br.readLine();
				
				if(value.equals("0")) {
					encrypt = true;
					found = true;
				}
				else if (value.equals("1")) {
					encrypt = false;
					found = true;
				}
				else {
					System.out.println("Falsche Eingabe. Versuchen Sie es erneut.");
				}
			}
			catch(IOException e) {
				System.out.println("Eingabe fehlgeschlagen.");
			}
		}
		
		// Schluessel einlesen
		int key = 0;
		found = false;
		System.out.println("Geben Sie den zu verwendenden Schlüssel ein (ganze Zahl).");
		while(!found) {
			try{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				value = br.readLine();
				
				key = Integer.parseInt(value);
				found = true;
			}
			catch(IOException e) {
				System.out.println("Eingabe fehlgeschlagen.");
				found = false;
			}
			catch(NumberFormatException e) {
				System.out.println("Die Eingabe hat das falsche Format. Versuchen Sie es erneut.");
				found = false;
			}
		}
		
		//shift = key;
		
		
		// Ver- / Entschlüsseln
		System.out.println("Gefundene Dateien:");
		File folder = new File(path);
		File[] fileArray = folder.listFiles();
		System.out.println();
		
		if(!folder.exists() || !folder.isDirectory()) {
			System.out.println("Es wurde kein gültiges Verzeichnis angegeben.");
			return;
		}
		
		printFiles(folder);
		
		CaesarFileEncryptor c;
		if(encrypt) {
			c = new CaesarFileEncryptor(key);
			try {
				c.encrypt(folder);
				System.out.println("Erfolgreich verschlüsselt.");
			} catch (IOException e) {
				System.out.println();
				System.out.println("Something went wrong when encrypting.");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		else {
			c = new CaesarFileEncryptor(-key);
			try {
				c.decrypt(folder);
				System.out.println("Erfolgreich entschlüsselt.");
			} catch (IOException e) {
				System.out.println();
				System.out.println("Something went wrong when decrypting.");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	private static void printFiles(File folder) {
		if(folder == null) {
			return;
		}
		if(!folder.isDirectory()) {
			System.out.println(folder.getPath());
			return;
		}
		
		File[] fileArray = folder.listFiles();
		
		for(int i = 0; i < fileArray.length; i++) {
			if(fileArray[i].isDirectory()) {
				printFiles(fileArray[i]);
			}
			else {
				System.out.println(fileArray[i].getPath());
			}
			
		}
	}

}
