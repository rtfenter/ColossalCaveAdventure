////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     Y2Room.java
//  
//  Name:     Rebecca Fenter
//  Email:    rtfenter@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////
package edu.waketech.ccave.location;

import edu.waketech.ccave.common.Direction;
import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.common.RoomDirectory;
import edu.waketech.ccave.item.Axe;
import edu.waketech.ccave.item.Lamp;
import edu.waketech.ccave.provided.Spelunker;

/**
 * Subclass for Y2 Room
 * 
 * @author Rebecca Fenter 
 *
 */
public class Y2Room extends CCaveRoom
{
	public static final String MY_NAME = "y2room";

	public Y2Room() {
		super(MY_NAME);
	}

	private boolean dwarfInRoom = true; 

	public void throwAxeAtDwarf() 
	{
		dwarfInRoom = false; 
	}

	public boolean isDwarfInRoom() 
	{
		return dwarfInRoom; 
	}
	
	 @Override
	   public String getLongDescription()
	   {
	      Axe axe = (Axe) ItemDirectory.getInstance().get("axe");
	      String desc = super.getLongDescription();

	      if (dwarfInRoom)
	      {
	         System.out.println("\nA nasty dwarf is coming right for you!\n");
	         if(axe.inLocation(Spelunker.SPELUNKER_ID))
	         {
	            System.out.println("You should probably throw your axe at it.");
	         }
	         else
	         {
	            System.out.println("Too bad you don't have an axe to throw at it :(");
	         }
	      }

	      return desc;
	   }


	/**

	@Override
	public CCaveRoom nextRoom(Direction dir)
	{
		CCaveRoom newRoom = super.nextRoom(dir);
		if (!(newRoom == RoomDirectory.getInstance().get("chamberwithhole")))
		{
			// make sure dwarf is gone
			if (dwarfInRoom)
			{
				System.out.println("\nA nasty dwarf is coming right for you! You should probably throw your axe at it.");
				newRoom = this;
			}

		}
		return newRoom;
	}
	*/
	


}
