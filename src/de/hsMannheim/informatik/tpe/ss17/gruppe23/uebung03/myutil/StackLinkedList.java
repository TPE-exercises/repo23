package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.myutil;

/**
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 */
public class StackLinkedList implements Stack {
	
	private static final int STANDARD_PUFFER = 5;
	
	private LinkedList elements = null;
	private int startSize, size;
	
	public StackLinkedList() {
		this(STANDARD_PUFFER);
	}
	
	public StackLinkedList(int size) {
		if(size < 1) {
			throw new IllegalArgumentException();
		}
		
		elements = new LinkedList();
		this.startSize = size;
		this.size = size;
	}

	@Override
	public void push(Object element) throws OverflowException {
		if(elements.size() >= size) {
			if(size == startSize) {
				size *= 2;
			}
			throw new OverflowException("Tried to insert in a full stack.", element);
		}
		else {
			elements.addFirst(element);
		}
	}

	@Override
	public Object pop() throws UnderflowException {
		if(isEmpty()) {
			throw new UnderflowException("Tried to remove an element from an empty stack.");
		}
		else {
			Object value = elements.getFirst();
			elements.removeFirst();
			return value;
		}

	}

	@Override
	public Object top() throws UnderflowException {
		if(isEmpty()) {
			throw new UnderflowException("Tried to get the top element of an empty stack.");
		}
		else {
			return elements.getFirst();
		}
	}

	@Override
	public Stack empty() {
		return new StackLinkedList();
	}

	@Override
	public Stack empty(int puffer) {
		return new StackLinkedList(puffer);
	}

	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@Override
	public int size() {
		return elements.size();
	}

}
