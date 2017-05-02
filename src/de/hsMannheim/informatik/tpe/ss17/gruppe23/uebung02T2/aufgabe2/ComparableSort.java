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
		sortArray(SortingMethod.InsertionSort, ints1);
		println("MyInt array after InsertionSort:");
		printArray(ints1);
		sortArray(SortingMethod.ShakerSort, ints2);
		println("MyInt array after ShakerSort:");
		printArray(ints2);
		
		println();
		
		println("MyString array before sort:");
		printArray(strings1);
		sortArray(SortingMethod.InsertionSort, strings1);
		println("MyString array after InsertionSort:");
		printArray(strings1);
		sortArray(SortingMethod.ShakerSort, strings2);
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
	public static void sortArray(SortingMethod method, Comparable[] array) {
		if(method == SortingMethod.InsertionSort) {
			insertionSort(array);
		}
		else if(method == SortingMethod.ShakerSort) {
			shakerSort(array);
		}
		else {
			throw new GDIException("Unknown sorting method.");
		}
	}
	
	/**
	 * Prints the values in an array to the console, separated by a comma.
	 * @param array The array that should be printed.
	 */
	public static void printArray(Comparable[] array) {
		for(int i = 0; i < array.length; i++) {
			if(i != 0) {
				print(", ");
			}
			print(array[i]);
		}
		println();
	}
	
	/**
	 * This method contains an implementation of the InsertionSort. The elements are sorted
	 * consecutively by inserting the current element at the right position in the already
	 * sorted part of the array.
	 * @param array Array to sort.
	 */
	public static void insertionSort(Comparable[] array) {
		for(int i = 1; i < array.length; i++) {
			Comparable marker = array[i];

			// Move all larger elements backwards
			int j;
			for(j = i; j > 0 && array[j - 1].compareTo(marker) > 0; j--) {
				array[j] = array[j - 1];
			}
			
			// Place current marker on free place
			array[j] = marker;
		}
	}
	
	/**
	 * This method contains an implementation of the shaker sort, a variation of the bubble sort,
	 * searching alternating in two directions.
	 * @param array Array to sort.
	 */
	public static void shakerSort(Comparable[] array) {
		boolean swapped = true;
		boolean leftToRight = true;
		int i;
		
		// algorithm ends when all elements are at the right place (no swaps anymore)
		while(swapped) {
			swapped = false;
			i = 0;
			if(!leftToRight)
				i = array.length - 1;
			
			while( (leftToRight && i < array.length - 1) || (!leftToRight && i > 0) ) {
				if(leftToRight){
					if(array[i].compareTo(array[i + 1]) > 0) {
						swap(array, i, i + 1);
						swapped = true;
					}
					
					i++;
				}
				else {
					if(array[i].compareTo(array[i - 1]) < 0) {
						swap(array, i, i - 1);
						swapped = true;
					}
					
					i--;
				}
			}
			
			if(swapped)			
			// change direction to search in the opposite direction
			leftToRight = !leftToRight;
		}
	}
	
	/**
	 * Swaps the elements at two specified indices in an array.
	 * @param array Array to swap the values in.
	 * @param index1 First index to swap at.
	 * @param index2 Second index to swap at.
	 */
	private static void swap(Comparable[] array, int index1, int index2) {
		Comparable tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
	}
}
