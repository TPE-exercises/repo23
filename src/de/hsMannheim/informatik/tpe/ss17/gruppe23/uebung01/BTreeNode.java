package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung01;

import static gdi.MakeItSimple.*;

public class BTreeNode {
	
	private Object[] values;
	private BTreeNode[] next;
	private BTreeNode parent;
	private int degree;

	public BTreeNode(int degree) {
		if(degree <= 0) {
			throw new GDIException("The order has to be positive.");
		}
		values = new Object[(degree * 2) + 1];
		next = new BTreeNode[(degree * 2) + 2];
		this.degree = degree;
	}
	
	public boolean isOverFilled() {
		return values[values.length - 1] != null;
	}
	
	public boolean isLeave() {
		/*for(int i = 0; i < next.length; i++) {
			if(next[i] != null) {
				return false;
			}
		}
		
		return true;*/
		
		return next[0] == null;
	}
	
	public boolean isEmpty() {
		/*for(int i = 0; i < values.length; i++) {
			if(values[i] != null) {
				return false;
			}
		}
		
		return true;*/
		
		return values[0] == null;
	}
	
	@Override
	public String toString() {
		String value = "[";
		int nr = 0;
		
		for(int i = 0; i < values.length; i++) {
			if(values[i] != null) {
				value += values[i].toString();
				value += " ";
				nr++;
			}
		}
		
		value += "]";
		
		return value;
	}
	
	public Object getMin() {
		if(next[0] == null){
			return values[0];
		}
		else {
			return next[0].getMin();
		}
	}
	
	public Object getMax() {
		for(int i = values.length - 1; i >= 0; i--) {
			if(values[i] != null) {
				return values[i];
			}
		}
		return null;
	}
	
	public BTreeNode getSmallestChild() {
		return next[0];
	}
	
	public int size() {
		int size = 0;
		for(Object value : values) {
			if(value != null) {
				size++;
			}
		}
		
		for(BTreeNode node : next) {
			if(node != null) {
				size += node.size();
			}
		}
		
		return size;
	}
	
	public BTreeNode getMinNext() {
		return next[0];
	}
	
	public Object[] getValues() {
		return values;
	}
	
	public BTreeNode[] getNext() {
		return next;
	}
	
	public BTreeNode getLargestChild() {
		for(int i = next.length - 1; i > 0; i--) {
			if(next[i] != null) {
				return next[i];
			}
		}
		return null;
	}
	
	public boolean contains(Object obj) {
		for(int i = 0; i < values.length; i++) {
			if(values[i] != null && values[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}
	
	/*public Object getValue(int index) {
		if(index < 0 || index >= values.length) {
			throw new GDIException("Value index not found.");
		}
		
		return values[index];
	}
	
	public void setValue(int index, Object o) {
		if(index < 0 || index >= values.length) {
			throw new GDIException("Value index not found.");
		}
		
		values[index] = o;
	}
	
	public BTreeNode getNext(int index) {
		if(index < 0 || index >= next.length) {
			throw new GDIException("Next index not found.");
		}
		
		return next[index];
	}
	
	public void setNext(int index, BTreeNode o) {
		if(index < 0 || index >= next.length) {
			throw new GDIException("Next index not found.");
		}
		
		next[index] = o;
	}*/
	
	public void insert(Object o, BTreeNode rightPart, BTreeNode leftPart) {
		if(values[values.length - 1] != null) {
			throw new GDIException("Node alredy filled. Insertion impossible.");
		}
		
		for(int i =  values.length - 1; i >= 0; i--) {
			// TODO: Handling full nodes input position last array postition
			if(values[i] != null) {
				if((Integer)values[i] > (Integer)o) {
					values[i + 1] = values[i];
					next[i + 2] = next[i + 1];
				}
				else if(values[i].equals(o)) {
					throw new GDIException("Double values are not allowed.");
				}
				else {
					values[i + 1] = o;
					//next[i + 2] = next[i + 1];
					next[i + 2] = rightPart; // i + 1 TODO
					return;
				}
			}
			
		}
		//next[1] = next[0];
		values[0] = o;
		next[1] = rightPart;
		if(leftPart != null) {
			next[0] = leftPart;
		}
		return;
	}
	
	public void insert(Object o) {	
		insert(o, null, null);
	}
	
	public BTreeNode getNextNodeToSearch(Object o) {
		BTreeNode nextNode = next[values.length - 1];
		boolean found = false;
		
		for(int i = 0; i < values.length - 1; i++) {
			if(values[i] == null || (Integer)o < (Integer)values[i]) {
				if(!found) {
					nextNode = next[i];
					found = true;
				}
			}
		}
		
		return nextNode;
	}
	
	public Object split(BTreeNode parent) {
		BTreeNode rightNode = new BTreeNode((values.length - 1) / 2);
		
		int middlePosition = values.length / 2;
		
		for(int i = middlePosition + 1; i < values.length; i++) {
			rightNode.insert(values[i], next[i + 1], null);
		}
		rightNode.next[0] = next[middlePosition + 1];
		
		parent.insert(values[middlePosition], rightNode, this);
			
		
		Object middleElement = values[middlePosition];
		
		for(int i = middlePosition; i < values.length; i++) {
			values[i] = null;
		}
		for(int i = middlePosition + 1; i < next.length; i++) {
			next[i] = null;
		}
		
		return middleElement;
	}
	
}
