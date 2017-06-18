package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung05.aufgabe1u2;

import static gdi.MakeItSimple.*;

/**
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 */
public class BTreeConsole {
	//TODO Die erste Zahl aus einer Datei wird als erstes Element mit eingefügt.
	private static final char SPACECHARACTER = ' ';
	private static String defaultFilePath = "defaultFile";
	private static BTree[] bTreeList = {};
	private static int currentBTree = 0;
	
	private static final String[] commands = {
			"Exit.",
			"Show commands.",
			"Creates a new B-Tree.",
			"Switch to another B-Tree.",
			"Inserts an integer object.",
			"Inserts a series of numbers in a file.",	// 5
			"Checks whether the value is contained in the tree.",
			"Shows the number of elements in the tree.",
			"Shows the height of the tree.",
			"Shows the largest element.",
			"Shows the smallest element.",	// 10
			"Checks whether the tree is empty.",
			"Inserts all elements in the b-tree by another one.",
			"Inorder output.",
			"Postorder output.",
			"Preorder output.",	// 15
			"Levelorder output.",
			"Sketch B-Tree.",
			"Clone deeply.",
			"Delete element",
			"IterateOverElements"	// 20
	};

	private static final String[] waysToCreateANewBTree = {
			"Reading a File.",
			"Inserting a number for the order."
	};

	private static void addTreeInTreeList(BTree tree){
		BTree[] newBTreeList = new BTree[bTreeList.length + 1];
		for(int i = 0; i < bTreeList.length; i++){
			newBTreeList[i] = bTreeList[i];
		}
		newBTreeList[newBTreeList.length - 1] = tree;
		bTreeList = newBTreeList;
	}

	private static void printOnConsoleCommands(){
		for(int i = 0; i < commands.length; i++){
			println(i + "\t" + commands[i]);
		}
	}

	private static void printOnConsoleWaysToCreateANewBTree(){
		println("Creating a new B-Tree by:");
		for(int i = 0; i < waysToCreateANewBTree.length; i++){
			println(i + "\t" + waysToCreateANewBTree[i]);
		}
	}
	

	private static void printConsole(){
		printOnConsoleActualUsingBTree(); 
		printOnConsoleCommands();
	}
	

	private static int fileLength(String filepath){
		Object file = openInputFile(filepath);
		int length = 0;
		while(!isEndOfInputFile(file)){
			readInt(file);
			length++;
		}
		closeInputFile(file);
		return length;
	}
	

	private static int[] getValuesFromFile(String filepath){
		if(isFilePresent(filepath)){
			int[] values = new int[fileLength(filepath)];
			int i = 0;
			Object file = openInputFile(filepath);
			while(!isEndOfInputFile(file)){
				values[i] = readInt(file);
				i++;
			}
			closeInputFile(file);
			return values;
		}
		else{
			throw new GDIException("Filepath: " + filepath + " does not exists.");
		}
	}
	

	private static void sitANewBTree(int order){
		int[] nothingToInsert = {};
		sitANewBTree(order, nothingToInsert);
	}
	

	private static void sitANewBTree(int order, int[] valuesToInsert){
		BTree tree1 = new BTree(order);
		addTreeInTreeList(tree1);
		if(valuesToInsert.length > 0){
			insertIntoBTree(valuesToInsert);
		}
	}
	

	private static void insertIntoBTree(int value){
		int[] valueToInsert = {value};
		insertIntoBTree(valueToInsert);
	}
	

	private static void insertIntoBTree(int[] values){
		for(int i = 0; i < values.length; i++){
			Integer valueToInsert = Integer.valueOf(values[i]);
			bTreeList[currentBTree].insert(valueToInsert);
		}
	}
	

	private static int[] removeFirstElementFromArray(int[] arrayToRemoveFirstElement){
		int[] firstlessArray = new int[arrayToRemoveFirstElement.length - 1];
		for(int i = 0; i < arrayToRemoveFirstElement.length; i++){
			if(i > 0){
				firstlessArray[i - 1] = arrayToRemoveFirstElement[i]; 
			}
		}
		return firstlessArray;
	}
	

	private static void creatingANewBTreePossibilities(int creatingBy){
		boolean exit = false;
		switch(creatingBy){
		case 0: 
			while(!exit){
				println("Use default file? 0 = No, 1 = Yes");
				int input = readInt();
				if(input != 0 && input != 1){
					println(input + " is no valid input.");
				}
				else{
					exit = true;
					String filepath = defaultFilePath;
					if(input == 0){
						println("Which filepath do You want to use?");
						readLine();
						filepath = readLine();
					}
					int[] values = getValuesFromFile(filepath);
					if(values.length > 1){
						//First element = order element
						int[] valuesToInsert = removeFirstElementFromArray(values); 
						sitANewBTree(values[0], valuesToInsert);
					}
					else{
						if(values.length == 0){
							println("No B-Tree could be read. File empty.");
						}
						else{
							sitANewBTree(values[0]); //values[0] Array index out of bounds bei leerer Datei
						}
					}
				}
			}
			break;
		case 1: 
			while(!exit){
				println("Which order should have the B-Tree?");
				int order = readInt();
				if(order <= 0){
					println("The order has to be positive.");
				}
				else{
					exit = true;
					sitANewBTree(order);
				}
			}
			break;
		default: println("Something goes wrong, by creating a BTree.");break;
		}
	}

	private static void createANewBTree(){
		printOnConsoleWaysToCreateANewBTree();
		boolean exit = false;
		while(!exit){
			int input = readInt();
			if(input < 0 || input > waysToCreateANewBTree.length - 1){
				println(input + " is not an instruction.");
			}
			else{
				exit = true;
				creatingANewBTreePossibilities(input);
			}
		}
	}
	

	private static void printOnConsoleActualUsingBTree(){
		//actualBTree uses the index Value
		int actualTree = currentBTree + 1;
		println("Using current BTree: " + actualTree);
	}
	

	private static void switchBTree(){
		if(bTreeList.length < 2){
			println("There is no other Tree to switch.");
		}
		else{
			boolean usingAnExistingBTree = false;
			while(!usingAnExistingBTree){
				println("Which BTree do You want to use?");
				println("There are " + bTreeList.length + " BTrees in the list.");
				int usingBtree = readInt();
				if(usingBtree < 0 || usingBtree > bTreeList.length){
					println(usingBtree + " is not in the list.");
				}
				else{
					usingAnExistingBTree = true;
					currentBTree = usingBtree - 1;
				}
			}
		}
	}
	
	/**
	 * This method calculates the exponent of an number 
	 * Works only for positive natural numbers, because the amount of a tree can only be positive.
	 * @param base (int) value of the base
	 * @param exponent (int) value of the exponent
	 * @return (int) calculated result of the exponential number.
	 */
	///*
	private static int powRecursivelyForBTrees(int base, int exponent){
		if(exponent == 1){
			return base;
		}
		else if(exponent == 0){
			return 1;
		}
		else if(exponent < 0){
			throw new GDIException("Method isn't set up for negative exponents.");
		}
		else{
			return (base * powRecursivelyForBTrees(base,exponent - 1));
		}
	}
	//*/

	 // TODO: remove
	public static String removeLastSpaceCharacters(String stringToRemoveLastSpaceCharacters){
		String newString = "";
		for(int i = stringToRemoveLastSpaceCharacters.length() - 1; i >= 0; i--){
			if((int)stringToRemoveLastSpaceCharacters.charAt(i) == SPACECHARACTER){
				for(int j = 0; j < i; j++){
					newString += stringToRemoveLastSpaceCharacters.charAt(j);
				}
			}
		}
		
		return newString;
	}
	
	///*
	

	private static String printingTabulatorsRecursively(int numbers){
		String tabulators = "";
		return printingTabulatorsRecursively(numbers, tabulators);
	}
	
	private static String printingTabulatorsRecursively(int frequency, String tabulators){
		if(frequency <= 0){
			return tabulators;
		}
		else{
			return printingTabulatorsRecursively(frequency - 1, tabulators += "\t");
		}
	}
	
	

	public static void main(String[] args) {
		while(bTreeList.length == 0){
			println("There is currently no B-Tree created.");
			createANewBTree();
		}

		printOnConsoleActualUsingBTree();
		println("You can interact with the B-Tree by using the following numbers.");
		printOnConsoleCommands();

		boolean exitProgramm = false;
		while(!exitProgramm){
			int input = readInt();
			switch(input){
			case 0: exitProgramm = true; break;
			case 1: printConsole(); break;
			case 2: createANewBTree(); break;
			case 3: switchBTree(); break;
			case 4: 
				println("Which number do You wish to insert?");
				insertIntoBTree(readInt()); break;
			case 5: 
				println("Which file do You wish to use?");
				readLine();
				String file = readLine();	
				insertIntoBTree(getValuesFromFile(file)); break;
			case 6:
				println("Which number are You searching for?");
				if(bTreeList[currentBTree].contains(readInt())){
					println("Yes the number is contained in the BTree.");
				}
				else{
					println("The number is not contained in the BTree.");
				}
				break;
			case 7:
				println("They are " + bTreeList[currentBTree].size() + " elements in the BTree.");
				break;
			case 8:
				println("The BTree has a hight of " + bTreeList[currentBTree].height());
				break;
			case 9:
				println("The largest element is: " + bTreeList[currentBTree].getMax());
				break;
			case 10: 
				println("The smallest element is: " + bTreeList[currentBTree].getMin());
				break;
			case 11:
				print("The tree is "); 
				if(!bTreeList[currentBTree].isEmpty()){
					print("not ");
				}
				print("empty");
				println();
				break;
			case 12:
				if(bTreeList.length < 2){
					println("There has to be more than one BTree to use the option.");
				}
				else if(bTreeList.length == 2){
					println("There is only one possibility. Use the elements of BTree ");
					int bTreeToUse;
					if(currentBTree == 0){
						bTreeToUse = currentBTree + 2;
						print(bTreeToUse);
					}
					else{
						bTreeToUse = currentBTree;
						print(bTreeToUse);
					}
					print(" to insert into BTree " + (currentBTree + 1) + "?");
					boolean exit = false;
					while(!exit){
						println("0 = No, 1 = Yes.");
						int selection = readInt();
						if(selection == 1){
							bTreeList[currentBTree].addAll(bTreeList[bTreeToUse]);
						}
						else{
							println("Process interrupted.");
						}
					}
				}
				else{
					print("Which tree you want to use to insert it's elements in the current tree? ");
					for(int i = 0; i < bTreeList.length; i++){
						if(!(i == currentBTree)){
							print((i + 1));
							if(currentBTree + 1 == bTreeList.length){
								if(i + 2 < bTreeList.length){
									print(", ");
								}
							}
							else{
								if(i + 1 < bTreeList.length){
									print(", ");
								}
							}
						}
					}
					println();
					int selection = readInt();
					if(!(selection < 1 || selection > bTreeList.length)){
						bTreeList[currentBTree].addAll(bTreeList[selection - 1]);
						println("All elements from BTree " + selection + " were inserted in BTree " + (currentBTree + 1));
					}
					else{
						println(selection + " is an invalid selection.");
					}
				}
				break;
			case 13: bTreeList[currentBTree].printInorder(); break;
			case 14: bTreeList[currentBTree].printPostorder(); break;
			case 15: bTreeList[currentBTree].printPreorder(); break;
			case 16: 
				// String elementsLevelordered = bTreeList[currentBTree].toStringLevelorder();
				//println(elementsLevelordered);
				// printingElementsLevelordered(elementsLevelordered, bTreeList[currentBTree].getOrder());
				bTreeList[currentBTree].printLevelorder();
				break;
				//bTreeList[actualBTree].printLevelorder(); break;
			case 17: bTreeList[currentBTree].sketchElementsOnConsole(); 
					 // printingElementsLevelordered(bTreeList[currentBTree].toStringLevelorder(), bTreeList[currentBTree].getOrder());
					break;
			case 18: //bTreeList[currentBTree].clone();
					BTree[] newBTreeList = new BTree[bTreeList.length + 1];
					for(int i = 0; i < bTreeList.length; i++){
						newBTreeList[i] = bTreeList[i];
					}
					newBTreeList[newBTreeList.length - 1] = bTreeList[currentBTree].clone();
					bTreeList = newBTreeList;
					System.out.println("New cloned B-Tree created.");
					break;
			case 19: System.out.println("Welches Element soll gelöscht werden?");
					int i = readInt();
					bTreeList[currentBTree].delete(new Integer(i));
					break;
			case 20: System.out.println("Iterieren ueber den B-Baum:");
					for(Object element: bTreeList[currentBTree]) {
						System.out.println("next(): " + element.toString());
					}
					break;
			}
		}
	}
}