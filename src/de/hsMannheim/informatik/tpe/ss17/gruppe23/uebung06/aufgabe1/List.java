package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung06.aufgabe1;

/**
 * Contains an implementation of a list storing values of a specific type.
 *
 * @param <T> Type of the values stored in the list.
 * 
 */
public class List<T> {
	
	/**
	 * Creates a new empty list.
	 */
	public List() {}
	

	/**
	 * This method inserts an element at the index position.
	 * @param index where to insert element
	 * @param element to insert
	 */
	public void add(int index, T element) {}
	
	/**
	 * This method returns the value of the element at the index position.
	 * @param index to search for
	 * @return element value
	 */
	public T get(int index) {
		return null;
	}
	
	/**
	 * Removes all existing elements with the passed value.
	 * @param element Value of elements to remove.
	 */
	public void remove(T element) {}
	
	/**
	 * Deletes the element at an index position.
	 * @param index position where to delete.
	 * @return the deleted elements value.
	 */
	public T delete(int index) {
		return null;
	}
	
	/**
	 * Inserts a value at the first position of the list.
	 * @param value to insert
	 */
	public void addFirst(T value) {}
	
	/**
	 * Returns the value at the first position of the list.
	 * @return first value
	 */
	public T getFirst() {
		return null;
	}
	
	/**
	 * Removes the first element from the list
	 * @return the previous first elements value.
	 */
	public T removeFirst() {
		return null;
	}
	
	/**
	 * Inserts a value at the last position of the list.
	 * @param value to insert
	 */
	public void addLast(T value) {}
	
	/**
	 * Returns the value at the last position of the list.
	 * @return last value
	 */
	public T getLast() {
		return null;
	}
	
	/**
	 * Removes the last element from the list
	 * @return the previous last elements value.
	 */
	public T removeLast() {
		return null;
	}
	
	/**
	 * Clears the list, removing all elements of the list.
	 */
	public void clear() {}
	
	/**
	 * Returns if the list is empty (no elements) or not.
	 * @return true = no elements, false = elements in list
	 */
	public boolean isEmpty() {
		return false;
	}
	
	/**
	 * Returns the number of elements in the list.
	 * @return number of elements.
	 */
	public int size() {
		return 0;
	}
	
	/**
	 * Creates a flat copy of the list, only cloning the list object, not the
	 * actual ListNodes.
	 * @return a flat copy
	 */
	public List<T> clone() {
		return null;
	}
	
	/**
	 * Searches for a value in the list and returns if it is found.
	 * @param value to search for
	 * @return whether the value was found or not
	 */
	public boolean contains(T value) {
		return false;
	}
	
	/**
	 * Creates a string with all ListNode values.
	 * @return String with list content.
	 */
	public String toString() {
		return null;
	}
	
	/**
	 * Adds all items of another list to the current list.
	 * @param otherList that should be added.
	 */
	public void addAll(List<T> otherList) {}
		
}
