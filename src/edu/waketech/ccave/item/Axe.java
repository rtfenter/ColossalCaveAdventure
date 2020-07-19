////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     Axe.java
//  
//  Name:     Rebecca Fenter
//  Email:    rtfenter@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////
package edu.waketech.ccave.item;

import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.common.RoomDirectory;
import edu.waketech.ccave.location.CCaveRoom;
import edu.waketech.ccave.location.Grate;
import edu.waketech.ccave.location.HallOfMists;
import edu.waketech.ccave.location.HallOfTheMountainKing;
import edu.waketech.ccave.location.Y2Room;
import edu.waketech.ccave.provided.ItemCommand;
import edu.waketech.ccave.provided.Spelunker;

/**
 * Subclass for Axe item
 * 
 * Can be picked up/dropped off
 * 
 * Can be thrown or not thrown
 * 
 * @author Rebecca Fenter
 *
 */
public class Axe extends CCaveItem {

	public static final String MY_NAME = "axe";
	
	private int state = 0;
	
	public Axe() {
		super(MY_NAME);
	}
	
	@Override
	public void executeCommand(ItemCommand cmd, String item, CCaveRoom currentLocation)
	{
	   if (cmd != ItemCommand.THROW)
	   {
	      super.executeCommand(cmd, item, currentLocation);
	      return;
	   }
	   Axe axe = (Axe) ItemDirectory.getInstance().get("axe");


	   if (!axe.inLocation(Spelunker.SPELUNKER_ID))
	   {
	      System.out.println("You need an axe to throw at the dwarf.\n");
	   }
	   else
	   {
	      System.out.println("You can throw your axe at the dwarf.\n");
	      if (cmd == ItemCommand.THROW)
	      {
	         axe.setLocation(currentLocation.getId());

	         if (currentLocation.isId("y2room"))
	         {
	            Y2Room y2room = (Y2Room) currentLocation;
	            if (y2room.isDwarfInRoom())
	            {
	               System.out.println("You killed the dwarf.");
	               y2room.throwAxeAtDwarf();
	            }
	         }
	      }
	   }
	}
  
  public void AxeThrown()
	{
	state = 1;
	    }
	    public void AxeNotThrown()
	    {
	    state = 0;
	    }
	    public boolean isThrown()
	    {
	    return state == 1;
	    }
	   }
