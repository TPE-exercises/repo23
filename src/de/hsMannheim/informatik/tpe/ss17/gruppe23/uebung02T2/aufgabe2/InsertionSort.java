package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02T2.aufgabe2;

import static gdi.MakeItSimple.*;

public class InsertionSort implements Sort {
	
	/**
	 * This method contains an implementation of the InsertionSort. The elements are sorted
	 * consecutively by inserting the current element at the right position in the already
	 * sorted part of the array.
	 * @param array Array to sort.
	 */
	@Override
	public void sort(Comparable[] array) {
		if(array == null) {
			throw new GDIException("null is an invalid array.");
		}
		
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
}