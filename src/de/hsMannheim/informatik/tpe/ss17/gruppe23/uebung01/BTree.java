package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung01;

import static gdi.MakeItSimple.*;

/**
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 */
public class BTree implements ADTBTree {

	private static final char SPACECHARACTER = ' ';

	private BTreeNode root;
	private int degree;

	public BTree(int degree) {
		if(degree <= 0) {
			throw new GDIException("The order has to be positive.");
		}
		else {
			this.degree = degree;
		}
	}

	/* TODO: remove
	public BTreeNode getRoot(){
		return this.root;
	}
	 */

	public int getOrder(){
		return this.degree;
	}

	public boolean insert(Object o) {

		if(o == null || contains(o)) {
			return false;
		}

		if(root == null) {
			// Tree is empty
			root = new BTreeNode(degree);
			root.insert(o);
		}
		else {
			// Tree is not empty
			// 1. find leave
			BTreeNode newRoot =  new BTreeNode(degree);
			insertRecursive(o, root, newRoot);

			if(!newRoot.isEmpty()) {
				root = newRoot;
			}

		}

		return true;
	}

	private void insertRecursive(Object o, BTreeNode currentNode, BTreeNode previousNode) {
		if(currentNode.isLeaf()) {
			currentNode.insert(o);
		}
		else {
			insertRecursive(o, currentNode.getNextNodeToSearch(o), currentNode);
		}

		if(currentNode.isOverFilled()) {
			currentNode.split(previousNode);
		}
	}


	@Override
	public boolean insert(Integer o) {
		return insert((Object) o);
	} 

	@Override
	public boolean insert(String filename) {
		if(!isFilePresent(filename)){
			throw new GDIException("File not found.");
		}

		boolean success = true;
		Object file = openInputFile(filename);
		while(!isEndOfInputFile(file)){
			if(!insert(readInt(file))) {
				success = false;
			}
		}

		closeInputFile(file);
		return success;
	}

	@Override
	public boolean contains(Integer o) {
		return contains((Object)o);
	}

	public boolean contains(Object o) {
		if(o == null) {
			return false;
		}

		BTreeNode currentNode = root;

		while(currentNode != null) {
			if(currentNode.contains(o)) {
				return true;
			}
			else {
				currentNode = currentNode.getNextNodeToSearch(o);
			}
		}

		return false;
	}

	@Override
	public int size() {
		if(root == null) {
			return 0;
		}
		else {
			return root.size();
		}
	}

	@Override
	public int height() {
		if(root == null) {
			return 0;
		}
		else {
			return height(root, 0);
		}
	}

	private int height(BTreeNode currentNode, int currentHeight) {
		if(currentNode.isLeaf()) {
			return currentHeight + 1;
		}
		else {
			return height(currentNode.getMinNext(), currentHeight + 1);
		}
	}

	@Override
	public Integer getMax() {
		if(root == null) {
			throw new GDIException("No maximum element in the B-Tree.");
		}
		else {
			return (Integer)root.getMax();
		}
	}

	/*
	private Integer getMax(BTreeNode currentNode) {
		if(currentNode.isLeave()) {
			return (Integer)currentNode.getMax();
		}
		else {
			return getMax(currentNode.getLargestChild());
		}
	}
	*/

	@Override
	public Integer getMin() {
		if(root == null) {
			throw new GDIException("No minimum element in the B-Tree.");
		}
		else {
			return (Integer)root.getMin();
		}
	}

	/*
	private Integer getMin(BTreeNode currentNode) {
		if(currentNode.isLeave()) {
			return (Integer)currentNode.getMin();
		}
		else {
			return getMin(currentNode.getSmallestChild());
		}
	}
	*/

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void printInorder() {
		println(toStringInorder(root));
	}

	private String toStringInorder(BTreeNode node) { // Recursive
		if(node == null) {
			return new String();
		}
		if(node.isLeaf()) {
			return node.toString();
		}
		else {
			String string = new String();
			Object[] values = node.getValues();
			BTreeNode[] next = node.getNext();
			boolean hasEnded = false;
			int lastElement = 0;

			for(int i = 0; i < values.length && !hasEnded; i++) {
				if(values[i] == null) {
					hasEnded = true;
					lastElement = i;
				}
				else {
					if(i != 0) {
						string += ", ";
					}
					string += toStringInorder(next[i]);
					string += ", ";
					string += values[i];
				}
			}
			string += toStringInorder(next[lastElement]);

			return string;
		}
	}

	@Override
	public void printPostorder() {
		println(toStringPostorder(root));
	}

	private String toStringPostorder(BTreeNode node) { // Recursive
		if(node == null) {
			return "";
		}
		if(node.isLeaf()) {
			return node.toString();
		}
		else {
			String string = "";
			// Next
			BTreeNode[] next = node.getNext();
			for(int i = 0; (i < next.length && next[i] != null); i++) {
				if(i > 0) {
					string += ", ";
				}
				string += toStringPostorder(next[i]);
			}

			// Elements
			string += node.toString();

			return string;
		}
	}

	@Override
	public void printPreorder() {
		println(toStringPreorder(root));
	}

	private String toStringPreorder(BTreeNode node) { // Recursive
		if(node == null) {
			return "";
		}
		if(node.isLeaf()) {
			return node.toString();
		}
		else {
			String string = "";
			// Elements
			string += node.toString();

			// Next
			BTreeNode[] next = node.getNext();
			for(int i = 0; (i < next.length && next[i] != null); i++) {
				if(i > 0) {
					string += ", ";
				}
				string += toStringPreorder(next[i]);
			}

			return string;
		}
	}

	@Override
	public void printLevelorder() {
		println(toStringLevelorder());
	}

	private String toStringLevelorder() {
		String elements = "";
		// TODO eigene ADT Queue
		java.util.Queue<BTreeNode> queue = new java.util.LinkedList<BTreeNode>();
		//Queue queue = new MyQueue();
		queue.add(root);
		//queue.enter(root);
		while(!queue.isEmpty()) {
			BTreeNode node = queue.remove();
			//BTreeNode node = queue.leave();
			if(node != null) {
				elements += node + " ";
				BTreeNode[] next = node.getNext();
				for(BTreeNode currentNext: next) {
					queue.add(currentNext);
					//queue.enter(currentNext);
				}
			}
		}
		return elements;
	}

	@Override
	public BTree clone() {
		BTree clone = new BTree(degree);
		
		clone.root = root.cloneDeep();
		
		return clone;
	}

	@Override
	public String toString() {
		return toStringLevelorder();
	}

	public Object[] values() {
		return root.getAll();
	}
	
	@Override
	public void addAll(BTree otherTree) {
		if(otherTree == null) {
			throw new GDIException("otherTree is null, adding impossible.");
		}
		Object[] otherValues = otherTree.values();
		
		for(Object o : otherValues) {
			insert(o);
		}
	}
	
	



	private String createNumberOfTabs(int nr){
		String tabs = new String();
		for(int i = 0; i < nr; i++) {
			tabs += '\t';
		}
		return tabs;
	}

	private int pow(int base, int exponent){
		if(exponent == 0){
			return 1;
		}
		else if(exponent < 0){
			throw new GDIException("Method isn't set up for negative exponents.");
		}
		else{
			return (base * pow(base,exponent - 1));
		}
	}
	
	private static String trim(String stringToRemoveLastSpaceCharacters){
		String newString = stringToRemoveLastSpaceCharacters;
		for(int i = 1; (int)stringToRemoveLastSpaceCharacters.charAt(stringToRemoveLastSpaceCharacters.length() - i) == SPACECHARACTER; i++){
			newString = "";
			for(int j = 0; j < stringToRemoveLastSpaceCharacters.length() - i; j++){
				newString += stringToRemoveLastSpaceCharacters.charAt(j);
			}
		}
		return newString;
	}

	
	public void sketchElementsOnConsole() {
		String levelorderElements = toStringLevelorder();

		int maxAssignments = 2 * degree + 1;
		int currentAmount = 1;
		int currentAssignment = 0;
		
		levelorderElements = trim(levelorderElements);

		for(int i = 0; i < levelorderElements.length(); i++){
			if((int)levelorderElements.charAt(i) == SPACECHARACTER && (int)levelorderElements.charAt(i + 1) == SPACECHARACTER){
				i++;
				currentAssignment++;
				if(currentAmount == 1){
					currentAmount++;
				}
				if(currentAssignment - 1 == pow(maxAssignments,currentAmount - 1)){
					currentAmount++;
					currentAssignment = 1;
				}
			}
		}
		int maxAmount = currentAmount;

		println(levelorderElements);
		currentAssignment = 0;
		currentAmount = 1;
		final int maxfields = 2 * pow(2 * degree + 1, maxAmount - 1) - 1;
		int maxBlocks = pow(2 * degree + 1, currentAmount - 1);
		int freeFields = maxfields - maxBlocks;
		final int center = freeFields / 2;

		int innerDistance = (freeFields + 1) / maxBlocks;
		int border = (innerDistance - 1) / 2;

		//Printing the elements.
		for(int i = 0; i < levelorderElements.length(); i++){
			if(currentAmount == 1 && i == 0){
				println("Amount" + createNumberOfTabs(center) + "Elements");
				print(currentAmount + createNumberOfTabs(center) + "\t");
			}
			if((int)levelorderElements.charAt(i) == SPACECHARACTER && (int)levelorderElements.charAt(i + 1) == SPACECHARACTER){
				currentAssignment++;
				//Switch from Root to first assignments.
				if(currentAmount == 1){
					currentAmount++;
					print("\n" + currentAmount + "\t"); 
					//Define variables new for second amount
					maxBlocks = pow(2 * degree + 1, currentAmount - 1);
					freeFields = maxfields - maxBlocks;
					innerDistance = (freeFields + 1) / maxBlocks;
					border = (innerDistance - 1) / 2;
					//
					print(createNumberOfTabs(border));
				}
				//actualAmount - 1 cause we need in, for example amount 2, the maxAssignments in amount 1.
				//actualAssignment - 1 to slides the next amount to after the last elements of the actual amount.
				if(currentAssignment - 1 == pow(maxAssignments,currentAmount - 1)){
					currentAmount++;
					currentAssignment = 1;
					//Define variables new for next amount
					maxBlocks = pow(2 * degree + 1, currentAmount - 1);
					freeFields = maxfields - maxBlocks;
					innerDistance = (freeFields + 1) / maxBlocks;
					border = (innerDistance - 1) / 2;
					//
					print("\n" + currentAmount + "\t");
					print(createNumberOfTabs(border));
				}
				else{
					print(createNumberOfTabs(innerDistance));
				}
			}
			else if((int)levelorderElements.charAt(i) != SPACECHARACTER){
				print(levelorderElements.charAt(i));
			}
			else{
				print(" ");
			}
		}
	}
}
