package edu.waketech.ccave.common;

import java.io.Serializable;
import java.util.ArrayList;

import edu.waketech.ccave.item.Axe;
import edu.waketech.ccave.item.Bird;
import edu.waketech.ccave.item.CCaveItem;
import edu.waketech.ccave.item.Cage;
import edu.waketech.ccave.item.Coins;
import edu.waketech.ccave.item.Diamonds;
import edu.waketech.ccave.item.Food;
import edu.waketech.ccave.item.Gold;
import edu.waketech.ccave.item.Jewels;
import edu.waketech.ccave.item.Keys;
import edu.waketech.ccave.item.Lamp;
import edu.waketech.ccave.item.Rod;
import edu.waketech.ccave.item.Silver;
import edu.waketech.ccave.item.Water;

/**
 * Singleton that maintains the "item identifier" to "item object" mapping.
 * <p>
 * Singleton classes are constructed so that there will be at most one instance
 * of them. This class uses an eager implementation.
 * </p>
 * <p>References to this object must be acquired by
 * <br>
 * ItemDirectory itemDirec = ItemDirectory.getInstance();
 * 
 * @author parks
 *
 */
public class ItemDirectory implements Serializable{
	
	private ArrayList<CCaveItem> caveItem = new ArrayList<>();
	
	private static ItemDirectory instance = new ItemDirectory();
	
	/*
	 * Doing something clever with Class.forName would be better,
	 * but we're not covering the reflection API.
	 * 
	 * This isn't too, too wasteful.  The duplicate
	 * configuration information is the worst part.
	 */
	private final CCaveItem[] ALL_ITEMS = {
			new Food(), new Water(), new Keys(), new Lamp(), new Silver(), new Gold(), new Axe(), new Cage(), new Bird(), new Coins(), new Jewels(), 
			new Rod(), new Diamonds() 
	};

	private ItemDirectory() {
		for (CCaveItem cci: ALL_ITEMS) {
			caveItem.add(cci);
		}
	}
	
	/**
	 * Static method to provide access to this singleton's object reference.
	 * 
	 * @return reference to ItemDirectory object
	 */
	public static ItemDirectory getInstance() {
		return instance;
	}
	
	/**
	 * Add a new element to the Directory
	 * 
	 * @param itemToAdd will be added to the Item Directory
	 * 
	 * @return true if the Directory was modified as a result of the call,
	 * false otherwise.
	 */
	public boolean add(CCaveItem itemToAdd) {
		return caveItem.add(itemToAdd);
	}
	
	/**
	 * The number of items in the directory
	 * 
	 * @return the number of items currently in the directory
	 */
	public int size() {
		return caveItem.size();
	}
	
	/**
	 * Accessor to retrieve a reference to the given element of the Directory.
	 * CCaveItem objects are numbered in the same order that they were received.
	 * 
	 * @param indexToRetrieve index (0 origin) of the CCaveItem to retrieve.
	 * 
	 * @return the item at the specified position in the Directory, or null if
	 * no such item exists.
	 */
	public CCaveItem get(int indexToRetrieve) {
		return caveItem.get(indexToRetrieve);
	}
	
	/**
	 * Remove an item from the Directory.
	 * 
	 * @param itemToRemove the item to remove will satisfy the equals relationship
	 * 
	 * @return true if the directory was modified as a result of this method call, false otherwise.
	 */
	public boolean remove(CCaveItem itemToRemove) {
		return caveItem.remove(itemToRemove);
	}
	
	/**
	 * Clear the entire directory.  After this call, the Directory will contain no elements.
	 */
	public void clear() {
		caveItem.clear();
	}

	/**
	 * Utility method in case we know the identifier we're interested in, but don't
	 * need an Item reference.
	 * 
	 * 
	 * 
	 * @param id
	 *            of the item we wish to verify is or is not in the directory,
	 *            ignoring case
	 * 
	 * @return true if an Item is in the Directory with the given id, false
	 *         otherwise
	 */
	public boolean contains(String id) {
		for (CCaveItem ele : caveItem) {
			if (ele.getId().equalsIgnoreCase(id))
				return true;
		}
		return false;
	}

	/**
	 * Utility method to find the location of an Item with a given identifier,
	 * ignoring case.
	 * 
	 * @param id
	 *            identifier whose associated Item we wish to find, ignoring case
	 * 
	 * @return the location within the List of the item with the associated id, or
	 *         -1 if no such item exists.
	 */
	public int indexOf(String id) {
		int i = 0;
		for (i = 0; i < caveItem.size(); i++) {
			if (caveItem.get(i).getId().equalsIgnoreCase(id))
				return i;
		}
		return -1;
	}

	/**
	 * 
	 * Utility method to remove the item with a given identifier,
	 * ignoring case.
	 * 
	 * @param id
	 *            identifier whose associated Item we wish to remove, ignoring case
	 * 
	 * 
	 * @return true if an item was removed from the Directory, false otherwise
	 */
	public boolean remove(String id) {
		int i = -1;
		boolean found = false;
		while (!found) {
			i++;
			if (caveItem.get(i).getId().equalsIgnoreCase(id))
				found = true;
		}
		if (i < caveItem.size()) {
			caveItem.remove(i);
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * Utility method to fetch the item with a given identifier,
	 * ignoring case.
	 * 
	 * @param id
	 *            identifier whose associated Item we wish to fetch, ignoring case
	 * 
	 * 
	 * @return item in the Directory with the given identifier, null if no such item exists
	 */
	public CCaveItem get(String id) {
		int i = indexOf(id);
		if (i == -1) return null;
		return caveItem.get(i);
	}
	
	/**
	 * Return all of the items currently in a given room.
	 * 
	 * @param roomId the identifier of the room whose items we wish to return
	 * 
	 * @return List of items in the given room.  The List will be empty if there are no such items.
	 */
	public ArrayList<CCaveItem> getItemsInRoom(String roomId) {
		ArrayList<CCaveItem> roomItems = new ArrayList<>();
		for (CCaveItem ele: caveItem) {
			if (ele.getLocation().equalsIgnoreCase(roomId)) roomItems.add(ele);
		}
		return roomItems;
	}
	
	public CCaveItem[] getAllItems() {
		return ALL_ITEMS;
	}

}

