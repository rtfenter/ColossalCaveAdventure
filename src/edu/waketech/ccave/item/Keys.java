////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCaveProject0
//  File:     Keys.java
//  
//  Name:     Rebecca Fenter
//  Email:    rtfenter@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////
package edu.waketech.ccave.item;

import edu.waketech.ccave.common.RoomDirectory;
import edu.waketech.ccave.location.CCaveRoom;
import edu.waketech.ccave.location.Grate;
import edu.waketech.ccave.provided.ItemCommand;
import edu.waketech.ccave.provided.Spelunker;

/**
 * Subclass for Keys item
 * 
 * Can be picked up/dropped off
 * 
 * Can be used to lock/unlock
 * 
 * @author Rebecca Fenter
 *
 */
public class Keys extends CCaveItem
{
	public static final String MY_NAME = "keys";
	
	private int state = 0;
	
	public Keys()
    {
        super(MY_NAME);

    }

	@Override
	public void executeCommand(ItemCommand cmd, String item, CCaveRoom currentLocation)
	{
		if (cmd != ItemCommand.LOCK && cmd != ItemCommand.UNLOCK)
		   {
		      super.executeCommand(cmd, item, currentLocation);
		      return;
		   }
		if (!inLocation(Spelunker.SPELUNKER_ID))
		{
			System.out.println("\nYou need keys to lock or unlock a door\n");
		}
		else if (currentLocation != RoomDirectory.getInstance().get("grate"))
		{
			System.out.println("/nThere is nothing to lock or unlock here/n");
		}
		else
		{
			Grate grate =  (Grate) currentLocation;
			if (cmd == ItemCommand.UNLOCK)
			{
				grate.Unlock();
			}
			if (cmd == ItemCommand.LOCK)
			{
				grate.Lock();
			}

		}

	}




	public void Unlock()
	{
		state = 1;
		}
	
	public void Lock()
	{
		state = 0;
	    }
	
	public boolean isUnlock()
	{
		return state == 1;
	    }

}
