package edu.waketech.ccave.provided;

/**
 * All possible classes of input:  movement, inventory management, looking around, and "other."
 * 
 * The hope is that if we can sort various commands into a smaller number of 
 * types, then processing will be easier to handle.
 * 
 * @author parks
 *
 */
public enum InputType {
	
	MOVE,
	INVENTORY,
	LOOK,
	OTHER,
	SAVE,
	MAGIC,
	MAGIC2
	;

}