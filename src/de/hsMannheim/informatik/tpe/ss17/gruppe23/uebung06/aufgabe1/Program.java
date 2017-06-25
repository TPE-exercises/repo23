package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung06.aufgabe1;

public class Program {
	
	public static void main(String[] args) {
		
		// Create a new List containing Integer trees
		// and two new Trees containing integer values.
		List<Tree<Integer>> list = new List<>();
		Tree<Integer> tree1 = new Tree<Integer>();
		Tree<Integer> tree2 = new Tree<Integer>();
		
		// Add the trees to the list
		list.addLast(tree1);
		list.addLast(tree2);
		
		// Get a tree from the list and store it in a tree variable.
		Tree<Integer> resultTree = list.getFirst();
		
	}

}
