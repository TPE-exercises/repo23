package de.hsMannheim.tpe.ss17.gruppe2_2.uebung01;

public class Test {
	public static void main(String[] args) {


		/**
		 * Test BTreeNode buche
		 */
		System.out.println("Test#1 A given tree with given elements");
		
		// create root; level 0
		BTreeNode buche = new BTreeNode(1, 1, null);

		// create nodes; level = 1
		for (int i = 0; i < 3; i++) {
			buche.kids[i] = new BTreeNode(1, 1, null);
		}
		// Create Leaves; level 2
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				buche.kids[i].kids[k] = new BTreeNode(1, 0, null);
			}
		}
		// initialize level 0
		buche.elements[0] = new Integer(9);
		buche.elements[1] = 18;
		// initialize level 1
		buche.kids[0].elements[0] = 3;
		buche.kids[0].elements[1] = 6;

		buche.kids[1].elements[0] = 12;
		buche.kids[1].elements[1] = 15;

		buche.kids[2].elements[0] = 21;
		buche.kids[2].elements[1] = 24;

		// initialize level 2
		buche.kids[0].kids[0].elements[0] = 1;
		buche.kids[0].kids[0].elements[1] = 2;

		buche.kids[0].kids[1].elements[0] = 4;
		buche.kids[0].kids[1].elements[1] = 5;

		buche.kids[0].kids[2].elements[0] = 7;
		buche.kids[0].kids[2].elements[1] = 8;

		buche.kids[1].kids[0].elements[0] = 10;
		buche.kids[1].kids[0].elements[1] = 11;

		buche.kids[1].kids[1].elements[0] = 13;
		buche.kids[1].kids[1].elements[1] = 14;

		buche.kids[1].kids[2].elements[0] = 16;
		buche.kids[1].kids[2].elements[1] = 17;

		buche.kids[2].kids[0].elements[0] = 19;
		buche.kids[2].kids[0].elements[1] = 20;

		buche.kids[2].kids[1].elements[0] = 22;
		buche.kids[2].kids[1].elements[1] = 23;

		buche.kids[2].kids[2].elements[0] = 25;
		buche.kids[2].kids[2].elements[1] = 26;
		// BTree Test#1
		// birke is a BTree with given elements
		BTree birke = new BTree(1);
		birke.root = buche;
		
		// size-test (Size = 26)
		System.out.println("Size: ");
		System.out.println(birke.size());

		// Traversions

		System.out.println("Inorder: ");
		birke.printInorder();
		System.out.println();

		System.out.println("Preorder: ");
		birke.printPreorder();
		System.out.println();

		System.out.println("Postorder: ");
		birke.printPostorder();
		System.out.println();

		System.out.println("Levelorder: ");
		birke.printLevelorder();
		System.out.println();
		
		// contains-test for birke with initial values.
		System.out.println("Contains: ");
		System.out.println("Expeceted value: True ");
		System.out.println(birke.contains(1));
		System.out.println(birke.contains(2));
		System.out.println(birke.contains(3));
		System.out.println(birke.contains(4));
		System.out.println(birke.contains(5));
		System.out.println(birke.contains(6));
		System.out.println(birke.contains(7));
		System.out.println(birke.contains(8));
		System.out.println(birke.contains(9));
		System.out.println(birke.contains(10));
		System.out.println(birke.contains(11));
		System.out.println(birke.contains(12));
		System.out.println(birke.contains(13));
		System.out.println(birke.contains(14));
		System.out.println(birke.contains(15));
		System.out.println(birke.contains(16));
		System.out.println(birke.contains(17));
		System.out.println(birke.contains(18));
		System.out.println(birke.contains(19));
		System.out.println(birke.contains(20));
		System.out.println(birke.contains(21));
		System.out.println(birke.contains(22));
		System.out.println(birke.contains(23));
		System.out.println(birke.contains(24));
		System.out.println(birke.contains(25));
		System.out.println(birke.contains(26));
		System.out.println("Expected value: False ");
		System.out.println(birke.contains(0));
		System.out.println(birke.contains(27));
		System.out.println(birke.contains(-1));
		System.out.println(birke.contains(30));

		// Queue-Test

		Queue queue = new Queue();

		// BTree Test #2 with insert()

		
		/**
		 *  BTree Test #2 With insert-function and a completely new Tree.
		 */
		System.out.println("Test#2 A completely new tree, thus empty");
		BTree myBTree = new BTree(2);
		// insert-Test
		System.out.println("Insert: ");
		myBTree.insert(12);
		myBTree.insert(11);
		myBTree.insert(-1);
		myBTree.insert(15);
		System.out.println(myBTree.insert(13));
		System.out.println(myBTree.insert(12));
		
		//contains-test
		System.out.println("Contains: ");
		System.out.println(myBTree.contains(11));
		System.out.println(myBTree.contains(12));
		System.out.println(myBTree.contains(-1));
		System.out.println(myBTree.contains(-8));
		System.out.println(myBTree.contains(null));
		System.out.println("Inorder: ");
		myBTree.printInorder();
		System.out.println();

		System.out.println("Preorder: ");
		myBTree.printPreorder();
		System.out.println();

		System.out.println("Postorder: ");
		myBTree.printPostorder();
		System.out.println();

		System.out.println("Levelorder: ");
		myBTree.printLevelorder();
		System.out.println();
		
		// Size-test
		
		System.out.println(myBTree.size());
	}
}