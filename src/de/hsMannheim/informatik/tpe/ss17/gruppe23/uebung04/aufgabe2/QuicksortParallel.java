package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe2;

/**
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 * Sorts the elements by using several threats.
 */
public class QuicksortParallel implements SortAlgorithm, Runnable{
	
	private Comparable[] array;
	private int lowerBorder, upperBorder;
	private int comparisons, swaps, recursiveCalls, threads;
	private long time;
	private QuicksortParallel caller;
	
	public QuicksortParallel() {
		// Standard Constructor
	}
	
	private QuicksortParallel(Comparable[] array, int lowerBorder, int upperBorder, QuicksortParallel caller) {
		this.array = array;
		this.lowerBorder = lowerBorder;
		this.upperBorder = upperBorder;
		this.caller = caller;
	}
	
	@Override
	public void sort(Comparable[] array) {
		comparisons = 0;
		swaps = 0;
		recursiveCalls = 0;
		threads = 0;
		time = 0;
		
		if(array == null) return;
		
		this.array = array;
		this.lowerBorder = 0;
		this.upperBorder = array.length - 1;
		this.caller = null;
		
		Thread t = new Thread(this);
		t.start();
		
		try {
			t.join();
		} catch (InterruptedException e) {
			System.out.println("An error occured. Try it again.");
		}
	}
	
	/**
	 * Prints the stats of the last sort on the console.
	 */
	public void printStats() {
		System.out.println("Vergleiche: " + comparisons);
		System.out.println("Vertauschungen: " + swaps);
		System.out.println("Rekursionsschritte: " + recursiveCalls);
		System.out.println("Erzeugte Threads: " + threads);
		System.out.println("Zeit: " + time + "ms");
		System.out.println();
	}
	
	public void run() {
		long startTime = System.currentTimeMillis();
		
		if(upperBorder > lowerBorder) {
			// Returns the current position of the pivot element after the split.
			int pivotIndex = split(array, lowerBorder, upperBorder);
			
			recursiveCalls++;
			// Ignore the position of the pivot element. Pivot element is currently at the right position.
			QuicksortParallel qs1 = new QuicksortParallel(array, lowerBorder, pivotIndex - 1, this);
			Thread t1 = new Thread(qs1);
			t1.start();
			QuicksortParallel qs2 = new QuicksortParallel(array, pivotIndex + 1, upperBorder, this);
			Thread t2 = new Thread(qs2);
			t2.start();
			
			threads += 2;
			
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
				return;
			}
			
			if(caller != null) {
				caller.addComparisons(comparisons);
				caller.addSwaps(swaps);
				caller.addRecursiveCalls(recursiveCalls);
				caller.addThreads(threads);
			}
			
			time = System.currentTimeMillis() - startTime;
		}
	}
	
	private void addComparisons(int comparisons) {
		this.comparisons += comparisons;
	}
	
	private void addSwaps(int swaps) {
		this.swaps += swaps;
	}
	
	private void addRecursiveCalls(int recursiveCalls) {
		this.recursiveCalls += recursiveCalls;
	}
	
	private void addThreads(int threads) {
		this.threads += threads;
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
		synchronized (array) {
			swaps++;
			Comparable tmp = array[index1];
			array[index1] = array[index2];
			array[index2] = tmp;
		}
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
	 * @return Number of used threads.
	 */
	public int getThreads() {
		return threads;
	}
	
}
