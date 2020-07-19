////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     Cage.java
//  
//  Name:     Rebecca Fenter
//  Email:    rtfenter@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////
package edu.waketech.ccave.item;

import edu.waketech.ccave.common.CCaveElement;
import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.common.RoomDirectory;
import edu.waketech.ccave.location.CCaveRoom;
import edu.waketech.ccave.location.HallOfTheMountainKing;
import edu.waketech.ccave.provided.ItemCommand;

/**
 * Subclass for Cage item
 * 
 * Can be picked up/dropped off
 * 
 * Can be open or shut
 * 
 * @author Rebecca Fenter
 *
 */
public class Cage extends CCaveItem
{

    public static final String MY_NAME = "cage";

    private int state = 0;
    private boolean birdInCage = false;

    public Cage()
    {
        super(MY_NAME);

    }

    public void CageOpen() { state = 1; }

    public void addBird()   { birdInCage = true; }
    public void freeBird()  { birdInCage = false; }
    public boolean hasBird() { return birdInCage; }

    public void CageShut()
    {
        state = 0;
    }

    public boolean isOpen()
    {
        return state == 1;
    }

    @Override
    public String getShortDescription() {

        String desc = super.getShortDescription();
        if (birdInCage)
        {
            desc = desc + " with bird ";
        }
        return desc;
    }

    @Override
    public void executeCommand(ItemCommand cmd, String item, CCaveRoom currentLocation)
    {
        Bird bird = (Bird) ItemDirectory.getInstance().get("bird");

        HallOfTheMountainKing mountainKingRoom = (HallOfTheMountainKing) RoomDirectory.getInstance().get("hallofthemountainking");

        if (cmd == ItemCommand.OPEN)
        {
            CageOpen();
            if (birdInCage)
            {
                freeBird();
                bird.setLocation(currentLocation.getId());

                if (currentLocation == mountainKingRoom)
                {
                    if (mountainKingRoom.isSnakeInRoom())
                    {
                        System.out.println("The bird chased the snake away.");
                        mountainKingRoom.chaseSnakeFromRoom();
                    }
                }
            }
        }
        else if (cmd == ItemCommand.SHUT)
        {
            CageShut();
        }
        else
        {
            super.executeCommand(cmd, item, currentLocation);
        }
    }

}

