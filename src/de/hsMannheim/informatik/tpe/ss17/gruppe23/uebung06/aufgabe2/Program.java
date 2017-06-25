package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung06.aufgabe2;

import java.util.TreeSet;

public class Program {

	public static void main(String[] args) {
		// Create 7 boxes with Integer values
		Box<Integer> box1 = new Box<Integer>(1);
		Box<Integer> box2 = new Box<Integer>(2);
		Box<Integer> box3 = new Box<Integer>(3);
		Box<Integer> box4 = new Box<Integer>(4);
		Box<Integer> box5 = new Box<Integer>(5);
		Box<Integer> box6 = new Box<Integer>(6);
		Box<Integer> box7 = new Box<Integer>(7);
		
		// Store the boxes in a tree
		TreeSet<Box<Integer>> tree = new TreeSet<>();
		tree.add(box1);
		tree.add(box2);
		tree.add(box3);
		tree.add(box4);
		tree.add(box5);
		tree.add(box6);
		tree.add(box7);
		
		// Print all values in the boxes to the console
		for(Box<Integer> box : tree) {
			System.out.println(box.toString());
		}
	}
	
}
