package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung06.aufgabe2;

/**
 * This class contains an implementation of a simple box containing a single comparable object.
 *
 * @param <E> The type of the element the box contains.
 */
public class Box<E extends Comparable<E>> implements Comparable<Box<E>> {
	
	private E element;
	
	/**
	 * Creates a new box with a specific element.
	 * @param element Element to insert in the box.
	 */
	public Box(E element) {
		this.element = element;
	}
	
	/**
	 * Returns the element contained in the box.
	 * @return element in the box.
	 */
	public E getElement() {
		return element;
	}
	
	/**
	 * Sets a new element in the box.
	 * @param element New element.
	 */
	public void setElement(E element) {
		this.element = element;
	}

	/**
	 * Compares the box with another box using the contained elements.
	 */
	@Override
	public int compareTo(Box<E> other) {
		return this.element.compareTo(other.element);
	}
	
	/**
	 * Returns a string containing the value of the stored element.
	 */
	@Override
	public String toString() {
		return element.toString();
	}

}
