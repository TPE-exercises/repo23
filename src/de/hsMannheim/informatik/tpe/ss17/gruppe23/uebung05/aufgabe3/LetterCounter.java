package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung05.aufgabe03;

import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 * This class reads the words out of an file and counts them.
 * The 10 often words will be printed on the console furthermore the time needed to count the words.
 */
public class LetterCounter {

	private static final char[] LETTERS_WITH_UMLAUTS = {
			'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','ä','ö','ü','ß',
			'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','Ä','Ö','Ü'
	};

	private static final String[] TEST_FILE_PATHS = {
			"Bravo30Test30",
			"Test100"
	};

	private static final String[] FILE_PATHS = {
			"Die_Bibel",
			"William_Shakespear"
	};

	private static boolean isValidLetter(char letter){
		for(int i = 0; i < LETTERS_WITH_UMLAUTS.length; i++){
			if(letter == LETTERS_WITH_UMLAUTS[i]){
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds a new word into the String array 
	 * @param words String Array in which the new word added
	 * @param wordToAdd 
	 * @return String array with the new added word
	 */
	private static String[] addNewWord(String[] words, String wordToAdd){
		if(wordToAdd != null){
			String[] tmp;
			if(words == null || words.length == 0){
				tmp = new String[1];
			}
			else{
				tmp = new String[words.length + 1];
				for(int i = 0; i < words.length; i++){
					tmp[i] = words[i];
				}
			}
			tmp[tmp.length - 1] = wordToAdd;
			words = tmp;
		}
		return words;
	}

	/**
	 * Returns an String with every word on the reading line
	 * or null if the line hasn't any word.
	 * @param line
	 * @return 
	 */
	private static String[] getWordsInLine(String line){
		String[] words = null;

		String word = "";
		for(int i = 0; i < line.length(); i++){
			if(isValidLetter(line.charAt(i))){
				word = word + line.charAt(i);
				if((i + 1) >= line.length()){
					words = addNewWord(words, word);
					word = "";
				}
			}
			else{
				if(word.length() > 0){
					words = addNewWord(words, word);
					word = "";
				}		
			}
		}

		return words;
	}

	/**
	 * Put in the new number on the right position
	 * @param numbers
	 * @param position
	 * @param numberToInsertOnTheRightPosition
	 * @return New int array with the numberToInsertOnTheRightPosition
	 */
	private static int[] updateNumbers(int[] numbers, int position, int numberToInsertOnTheRightPosition){
		for(int i = numbers.length - 1; i > position; i--){
			numbers[i] = numbers[i - 1];
		}
		numbers[position] = numberToInsertOnTheRightPosition;
		return numbers;
	}

	/**
	 * Put a new String on the right position
	 * @param oftenWords
	 * @param position
	 * @param stringToInsertAtTheRightPosition
	 * @return new String array with the stringToInsertAtTheRightPosition
	 */
	private static String[] updateOftenWords(String[] oftenWords, int position, String stringToInsertAtTheRightPosition){
		for(int i = oftenWords.length - 1; i > position; i--){
			oftenWords[i] = oftenWords[i - 1];
		}
		oftenWords[position] = stringToInsertAtTheRightPosition;
		return oftenWords;
	}

	/**
	 * Prints the often words out of the hashtable furthermore the number of the counted words.
	 * @param h
	 */
	private static void printOftenWords(Hashtable<String, Integer> h){
		int outputNumberOfPrintingWords = 100;
		String[] oftenWords = new String[outputNumberOfPrintingWords];
		int[] numbers = new int[outputNumberOfPrintingWords];

		Enumeration<String> e = h.keys();
		while(e.hasMoreElements()){
			String key = (String)e.nextElement();
			for(int i = 0; i < outputNumberOfPrintingWords; i++){
				if(h.get(key) > numbers[i]){
					numbers = updateNumbers(numbers, i, h.get(key));
					oftenWords = updateOftenWords(oftenWords, i, key);
					break;
				}
			}
		}

		for(int i = 0; i < oftenWords.length; i++){
			for(int j = oftenWords.length - 1; j >= i; j--){
				if(oftenWords[j].toLowerCase().charAt(0) < oftenWords[i].toLowerCase().charAt(0)){
					String tmp = oftenWords[i];
					oftenWords[i] = oftenWords[j];
					oftenWords[j] = tmp;
				}
			}
		}

		for(int i = 0; i < oftenWords.length; i++){
			System.out.println((i + 1) + ".: " + oftenWords[i] + " mit " + numbers[i]);
		}
	}

	public static void main(String[] args){
		BufferedReader f;
		String line;
		Hashtable<String, Integer> wordCollection = new Hashtable<String, Integer>();
		long time;

		try{
			f = new BufferedReader(new FileReader(FILE_PATHS[0]));
			time = System.currentTimeMillis();
			while((line = f.readLine()) != null){
				String[] newWords = getWordsInLine(line);
				if(!(newWords == null)){
					for(int i = 0; i < newWords.length; i++){
						if(!wordCollection.containsKey(newWords[i])){
							wordCollection.put(newWords[i], 1);
						}
						else{
							int value = wordCollection.get(newWords[i]) + 1;
							wordCollection.replace(newWords[i], value);
						}
					}
				}
			}
			//Stop the time
			time = System.currentTimeMillis() - time;
			//Outputting the elements of the Hashmap
			printOftenWords(wordCollection);
			//Outputting the needed time
			System.out.println("Benötigte Zeit: " + time + " ms.");
			f.close();
		}catch( IOException e){
			System.out.println("Fehler beim Lesen der Datei.");
		}
	}
}











