package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung03.myutil;

public class ConsoleInstructions {
	protected static final String[] CONSOLE_INSTRUCTIONS = {
			"exit",
			"create new StackArray",
			"create new StackLinkedList",
			"create new QueueArray",
			"create new QueueLinkedList",
			"print available Stacks and Queues",
			"switch ADT"
	};
	
	protected static final String[] STACK_INSTRUCTIONS = {
			"push:\tpushs an Object into the top of the actual Stack",
			"pop:\tpops the top Object from the actual Stack",
			"top:\tprint the top Object from the actual Stack",
			"empty:\tcreates an new empty Stack.",
			"isEmpty:\tIs the actual Stack empty?",
			"size:\tprints the size of the actual Stack",
			"exit"
	};
	
	protected static final String[] QUEUE_INSTRUCTIONS = {
			"enter:\tAdds an Object at the last position of the actual Queue",
			"leave:\tRemoves the first Object from the actual Queue",
			"front:\tprints the first Object from the actual Queue",
			"empty:\tcreates a new empty Queue",
			"isEmpty:\tchecks whether or not the actual Queue is empty",
			"size:\tprints the size of the actual Queue",
			"exit"
	};
}