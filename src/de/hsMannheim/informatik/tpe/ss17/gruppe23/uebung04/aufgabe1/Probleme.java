package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung04.aufgabe1;

/**
 * Wenn ein Programm mehrere Threads verwendet können mehrere Probleme auftreten,
 * die direkt durch die Verwendung mehrerer Threads ausgelöst werden.
 * 
 * Man unterscheidet drei Kategorien: Safety-, Liveness- und Performance Hazards.
 * 
 * Safety Hazards:
 * 	- Race condition:
 * 		Das Programm werhält sich in Anwesenheit mehrerer Threads nicht mehr (unbedingt) korrekt.
 * 		Dabei hängt das Ergebnis des Programms von der zeitlichen Abarbeitung der Threads ab,
 * 		die jedoch nicht eindeutig gegeben ist. So kann das Ergebnis (ungewollt) variieren,
 * 		da die Variablen in einen inkonsistenten Zustand versetzt werden (können).
 * 
 * Liveness Hazards:
 * 	- DeadLock:
 * 		Ein Deadlock ist eine Verklemmung mehrerer Threads, wobei diese zyklisch
 * 		auf bestimmte Resourcen warten, die jedoch noch von einem anderen Thread 
 * 		beansprucht werden.
 * 	- LiveLock:
 * 		Bei einem Livelock wechselt das Programm ständig zwischen zwei Zuständen, ohne
 * 		diese verlassen zu können. So läuft das Programm zwar weiter, es kommt aber
 * 		trotzdem zu einer Verklemmung.
 * 	- Starvation:
 * 		Bei einer Starvation, auch Aushungern genannt, kann ein Thread seine Aufgabe
 * 		nicht erfüllen, da immer ein anderer Thread (mit einer höheren Priorität) 
 * 		bevorzugt wird.
 * 
 * Performance Hazards:
 * 	- Performance Verlust:
 * 		Wenn ein Programm zwar mit mehreren Threads korrekt funktioniert, jedoch die
 * 		Performance sehr schlecht ist, spricht man von Performance Hazards.
 * 
 */