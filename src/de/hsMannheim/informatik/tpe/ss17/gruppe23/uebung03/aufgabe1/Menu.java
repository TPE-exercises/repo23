package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.aufgabe1;

import java.util.Scanner;
import de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.myutil.*;

public class Menu {
	
	private static Scanner scanner = new Scanner(System.in);
	private static Queue queue;
	private static Stack stack;
	private static boolean useStack;

	public static void main(String[] args) {
		// ADT type einlesen
		System.out.println("Welche Datenstruktur soll gewählt werden?");
		System.out.println("1: Stack mit Array");
		System.out.println("2: Stack mit LinkedList");
		System.out.println("3: Queue mit Array");
		System.out.println("4: Queue mit LinkedList");
		int structure = readInt(1, 4);
		
		// Länge einlesen
		System.out.println("Welche Länge soll die ausgewählte Datenstruktur anfangs haben?");
		System.out.println("0: Default Wert von 5");
		System.out.println("1+: Länge von 1+");
		int length = readInt(0, Integer.MAX_VALUE);
		if(length == 0) length = 5;
		
		if(structure == 1) {
			stack = new StackArray(length);
			useStack = true;
		}
		else if(structure == 2) {
			stack = new StackLinkedList(length);
			useStack = true;
		}
		else if(structure == 3) {
			queue = new QueueArray(length);
			useStack = false;
		}
		else if(structure == 4) {
			queue = new QueueLinkedList(length);
			useStack = false;
		}
		
		while(true) {
			if(useStack) {
				stackMenu();
			}
			else {
				queueMenu();
			}
		}

	}
	
	private static void stackMenu() {
		Object o;
		// Action einlesen
		System.out.println("Welche Operation soll auf den Stack ausgeführt werden?");
		System.out.println("0: Exit");
		System.out.println("1: push\tpushs an Object into the top of the actual Stack");
		System.out.println("2: pop\tpops the top Object from the actual Stack");
		System.out.println("3: top\tprint the top Object from the actual Stack");
		System.out.println("4: empty\tcreates an new empty Stack.");
		System.out.println("5: isEmpty\tIs the actual Stack empty?");
		System.out.println("6: size\tprints the size of the actual Stack");
		System.out.println("7: Change to other Stack implementation (all changes will be lost)");
		int command = readInt(0, 7);
		
		if(command == 0) {
			System.exit(0);
		}
		else if(command == 1) {
			// Push element
			try {
				stack.push(readObject());
				System.out.println("Element inserted properly.");
			} catch (OverflowException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		else if(command == 2) {
			// Pop element
			try {
				o = stack.pop();
				System.out.println("Oberstes Element entfernt: " + o.toString());
			} catch (UnderflowException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		else if(command == 3) {
			// Top element
			try {
				o = stack.top();
				System.out.println("Oberstes Element: " + o.toString());
			} catch (UnderflowException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		else if(command == 4) {
			// empty()
			stack = stack.empty();
			System.out.println("The stack is now empty.");
		}
		else if(command == 5) {
			// isEmpty
			if(stack.isEmpty()) {
				System.out.println("Der Stack ist leer.");
			}
			else {
				System.out.println("Der Stack ist nicht leer.");
			}
		}
		else if(command == 6) {
			// size
			System.out.println("Größe des Stack: " + stack.size());
		}
		else if(command == 7) {
			if(stack instanceof StackArray) {
				stack = new StackLinkedList();
				System.out.println("Stack Type gewechselt zu: StackLinkedList.");
			}
			else {
				stack = new StackArray();
				System.out.println("Stack Type gewechselt zu: StackArray.");
			}
		}
	}
	
	private static String readObject() {
		System.out.println("Erstellen Sie ein neues Objekt (hier String)");
		return scanner.nextLine();
	}
	
	private static void queueMenu() {
		Object o;
		// Action einlesen
		System.out.println("Welche Operation soll auf die Queue ausgeführt werden?");
		System.out.println("0: Exit");
		System.out.println("1: enter\tAdds an Object at the last position of the actual Queue");
		System.out.println("2: leave\tRemoves the first Object from the actual Queue");
		System.out.println("3: front\tprints the first Object from the actual Queue");
		System.out.println("4: empty\tcreates a new empty Queue");
		System.out.println("5: isEmpty\tchecks whether or not the actual Queue is empty");
		System.out.println("6: size\tprints the size of the actual Queue");
		System.out.println("7: Change to other Queue implementation (all changes will be lost)");
		int command = readInt(0, 7);
		
		if(command == 0) {
			System.exit(0);
		}
		else if(command == 1) {
			// enter element
			try {
				queue.enter(readObject());
				System.out.println("Element inserted properly.");
			} catch (OverflowException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		else if(command == 2) {
			// leave element
			try {
				o = queue.leave();
				System.out.println("Erstes entferntes Element: " + o.toString());
			} catch (UnderflowException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		else if(command == 3) {
			// front element
			try {
				o = queue.front();
				System.out.println("Erstes Element: " + o.toString());
			} catch (UnderflowException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
		}
		else if(command == 4) {
			// empty()
			queue = queue.empty();
		}
		else if(command == 5) {
			//isEmpty
			if(queue.isEmpty()) {
				System.out.println("Die Queue ist leer.");
			}
			else {
				System.out.println("Die Queue ist nicht leer.");
			}
		}
		else if(command == 6) {
			// size
			System.out.println("Größe der Queue: " + queue.size());
		}
		else if(command == 7) {
			if(queue instanceof QueueArray) {
				queue = new QueueLinkedList();
				System.out.println("Queue Type gewechselt zu: QueueLinkedList.");
			}
			else {
				queue = new QueueArray();
				System.out.println("Queue Type gewechselt zu: QueueArray.");
			}
		}
	}
	
	private static int readInt(int minValue, int maxValue) {
		int userInput = -1;
		boolean correctInput;
		
		do {
			String value = scanner.nextLine();
			
			try {
				correctInput = true;
				userInput = Integer.parseInt(value);
			}
			catch (NumberFormatException e) {
				correctInput = false;
				System.out.println("Die Eingabe ist keine ganze Zahl. Versuchen Sie es erneut.");
			}
			
			if(userInput < minValue || userInput > maxValue) {
				correctInput = false;
				System.out.println("Die Eingabe war nicht im angegebenen Bereich [" + minValue + ", " + maxValue +"]. Versuchen Sie es erneut.");
			}
		}
		while(!correctInput);
		
		return userInput;
	}

}
