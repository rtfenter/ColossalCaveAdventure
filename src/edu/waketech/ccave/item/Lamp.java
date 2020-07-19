////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC251
// 
//  Project:  ColossalCave
//  File:     Lamp.java
//  
//  Name:     Rebecca Fenter
//  Email:    rtfenter@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////
package edu.waketech.ccave.item;

import edu.waketech.ccave.location.CCaveRoom;
import edu.waketech.ccave.provided.ItemCommand;

/**
 * Subclass for Lamp item
 * 
 * Can be picked up/dropped off
 * 
 * Can be on or off
 * 
 * @author Rebecca Fenter
 *
 */
public class Lamp extends CCaveItem
{

    public static final String MY_NAME = "lamp";

    private int state = 0;

    public Lamp()
    {
        super(MY_NAME);

    }

    public void LampOn()
    {
        state = 1;
    }

    public void LampOff()
    {
        state = 0;
    }

    public boolean isOn()
    {
        return state == 1;
    }

    @Override
    public void executeCommand(ItemCommand cmd, String item, CCaveRoom currentLocation)
    {
        if (cmd == ItemCommand.TURNON)
        {
            LampOn();
        }
        else if (cmd == ItemCommand.TURNOFF)
        {
            LampOff();
        }
        else
        {
            super.executeCommand(cmd, item, currentLocation);
        }
    }

}
