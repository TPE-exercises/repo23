package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe2;

public class QuicksortSequential implements SortAlgorithm {

	private int comparisons, swaps, recursiveCalls;
	private long time;
	
	public QuicksortSequential() {
		// Default constructor
	}
	
	public void sort(Comparable[] array) {
		comparisons = 0;
		swaps = 0;
		recursiveCalls = 0;
		time = 0;
		
		if(array == null) return;
		
		long startTime = System.currentTimeMillis();
		
		quicksort(array, 0, array.length - 1);
		
		time = System.currentTimeMillis() - startTime;
	}
	
	
	/**
	 * Recursively call of the Quicksort method and sort of the array.
	 * @param array Series of numbers to sort.
	 * @param lowerBorder of the unsorted part of the array
	 * @param upperBorder of the unsorted part of the array
	 */
	public void quicksort(Comparable[] array, int lowerBorder, int upperBorder) {		
		if(upperBorder > lowerBorder) {
			// Returns the current position of the pivot element after the split.
			int pivotIndex = split(array, lowerBorder, upperBorder);
			
			recursiveCalls++;
			// Ignore the position of the pivot element. Pivot element is currently at the right position.
			quicksort(array, lowerBorder, pivotIndex - 1);	
			quicksort(array, pivotIndex + 1, upperBorder);
		}
	}
	
	/**
	 * Splits the elements of the array at the value of the pivot element.
	 * @param array Series of numbers to split.
	 * @param lowerBorder of the unsorted part of the array
	 * @param upperBorder of the unsorted part of the array
	 * @return Index position of the pivot element.
	 */
	public int split(Comparable[] array, int lowerBorder, int upperBorder) {
		int pivot = upperBorder;
		int index = lowerBorder;
		
		for(int pointer = lowerBorder; pointer < upperBorder; pointer++) {
			comparisons++;
//			if(array[pointer] <= array[pivot]) {
			if(array[pointer].compareTo(array[pivot]) <= 0) { // <=
				if(index != pointer) {
					swap(array, index, pointer);
				}
				index++;
			}
		}
		
		if(index != pivot) {
			swap(array, index, pivot);
		}
		
		return index;
	}

	/**
	 * Swaps the elements in the series of numbers at the passed indices.
	 */
	private void swap(Comparable[] array, int index1, int index2) {
		swaps++;
		Comparable tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
	}
	
	/**
	 * Returns the number of comparisons performed in the last sort.
	 * @return Number of comparisons.
	 */
	public int getComparisons() {
		return comparisons;
	}
	
	/**
	 * Returns the number of swaps performed in the last sort.
	 * @return Number of swaps.
	 */
	public int getSwaps() {
		return swaps;
	}
	
	/**
	 * Returns the number of recursive calls in the last sort.
	 * @return Number of recursive calls.
	 */
	public int getRecursiveCalls() {
		return recursiveCalls;
	}
	
	/**
	 * Returns the amount of time that the algorithm terminated in.
	 * @return Used amount of time.
	 */
	public long getMilliTime() {
		return time;
	}
	
	/**
	 * Returns the number of thread used beside the main thread.
	 * @return Number of used threads. (0 for sequential quick sort)
	 */
	public int getThreads() {
		return 0;
	}
	
	/**
	 * Prints the stats of the last sort on the console.
	 */
	public void printStats() {
		System.out.println("Vergleiche: " + getComparisons());
		System.out.println("Vertauschungen: " + getSwaps());
		System.out.println("Rekursionsschritte: " + getRecursiveCalls());
		System.out.println("Erzeugte Threads: 0");
		System.out.println("Zeit: " + getMilliTime() + "ms");
		System.out.println();
	}
	
}
