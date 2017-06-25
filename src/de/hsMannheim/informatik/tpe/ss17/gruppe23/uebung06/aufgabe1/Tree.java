package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung06.aufgabe1;

/**
 * This class contains an implementation of a tree containing values of a specific type.
 * 
 * @param <T> Type of the values stored in the tree.
 * 
 */
public class Tree<T> {

	/**
	 * Inserts a new value in the tree.
	 * @param value Value to insert.
	 * @return 
	 */
	public void insert(T value) {}
	
	/**
	 * Checks if a value is contained in the tree.
	 * @param value The value to check for in the tree.
	 * @return true = value is contained, falue = value not contained.
	 */
	public boolean contains(T value) {
		return false;
	}
	
	/**
	 * Returns the number of elements in the tree.
	 * @return
	 */
	public int size() {
		return 0;
	}
	
	/**
	 * Returns the height of the tree.
	 * @return height of the tree.
	 */
	public int height() {
		return 0;
	}
	
	/**
	 * Returns the maximum element stored in the tree.
	 * @return The maximum element.
	 */
	public T getMax() {
		return null;
	}
	
	/**
	 * Returns the minimum element stored in the tree.
	 * @return The minimum element.
	 */
	public T getMin() {
		return null;
	}
	
	/**
	 * Removes a value from the tree.
	 * @param value Value to remove.
	 */
	public void remove (T value) {}
	
	/**
	 * Returns if the tree is empty.
	 * @return true = tree empty, false = tree not empty.
	 */
	public boolean isEmpty() {
		return false;
	}
	
	/**
	 * Inserts all values stored in another tree (otherTree) in the current tree.
	 * @param otherTree Tree to insert values from.
	 */
	public void addAll(Tree<T> otherTree) {}
	
	/**
	 * Print the tree inorder.
	 */
	public void printInorder() {}
	
	/**
	 * Print the tree postorder.
	 */
	public void printPostorder() {
		//
	}
	
	/**
	 * Print the tree preorder.
	 */
	public void printPreorder() {
		//
	}
	
	/**
	 * Print the tree levelorder.
	 */
	public void printLevelorder() {
		//
	}
	
	/**
	 * Create a deep copy of the tree.
	 */
	@Override
	public Tree<T> clone() {
		return null;
	}
	
}
