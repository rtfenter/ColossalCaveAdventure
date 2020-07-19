////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     Grate.java
//  
//  Name:     Rebecca Fenter
//  Email:    rtfenter@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////
package edu.waketech.ccave.location;

import edu.waketech.ccave.common.Direction;
import edu.waketech.ccave.common.RoomDirectory;

/**
 * Subclass for Grate Room
 * 
 * @author Rebecca Fenter 
 *
 */
public class Grate extends CCaveRoom
{
	public static final String MY_NAME = "grate";

	private int state = 0;

	public Grate() {
		super(MY_NAME);
	}

	public void Unlock()
	{
		state = 1;
	}

	public void Lock()
	{
		state = 0;
	}

	public boolean isUnlocked()
	{
		return state == 1;
	}

	@Override
	public String getLongDescription()
	{
		String desc = super.getLongDescription();
		desc = desc + "\nThe grate is currently " + ((isUnlocked()) ? "unlocked." : "locked.");
		return desc;
	}

	@Override
	public CCaveRoom nextRoom(Direction dir)
	{
		CCaveRoom newRoom = super.nextRoom(dir);
		if (newRoom == RoomDirectory.getInstance().get("chamber"))
		{
			// make sure door is not locked
			if (!isUnlocked())
			{
				System.out.println("\nYou need to unlock the grate before traveling in that direction.");
				newRoom = this;
			}

		}
		return newRoom;
	}


}

