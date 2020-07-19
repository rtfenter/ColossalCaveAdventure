////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     Fissure.java
//  
//  Name:     Rebecca Fenter
//  Email:    rtfenter@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////
package edu.waketech.ccave.location;

import edu.waketech.ccave.common.Direction;
import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.common.RoomDirectory;
import edu.waketech.ccave.item.Lamp;
import edu.waketech.ccave.item.Rod;
import edu.waketech.ccave.location.CCaveRoom;
import edu.waketech.ccave.provided.Spelunker;

/**
 * Subclass for Fissure Room
 * 
 * @author Rebecca Fenter 
 *
 */
public class Fissure extends CCaveRoom
{
	public static final String MY_NAME = "fissure";

	private int state = 0;

	public Fissure() {
		super(MY_NAME);
	}

	public void NotEmpty()
	{
		state = 1;
	}

	public void Empty()
	{
		state = 0;
	}

	public boolean isNotEmpty()
	{
		return state == 1;
	}

	@Override
	public String getLongDescription()
	{
		String desc = super.getLongDescription();
		desc = desc + "\nThe fissure is currently " + ((isNotEmpty()) ? "notempty." : "empty.");
		return desc;
	}

	@Override
	public CCaveRoom nextRoom(Direction dir)
	{
		CCaveRoom newRoom = super.nextRoom(dir);
		if (newRoom == RoomDirectory.getInstance().get("crystalbridge"))
		{
			// make sure bridge has appeared
			if (!isNotEmpty())
			{
				System.out.println("\nYou need to wave your rod in order to continue forward.");
				newRoom = this;
			}

		}
		return newRoom;
	}


}


	
	/**

	@Override
	public String getLongDescription()
	{
		Rod rod = (Rod) ItemDirectory.getInstance().get("rod");
		if (rod.isWaved() && rod.inLocation(Spelunker.SPELUNKER_ID))
		{
			String desc = "A crystal bridge has appeared, simply by waving your rod.";
			return desc;
		}
		else
		{
			return super.getLongDescription();
		}

	}

	@Override
	public String getContentsLongDescription()
	{
		Rod rod = (Rod) ItemDirectory.getInstance().get("rod");
		if (rod.isWaved() && rod.inLocation(Spelunker.SPELUNKER_ID))
		{
			return super.getContentsLongDescription();
		}
		else
		{
			return "There is no where to go.\n";
		}

	}
	*/



