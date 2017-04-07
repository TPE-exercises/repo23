package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung01;

import static gdi.MakeItSimple.*;

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
			"Inserts a series of numbers in a file.",
			"Checks whether the value is contained in the tree.",
			"Shows the number of elements in the tree.",
			"Shows the height of the tree.",
			"Shows the largest element.",
			"Shows the smallest element.",
			"Checks whether the tree is empty.",
			"Inserts all elements in the b-tree by another one.",
			"Inorder output.",
			"Postorder output.",
			"Preorder output.",
			"Levelorder output.",
			"Sketch B-Tree.",
			"Clone deeply."
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

	/* TODO: remove
	public static String[] getCommands(){
		return commands;
	}*/
	

	private static void printOnConsoleCommands(){
		for(int i = 0; i < commands.length; i++){
			println(i + "\t" + commands[i]);
		}
	}
	
	/* TODO: remove
	public static String[] getWaysToCreateANewBTree(){
		return waysToCreateANewBTree;
	}*/
	

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
	
	//TODO
	private static void printingElementsLevelordered(String levelorderElements, int order){
		//Assignment = Verknüpfung
		int maxAssignments = 2 * order + 1;
		//KICK: By printing the elements as an String have they one less assignment then in truth. 
		//KICK: int maxInlineAssignments = maxAssignments - 1;
		//KICK: int maxElements = 2 * order;
		//Root is on step 1
		int actualAmount = 1;
		int actualAssignment = 0;
		int maxAmount;
		//actualAmount - 1 cause we need in for example amount 2 the maxAssignments in amount 1.
		//KICK: int assignmentsInAmountX = powRecursivelyForBTrees(maxAssignments,actualAmount - 1);
		//println(assignmentsInAmountX);
		levelorderElements = removeLastSpaceCharacters(levelorderElements);
//		int spaces = 0;
//		for(int i = 0; i < levelorderElements.length(); i++){
//			if((int)levelorderElements.charAt(i) == SPACECHARACTER){
//				spaces++;
//			}
//		}
		//Getting the max amount
		for(int i = 0; i < levelorderElements.length(); i++){
			if((int)levelorderElements.charAt(i) == SPACECHARACTER && (int)levelorderElements.charAt(i + 1) == SPACECHARACTER){
				i++;
				actualAssignment++;
				if(actualAmount == 1){
					actualAmount++;
				}
				if(actualAssignment - 1 == powRecursivelyForBTrees(maxAssignments,actualAmount - 1)){
					actualAmount++;
					actualAssignment = 1;
				}
			}
		}
		maxAmount = actualAmount;
		
		println(levelorderElements);
		actualAssignment = 0;
		actualAmount = 1;
		final int maxfields = 2 * powRecursivelyForBTrees(2 * order + 1, maxAmount - 1) - 1;
		int maxBlocks = powRecursivelyForBTrees(2 * order + 1, actualAmount - 1);
		int freeFields = maxfields - maxBlocks;
		final int center = freeFields / 2;

		int innerDistance = (freeFields + 1) / maxBlocks;
		int border = (innerDistance - 1) / 2;
		
		//Printing the elements.
		for(int i = 0; i < levelorderElements.length(); i++){
			if(actualAmount == 1 && i == 0){
				println("Amount" + printingTabulatorsRecursively(center) + "Elements");
				print(actualAmount + printingTabulatorsRecursively(center) + "\t");
			}
			if((int)levelorderElements.charAt(i) == SPACECHARACTER && (int)levelorderElements.charAt(i + 1) == SPACECHARACTER){
				actualAssignment++;
				//Switch from Root to first assignments.
				if(actualAmount == 1){
					actualAmount++;
					print("\n" + actualAmount + "\t"); 
					//Define variables new for second amount
					maxBlocks = powRecursivelyForBTrees(2 * order + 1, actualAmount - 1);
					freeFields = maxfields - maxBlocks;
					innerDistance = (freeFields + 1) / maxBlocks;
					border = (innerDistance - 1) / 2;
					//
					print(printingTabulatorsRecursively(border));
				}
				//actualAmount - 1 cause we need in, for example amount 2, the maxAssignments in amount 1.
				//actualAssignment - 1 to slides the next amount to after the last elements of the actual amount.
				if(actualAssignment - 1 == powRecursivelyForBTrees(maxAssignments,actualAmount - 1)){
					actualAmount++;
					actualAssignment = 1;
					//Define variables new for next amount
					maxBlocks = powRecursivelyForBTrees(2 * order + 1, actualAmount - 1);
					freeFields = maxfields - maxBlocks;
					innerDistance = (freeFields + 1) / maxBlocks;
					border = (innerDistance - 1) / 2;
					//
					print("\n" + actualAmount + "\t");
					print(printingTabulatorsRecursively(border));
				}
				else{
					print(printingTabulatorsRecursively(innerDistance));
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
	//*/

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
				insertIntoBTree(getValuesFromFile(readLine())); break;
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
			case 17: bTreeList[currentBTree].sketchElementsOnConsole(); // TODO: move to Tree
					 // printingElementsLevelordered(bTreeList[currentBTree].toStringLevelorder(), bTreeList[currentBTree].getOrder());
			case 18: bTreeList[currentBTree].clone(); break; // TODO: clone to what tree?
			}
		}
	}
}

