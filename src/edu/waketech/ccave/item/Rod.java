////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 151 Spring 2014
//  Section:  (your section number)
// 
//  Project:  ColossalCave
//  File:     Rod.java
//  
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
////////////////////////////////////////////////////////////////////////////////
package edu.waketech.ccave.item;

import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.common.RoomDirectory;
import edu.waketech.ccave.location.CCaveRoom;
import edu.waketech.ccave.location.Fissure;
import edu.waketech.ccave.location.Grate;
import edu.waketech.ccave.provided.ItemCommand;
import edu.waketech.ccave.provided.Spelunker;

/**
 * Subclass for Rod item
 * Can be picked up/dropped
 * 
 * @author Rebecca Fenter
 *
 */
public class Rod extends CCaveItem
{
	public static final String MY_NAME = "rod";
	
	private int state = 0;
	
	public Rod()
    {
        super(MY_NAME);

    }

	@Override
	public void executeCommand(ItemCommand cmd, String item, CCaveRoom currentLocation)
	{
		if (cmd != ItemCommand.WAVE && cmd != ItemCommand.UNWAVE)
		   {
		      super.executeCommand(cmd, item, currentLocation);
		      return;
		   }
		if (!inLocation(Spelunker.SPELUNKER_ID))
		{
			System.out.println("\nYou need a rod to find the rainbow bridge.\n");
		}
		else if (currentLocation != RoomDirectory.getInstance().get("fissure"))
		{
			System.out.println("/nThere is nothing to make appear here./n");
		}
		else
		{
			Fissure fissure =  (Fissure) currentLocation;
			if (cmd == ItemCommand.WAVE)
			{
				fissure.NotEmpty();//check this tomorrow changed from isNotEmpty
			}
			if (cmd == ItemCommand.UNWAVE)
			{
				fissure.Empty();
			}

		}

	}




	public void isNotEmpty()
	{
		state = 1;
		}
	
	public void Empty()
	{
		state = 0;
	    }
	
	public boolean isntEmpty()
	{
		return state == 1;
	    }

}
	