package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.myutil;

public class Tester {
	
	public static void main(String[] args) {
		testQueueArray();
	}

	private static void testStackArray() {
		StackArray stack = new StackArray(2);
		System.out.println("EINGABE: push(Test)");
		try {
			stack.push("Test");
		}
		catch(OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		

		System.out.println("EINGABE: top()");
		try {
			System.out.println(stack.top());
		}
		catch(UnderflowException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("EINGABE: pop()");
		try {
			stack.pop();
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("EINGABE: isEmpty()");
		System.out.println(stack.isEmpty());
		
		System.out.println("EINGABE: pop()");
		try {
			stack.pop();
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("EINGABE: push(Test1)");
		try {
			stack.push("Test1");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		
		System.out.println("EINGABE: push(Test2)");
		try {
			stack.push("Test2");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		
		System.out.println("EINGABE: push(Test3)");
		try {
			stack.push("Test3");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		
		System.out.println("EINGABE: push(Test4)");
		try {
			stack.push("Test4");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		
		System.out.println("EINGABE: push(Test5)");
		try {
			stack.push("Test5");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		
		System.out.println("EINGABE: push(Test6)");
		try {
			stack.push("Test6");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		
		while(!stack.isEmpty()) {
			
			System.out.println("EINGABE: pop()");
			try {
				System.out.println(stack.pop());
			} catch (UnderflowException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		System.out.println("EINGABE: isEmpty()");
		System.out.println(stack.isEmpty());
	}
	
	private static void testQueueArray() {
		Queue queue = new QueueArray(2);
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: enter(Test)");
		try {
			queue.enter("Test");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: isEmpty()");
		System.out.println(queue.isEmpty());
		
		System.out.println("EINGABE: front()");
		try {
			System.out.println(queue.front());
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: leave()");
		try {
			System.out.println(queue.leave());
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: isEmpty()");
		System.out.println(queue.isEmpty());
		
		///////////
		System.out.println("EINGABE: enter(Test)");
		try {
			queue.enter("Test");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: leave()");
		try {
			System.out.println(queue.leave());
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		///////////
		System.out.println("EINGABE: enter(Test)");
		try {
			queue.enter("Test");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: leave()");
		try {
			System.out.println(queue.leave());
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		///////////
		
		System.out.println("EINGABE: leave()");
		try {
			System.out.println(queue.leave());
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		
		System.out.println("EINGABE: enter(Test1)");
		try {
			queue.enter("Test1");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: enter(Test2)");
		try {
			queue.enter("Test2");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: enter(Test3)");
		try {
			queue.enter("Test3");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: enter(Test4)");
		try {
			queue.enter("Test4");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: enter(Test5)");
		try {
			queue.enter("Test5");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: enter(Test6)");
		try {
			queue.enter("Test6");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: enter(Test7)");
		try {
			queue.enter("Test7");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
	}
	
	private static void testQueueLinkedList() {
		Queue queue = new QueueLinkedList(2);
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: enter(Test)");
		try {
			queue.enter("Test");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: isEmpty()");
		System.out.println(queue.isEmpty());
		
		System.out.println("EINGABE: front()");
		try {
			System.out.println(queue.front());
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: leave()");
		try {
			System.out.println(queue.leave());
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: isEmpty()");
		System.out.println(queue.isEmpty());
		
		///////////
		System.out.println("EINGABE: enter(Test)");
		try {
			queue.enter("Test");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: leave()");
		try {
			System.out.println(queue.leave());
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		///////////
		System.out.println("EINGABE: enter(Test)");
		try {
			queue.enter("Test");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: leave()");
		try {
			System.out.println(queue.leave());
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		///////////
		
		System.out.println("EINGABE: leave()");
		try {
			System.out.println(queue.leave());
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		
		System.out.println("EINGABE: enter(Test1)");
		try {
			queue.enter("Test1");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: enter(Test2)");
		try {
			queue.enter("Test2");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: enter(Test3)");
		try {
			queue.enter("Test3");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: enter(Test4)");
		try {
			queue.enter("Test4");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: enter(Test5)");
		try {
			queue.enter("Test5");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: enter(Test6)");
		try {
			queue.enter("Test6");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
		
		System.out.println("EINGABE: enter(Test7)");
		try {
			queue.enter("Test7");
		} catch (OverflowException e) {
			System.out.println(e.getMessage() + " Value: " + e.getInsertionObject().toString());
			e.printStackTrace();
		}
		System.out.println(queue.toString());
	}
}
