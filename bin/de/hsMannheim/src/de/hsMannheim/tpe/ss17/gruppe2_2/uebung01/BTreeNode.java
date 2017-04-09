package de.hsMannheim.tpe.ss17.gruppe2_2.uebung01;

public class BTreeNode {
	static final int LEAF = 0;
	static final int NODE = 1;
	int nodeType;
	Integer[] elements;
	// degree m
	private int m;
	BTreeNode[] kids;
	BTreeNode parent;

	BTreeNode(int order, int nodeType, BTreeNode parent) {

		this.elements = new Integer[2 * order + 1];
		this.kids = new BTreeNode[2 * order + 2];
		this.m = order;
		this.nodeType = nodeType;
		this.parent = parent;
	}

	public void insertInNode(Integer key) {
		int i = 2 * this.m;
		while (this.elements[i] == null && i > 0)
			i--;
		while (!BTree.isBigger(key, this.elements[i])) {
			this.elements[i+1] = this.elements[i];
			this.elements[i] = null;
			this.kids[i + 2] = this.kids[i+1];
			if (i > 0)
				i--;
		}
		this.elements[i] = key;
	}


	public void popLeaf() {
		this.pop();
	}

	private void pop() {
		if (parent != null) {
			this.parent.insertInNode(this.elements[this.m]);
			BTreeNode newNode = new BTreeNode(this.m, this.nodeType, this.parent);
			this.parent.kids[this.getElementPosition(this.m) + 1] = newNode;
			for (int i = 0; i < m; i++) {
				newNode.elements[i] = this.elements[i + m + 1];
				this.elements[i + m + 1] = null;
				newNode.kids[i] = this.kids[i + m + 1];
				this.kids[i + m + 1] = null;
				if (newNode.nodeType == NODE)
					newNode.kids[i].setParent(newNode);
			}
			newNode.kids[m] = this.kids[2 * m + 1];
			this.kids[2 * m + 1] = null;
			if (newNode.nodeType == NODE)
				newNode.kids[m].setParent(newNode);
			if (this.parent.nodeIsFull())
				this.parent.pop();
		} else {
			BTreeNode newNode1 = new BTreeNode(this.m, this.nodeType, this.parent);
			BTreeNode newNode2 = new BTreeNode(this.m, this.nodeType, this.parent);
			this.nodeType = 1;
			for (int i = 0; i < m; i++) {
				newNode1.elements[i] = this.elements[i];
				this.elements[i] = null;
				newNode2.elements[i] = this.elements[i + m + 1];
				this.elements[i + m + 1] = null;
				newNode1.kids[i] = this.kids[i];
				this.kids[i] = null;
				if (newNode1.nodeType == NODE)
					newNode1.kids[i].setParent(newNode1);
				newNode2.kids[i] = this.kids[i + m + 1];
				this.kids[i + m + 1] = null;
				if (newNode2.nodeType == NODE)
					newNode2.kids[i].setParent(newNode1);
			}
			newNode1.kids[m] = this.kids[m];
			this.kids[m] = null;
			if (newNode1.nodeType == NODE)
				newNode1.kids[m].setParent(newNode1);
			newNode2.kids[m] = this.kids[2 * m + 1];
			this.kids[2 * m + 1] = null;
			if (newNode1.nodeType == NODE)
				newNode2.kids[m].setParent(newNode1);

			this.elements[0] = this.elements[m];
			this.elements[m] = null;
			this.kids[0] = newNode1;
			this.kids[1] = newNode2;
		}

	}

	private void setParent(BTreeNode parent) {
		this.parent = parent;
	}

	private int getElementPosition(Integer key) {
		int i = 0;
		while (!key.equals(this.elements[i]))
			i++;
		return i;
	}

	public boolean nodeIsEmpty() {
		if (this.elements[0] == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean nodeIsFull() {
		if (this.elements[2 * m] != null) {
			return true;
		} else {
			return false;
		}
	}

	public int nodeSize() {
		int size = 0;
		while (elements[size] != null) {
			size++;
		}
		return size;
	}

	/**
	 * Calculates the size of a tree part, a node, without disregarding its
	 * child nodes.
	 * 
	 * @param size
	 * @return The size of the tree fraction
	 */
	public int treeSize(int size) {
		if (nodeIsEmpty()) {
			return 0;
		} else {
			size += this.nodeSize();
			if (this.nodeType == NODE) {
				int i = 0;
				while (this.kids[i] != null) {
					size = this.kids[i].treeSize(size);
					i++;
				}
			}
			return size;
		}
	}
}