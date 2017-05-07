package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.aufgabe3;

import java.io.*;

public interface IFileEncrypter {
	
	public File encrypt(File sourceDirectory) throws IOException;
	
	public File decrypt(File sourceDirectory) throws IOException;
}
