package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.myutil;

public class QueueArray implements Queue {

	private static final int STANDARD_PUFFER = 5;
	
	private Object elements[];
	private int start = 0, end = 0;
	int size;
	
	public QueueArray() {
		this(STANDARD_PUFFER);
	}
	
	public QueueArray(int size) {
		elements = new Object[size + 1];
		this.size = size;
	}
	
	@Override
	public void enter(Object element) throws OverflowException {
		if((elements.length - start + end) % elements.length == elements.length - 1) {
			if(size() == size) {
				// Double array range
				Object[] newElements = new Object[(elements.length * 2) - 1];
				
				
				int counter = 0;
				for(int i = 0; i <= (end - 1 + elements.length) % elements.length; i++) {
					newElements[i] = elements[i];
					counter++;
				}
				
				// Insert new elements
				for(int i = 0; i < elements.length - 1; i++) {
					newElements[counter + i] = null;
				}
				
				for(int i = counter; i < elements.length; i++) {
					newElements[elements.length - 1 + i] = elements[i];
					if(start == i) {
						start = elements.length + i;
					}
				}
				
				if(!(start < end || start == 0)) {
					start = (counter + (elements.length)) % (newElements.length);
					System.out.println("Counter: "+ counter);
				}
				
				end = (counter) % newElements.length;
				
				elements = newElements;
				
			}
			
			throw new OverflowException(element);
		}
		else {
			elements[end] = element;
			end = (end + 1) % elements.length;
		}

	}

	@Override
	public Object leave() throws UnderflowException {
		if(isEmpty()) {
			throw new UnderflowException("Removing an element from an empty queue is not possible.");
		}
		else {
			Object value = elements[start];
			elements[start] = null;
			start = (start + 1) % elements.length;
			
			return value;
		}
	}

	@Override
	public Object front() throws UnderflowException {
		if(isEmpty()) {
			throw new UnderflowException("Getting the front element from an empty queue is not possible.");
		}
		else {
			return elements[start];
		}
	}

	@Override
	public Queue empty() {
		return new QueueArray();
	}

	@Override
	public Queue empty(int bufferSize) {
		return new QueueArray(bufferSize);
	}

	@Override
	public boolean isEmpty() {
		return start == end;
	}

	@Override
	public int size() {
		return (elements.length + (end - start)) % elements.length;
	}
	
	@Override
	public String toString() {
		String value = "";
		
		for(int i = 0; i < elements.length; i++) {
			if(i != 0) {
				value += ", ";
			}
			value += elements[i];
		}
		
		return value;
	}

}
