package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.myutil;

public class QueueLinkedList implements Queue {

	private static final int STANDARD_PUFFER = 5;
	
	private LinkedList elements = null;
	private int startSize, size;
	
	public QueueLinkedList() {
		this(STANDARD_PUFFER);
	}
	
	public QueueLinkedList(int size) {
		elements = new LinkedList();
		this.startSize = size;
		this.size = size;
	}

	@Override
	public void enter(Object element) throws OverflowException {
		if(elements.size() >= size) {
			if(size == startSize) {
				size *= 2;
			}
			throw new OverflowException("Tried to insert in a full queue.", element);
		}
		else {
			elements.addLast(element);
		}
	}

	@Override
	public Object leave() throws UnderflowException {
		if(isEmpty()) {
			throw new UnderflowException("Tried to remove an element from an empty queue.");
		}
		else {
			return elements.removeFirst();
		}
	}

	@Override
	public Object front() throws UnderflowException {
		if(isEmpty()) {
			throw new UnderflowException("Tried to get the first element of an empty queue.");
		}
		else {
			return elements.getFirst();
		}
	}

	@Override
	public Queue empty() {
		return new QueueLinkedList();
	}

	@Override
	public Queue empty(int bufferSize) {
		return new QueueLinkedList(bufferSize);
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
