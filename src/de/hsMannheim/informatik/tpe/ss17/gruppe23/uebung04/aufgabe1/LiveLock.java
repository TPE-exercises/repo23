package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe1;

/**
 * Beispiel für eine Livelock Situation:
 * Bei einem Livelock wechselt das Programm ständig zwischen zwei Zuständen, ohne
 * diese verlassen zu können. So läuft das Programm zwar weiter, es kommt aber
 * trotzdem zu einer Verklemmung.
 * 
 * Hier greifen zwei Threads auf eine gemeinsame Ressource zu, wobei die beiden
 * Threads nichts tun, sondern sich ewig gegenseitig den Zugriff auf die Ressource
 * hin und her zu schieben.
 */

/**
 * Repräsentiert eine Ressource, die von einem bestimmten Task gelockt werden kann.
 */
class Resource {
    private Task task;
    
    public Resource(Task task) {
    	this.task = task;
    }
    
    public Task getTask() {
    	return task;
    }
    
    public synchronized void setTask(Task newTask) {
    	task = newTask;
    }
    
    public synchronized void use() {
    	System.out.println(task.getName() + " uses the resource.");
    }
}

/**
 * Ein Thread, der eine Ressource nutzen möchte, jedoch einem bestimmten
 * anderen Thread dabei immer die Ressource überträgt.
 */
class Task {
    private String name;
    private boolean needingResource;

    public Task(String name) {
    	this.name = name;
    	needingResource = true;
    }
    
    public String getName() {
    	return name;
    }
    
    public boolean needingResource() {
    	return needingResource;
    }

    public void useResource(Resource resource, Task otherTask) {
        while (needingResource) {
            if (resource.getTask() != this) {
                try {
                	Thread.sleep (1);
                }
                catch(InterruptedException e) {
                	continue;
                }
                continue;
            }                       

            if (otherTask.needingResource()) {
            	System.out.println(name + " gives resource to " + otherTask.getName());
                resource.setTask(otherTask);
                continue;
            }

            resource.use();
            needingResource = false;
            System.out.println(name + " uses resource.");            
            resource.setTask(otherTask);
        }
    }
}


public class LiveLock {

    public static void main(String[] args) {
    	System.out.println("LiveLock:");
    	
    	// Zwei Threads erzeugen
        Task task1 = new Task("Task1");
        Task task2 = new Task("Task2");
        
        // EIne Ressource erzeugen
        Resource resource = new Resource(task1);

        // Beide Threads greifen auf die selbe Ressource zu.
        new Thread(new Runnable() { public void run() { task1.useResource(resource, task2); } }).start();
        new Thread(new Runnable() { public void run() { task2.useResource(resource, task1); } }).start();
    }
}
