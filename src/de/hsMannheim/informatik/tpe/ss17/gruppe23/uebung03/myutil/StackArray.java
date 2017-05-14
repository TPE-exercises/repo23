package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.myutil;

/**
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 */
public class StackArray implements Stack {
	
	private static final int STANDART_PUFFER = 5;
	private static final int MIN_PUFFER = 1;
	protected int size = 0;
	protected int userPreferedPuffer = MIN_PUFFER;
	protected boolean increasedArrayLength = false;
	
	private Object[] puffer;
	
	public StackArray() {
		this(STANDART_PUFFER);
	}
	
	public StackArray(int puffer) throws IllegalArgumentException {
		if(puffer < MIN_PUFFER){
			throw new IllegalArgumentException("Der Puffer muss mindestens " + MIN_PUFFER + " sein.");
		}
		this.userPreferedPuffer = puffer;
		
		this.puffer = new Object[userPreferedPuffer];
	}

	@Override
	public void push(Object element) throws OverflowException {
		if(size + 1 > userPreferedPuffer){
			if(increasedArrayLength){
				throw new OverflowException("Das Element: <" + element.toString() + "> konnte nicht mehr hinzugefügt werden.");
			}
			else{
				Object[] newPuffer = new Object[userPreferedPuffer * 2];
				for(int i = 0; i < puffer.length; i++){
					newPuffer[i] = puffer[i];
				}
				puffer = newPuffer;
				userPreferedPuffer = userPreferedPuffer * 2;
				increasedArrayLength = true;
				System.out.println("Das Array wurde verdoppelt.");
				push(element);
			}
		}
		else{
			puffer[size] = element;
			size++;
		}
	}

	@Override
	public Object pop() throws UnderflowException {
		if(isEmpty()){
			throw new UnderflowException();
		}
		else{
			Object value = top();
			puffer[size - 1] = null;
			size--;
			
			return value;
		}
	}

	@Override
	public Object top() throws UnderflowException {
		if(isEmpty()){
			throw new UnderflowException("Die Liste ist leer.");
		}
		else{
			return puffer[size - 1];
		}
	}

	@Override
	public Stack empty() {
		return new StackArray();
	}

	@Override
	public Stack empty(int puffer) {
		return new StackArray(puffer);
	}

	@Override
	public boolean isEmpty() {
		if(size != 0){
			return false;
		}
		return true;
	}

	@Override
	public int size() {
		return this.size;
	}
	
	public static void main(String[] args){
		StackArray stack = new StackArray(2);
		
		try{
//			System.out.println("top(): ");
			//stack.top();
			System.out.println("push(2): ");
			stack.push(2);
			System.out.println("push(11): ");
			stack.push(11);
			System.out.println("push(Test1): ");
			stack.push("Test1");
			System.out.println("pop(): ");
			stack.pop();
			System.out.print("top() = ");
			System.out.println(stack.top());
			System.out.println("push(Test1): ");
			stack.push("Test1");
			System.out.println("push(Test2): ");
			stack.push("Test2");
			System.out.print("size() = ");
			System.out.println(stack.size());
			System.out.println("push(9): ");
			stack.push(9);
			System.out.print("top()= ");
			System.out.println(stack.top());
		}
		catch(OverflowException | UnderflowException e){
			e.printStackTrace();
		}
	}

}
