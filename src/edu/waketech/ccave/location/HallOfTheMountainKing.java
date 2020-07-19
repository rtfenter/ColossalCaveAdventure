////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     HallOfTheMountainKing.java
//  
//  Name:     Rebecca Fenter
//  Email:    rtfenter@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////
package edu.waketech.ccave.location;

import edu.waketech.ccave.common.Direction;
import edu.waketech.ccave.common.RoomDirectory;

/**
 * Subclass for Hall of the Mountain King Room
 * 
 * @author Rebecca Fenter 
 *
 */
public class HallOfTheMountainKing extends CCaveRoom
{

	public static final String MY_NAME = "hallofthemountainking";

	public HallOfTheMountainKing() {
		super(MY_NAME);
	}

	private boolean snakeInRoom = true; 

	public void chaseSnakeFromRoom() 
	{
		snakeInRoom = false; 
	}

	public boolean isSnakeInRoom() 
	{
		return snakeInRoom; 
	}

	@Override
	public CCaveRoom nextRoom(Direction dir)
	{
		CCaveRoom newRoom = super.nextRoom(dir);
		if (!(newRoom == RoomDirectory.getInstance().get("hallofmists")))
		{
			// make sure snake is gone
			if (snakeInRoom)
			{
				System.out.println("\nA large snake blocks you from going in that direction.");
				newRoom = this;
			}

		}
		return newRoom;
	}


}
