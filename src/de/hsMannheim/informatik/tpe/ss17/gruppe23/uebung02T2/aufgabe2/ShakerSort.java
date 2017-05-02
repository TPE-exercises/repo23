package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung02T2.aufgabe2;

import static gdi.MakeItSimple.*;

public class ShakerSort implements Sort {
	
	/**
	 * This method contains an implementation of the shaker sort, a variation of the bubble sort,
	 * searching alternating in two directions.
	 * @param array Array to sort.
	 */
	@Override
	public void sort(Comparable[] array) {
		if(array == null) {
			throw new GDIException("null is an invalid array.");
		}
		
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