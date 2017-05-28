package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe2;

public class QuickSortParallelThread extends Thread {
	
	private Comparable[] array;
	private int lowerBorder, upperBorder;
	private int comparisons, swaps, recursiveCalls, threads;
	private QuickSortParallelThread caller;
	private QuicksortParallel startCaller;

	public QuickSortParallelThread(Comparable[] array, int lowerBorder, int upperBorder, QuicksortParallel startCaller) {
		this.array = array;
		this.lowerBorder = lowerBorder;
		this.upperBorder = upperBorder;
		this.startCaller = startCaller;
	}
	
	public QuickSortParallelThread(Comparable[] array, int lowerBorder, int upperBorder, QuickSortParallelThread caller) {
		this.array = array;
		this.lowerBorder = lowerBorder;
		this.upperBorder = upperBorder;
		this.caller = caller;
	}
	
	public void run() {
		if(upperBorder > lowerBorder) {
			// Returns the current position of the pivot element after the split.
			int pivotIndex = split(array, lowerBorder, upperBorder);
			
			recursiveCalls++;
			// Ignore the position of the pivot element. Pivot element is currently at the right position.
			QuickSortParallelThread t1 = new QuickSortParallelThread(array, lowerBorder, pivotIndex - 1, this);
			t1.start();
			QuickSortParallelThread t2 = new QuickSortParallelThread(array, pivotIndex + 1, upperBorder, this);
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
			
			if(startCaller != null) {
				startCaller.setComparisons(comparisons);
				startCaller.setSwaps(swaps);
				startCaller.setRecursiveCalls(recursiveCalls);
				startCaller.setThreads(threads);
			}
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
			
//			synchronized (array) {
//				if(array[pointer] <= array[pivot]) {
				if(array[pointer].compareTo(array[pivot]) <= 0) { // <=
					if(index != pointer) {
						swap(array, index, pointer);
					}
					index++;
//				}
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
//		synchronized (array) {
			swaps++;
			Comparable tmp = array[index1];
			array[index1] = array[index2];
			array[index2] = tmp;
//		}
	}
	
}
