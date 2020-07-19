////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCaveProject0
//  File:     CCaveRoom.java
//  
//  Name:     Rebecca Fenter
//  Email:    rtfenter@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////
package edu.waketech.ccave.location;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Properties; 
import edu.waketech.ccave.common.CCaveElement;
import edu.waketech.ccave.common.Direction;
import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.common.RoomDirectory;
import edu.waketech.ccave.item.CCaveItem;

/**
 * Class from which all Items (such as WellHouse, Spring, Forest) inherit.
 * This class provides generic, non-customized behavior for all rooms.
 * 
 * @author Rebecca Fenter
 *
 */
public abstract class CCaveRoom implements CCaveElement, Serializable 
{
	public static final String ROOM_LOCATION = "location";

	private String identifier;   // this room's identifier
	private String currentLocation;  // Room identifier of this item's current location
	private Properties props;  // Properties from the room's properties file
	
	/**
	 * Constructor that is given the Room's identifier by the subclass, 
	 * reads and and holds the room's properties.
	 */
	
	public CCaveRoom(String roomIdentifier)
	{
		identifier = roomIdentifier;
		props = CCaveElement.getPropertiesForId(identifier);
		currentLocation = props.getProperty(ROOM_LOCATION);
	}
	
	/**
	 * Accessor to figure out what room lies in a given direction. This is always from our own perspective.
	 * Our solution to implementing room connectivity is really simple. When nextRoom is called, 
	 * we scan our properties file looking for keys that are synonyms of the Direction parameter. 
	 * If we find such a key, we use its value to look up the associated CCaveRoom object in the RoomDirectory.
	 *  We return that object.
	 *  If the direction parameter does not specify a valid direction to move out of this room, 
	 *  we stay were we are by returning ourselves (i.e., this) as the "next room."
	 */
	
	public CCaveRoom nextRoom(Direction dir)
	{
		for (Object o: props.keySet())
		{
			String k = (String) o;
			// System.out.println(Direction.findSynonym(k));
			if (Direction.findSynonym(k) == dir)
			{
				// System.out.println("We can go in that direction.");
				// get the property value which should be the name of a CCaveRoom
				String v = props.getProperty(k);
				System.out.println("Moving to " + v);
				if (RoomDirectory.getInstance().contains(v))
				{
					return RoomDirectory.getInstance().get(v);
				}
				else
				{
					System.out.println("Room " + v + " not in Room directory");
				}
			}
		}

		System.out.println("You can not go in that direction.");
		return this;
	
	}
	
	/**
	 * Accessor for properties file
	 */
	
	public Properties getProps()
	{
		 return props;
	}
	
	/**
	 * Accessor for the items currently in this room
	 */
	
	public ArrayList<CCaveItem> getRoomItems()
	{
		return new ArrayList<>(); 
	}
	
	/**
	 * Getter for a long description
	 */
	
	@Override
	public String getLongDescription() 
	{
		return props.getProperty(CCaveElement.LONG_DESCRIPTION);
	}
	
	/**
	 * Getter for a short description
	 */
	
	@Override
	public String getShortDescription() 
	{
		return props.getProperty(CCaveElement.SHORT_DESCRIPTION);
	}
	
	/**
	 * Getter for "this" item's identifier
	 */
	
	@Override
	public String getId() 
	{
		return identifier;
	}
	
	/**
	 * Tests whether this element has the given id
	 */
	
	@Override
	public boolean isId(String identifier) 
	{
		return this.identifier.equalsIgnoreCase(identifier);
	}
	
	/**
	 * Accessor for the long description of this room and the long description for each of its items
	 */

	public String getContentsLongDescription()
	{
		StringBuilder roomItems = new StringBuilder();
		for (CCaveItem ele : ItemDirectory.getInstance().getItemsInRoom(this.getId())) {
			roomItems.append(ele.getLongDescription());
			roomItems.append("\n");
		}

		return roomItems.toString(); 
	}
	
	/**
	 * Accessor for the short description of this room and the short description for each of its items
	 */
	
	public String getContentsShortDescription()
	{
		return getShortDescription(); 
	}
	
	/**
	 * String representation of our room's info 
	 */
	
	@Override
	public String toString() 
	{
		return "CCaveRoom [identifier=" + identifier + ", currentLocation=" + currentLocation + ", props=" + props
				+ "]";
	}
}
