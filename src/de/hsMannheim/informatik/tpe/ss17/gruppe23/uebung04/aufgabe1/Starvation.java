package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe1;

/**
 * Beispiel für eine Starvation Situation:
 * Bei einer Starvation, auch Aushungern genannt, kann ein Thread seine Aufgabe
 * nicht erfüllen, da immer ein anderer Thread (mit einer höheren Priorität) 
 * bevorzugt wird.
 * 
 * Hier greifen zwei Threads "gleichzeitig" auf eine Ressource zu. Dabei kommt ein Thread
 * weit häufiger / immer zum Zug, da er eine höhere Priorität hat und der andere Thread
 * verhungert, da er nie an die Reihe kommt.
 */

class Resource3 {
	
	int value;
	
	public Resource3(int value) {
		this.value = value;
	}
	
	public synchronized int getValue() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			return value;
		}
		return value;
	}
}

class Task3 extends Thread {
	
	private Resource3 resource;
	private String name;
	
	public Task3(Resource3 resource, String name) {
		this.resource = resource;
		this.name = name;
	}
	
	public void run() {
		while(true) {
			synchronized (resource) {
				System.out.println(name + " hat Zugriff auf die Resource: " + resource.getValue());
			}
		}
	}
}

public class Starvation {

	public static void main(String[] args) {
		Resource3 resource = new Resource3(5);
		
		Task3 workerTask = new Task3(resource, "WorkerTask");
		Task3 starvationTask = new Task3(resource, "StarvationTask");
		
		workerTask.setPriority(Thread.MAX_PRIORITY);
		starvationTask.setPriority(Thread.MIN_PRIORITY);
		
		workerTask.start();
		starvationTask.start();
	}
	
}
