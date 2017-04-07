package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung01;

import static gdi.MakeItSimple.*;

/**
 * This class contains an implementation of the nodes of a B-Tree.
 * The node contains a number of values (degree - 2 * degree) and one more
 * child than values in the tree.
 * 
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 */
public class BTreeNode {
	
	private Object[] values;
	private BTreeNode[] next;
	private BTreeNode parent;
	private int degree;

	/**
	 * Creates a new BTreeNode Object with a given degree.
	 * @param degree The degree of the node.
	 */
	public BTreeNode(int degree) {
		if(degree <= 0) {
			throw new GDIException("The order has to be positive.");
		}
		values = new Object[(degree * 2) + 1];
		next = new BTreeNode[(degree * 2) + 2];
		this.degree = degree;
	}
	
	/**
	 * This method returns whether the node is over filled (more than 2 * degree values).
	 * @return true if over filled, false if number of values between degree and 2 * degree.
	 */
	public boolean isOverFilled() {
		return values[values.length - 1] != null;
	}
	
	/**
	 * Returns if the node is a leaf (has no children).
	 * @return true if the node is a leaf, false if not.
	 */
	public boolean isLeaf() {
		return next[0] == null;
	}
	
	/**
	 * Returns if the node is empty (has no elements).
	 * @return true if node is empty, false if not.
	 */
	public boolean isEmpty() {
		return values[0] == null;
	}
	
	@Override
	/**
	 * Creates a string with a representation of the node in the format: [ elements ].
	 */
	public String toString() {
		String value = "[";
		int nr = 0;
		
		for(int i = 0; i < values.length; i++) {
			if(values[i] != null) {
				if(nr != 0) {
					value += " ";
				}
				value += values[i].toString();
				nr++;
			}
		}
		
		value += "]";
		
		return value;
	}
	
	/**
	 * Searches for the smallest element at the subtree (node and it's children).
	 * @return returns the smallest value at the subtree.
	 */
	public Object getMin() {
		if(next[0] == null){
			return values[0];
		}
		else {
			return next[0].getMin();
		}
	}
	
	/**
	 * Searches for the largest element at the subtree (node and it's children).
	 * @return returns the largest value at the subtree.
	 */
	public Object getMax() {
		for(int i = next.length - 1; i >= 0; i--) {
			if(next[i] != null) {
				return next[i].getMax();
			}
		}
		
		for(int i = values.length - 1; i >= 0; i--) {
			if(values[i] != null) {
				return values[i];
			}
		}
		
		return null;
		
		/*for(int i = values.length - 1; i >= 0; i--) {
			if(values[i] != null) {
				return values[i];
			}
		}
		return null;*/
	}
	
	/*public BTreeNode getSmallestChild() {
		return next[0];
	}*/
	
	/**
	 * Calculates the size (number of elements) at the subtree.
	 * @return Returns the number of elements.
	 */
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
	
	/**
	 * Returns the smallest child of the node.
	 * @return smallest child, null if not existing.
	 */
	public BTreeNode getMinNext() {
		return next[0];
	}
	
	/**
	 * Returns the array of values stored at this node.
	 * @return values
	 */
	public Object[] getValues() {
		return values;
	}
	
	/**
	 * Inserts all elements in the node and subtree in the array.
	 * @return returns an array with all elements in the subtree in it.
	 */
	public Object[] getAll() {
		Object[] all = new Object[0];
		for(int i = 0; i < values.length; i++) {
			if(values[i] != null) {
				Object[] val = new Object[1];
				val[0] = values[i];
				all = mergeArrays(all, val);
			}
		}
		
		for(int i = 0; i < next.length; i++) {
			if(next[i] != null) {
				Object[] nextArray = next[i].getAll();
				all = mergeArrays(all, nextArray);
			}
		}
		
		return all;
	}
	
	public BTreeNode cloneDeep() {
		BTreeNode clone = new BTreeNode(degree);
		clone.values = this.values;
		for(int i = 0; i < next.length; i++) {
			if(next[i] != null) {
				clone.next[i] = next[i].cloneDeep();
			}
		}
		
		return clone;
	}
	
	/**
	 * Merges the elements of two arrays in one larger array with all elements.
	 * @param a1 First array to merge.
	 * @param a2 Second array to merge.
	 * @return Merged array.
	 */
	private Object[] mergeArrays(Object[] a1, Object[] a2) {
		Object[] merged = new Object[a1.length + a2.length];
		
		for(int i = 0; i < a1.length; i++) {
			merged[i] = a1[i];
		}
		for(int i = a1.length, j = 0; j < a2.length; i++, j++) {
			merged[i] = a2[j];
		}
		
		return merged;
	}
	
	/**
	 * Returns the array of children of this node.
	 * @return children of this node.
	 */
	public BTreeNode[] getNext() {
		return next;
	}
	
	/*public BTreeNode getLargestChild() {
		for(int i = next.length - 1; i > 0; i--) {
			if(next[i] != null) {
				return next[i];
			}
		}
		return null;
	}*/
	
	/**
	 * Checks whether an object is contained in the node.
	 * @param obj Object to search for in the node.
	 * @return true if element in this node, false if not.
	 */
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
	
	/**
	 * Inserts an element at the right position in the node.
	 * The right and left child of this value are set, too.
	 * @param o value to insert in the node.
	 * @param rightPart right child at the position next to the inserted number.
	 * @param leftPart left child at the position next to the inserted number.
	 * @exception Throws an exception if the node is over filled or the value already exists.
	 */
	public void insert(Object o, BTreeNode rightPart, BTreeNode leftPart) {
		if(values[values.length - 1] != null) {
			throw new GDIException("Node alredy filled. Insertion impossible.");
		}
		
		for(int i =  values.length - 1; i >= 0; i--) {
			// TODO: Handling full nodes input position last array position
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
					next[i + 2] = rightPart;
					return;
				}
			}
			
		}
		values[0] = o;
		next[1] = rightPart;
		if(leftPart != null) {
			next[0] = leftPart;
		}
		return;
	}
	
	/**
	 * Inserts a single element in the node, without affecting it's children.
	 * @param o Element to insert in the node.
	 */
	public void insert(Object o) {	
		insert(o, null, null);
	}
	
	/**
	 * Searches for the right position of the passed object or the position at
	 * which the element would be, if it was in the tree.
	 * @param o Element to search for or for it's position.
	 * @return returns the best fitting child, null if no children (leaf).
	 */
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
	
	/**
	 * Splits the current node at the middle element in two new nodes.
	 * The middle element gets inserted at the parent node and the
	 * references to the two new subnodes are updated.
	 * @param parent parent node of the current node.
	 */
	public void split(BTreeNode parent) {
		BTreeNode rightNode = new BTreeNode((values.length - 1) / 2);
		
		int middlePosition = values.length / 2;
		
		for(int i = middlePosition + 1; i < values.length; i++) {
			rightNode.insert(values[i], next[i + 1], null);
		}
		rightNode.next[0] = next[middlePosition + 1];
		
		parent.insert(values[middlePosition], rightNode, this);
		
		//Object middleElement = values[middlePosition];
		
		for(int i = middlePosition; i < values.length; i++) {
			values[i] = null;
		}
		for(int i = middlePosition + 1; i < next.length; i++) {
			next[i] = null;
		}
		
		//return middleElement;
	}
	
}
