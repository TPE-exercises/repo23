package de.hsMannheim.tpe.ss17.gruppe2_2.uebung01;

import static gdi.MakeItSimple.*;

public class BTree {

	public BTreeNode root;

	public BTree(int order) {
		root = new BTreeNode(order, 0, null);
	}

	/**
	 * TO BE IMPLEMENTED
	 */
	public boolean insert(Integer o) {
		if (contains(o)) {
			return false;
		}
		insert(o, root);
		return true;
	}

	public boolean insertFile(String filename){
		Object file = openInputFile(filename);
		boolean insertedEverythingFromFile = true;
		while (!isEndOfInputFile(file))
			if (!insert(readInt(file)))
				insertedEverythingFromFile = false;
		return insertedEverythingFromFile;	
	}
	public static boolean isBigger(Integer key, Integer currentElement) {
		if (key != null && currentElement != null) {
			int keyValue = key;
			int currentElementValue = currentElement;
			return keyValue > currentElementValue;
		} else {
			// error: comparison of null Integer.
			return true;
		}
	}

	public boolean contains(Integer o) {
		if (o == null) {
			System.out.println("Please do not enter null keys!");
			return false;
		} else {
			return contains(o, root);
		}
	}

	/**
	 * 
	 * @param key:
	 *            The key which is to be checked whether it is contained
	 * @param node:
	 *            The node to be looked through
	 * @return true if the key exists in the tree, false if not.
	 */
	private boolean contains(Integer key, BTreeNode node) {
		int k = (int) key;
		if (node.nodeIsEmpty()) {
			return false;
		} else {
			/**
			 * Checks through the corresponding node until the key is found or
			 * until an element (at position i) is found which is bigger than
			 * our key. In this case, child nodes of index i will be visited.
			 */
			int i = 0;
			while (i < node.nodeSize()) {
				if (k == ((int) node.elements[i])) {
					return true;
				} else if (k < ((int) node.elements[i])) {
					if (node.kids[i] != null) {
						return contains(key, node.kids[i]);
					} else {
						return false;
					}
				}
				i++;
			}
			if (node.kids[i] != null) {
				return contains(key, node.kids[i]);
			}
			return false;
		}
	}

	public boolean isEmpty() {
		if (root.nodeIsEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return the size (^= amount of elements) of the whole BTree.
	 */
	public int size() {
		int treeSize = 0;
		treeSize = root.treeSize(treeSize);
		return treeSize;

	}

	public int height() {
		int i = 0;
		BTreeNode currentLevel = root;
		while (currentLevel.nodeType == BTreeNode.NODE) {
			i++;
			currentLevel = currentLevel.kids[0];
		}
		return i;
	}

	public int getMin() {
		BTreeNode currentNode = root;
		while (currentNode.nodeType == BTreeNode.NODE)
			currentNode = currentNode.kids[0];
		return currentNode.elements[0];
	}

	public int getMax() {
		int i;
		BTreeNode currentNode = root;
		while (currentNode.nodeType == BTreeNode.NODE) {
			i = 0;
			while (currentNode.kids[i] != null)
				i++;
			currentNode = currentNode.kids[i];
		}
		i = 0;
		while (currentNode.elements[i] != null)
			i++;
		return currentNode.elements[i - 1];
	}

	private void insert(Integer key, BTreeNode node) {
		int i = 0;
		if (node.nodeType == BTreeNode.LEAF) {
			node.insertInNode(key);
			if (node.nodeIsFull())
				node.popLeaf();
			return;
		}
		while (node.elements[i] != null && isBigger(key, node.elements[i])) {
			i++;
		}
		insert(key, node.kids[i]);

	}

	public void printInorder() {
		printInorder(root);
		System.out.println();
	}

	/**
	 * Prints all elements sorted by increasing value (if the BTree was
	 * implemented correctly).
	 * 
	 * In detail: If a node has elements x(0), x(1), ..., x(i-1), x(i) and
	 * children ch(0), ..., ch(i), ch(i+1) its elements will be printed out as
	 * the following: ch(0), x(0), ch(1), x(1), ..., ch(i), x(i), ch(i+1)
	 * 
	 * @param node:
	 *            The node which is to be printed
	 */
	private void printInorder(BTreeNode node) {
		int k = node.nodeSize();
		for (int i = 0; i < k; i++) {
			if (node.kids[i] != null) {
				printInorder(node.kids[i]);
			}
			System.out.print(node.elements[i] + ", ");
		}
		if (node.kids[k] != null) {
			printInorder(node.kids[k]);
		}
	}

	public void printPreorder() {
		printPreorder(root);
		System.out.println();
	}

	/**
	 * If a node has elements x(0), x(1), ..., x(i-1), x(i) and children ch(0),
	 * ..., ch(i), ch(i+1) its elements will be printed out as the following:
	 * x(0), ch(0), x(1), ch(1), ..., x(i), ch(i), ch(i+1)
	 * 
	 * @param node:
	 *            The node which is to be printed
	 */
	private void printPreorder(BTreeNode node) {
		int k = node.nodeSize();
		for (int i = 0; i < k; i++) {
			System.out.print(node.elements[i] + ", ");
			if (node.kids[i] != null) {
				printPreorder(node.kids[i]);
			}
		}
		if (node.kids[k] != null) {
			printPreorder(node.kids[k]);
		}
	}

	/**
	 * If a node has elements x(0), x(1), ..., x(i-1), x(i) and children ch(0),
	 * ..., ch(i), ch(i+1) its elements will be printed out as the following:
	 * ch(0), ch(1), x(0), ch(2), x(1), ch(3), x(2), ..., ch(i), x(i-1),
	 * ch(i+1), x(i)
	 * 
	 * @param node:
	 *            The node which is to be printed
	 */
	public void printPostorder() {
		printPostorder(root);
		System.out.println();
	}

	private void printPostorder(BTreeNode node) {
		int k = node.nodeSize();
		if (node.kids[0] != null) {
			printPostorder(node.kids[0]);
		}
		for (int i = 0; i < k; i++) {
			if (node.kids[i] != null) {
				printPostorder(node.kids[i + 1]);

			}
			System.out.print(node.elements[i] + ", ");
		}
	}

	/**
	 * Prints out the first level, then the second one and so on.
	 */
	public void printLevelorder() {
		Queue nodeQueue = new Queue(size());
		nodeQueue.enter(root);
		while (!nodeQueue.isEmpty()) {
			int i = 0;
			/*
			 * Insert next nodes into queue.
			 */
			while (nodeQueue.peak() != null && i < (nodeQueue.peak().nodeSize() + 1)) {
				if (nodeQueue.peak().kids[i] != null) {
					nodeQueue.enter(nodeQueue.peak().kids[i]);
				}
				i++;
			}
			i = 0;
			/*
			 * Print out the elements of the current node pointed at in the
			 * queue.
			 */
			while (nodeQueue.peak() != null && i < nodeQueue.peak().nodeSize()) {
				System.out.print(nodeQueue.peak().elements[i] + ", ");
				i++;
			}
			nodeQueue.leave();
		}
		System.out.println();
	}

}
