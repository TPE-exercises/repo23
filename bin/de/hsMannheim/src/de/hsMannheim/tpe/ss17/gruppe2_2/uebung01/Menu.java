package de.hsMannheim.tpe.ss17.gruppe2_2.uebung01;

import static gdi.MakeItSimple.*;

public class Menu {

	static boolean menuNeeded = true;
	
	public static void main (String[] args){
		
		int degree;
		println("Bitte geben Sie den gewünschten Grad des Baums an.");
		degree = readInt();
		BTree tree = new BTree(degree);
		while (menuNeeded)
			makeMenu(tree);
		
	}
	public static void makeMenu(BTree tree){
		println("------------------- Menü -------------------");
		println("1:  insert element");
		println("2:  insert file");
		println("3:  contains element");
		println("4:  size of tree");
		println("5:  heigh of tree");
		println("6:  get maximum element");
		println("7:  get minimum element");
		println("8:  print tree in Inorder");
		println("9:  print tree in Preorder");
		println("10: print tree in Postorder");
		println("11: print tree in Levelorder");
		println("99: quit menu");
		
		int selection =readInt();
		
		switch(selection){
		case 1:
			println("Welcher Wert soll eingefügt werden?");
			int insertKey = readInt();
			if (tree.insert(insertKey))
				println("Einfügen erfolgreich");
			else 
				println("Einfügen gescheitert");
			break;
		case 2:
			println("Welche Datei soll eingefügt werden?");
			String filename = readLine();
			if (tree.insertFile(filename))
				println("Einfügen erfolgreich");
			else
				println("Nicht alle Werte aus der Datei konnten eingefügt werden.");
			break;
		case 3:
			println("Nach welchem Wert soll gesucht werden?");
			int searchKey = readInt();
			println(tree.contains(searchKey));
			break;
		case 4:
			println("Der B-Baum hat die Größe " + tree.size());
			break;
		case 5:
			println("Der B-Baum hat die Höhe " + tree.height());
			break;
		case 6:
			println("Das größte Element im Baum ist " + tree.getMax());
			break;
		case 7:
			println("Das kleinste Element im Baum ist " + tree.getMin());
			break;
		case 8:
			tree.printInorder();
			break;
		case 9:
			tree.printPreorder();
			break;
		case 10:
			tree.printPostorder();
			break;
		case 11:
			tree.printLevelorder();
			break;
		case 99:
			menuNeeded = false;
			break;
		}
	}
	
}

