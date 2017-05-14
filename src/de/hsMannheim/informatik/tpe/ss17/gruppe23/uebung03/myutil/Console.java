package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.myutil;

import static gdi.MakeItSimple.*;

public class Console extends ConsoleInstructions{
	private static final int STANDART_PUFFER = 5;

	private static QueueArray[] availableQueueArray = new QueueArray[0];
	private static QueueLinkedList[] availableQueueLinkedList = new QueueLinkedList[0];
	private static StackArray[] availableStackArray = new StackArray[0];
	private static StackLinkedList[] availableStackLinkedList = new StackLinkedList[0];

	private static boolean usingActualQueue = false;
	private static boolean usingActualLinkedListVersion = false;
	private static int index = 0;

	private static void printConsoleInstructions(){
		for(int i = 0; i < CONSOLE_INSTRUCTIONS.length; i++){
			System.out.println((i + 1) + ": " + CONSOLE_INSTRUCTIONS[i]);
		}
	}

	private static void printStackInstructions(){
		for(int i = 0; i < STACK_INSTRUCTIONS.length; i++){
			System.out.println((i + 1) + ": " + STACK_INSTRUCTIONS[i]);
		}
	}

	private static void printQueueInstructions(){
		for(int i = 0; i < QUEUE_INSTRUCTIONS.length; i++){
			System.out.println((i + 1) + ": " + QUEUE_INSTRUCTIONS[i]);
		}
	}

	private static void printAvailableStacksAndQueues(boolean showAvailableQueueArray, boolean showAvailableQueueLinkedList, boolean showAvailableStackArray, boolean showAvailableStackLinkedList){
		if(availableQueueArray == null && availableQueueLinkedList == null && 
				availableStackArray == null && availableStackLinkedList == null){
			println("There is actual whether an Stack nor an Queue created.");
		}
		else{
			println("There are actual created:");
			if(showAvailableQueueArray && availableQueueArray != null){
				println(availableQueueArray.length + " QueueArrays");
			}
			if(showAvailableQueueLinkedList && availableQueueLinkedList != null){
				println(availableQueueLinkedList.length + " QueueLinkedLists");
			}
			if(showAvailableStackArray && availableStackArray != null){
				println(availableStackArray.length + " StackArrays");
			}
			if(showAvailableStackLinkedList && availableStackLinkedList != null){
				println(availableStackLinkedList.length + " StackLinkedLists");
			}
		}
	}

	private static int getPuffer(){
		println("Which puffer you want? 0 = standart puffer(" + STANDART_PUFFER + ")");
		int userInput = readInt();
		while(userInput < 0){
			println("The puffer has to be positiv.");
			userInput = readInt();
		}
		if(userInput == 0){
			return STANDART_PUFFER;
		}
		return userInput;
	}

	private static void includeNewADTIntoList(String whichADT, Object adt){
		if(whichADT != null){
			if(whichADT.equals("QueueArray")){
				QueueArray[] newAvailableQueueArray = new QueueArray[availableQueueArray.length + 1];
				for(int i = 0; i < availableQueueArray.length; i++){
					newAvailableQueueArray[i] = availableQueueArray[i];
				}
				newAvailableQueueArray[availableQueueArray.length] = (QueueArray)adt;
				availableQueueArray = newAvailableQueueArray;
				usingActualQueue = true;
				usingActualLinkedListVersion = false;
				index = availableQueueArray.length + 1;
			}
			else if(whichADT.equals("QueueLinkedList")){
				QueueLinkedList[] newAvailableQueueLinkedList = new QueueLinkedList[availableQueueLinkedList.length + 1];
				for(int i = 0; i < availableQueueLinkedList.length; i++){
					newAvailableQueueLinkedList[i] = availableQueueLinkedList[i];
				}
				newAvailableQueueLinkedList[availableQueueLinkedList.length] = (QueueLinkedList)adt;
				availableQueueLinkedList = newAvailableQueueLinkedList;
				usingActualQueue = true;
				usingActualLinkedListVersion = true;
				index = availableQueueLinkedList.length + 1;
			}
			else if(whichADT.equals("StackArray")){
				StackArray[] newAvailableStackArray = new StackArray[availableStackArray.length + 1];
				for(int i = 0; i < availableStackArray.length; i++){
					newAvailableStackArray[i] = availableStackArray[i];
				}
				newAvailableStackArray[availableStackArray.length] = (StackArray)adt;
				availableStackArray = newAvailableStackArray;
				usingActualQueue = false;
				usingActualLinkedListVersion = false;
				index = availableStackArray.length + 1;
			}
			else if(whichADT.equals("StackLinkedList")){
				StackLinkedList[] newAvailableStackLinkedList = new StackLinkedList[availableStackLinkedList.length + 1];
				for(int i = 0; i < availableStackLinkedList.length; i++){
					newAvailableStackLinkedList[i] = availableStackLinkedList[i];
				}
				newAvailableStackLinkedList[availableStackLinkedList.length] = (StackLinkedList)adt;
				availableStackLinkedList = newAvailableStackLinkedList;
				usingActualQueue = false;
				usingActualLinkedListVersion = true;
				index = availableStackLinkedList.length + 1;
			}
			else{
				println("ADT cannot include into list <" + whichADT + ">.");
			}
		}
	}

	public static void main(String[] args) {
		boolean exit = true;
		printConsoleInstructions();
		while(exit){
			int userInput = readInt();
			while(userInput <= 0 || userInput > CONSOLE_INSTRUCTIONS.length){
				println("The order has to be between 1 and " + CONSOLE_INSTRUCTIONS.length);
				userInput = readInt();
			}
			int puffer = 0;
			switch(userInput){
			case 1: println("Programm stopped.");exit = false;break;
			case 2: 
				puffer = getPuffer();
				StackArray newStackArray = new StackArray(puffer);
				includeNewADTIntoList("StackArray",newStackArray);
				break;
			case 3:
				puffer = getPuffer();
				StackLinkedList newStackLinkedList = new StackLinkedList(puffer);
				includeNewADTIntoList("StackLinkedList",newStackLinkedList);
				break;
			case 4:
				puffer = getPuffer();
				QueueArray newQueueArray = new QueueArray(puffer);
				includeNewADTIntoList("QueueArray",newQueueArray);
				break;
			case 5:
				puffer = getPuffer();
				QueueLinkedList newQueueLinkedList = new QueueLinkedList(puffer);
				includeNewADTIntoList("QueueLinkedList",newQueueLinkedList);
				break;
			case 6: printAvailableStacksAndQueues(true, true, true, true);
			case 7:
				println("Which adt you want to use?");
				println("1: StackArray");
				println("2: StackLinkedList");
				println("3: QueueArray");
				println("4: QueueLinkedList");
				int input = readInt();
				while(input < 1 || input > 4){
					println("There are only 4 adts to choose.");
				}
				switch(input){
				case 1:
					if(availableStackArray == null || availableStackArray.length == 0){
						println("There are no StackArrays available yet.");
						break;
					}
					else{
						printAvailableStacksAndQueues(false, false, true, false);
						println("Which StackArray do you prefer?");
						int in = readInt();
						while(in < 0 || in > availableStackArray.length){
							println("StackArray No. " + in + " does not exist.");
						}
						usingActualQueue = false;
						usingActualLinkedListVersion = false;
						index = in;
					}
					break;
				case 2: 
					if(availableStackLinkedList == null || availableStackLinkedList.length == 0){
						println("There are no StackLinkedLists available yet.");
						break;
					}
					else{
						printAvailableStacksAndQueues(false, false, false, true);
						println("Which StackLinkedList do you prefer?");
						int in = readInt();
						while(in < 0 || in > availableStackLinkedList.length){
							println("StackArray No. " + in + " does not exist.");
						}
						usingActualQueue = false;
						usingActualLinkedListVersion = true;
						index = in;
					}
					break;
				case 3: 
					if(availableQueueArray == null || availableQueueArray.length == 0){
						println("There are no QueueArray available yet.");
						break;
					}
					else{
						printAvailableStacksAndQueues(true, false, false, false);
						println("Which QueueArray do you prefer?");
						int in = readInt();
						while(in < 0 || in > availableQueueArray.length){
							println("StackArray No. " + in + " does not exist.");
						}
						usingActualQueue = true;
						usingActualLinkedListVersion = false;
						index = in;
					}
					break;
				case 4: 
					if(availableQueueLinkedList == null || availableQueueLinkedList.length == 0){
						println("There are no QueueLinkedList available yet.");
						break;
					}
					else{
						printAvailableStacksAndQueues(false, true, false, false);
						println("Which QueueLinkedList do you prefer?");
						int in = readInt();
						while(in < 0 || in > availableQueueLinkedList.length){
							println("StackArray No. " + in + " does not exist.");
						}
						usingActualQueue = true;
						usingActualLinkedListVersion = true;
						index = in;
					}
					break;
				default: println("Something goes wrong.");break;
				}
				break;
			default: println("Something goes wrong.");break;
			}

			if(!(availableQueueArray == null && availableQueueLinkedList == null && 
					availableStackArray == null && availableStackLinkedList == null)){	
				print("Working actual with: <");
				if(usingActualQueue && usingActualLinkedListVersion){
					print("QueueLinkedList");
				}
				else if(usingActualQueue && !usingActualLinkedListVersion){
					print("QueueArray");
				}
				else if(!usingActualQueue && usingActualLinkedListVersion){
					print("StackLinkedList");
				}
				else if(!usingActualQueue && !usingActualLinkedListVersion){
					print("StackArray");
				}
				print(" No. " + index + ">");
				println("");

				if(usingActualQueue){
					printQueueInstructions();
					int input = readInt();
					while(input < 0 || input > QUEUE_INSTRUCTIONS.length){
						println("Insert values between 1 and " + QUEUE_INSTRUCTIONS.length);
					}
					switch(input){
					case 1: 
						println("Which you want to enter?");
						Object toEnter = readLine();
						if(usingActualLinkedListVersion){
							try{
								availableQueueLinkedList[index].enter(toEnter);
							}
							catch(OverflowException e){
								e.printStackTrace();
							}
						}
						else{
							try{
								availableQueueArray[index].enter(toEnter);
							}
							catch(OverflowException e){
								e.printStackTrace();
							}
						}
						break;
					case 2:
						if(usingActualLinkedListVersion){
							try{
								availableQueueLinkedList[index].leave();
							}
							catch(UnderflowException e){
								e.printStackTrace();
							}
						}
						else{
							try{
								availableQueueArray[index].leave();
							}
							catch(UnderflowException e){
								e.printStackTrace();
							}
						}
						break;
					case 3:
						if(usingActualLinkedListVersion){
							try{
								println(availableQueueLinkedList[index].front());
							}
							catch(UnderflowException e){
								e.printStackTrace();
							}
						}
						else{
							try{
								println(availableQueueArray[index].front());
							}
							catch(UnderflowException e){
								e.printStackTrace();
							}
						}
						break;
					case 4:
						if(usingActualLinkedListVersion){
							puffer = getPuffer();
							QueueLinkedList newQueueLinkedList = new QueueLinkedList(puffer);
							includeNewADTIntoList("QueueLinkedList",newQueueLinkedList);
						}
						else{
							puffer = getPuffer();
							QueueArray newQueueArray = new QueueArray(puffer);
							includeNewADTIntoList("QueueArray",newQueueArray);
						}
						break;
					case 5:
						if(usingActualLinkedListVersion){
							println(availableQueueLinkedList[index].isEmpty());
						}
						else{
							println(availableQueueArray[index].isEmpty());
						}
						break;
					case 6:
						if(usingActualLinkedListVersion){
							println(availableQueueLinkedList[index].size());
						}
						else{
							println(availableQueueArray[index].size);
						}
						break;
					case 7: break;
					default: println("Something goes wrong.");
					}
				}
				else{
					printStackInstructions();
					int input = readInt();
					while(input < 0 || input > STACK_INSTRUCTIONS.length){
						println("Insert values between 1 and " + STACK_INSTRUCTIONS.length);
					}
					switch(input){
					case 1: 
						println("Which you want to push?");
						Object toEnter = readLine();
						if(usingActualLinkedListVersion){
							try{
								availableStackLinkedList[index].push(toEnter);
							}
							catch(OverflowException e){
								e.printStackTrace();
							}
						}
						else{
							try{
								availableStackArray[index].push(toEnter);
							}
							catch(OverflowException e){
								e.printStackTrace();
							}
						}
						break;
					case 2:
						if(usingActualLinkedListVersion){
							try{
								availableStackLinkedList[index].pop();
							}
							catch(UnderflowException e){
								e.printStackTrace();
							}
						}
						else{
							try{
								availableStackArray[index].pop();
							}
							catch(UnderflowException e){
								e.printStackTrace();
							}
						}
						break;
					case 3:
						if(usingActualLinkedListVersion){
							try{
								println(availableStackLinkedList[index].top());
							}
							catch(UnderflowException e){
								e.printStackTrace();
							}
						}
						else{
							try{
								println(availableStackArray[index].top());
							}
							catch(UnderflowException e){
								e.printStackTrace();
							}
						}
						break;
					case 4:
						if(usingActualLinkedListVersion){
							puffer = getPuffer();
							StackLinkedList newStackLinkedList = new StackLinkedList(puffer);
							includeNewADTIntoList("StackLinkedList",newStackLinkedList);
						}
						else{
							puffer = getPuffer();
							StackArray newStackArray = new StackArray(puffer);
							includeNewADTIntoList("StackArray",newStackArray);
						}
						break;
					case 5:
						if(usingActualLinkedListVersion){
							println(availableStackLinkedList[index].isEmpty());
						}
						else{
							println(availableStackArray[index].isEmpty());
						}
						break;
					case 6:
						if(usingActualLinkedListVersion){
							println(availableStackLinkedList[index].size());
						}
						else{
							println(availableStackArray[index].size);
						}
						break;
					case 7: break;
					default: println("Something goes wrong.");
					}
				}
			}
		}
	}
}
