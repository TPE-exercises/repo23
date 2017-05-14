package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.aufgabe3;

import java.io.*;
import de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.aufgabe2.CaesarWriter;
import de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.aufgabe2.CaesarReader;

public class CaesarFileEncryptor implements IFileEncrypter {

	private int shift;
	
	/**
	 * Creates a new CaesarFileEncryptor to access the CaesarReader and -Writer functionality.
	 * @param shift The number of characters the letters should be shifted.
	 */
	public CaesarFileEncryptor(int shift) {
		this.shift = shift;
	}
	
	
	/**
	 * Encrypts a whole directory (with all included text files) and returns the encrypted directory.
	 * @param sourceDirectory The directory to encrypt.
	 * @return The new folder containing the encrypted files.
	 * @throws IOException Throws IOException if the access to the file system is not properly possible.
	 */
	@Override
	public File encrypt(File sourceDirectory) throws IOException {
		if(!sourceDirectory.exists() || !sourceDirectory.isDirectory()) {
			throw new FileNotFoundException("Directory not found.");
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
	
	/**
	 * Creates a new folder in the target directory and fills it with an encrypted version of the files in this directory.
	 * @param folder The folder to copy and encrypt.
	 * @param targetPath The target directory for the new folder.
	 */
	private void createEncryptedDirectory(File folder, String targetPath) throws IOException {
		File newFolder = new File(targetPath + File.separator + folder.getName());
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
	
	/**
	 * Creates a new encrypted file in the corresponding encrypted folder.
	 * @param file The file to encrypt.
	 * @param targetPath The target path to the encrypted file.
	 */
	private void createEncryptedFile(File file, String targetPath) throws IOException {
		String[] parts = file.getName().split("\\.");
		if(parts.length > 0 && !parts[parts.length - 1].equals("txt")) {
			copyFile(file, targetPath);
			return;
		}
		
		File newFile = new File(targetPath + File.separator + file.getName());
		newFile.createNewFile();
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new CaesarWriter(new FileWriter(newFile), shift)));
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath())));
		
		while ( reader.ready() ) {
			writer.write((char)reader.read());
		}
		
		reader.close();
		writer.close();
	}
	
	/**
	 * Copies a file to a new folder.
	 * @param file The file to copy.
	 * @param targetPath The target file path (for the copy).
	 */
	private void copyFile(File file, String targetPath) throws IOException {
		File newFile = new File(targetPath + File.separator + file.getName());
		newFile.createNewFile();
		
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(newFile));
		
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
		
		while ( input.available() > 0) {
			output.write(input.read());
		}
		output.flush();
		
		input.close();
		output.close();
	}
	
	
	/**
	 * Decrypts a whole encrypted directory, considering only text files.
	 * @param sourceDirectory The directory to decrypt.
	 * @return The new decrypted folder.
	 * @throws IOException Throws IOException if the access to the file system is not properly possible.
	 */
	@Override
	public File decrypt(File sourceDirectory) throws IOException {
		if(!sourceDirectory.exists() || !sourceDirectory.isDirectory()) {
			throw new FileNotFoundException("Directory not found.");
		}
		
		File parent = sourceDirectory.getParentFile();
		
		if (parent == null) {
			throw new IOException("No parent directory available.");
		}
		
		String newFolderPath = parent.getAbsolutePath() + File.separator + sourceDirectory.getName() + "_decrypted";
		int counter = 0;
		File newFolder = new File(newFolderPath);
		while(newFolder.exists()) {
			counter++;
			newFolder = new File(newFolderPath + "(" + counter + ")");
		}
		
		if(!newFolder.mkdir()) {
			throw new IOException("UnableToCreateFile.");
		}
		
		File[] subFolders = sourceDirectory.listFiles();
		
		for(File currentFile : subFolders) {
			if(currentFile.isDirectory()) {
				createDecryptedDirectory(currentFile, newFolder.getAbsolutePath());
			}
			else {
				createDecryptedFile(currentFile, newFolder.getAbsolutePath());
			}
		}
		
		return newFolder;
	}
	
	/**
	 * Creates a new folder in the target directory and fills it with an decrypted version of the files in this directory.
	 * @param folder The folder to copy and decrypt.
	 * @param targetPath The target directory for the new folder.
	 */
	private void createDecryptedDirectory(File folder, String targetPath) throws IOException {
		File newFolder = new File(targetPath + File.separator + folder.getName());
		newFolder.mkdir();
		
		File[] subFolders = folder.listFiles();
		
		for(File currentFile : subFolders) {
			if(currentFile.isDirectory()) {
				createDecryptedDirectory(currentFile, newFolder.getAbsolutePath());
			}
			else {
				createDecryptedFile(currentFile, newFolder.getAbsolutePath());
			}
		}
	}
	
	/**
	 * Creates a new decrypted file in the corresponding decrypted folder.
	 * @param file The file to decrypt.
	 * @param targetPath The target path to the decrypted file.
	 */
	private void createDecryptedFile(File file, String targetPath) throws IOException {
		String[] parts = file.getName().split("\\.");
		if(parts.length > 0 && !parts[parts.length - 1].equals("txt")) {
			copyFile(file, targetPath);
			return;
		}
		
		File newFile = new File(targetPath + File.separator + file.getName());
		newFile.createNewFile();
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(newFile)));
		CaesarReader reader = new CaesarReader(new FileReader(file), shift);
		
		while ( reader.ready() ) {
			writer.print((char)reader.read());
		}
		
		reader.close();
		writer.close();
	}
	
	/**
	 * Prints the menu to de-/encrypt a folder to the console.
	 */
	public static void main(String[] args) {
		// Main menu
		System.out.println("CAESAR-ENCRYPTOR");
		System.out.println("");
		
		// Pfad zu Ordner einlesen
		String path = "";
		System.out.println("Geben Sie den Namen des Verzeichnisses an:");
		
		boolean validPath = false;
		while(!validPath) {
			
			try{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				path = br.readLine(); 
			}
			catch(IOException e) {
				System.out.println("Eingabe fehlgeschlagen.");
			}
			
			if(new File(path).exists()) {
				validPath = true;
			}
			else {
				System.out.println("Der angegebene Pfad ist ungültig. Versuchen Sie es erneut.");
			}
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
		
		
		// Ver- / Entschlüsseln
		System.out.println("Gefundene Dateien:");
		File folder = new File(path);
		System.out.println();
		
		if(!folder.exists() || !folder.isDirectory()) {
			System.out.println("Es wurde kein gültiges Verzeichnis angegeben.");
			return;
		}
		
		printFiles(folder);
		
		System.out.println();
		System.out.println("Die Dateien werden verarbeitet. Bitte haben Sie einen Moment Geduld.");
		
		CaesarFileEncryptor c = new CaesarFileEncryptor(key);
		try {
			if(encrypt) {
				c.encrypt(folder);
				System.out.println("Erfolgreich verschlüsselt.");
			}
			else {
				c.decrypt(folder);
				System.out.println("Erfolgreich entschlüsselt.");
			}
		}
		catch(IOException e) {
			System.out.println();
			System.out.println("Beim Verarbeiten der Dateien ist ein Fehler aufgetreten.");
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
	}
	
	/**
	 * Prints all file names in a directory and it's sub-directories.
	 * @param folder the folder containing the files to print.
	 */
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
