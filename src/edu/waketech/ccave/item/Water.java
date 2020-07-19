////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC251
// 
//  Project:  ColossalCave
//  File:     Water.java
//  
//  Name:     Rebecca Fenter
//  Email:    rtfenter@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////
package edu.waketech.ccave.item;

import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.location.CCaveRoom;
import edu.waketech.ccave.provided.ItemCommand;
import edu.waketech.ccave.provided.Spelunker;

/**
 * Subclass for Water item
 * 
 * Can be picked up/dropped off
 * 
 * Can be drank and like food will disappear once drunken
 * 
 * @author Rebecca Fenter
 *
 */
public class Water extends CCaveItem {

	public static final String MY_NAME = "water";

	public Water() {
		super(MY_NAME);
	}

	/**
	 * Drink the water, if that's what's commanded.  
	 * Food that's eaten simply disappears from the game.
	 */
	
	@Override
	public void executeCommand(ItemCommand cmd, String item, CCaveRoom currentLocation) {
		if (cmd == ItemCommand.DRINK && (inLocation(currentLocation)) || inLocation(Spelunker.SPELUNKER_ID)) {
			// yes we can!
			ItemDirectory.getInstance().remove(this);

		} else {
			super.executeCommand(cmd, item, currentLocation);
		}
	}

}
