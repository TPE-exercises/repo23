package de.hsMannheim.tpe.ss17.gruppe2_2.uebung01;

public class Queue {
	BTreeNode[] q = new BTreeNode[16384];
	private int front = 0;
	private int end = 0;
	private int count = 0;

	public Queue() {
	}

	public Queue(int length) {
		this.q = new BTreeNode[length];
	}

	/**
	 * @param el:
	 *            The element that joins the queue.
	 */
	public void enter(BTreeNode el) {
		if (isFull()) {
			System.out.println("Queue is full. Please serve more capacity.");
		} else {
			this.q[this.end] = el;
			this.count++;

			if (this.end == (this.q.length - 1)) {
				this.end = 0;
			} else {
				this.end++;
			}
			
		}
	}

	/**
	 * Returns an element and makes it exit the queue.
	 * 
	 * @return the element at the front of the queue.
	 */

	public BTreeNode leave() {
		if (!isEmpty()) {
			this.count--;
			if (this.end != (this.front)) {
				this.front += 1;
				if (this.front >= this.q.length) {
					this.front = 0;
				}
			}
			return this.q[this.front];
		} else {
			System.out.println("Error: Queue is empty");
			return null;
		}
	}

	public BTreeNode peak() {
		return this.q[this.front];
	}

	public boolean isEmpty() {
		if (this.count == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		if (this.count == this.q.length) {
			return true;
		} else {
			return false;
		}
	}
}
