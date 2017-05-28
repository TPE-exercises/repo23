package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe2;

public class QuicksortParallel implements SortAlgorithm {

	private int comparisons, swaps, recursiveCalls, threads;
	private long time;
	
	public QuicksortParallel() {
		// Default constructor
	}
	
	@Override
	public void sort(Comparable[] array) {
		comparisons = 0;
		swaps = 0;
		recursiveCalls = 0;
		threads = 0;
		time = 0;
		
		if(array == null) return;
		
		long startTime = System.currentTimeMillis();
		
		Thread t = new QuickSortParallelThread(array, 0, array.length - 1, this);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			System.out.println("The main thread was interrupted and the quick sort ended unsuccessful.");
		}
		
		time = System.currentTimeMillis() - startTime;
	}
	
	/**
	 * Sets the number of comparisons.
	 * @param comparisons Number of comparisons.
	 */
	public void setComparisons(int comparisons) {
		this.comparisons = comparisons;
	}
	
	/**
	 * Sets the number of swaps.
	 * @param swaps Number of swaps.
	 */
	public void setSwaps(int swaps) {
		this.swaps = swaps;
	}
	
	/**
	 * Sets the number of recursive calls.
	 * @param recursiveCalls Number of recursive calls.
	 */
	public void setRecursiveCalls(int recursiveCalls) {
		this.recursiveCalls = recursiveCalls;
	}
	
	/**
	 * Sets the number of used threads.
	 * @param threads Number of used threads.
	 */
	public void setThreads(int threads) {
		this.threads = threads;
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
	
	/**
	 * Prints the stats of the last sort on the console.
	 */
	public void printStats() {
		System.out.println("Vergleiche: " + getComparisons());
		System.out.println("Vertauschungen: " + getSwaps());
		System.out.println("Rekursionsschritte: " + getRecursiveCalls());
		System.out.println("Erzeugte Threads: " + getThreads());
		System.out.println("Zeit: " + getMilliTime() + "ms");
		System.out.println();
	}

}
