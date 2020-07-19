package edu.waketech.ccave.item;

import java.io.Serializable;
import java.util.Properties;

import edu.waketech.ccave.common.CCaveElement;
import edu.waketech.ccave.location.CCaveRoom;
import edu.waketech.ccave.provided.ItemCommand;

/**
 * Class from which all Items (such as Food, Keys, Snake) inherit.
 * This class provides generic, non-customized behavior for all items.
 * 
 * Creating a new Item involves
 * <ol>
 * <li>subclassing this class.  The name of the subclass (say it's "Dachshund") will
 * have an element id of "dachshund" which will be provided to this superclass via constructor
 * parameter
 * <li>dachshund.properties will be created in the resources directory.  longdescription,
 * shortdescription and location properties values will be defined.  The
 * location property must be the id of a Room.  Any properties unique to the Dachshund item 
 * must also be defined in this properties file.
 * <li>the line 
 * <br>
 * new Dachshund(),
 * <br>
 * must be added to the ItemDirectory class's ALL_ITEMS array
 * </ol>
 * 
 * @author parks
 *
 */

public abstract class CCaveItem implements CCaveElement, Serializable {

	public static final String ITEM_LOCATION = "location";

	private String identifier;   // this item's identifier
	private String currentLocation;  // Room identifier of this item's current location
	private Properties props;  // Properties from the item's properties file

	/**
	 * Constructor.  The subclass must provide an identifier
	 * for itself, but we store it and provide the getter.
	 * 
	 * This constructor also reads the subclass's properties file,
	 * fetches the initial location for the item from the properties
	 * file.
	 * 
	 * @param itemIdentifier subclass's identifier
	 */
	public CCaveItem(String itemIdentifier) {
		identifier = itemIdentifier;
		props = CCaveElement.getPropertiesForId(identifier);
		currentLocation = props.getProperty(ITEM_LOCATION);
	}

	/**
	 * Getter
	 * @return Room this item is currently located in
	 */
	public String getLocation() {
		return currentLocation;
	}

	/**
	 * Setter to change this item's Room
	 * 
	 * @param newLocation identifier of the Room this item will move to
	 */
	public void setLocation(String newLocation) {
		currentLocation = newLocation;
	}

	/**
	 * Test whether this item is in a given Room
	 * 
	 * @param possibleLocation Room identifier 
	 * 
	 * @return true if this item is in the specified Room, false otherwise
	 */
	public boolean inLocation(String possibleLocation) {
		return currentLocation.equalsIgnoreCase(possibleLocation);
	}

	/**
	 * Test whether this item is in a given Room
	 * 
	 * @param possibleLocation the Room (the object, not the identifier) that is the possible location 
	 * of this item
	 * 
	 * @return true if this item is in the specified Room, false otherwise
	 */
	public boolean inLocation(CCaveRoom possibleLocation) {
		if (possibleLocation == null)
			return false;
		return currentLocation.equalsIgnoreCase(possibleLocation.getId());
	}

	/**
	 * Some items have specific commands, such as "eat food" or "lamp on."  This
	 * is the default behavior for item-specific capabilities, which is to do nothing.
	 * 
	 * @param cmd the command the item is to carry out, if possible
	 * 
	 * @param item the item identifier that is the target of the command.  Sometimes
	 * a command might be given for some item other than "us."
	 * 
	 * @param currentLocation the Room identifier that our player currently inhabits.
	 */
	public void executeCommand(ItemCommand cmd, String item, CCaveRoom currentLocation) {
	}

	@Override
	public String getLongDescription() {
		return props.getProperty(CCaveElement.LONG_DESCRIPTION);
	}

	@Override
	public String getShortDescription() {
		return props.getProperty(CCaveElement.SHORT_DESCRIPTION);
	}

	@Override
	public String getId() {
		return identifier;
	}

	@Override
	public boolean isId(String identifier) {
		return this.identifier.equalsIgnoreCase(identifier);
	}

	@Override
	public String toString() {
		return "CCaveItem [identifier=" + identifier + ", currentLocation=" + currentLocation + ", props=" + props
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		return result;
	}

	/**
	 * Equality is based on element identifier
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CCaveItem other = (CCaveItem) obj;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		return true;
	}

}
