package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe2;

/**
 * The parallel quick sort takes way more time, mostly because the management of
 * the threads takes more time then it gains. This effect is even more relevant
 * when the parallelized tasks are not very time-consuming, so the sequential
 * approach is faster.
 *
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 */
public class Program {
	
	private static QuicksortSequential qss = new QuicksortSequential();
	private static QuicksortParallel   qsp = new QuicksortParallel();
	
	private static Comparable[][] testArrays = {
			{	// Test array 1 (8 Elements)
				new Integer(5),  new Integer(9),   new Integer(2),  new Integer(4),
				new Integer(7),  new Integer(5),   new Integer(3),  new Integer(35)
			},
			
			{	// Test array 2 (42 Elements)
				new Integer(5),  new Integer(9),   new Integer(2),  new Integer(4),
				new Integer(7),  new Integer(5),   new Integer(3),  new Integer(35),
				new Integer(0),  new Integer(-4),  new Integer(8),  new Integer(87),
				new Integer(31), new Integer(24),  new Integer(47), new Integer(42),
				new Integer(29), new Integer(-3),  new Integer(73), new Integer(62),
				new Integer(55), new Integer(-69), new Integer(77), new Integer(60),
				new Integer(39), new Integer(-23), new Integer(56), new Integer(4),
				new Integer(11), new Integer(05),  new Integer(45), new Integer(32),
				new Integer(99), new Integer(26),  new Integer(44), new Integer(-8),
				new Integer(67), new Integer(24),  new Integer(38), new Integer(33),
				new Integer(95), new Integer(91)
			},
			
			{	// Test array 3: (400 Elements)
				new Integer(5),  new Integer(9),   new Integer(2),  new Integer(4), new Integer(7),  new Integer(5),   new Integer(3),  new Integer(35),
				new Integer(0),  new Integer(-4),  new Integer(8),  new Integer(87), new Integer(31), new Integer(24),  new Integer(47), new Integer(42),
				new Integer(29), new Integer(-3),  new Integer(73), new Integer(62), new Integer(55), new Integer(-69), new Integer(77), new Integer(60),
				new Integer(39), new Integer(-23), new Integer(56), new Integer(4), new Integer(11), new Integer(05),  new Integer(45), new Integer(32),
				new Integer(99), new Integer(26),  new Integer(44), new Integer(-8), new Integer(67), new Integer(24),  new Integer(38), new Integer(33),
				new Integer(5),  new Integer(9),   new Integer(2),  new Integer(4), new Integer(7),  new Integer(5),   new Integer(3),  new Integer(35),
				new Integer(0),  new Integer(-4),  new Integer(8),  new Integer(87), new Integer(31), new Integer(24),  new Integer(47), new Integer(42),
				new Integer(29), new Integer(-3),  new Integer(73), new Integer(62), new Integer(55), new Integer(-69), new Integer(77), new Integer(60),
				new Integer(39), new Integer(-23), new Integer(56), new Integer(4), new Integer(11), new Integer(05),  new Integer(45), new Integer(32),
				new Integer(99), new Integer(26),  new Integer(44), new Integer(-8), new Integer(67), new Integer(24),  new Integer(38), new Integer(33),
				new Integer(5),  new Integer(9),   new Integer(2),  new Integer(4), new Integer(7),  new Integer(5),   new Integer(3),  new Integer(35),
				new Integer(0),  new Integer(-4),  new Integer(8),  new Integer(87), new Integer(31), new Integer(24),  new Integer(47), new Integer(42),
				new Integer(29), new Integer(-3),  new Integer(73), new Integer(62), new Integer(55), new Integer(-69), new Integer(77), new Integer(60),
				new Integer(39), new Integer(-23), new Integer(56), new Integer(4), new Integer(11), new Integer(05),  new Integer(45), new Integer(32),
				new Integer(99), new Integer(26),  new Integer(44), new Integer(-8), new Integer(67), new Integer(24),  new Integer(38), new Integer(33),
				new Integer(5),  new Integer(9),   new Integer(2),  new Integer(4), new Integer(7),  new Integer(5),   new Integer(3),  new Integer(35),
				new Integer(0),  new Integer(-4),  new Integer(8),  new Integer(87), new Integer(31), new Integer(24),  new Integer(47), new Integer(42),
				new Integer(29), new Integer(-3),  new Integer(73), new Integer(62), new Integer(55), new Integer(-69), new Integer(77), new Integer(60),
				new Integer(39), new Integer(-23), new Integer(56), new Integer(4), new Integer(11), new Integer(05),  new Integer(45), new Integer(32),
				new Integer(99), new Integer(26),  new Integer(44), new Integer(-8), new Integer(67), new Integer(24),  new Integer(38), new Integer(33),
				new Integer(5),  new Integer(9),   new Integer(2),  new Integer(4), new Integer(7),  new Integer(5),   new Integer(3),  new Integer(35),
				new Integer(0),  new Integer(-4),  new Integer(8),  new Integer(87), new Integer(31), new Integer(24),  new Integer(47), new Integer(42),
				new Integer(29), new Integer(-3),  new Integer(73), new Integer(62), new Integer(55), new Integer(-69), new Integer(77), new Integer(60),
				new Integer(39), new Integer(-23), new Integer(56), new Integer(4), new Integer(11), new Integer(05),  new Integer(45), new Integer(32),
				new Integer(99), new Integer(26),  new Integer(44), new Integer(-8), new Integer(67), new Integer(24),  new Integer(38), new Integer(33),
				new Integer(5),  new Integer(9),   new Integer(2),  new Integer(4), new Integer(7),  new Integer(5),   new Integer(3),  new Integer(35),
				new Integer(0),  new Integer(-4),  new Integer(8),  new Integer(87), new Integer(31), new Integer(24),  new Integer(47), new Integer(42),
				new Integer(29), new Integer(-3),  new Integer(73), new Integer(62), new Integer(55), new Integer(-69), new Integer(77), new Integer(60),
				new Integer(39), new Integer(-23), new Integer(56), new Integer(4), new Integer(11), new Integer(05),  new Integer(45), new Integer(32),
				new Integer(99), new Integer(26),  new Integer(44), new Integer(-8), new Integer(67), new Integer(24),  new Integer(38), new Integer(33),
				new Integer(5),  new Integer(9),   new Integer(2),  new Integer(4), new Integer(7),  new Integer(5),   new Integer(3),  new Integer(35),
				new Integer(0),  new Integer(-4),  new Integer(8),  new Integer(87), new Integer(31), new Integer(24),  new Integer(47), new Integer(42),
				new Integer(29), new Integer(-3),  new Integer(73), new Integer(62), new Integer(55), new Integer(-69), new Integer(77), new Integer(60),
				new Integer(39), new Integer(-23), new Integer(56), new Integer(4), new Integer(11), new Integer(05),  new Integer(45), new Integer(32),
				new Integer(99), new Integer(26),  new Integer(44), new Integer(-8), new Integer(67), new Integer(24),  new Integer(38), new Integer(33),
				new Integer(5),  new Integer(9),   new Integer(2),  new Integer(4), new Integer(7),  new Integer(5),   new Integer(3),  new Integer(35),
				new Integer(0),  new Integer(-4),  new Integer(8),  new Integer(87), new Integer(31), new Integer(24),  new Integer(47), new Integer(42),
				new Integer(29), new Integer(-3),  new Integer(73), new Integer(62), new Integer(55), new Integer(-69), new Integer(77), new Integer(60),
				new Integer(39), new Integer(-23), new Integer(56), new Integer(4), new Integer(11), new Integer(05),  new Integer(45), new Integer(32),
				new Integer(99), new Integer(26),  new Integer(44), new Integer(-8), new Integer(67), new Integer(24),  new Integer(38), new Integer(33),
				new Integer(5),  new Integer(9),   new Integer(2),  new Integer(4), new Integer(7),  new Integer(5),   new Integer(3),  new Integer(35),
				new Integer(0),  new Integer(-4),  new Integer(8),  new Integer(87), new Integer(31), new Integer(24),  new Integer(47), new Integer(42),
				new Integer(29), new Integer(-3),  new Integer(73), new Integer(62), new Integer(55), new Integer(-69), new Integer(77), new Integer(60),
				new Integer(39), new Integer(-23), new Integer(56), new Integer(4), new Integer(11), new Integer(05),  new Integer(45), new Integer(32),
				new Integer(99), new Integer(26),  new Integer(44), new Integer(-8), new Integer(67), new Integer(24),  new Integer(38), new Integer(33),
				new Integer(5),  new Integer(9),   new Integer(2),  new Integer(4), new Integer(7),  new Integer(5),   new Integer(3),  new Integer(35),
				new Integer(0),  new Integer(-4),  new Integer(8),  new Integer(87), new Integer(31), new Integer(24),  new Integer(47), new Integer(42),
				new Integer(29), new Integer(-3),  new Integer(73), new Integer(62), new Integer(55), new Integer(-69), new Integer(77), new Integer(60),
				new Integer(39), new Integer(-23), new Integer(56), new Integer(4), new Integer(11), new Integer(05),  new Integer(45), new Integer(32),
				new Integer(99), new Integer(26),  new Integer(44), new Integer(-8), new Integer(67), new Integer(24),  new Integer(38), new Integer(33),
				new Integer(95), new Integer(91),  new Integer(44), new Integer(-8), new Integer(67), new Integer(24),  new Integer(38), new Integer(33)
			}
	};
	
	/**
	 * Compares a few example arrays with both, the sequential and the parallel quick sort
	 * and compares the results (array values, comparisons, swaps, recursive calls, threads
	 * and time).
	 * @param args
	 */
	public static void main(String[] args) {
		if(testArrays == null || testArrays.length == 0) {
			System.out.println("No test performed.");
		}
		for(int i = 0; i < testArrays.length; i++) {
			System.out.println("Test " + (i + 1) + ":");
			sortAndCompare(testArrays[i]);
			System.out.println();
			System.out.println();
		}
	}
	
	/**
	 * Sorts a given array with the Quicksort in parallel and sequential and
	 * prints a comparison to the console.
	 * @param array Array to sort.
	 */
	private static void sortAndCompare(Comparable[] array) {
		// Sequential quicksort
		sortAndPrint("Quicksort Sequential", array, qss);

		// Parallel quicksort
		sortAndPrint("Quicksort Parallel", array, qsp);
		
	}
	
	/**
	 * Sorts an array with a specific sort algorithm and prints the results and
	 * stats to the console.
	 * @param message Message to display before sort.
	 * @param array Array to sort.
	 * @param algo Algorithm to use to sort the array.
	 */
	private static void sortAndPrint(String message, Comparable[] array, SortAlgorithm algo) {
		Comparable[] arrayCopy = copyArray(array);
		
		System.out.println("Quicksort Sequential:");
		System.out.println();
		
		printArray("Before:", arrayCopy);
		
		algo.sort(arrayCopy);
		
		printArray("After:", arrayCopy);
		
		// Print stats
		algo.printStats();
	}
	
	/**
	 * Prints the content of an array to the console.
	 * @param message Message displayed before the array content.
	 * @param array Array to print.
	 */
	private static void printArray(String message, Object[] array) {
		System.out.println(message);
		
		if(array == null) {
			System.out.println("null");
			return;
		}
		
		for(int i = 0; i < array.length; i++) {
			if(i != 0) {
				System.out.print(", ");
			}
			System.out.print(array[i].toString());
		}
		System.out.println();
		System.out.println();
	}
	
	/**
	 * Creates a flat copy of a comparable array.
	 * @param array array to copy.
	 * @return flat copy of the array.
	 */
	private static Comparable[] copyArray(Comparable[] array) {
		if(array == null) {
			return null;
		}
		
		Comparable[] copy = new Comparable[array.length];
		for(int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		return copy;
	}

}
