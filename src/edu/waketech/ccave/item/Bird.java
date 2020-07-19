////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 151 Spring 2014
//  Section:  (your section number)
//
//  Project:  ColossalCaveProject0
//  File:     Gold.java
//
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
////////////////////////////////////////////////////////////////////////////////
package edu.waketech.ccave.item;

import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.common.RoomDirectory;
import edu.waketech.ccave.location.CCaveRoom;
import edu.waketech.ccave.location.Grate;
import edu.waketech.ccave.provided.ItemCommand;
import edu.waketech.ccave.provided.Spelunker;

/**
 * Subclass for Gold item
 * Can be picked up/dropped
 *
 * @author Rebecca Fenter
 *
 */
public class Bird extends CCaveItem
{
    public static final String MY_NAME = "bird";

    public Bird()
    {
        super(MY_NAME);
    }

    @Override
    public String getShortDescription() {

        return "";
    }

    @Override
    public void executeCommand(ItemCommand cmd, String item, CCaveRoom currentLocation)
    {
        Cage cage = (Cage) ItemDirectory.getInstance().get("cage");
        Bird bird = (Bird) ItemDirectory.getInstance().get("bird");
        Rod rod = (Rod) ItemDirectory.getInstance().get("rod"); 
        
        if(rod.inLocation(Spelunker.SPELUNKER_ID))
        {
        	System.out.println("The bird is afraid of the rod.\n");
        }
        else
        {
        	if (!cage.inLocation(Spelunker.SPELUNKER_ID))
        	{
        		System.out.println("You need a cage to get the bird.\n");
        		}
        	else
        	{
        		if (cmd == ItemCommand.GET)
        		{
        			cage.addBird();
        			bird.setLocation(Spelunker.SPELUNKER_ID);
        			}
        		if (cmd == ItemCommand.DROP)
        		{
        			bird.setLocation(currentLocation.getId());
        			cage.freeBird();
        			}
        		}
        	}
    }
}
