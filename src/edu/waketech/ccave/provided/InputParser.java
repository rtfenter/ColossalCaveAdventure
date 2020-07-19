package edu.waketech.ccave.provided;

import java.util.Scanner;

import edu.waketech.ccave.common.Direction;
import edu.waketech.ccave.common.ItemDirectory;

/**
 * Singleton for input parsing from a command line.  
 * 
 * 
 * @author parks
 *
 */
public class InputParser {

	private static InputParser me = null;
	private Scanner inp;
	private String line;
	private Direction direction;
	private String noun;
	private String verb;
	private ItemCommand itemCommand;
	private String cCaveItemName;
	private InputType inputType;

	/**
	 * Singleton for getting input and parsing it.
	 * 
	 * The general form of input is 
	 * 
	 * <verb> <noun>
	 * 
	 * where <verb> is the action to take and <noun> the item to be manipulated or
	 * something that qualifies the <verb>.
	 * 
	 * 
	 * 
	 * Examples are 
	 * 
	 * go east
	 * get lamp
	 * drop food
	 * 
	 * The <verb>s are classified into "move" actions ("go") or inventory manipulation 
	 * ("get," "drop"), or requests to restate current information ("look"), 
	 * or "other" for commands that are special and must be processed by special code 
	 * somewhere else.
	 * 
	 * "Move" commands have special processing.  If only a single word is entered
	 * that is a direction, the "move" classification is assumed.  Thus
	 * 
	 * "go ne" and "ne"
	 * 
	 * are synonyms. 
	 * 
	 * 
	 * NOTE: need to add lock for multi-tasking access.
	 */
	private InputParser() {
		inp = new Scanner(System.in);
	}

	/**
	 * Access the input parser object.  We create one if necessary,
	 * and simply return the one and only existing InputParser object
	 * if it was created already.
	 * 
	 * @return the input parser to handle user input
	 */
	public static synchronized InputParser getInputParser() {
		if (me == null)
			me = new InputParser();
		return me;
	}

	/**
	 * Read the next input from the user.
	 * 
	 * I wonder if this method should be combined with the 
	 * determineType method below?
	 */
	public void readInput() {
		line = inp.nextLine();
		inputType = parseInput();
	}
	
	public InputType getInputType() {
		return inputType;
	}
	
	private void parseSingleWord() {
		Direction d = Direction.findSynonym(verb);
		if (d != Direction.UNKNOWN) {
			inputType = InputType.MOVE;
			itemCommand = ItemCommand.UNKNOWN;
			direction = d;
		}
		
		if ("xyzzy".equalsIgnoreCase(verb))  inputType = InputType.MAGIC;//adding magic word
		if ("plugh".equalsIgnoreCase(verb)) inputType = InputType.MAGIC2;
		if (verb.equalsIgnoreCase("save"))      inputType = InputType.SAVE;

		}

	/**
	 * Parse the input as best we can. 
	 * 
	 * @return value of InputType.  InputType.OTHER is returned if the 
	 * input was not recognized.
	 */
	private InputType parseInput() {
		verb = "";
		noun = "";
		direction = Direction.UNKNOWN;
		itemCommand = ItemCommand.UNKNOWN;
		ItemDirectory itemDirec = ItemDirectory.getInstance();

		int numInputs = 1;
		Scanner parseLine = new Scanner(line);
		if (parseLine.hasNext()) {
			verb = parseLine.next();
		}
		if (parseLine.hasNext()) {
			noun = parseLine.next();
			numInputs++;
		}
		parseLine.close();
		
		if (numInputs == 1) {
			parseSingleWord();
			return inputType;
		}
		// else parseTwoWords();
		
		// if anything in the line looks like a direction (or synonym),
		// we'll assume we're moving.
		direction = Direction.findSynonym(verb);
		if (direction != Direction.UNKNOWN) {
			return InputType.MOVE;
		}

		direction = Direction.findSynonym(noun);
		if (direction != Direction.UNKNOWN) {
			return InputType.MOVE;
		}
		
		itemCommand = ItemCommand.findItemCommand(verb);
		if ((itemCommand == ItemCommand.DROP || itemCommand == ItemCommand.GET) && itemDirec.contains(noun)) {
			cCaveItemName = noun;
			if ("bird".equalsIgnoreCase(noun))
			{
				return InputType.OTHER;
			}
			else
			{
				return InputType.INVENTORY;
			}
		}
		
		// yuck.  Needs to support NLS
		if ("l".equalsIgnoreCase(verb) || "look".equalsIgnoreCase(verb)) return InputType.LOOK;
		
		if(itemCommand==ItemCommand.LOCK||itemCommand== ItemCommand.UNLOCK)
		{
			cCaveItemName="keys";
			return InputType.OTHER; 
		}
		
		cCaveItemName = noun;
		return InputType.OTHER;
	}


	/**
	 * Getter for the parsed direction to move
	 * @return Direction value.  Direction.UNKNOWN if the input was not a "move" command.
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * Getter for the first word of user input.  This method is always
	 * valid, but only useful for OTHER inputs.
	 * 
	 * @return the first word of user input.
	 */
	public String getVerb() {
		return verb;
	}

	/**
	 * Getter for the second word of user input.  This method is always
	 * valid, but only useful for OTHER inputs.
	 * 
	 * @return the second word of user input, or the empty string if no second word was given.
	 */
	public String getNoun() {
		return noun;
	}

	/**
	 * Getter for the entire line of user input.
	 * 
	 * @return the line of user input
	 */
	public String getLine() {
		return line;
	}

	/**
	 * This accessor is valid if and only if the user entered an inventory-related
	 * command, such as "get lamp."  It returns the command (such as GET) entered by the user.
	 * 
	 * @return the ItemCommand value (such as GET) entered by the user if an inventory-related
	 * command was entered.  ItemCommand.UNKNOWN otherwise.
	 */
	public ItemCommand getItemCommand() {
		return itemCommand;
	}

	/**
	 * This accessor is valid if and only if the user entered an inventory-related
	 * command, such as "get lamp."  It returns the object to be manipulated.
	 * 
	 * @return the CCaveItemConfig value (such as "KEYS") that the user wishes to manipulate,
	 * if an inventory-related command was entered.  CCaveItemConfig.UNKNOWN otherwise.
	 */
	public String getcCaveItemName() {
		return cCaveItemName;
	}
	
	

}

