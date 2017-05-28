package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe1;

/**
 * Gruppe 2-3:
 * @author Max Granzow(1624770)
 * @author Joshua Joost(1626034)
 * 
 * This class shows the problem by using more then one threads at 
 * the same time when the threads writing the same fields.
 * So-called RaceCondition (Safety Hazard)
 */
public class RaceCondition2{
	
	public static void main(String[] args){
		//Problem RaceCondition
		Rectangle rect = new Rectangle();
		
		//Setup an 2*3 rectangle
		Thread setNewRect1 = new Thread(){
			@Override
			public void run(){
				rect.setBaseLine(2);
				rect.setHeight(3);
			}
		};
		
		//Setup an 4*5 rectangle
		Thread setNewRect2 = new Thread(){
			@Override
			public void run(){
				rect.setBaseLine(4);
				rect.setHeight(5);
			}
		};
		
		//Setup an 6*7 rectangle
		Thread setNewRect3 = new Thread(){
			@Override
			public void run(){
				rect.setBaseLine(6);
				rect.setHeight(7);
			}
		};
		
		setNewRect1.start();
		setNewRect2.start();
		setNewRect3.start();
		
		// An dieser Stelle tritt ein Problem auf, erstmal wird deutlich, dass das Verwenden von
		// Threads das Programm nicht deterministisch macht, das heißt dass das Programm unter gleichen
		// Bedinungen zu unterschiedlichen Ergebnissen kommen kann. Darüber hinaus wird an diesem Beispiel 
		// auch das Problem deutlich was passieren kann, wenn mehrere Threads schreibend auf die selben Daten 
		// zugreifen. Sind sie nicht synchronisiert kann sich das Ergebnis, hier das des Flächeninhaltes eines 
		// Rechtecks, auch dann noch ändern, wenn nach der ersten Ausgabe direkt eine Weitere Folgt. 
		// Das Programm wird unkontrollierbar und verhält sich nicht richtig -> RaceCondition
		System.out.println("Der Fläscheninhalt beträgt: " + rect.getArea());
		System.out.println("Und jetzt ist er: " + rect.getArea());
	}
}