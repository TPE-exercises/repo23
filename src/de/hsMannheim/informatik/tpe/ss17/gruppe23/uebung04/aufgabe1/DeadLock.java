package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe1;

/**
 * Beispiel für eine Deadlock Situation:
 * Ein Deadlock ist eine Verklemmung mehrerer Threads, wobei diese zyklisch
 * auf bestimmte Resourcen warten, die jedoch noch von einem anderen Thread 
 * beansprucht werden.
 * 
 * Hier verwenden zwei Threads die gleichen zwei Resourcen, wobei jeder Thread
 * beide benötigt um fortzufahren. Da beide Threads jeweils eine Resource
 * blockiert kann das Programm nicht fortfahren und blockiert.
 *
 */

/**
 * Eine Klasse, die einen int Wert speichert und synchronisierte getter und setter bereitstellt.
 */
class Resource2 {
    private int value;
    
    public Resource2(int value) {
    	this.value = value;
    }
    
    public synchronized int getValue() {
    	return value;
    }
    
    public synchronized void setValue(int newValue) {
    	value = newValue;
    }
}

/**
 * Ein Thread, der synchron einen Wert von einer Ressource in eine andere kopiert.
 */
 class Task2 extends Thread {
	 
	 private Resource2 origin, target;

    public Task2(String name, Resource2 origin, Resource2 target) {
    	super(name);
    	this.origin = origin;
    	this.target = target;
    }

    /**
     * Copy the value from the origin resource to the value of the target resource.
     */
    public void run() {
        synchronized (origin) {
        	System.out.println(getName() + " locked origin.");
        	int value = origin.getValue();
        	
        	synchronized (target) {
        		System.out.println(getName() + " locked target.");
				target.setValue(value);
				
				System.out.println(getName() + " ended.");
			}
			
		}
    }
}


public class DeadLock {

    public static void main(String[] args) {
    	System.out.println("DeadLock:");
    	
    	// Create two resources
    	Resource2 resource1 = new Resource2(1);
        Resource2 resource2 = new Resource2(2);
    	
        // Both tasks need both resources to proceed.
        Task2 task1 = new Task2("Task1", resource1, resource2);
        Task2 task2 = new Task2("Task2", resource2, resource1);
        
        task1.start();
        task2.start();
    }
}