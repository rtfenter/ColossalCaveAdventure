////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     RoomDirectory.java
//  
//  Name:     Rebecca Fenter
//  Email:    rtfenter@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////
package edu.waketech.ccave.common;
import java.io.Serializable;
import java.util.ArrayList;

import edu.waketech.ccave.item.Axe;
import edu.waketech.ccave.item.CCaveItem;
import edu.waketech.ccave.item.Food;
import edu.waketech.ccave.item.Gold;
import edu.waketech.ccave.item.Keys;
import edu.waketech.ccave.item.Lamp;
import edu.waketech.ccave.item.Silver;
import edu.waketech.ccave.item.Water;
import edu.waketech.ccave.location.CCaveRoom;
import edu.waketech.ccave.location.Chamber;
import edu.waketech.ccave.location.ChamberWithHole;
import edu.waketech.ccave.location.CrystalBridge;
import edu.waketech.ccave.location.DebrisRoom;
import edu.waketech.ccave.location.EastSideChamber;
import edu.waketech.ccave.location.EndOfRoad;
import edu.waketech.ccave.location.Fissure;
import edu.waketech.ccave.location.Forest;
import edu.waketech.ccave.location.Grate;
import edu.waketech.ccave.location.HallOfMists;
import edu.waketech.ccave.location.HallOfTheMountainKing;
import edu.waketech.ccave.location.OrangeRiverChamber;
import edu.waketech.ccave.location.Pit;
import edu.waketech.ccave.location.SlitInRock;
import edu.waketech.ccave.location.SlopingRoom;
import edu.waketech.ccave.location.Spring;
import edu.waketech.ccave.location.WellHouse;
import edu.waketech.ccave.location.WestSideChamber;
import edu.waketech.ccave.location.Y2Room;


/**
 * Singleton that implements the Room identifier to Room object correspondence.
 * Singleton classes are constructed so that there will be at most one instance of them. 
 * Access to that one instance can be attained by means of a static method. This implementation uses "eager instantiation." 
 * Its object is created when the class is loaded by the JVM, and all calls to getInstance() 
 * return a reference to the one and only object.
 * References to this object must be acquired by
 * RoomDirectory roomDirec = RoomDirectory.getInstance(); 
 * 
 * @author Rebecca Fenter
 *
 */

public class RoomDirectory implements Serializable
{
	private ArrayList<CCaveRoom> caveRoom = new ArrayList<>();
	
	private static RoomDirectory instance = new RoomDirectory();
	
	/*
	 * Doing something clever with Class.forName would be better,
	 * but we're not covering the reflection API.
	 * 
	 * This isn't too, too wasteful.  The duplicate
	 * configuration information is the worst part.
	 */
	private final CCaveRoom[] ALL_ROOMS = {
			new WellHouse(), new Spring(), new EndOfRoad(), new SlitInRock(), new Forest(), new Pit(), new Grate(), new HallOfMists(), new Chamber(), 
			new OrangeRiverChamber(), new HallOfTheMountainKing(), new WestSideChamber(), new EastSideChamber(), new ChamberWithHole(), new Fissure(), new DebrisRoom(),
			new SlopingRoom(), new Y2Room(), new CrystalBridge(), 
			
	};

	private RoomDirectory() {
		for (CCaveRoom cci: ALL_ROOMS) {
			caveRoom.add(cci);
		}
	}
	/**
	 * Mechanism to access reference to this object
	 */
	
	public static RoomDirectory getInstance()
	{
		return instance; 
	}
	
	/**
	 * Utility method in case we know the identifier we're interested in, but don't have the entire Item object
	 */
	
	public boolean contains(String id)
	{
		for (CCaveRoom ele : caveRoom) 
		{
			if (ele.getId().equalsIgnoreCase(id))
				return true;
		}
		return false;
	}
	
	/**
	 * Utility method to find the location of an Item with a given identifier, ignoring case.
	 */
	
	public int indexOf(String id)
	{
		int i = 0;
		for (i = 0; i < caveRoom.size(); i++) 
		{
			if (caveRoom.get(i).getId().equalsIgnoreCase(id))
				return i;
		}
		return -1;
	}
	
	/**
	 * Utility method to remove the item with a given identifier, ignoring case.
	 */
	
	public boolean remove(String id)
	{
		int i = -1;
		boolean found = false;
		while (!found) 
		{
			i++;
			if (caveRoom.get(i).getId().equalsIgnoreCase(id))
				found = true;
		}
		if (i < caveRoom.size()) 
		{
			caveRoom.remove(i);
			return true;
		}
		return false;
	}
	
	/**
	 * Utility method to fetch the item with a given identifier, ignoring case.
	 */
	
	public CCaveRoom get(String id)
	{
		int i = indexOf(id);
		if (i == -1) return null;
		return caveRoom.get(i);
	}

}
