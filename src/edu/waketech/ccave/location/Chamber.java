////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     Chamber.java
//  
//  Name:     Rebecca Fenter
//  Email:    rtfenter@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////
package edu.waketech.ccave.location;

import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.item.CCaveItem;
import edu.waketech.ccave.item.Lamp;
import edu.waketech.ccave.provided.Spelunker;

import java.util.ArrayList;

/**
 * Subclass for Chamber Room
 * 
 * @author Rebecca Fenter 
 *
 */
public class Chamber extends CCaveRoom
{
	public static final String MY_NAME = "chamber";

	public Chamber() {
		super(MY_NAME);
	}

	@Override
	public String getLongDescription()
	{
		Lamp lamp = (Lamp) ItemDirectory.getInstance().get("lamp");
		if (lamp.isOn() && lamp.inLocation(Spelunker.SPELUNKER_ID))
		{
			String desc = "You are in the middle of a room, lit up by your lantern.";
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
		Lamp lamp = (Lamp) ItemDirectory.getInstance().get("lamp");
		if (lamp.isOn() && lamp.inLocation(Spelunker.SPELUNKER_ID))
		{
			return super.getContentsLongDescription();
		}
		else
		{
			return "Too dark to see what is in this room.\n";
		}

	}


}
