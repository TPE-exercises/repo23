package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung05.aufgabe3;

import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;

public class LetterCounter {

	private static final char[] LOWER_LETTERS_WITH_UMLAUTS = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','ä','ö','ü','ß'};
	private static final char[] NUMBERS = {'0','1','2','3','4','5','6','7','8','9'};

	private static final String[] TEST_FILE_PATHS = {
			"Bravo30Test30",
			"Test100"
	};

	private static final String[] FILE_PATHS = {
			"Die_Bibel",
			"William_Shakespear"
	};

	private static boolean isValidLetter(char letter){
		for(int i = 0; i < LOWER_LETTERS_WITH_UMLAUTS.length; i++){
			if(letter == LOWER_LETTERS_WITH_UMLAUTS[i]){
				return true;
			}
		}
		return false;
	}

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

	private static String[] getWordsInLine(String line){
		String[] words = null;
		String lowerCaseWord = line.toLowerCase();

		String word = "";
		for(int i = 0; i < lowerCaseWord.length(); i++){
			if(isValidLetter(lowerCaseWord.charAt(i))){
				word = word + lowerCaseWord.charAt(i);
				if((i + 1) >= lowerCaseWord.length()){
					words = addNewWord(words, word);
					word = "";
				}
			}
			else{
				words = addNewWord(words, word);
				word = "";
			}
		}

		return words;
	}

	private static int[] updateNumbers(int[] numbers, int position, int numberToInsertOnTheRightPosition){
		for(int i = numbers.length - 1; i > position; i--){
			numbers[i] = numbers[i - 1];
		}
		numbers[position] = numberToInsertOnTheRightPosition;
		return numbers;
	}
	
	private static String[] updateOftenWords(String[] oftenWords, int position, String stringToInsertAtTheRightPosition){
		for(int i = oftenWords.length - 1; i > position; i--){
			oftenWords[i] = oftenWords[i - 1];
		}
		oftenWords[position] = stringToInsertAtTheRightPosition;
		return oftenWords;
	}

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
			//Stop the time
			time = System.currentTimeMillis() - time;
			//Outputting the elements of the Hashmap
			printOftenWords(wordCollection);
//			Enumeration<String> e = wordCollection.keys();
//			while(e.hasMoreElements()){
//				String key = (String)e.nextElement();
//				System.out.println(key + ": " + wordCollection.get(key));
//			}
			//Outputting the needed time
			System.out.println("Benötigte Zeit: " + time + " ms.");
			f.close();
		}catch( IOException e){
			System.out.println("Fehler beim Lesen der Datei.");
		}
	}
}