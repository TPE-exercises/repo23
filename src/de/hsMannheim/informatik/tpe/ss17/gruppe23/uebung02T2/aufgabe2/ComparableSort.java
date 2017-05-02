package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02T2.aufgabe2;

import static gdi.MakeItSimple.*;

/**
 * This class contains an implementation of the ShakerSort and the InsertionSort changed to
 * work with Comparable objects. The functionality is tested in the main method.
 *
 */
public class ComparableSort {

	/**
	 * Creates arrays of Comparables containing MyInt and MyString objects.
	 * The arrays are sorted with two sorting methods, ShakerSort and InsertionSort.
	 */
	public static void main(String[] args) {
		int[] ints = {4, 5, 3, 1, 1, 2};
		Comparable[] ints1 = createMyArray(ints), ints2 = createMyArray(ints);
		
		String[] strings = {"abc", "ab", "abe", "abd", ""};
		Comparable[] strings1 = createMyArray(strings), strings2 = createMyArray(strings);
		
		println("MyInt array before sort:");
		printArray(ints1);
		sortArray(new InsertionSort(), ints1);
		println("MyInt array after InsertionSort:");
		printArray(ints1);
		sortArray(new ShakerSort(), ints2);
		println("MyInt array after ShakerSort:");
		printArray(ints2);
		
		println();
		
		println("MyString array before sort:");
		printArray(strings1);
		sortArray(new InsertionSort(), strings1);
		println("MyString array after InsertionSort:");
		printArray(strings1);
		sortArray(new ShakerSort(), strings2);
		println("MyString array after ShakerSort:");
		printArray(strings2);
	}
	
	/**
	 * Creates an array of MyString objects with the values specified in an String array.
	 * @param stringArray Array with values to insert.
	 * @return Returns an MyString array with the specified values.
	 */
	private static Comparable[] createMyArray(String[] stringArray) {
		if(stringArray == null) {
			return null;
		}
		
		MyString[] myArray = new MyString[stringArray.length];
		
		for(int i = 0; i < stringArray.length; i++) {
			myArray[i] = new MyString(stringArray[i]);
		}
		
		return myArray;
	}
	
	/**
	 * Creates an array of MyInt objects with the values specified in an int array.
	 * @param intArray Array with values to insert.
	 * @return Returns an MyInt array with the specified values.
	 */
	private static Comparable[] createMyArray(int[] intArray) {
		if(intArray == null) {
			return null;
		}
		
		MyInt[] myArray = new MyInt[intArray.length];
		
		for(int i = 0; i < intArray.length; i++) {
			myArray[i] = new MyInt(intArray[i]);
		}
		
		return myArray;
	}
	
	/**
	 * Sorts an array with a specific sorting method.
	 * @param method The sorting method to use.
	 * @param array The array that should be sorted.
	 */
	public static void sortArray(Sort method, Comparable[] array) {
		method.sort(array);
	}
	
	/**
	 * Prints the values in an array to the console, separated by a comma.
	 * @param array The array that should be printed.
	 */
	public static void printArray(Comparable[] array) {
		if(array == null) {
			println("null");
		}
		
		for(int i = 0; i < array.length; i++) {
			if(i != 0) {
				print(", ");
			}
			print(array[i]);
		}
		println();
	}
	
}
