package edu.waketech.ccave.item;

import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.location.CCaveRoom;
import edu.waketech.ccave.provided.ItemCommand;
import edu.waketech.ccave.provided.Spelunker;

/**
 * See the executeCommand method for item-specfic behavior.
 * 
 * @author jparks
 *
 */
public class Food extends CCaveItem {

	public static final String MY_NAME = "food";

	public Food() {
		super(MY_NAME);
	}

	/**
	 * Eat the food, if that's what's commanded.  
	 * Food that's eaten simply disappears from the game.
	 */
	@Override
	public void executeCommand(ItemCommand cmd, String item, CCaveRoom currentLocation) {
		if (cmd == ItemCommand.EAT && (inLocation(currentLocation)) || inLocation(Spelunker.SPELUNKER_ID)) {
			// yes we can!
			ItemDirectory.getInstance().remove(this);

		} else {
			super.executeCommand(cmd, item, currentLocation);
		}
	}

}

