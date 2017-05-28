package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe2;

public interface SortAlgorithm {

	/**
	 * Sorts an array of Comparable elements.
	 * @param array Array to sort.
	 */
	public void sort(Comparable[] array);
	
	/**
	 * Prints the stats of the last sort to the console:
	 * Comparisons, swaps, recursive calls, threads and time.
	 */
	public void printStats();
	
}
