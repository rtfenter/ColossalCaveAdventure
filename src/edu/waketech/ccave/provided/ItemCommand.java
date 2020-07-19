package edu.waketech.ccave.provided;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * This enum lists the commands that can affect Cave items, such as FOOD or
 * WATERBOTTLE
 * 
 * @author parks
 *
 */

public enum ItemCommand {

	GET, DROP, EAT, DRINK, LOCK, UNLOCK, TURNON, TURNOFF, UNKNOWN, THROW, OPEN, SHUT, WAVE, UNWAVE;

	private static final String RESOURCE_DIR = "resources/";
	private static final String ITEM_COMMAND_FILE = "itemcommand";

	private static Map<String, ItemCommand> synonyms = new HashMap<>();

	/**
	 * This is an enum-wide friendly version of valueOf. It ignores case and also
	 * handles synonyms, making it NLS friendly.
	 * 
	 * @param key
	 *            String value identifying the enum value to return.
	 * 
	 * @return ItemCommand value associated with the given parameter, or
	 *         ItemCommand.UNKNOWN otherwise.
	 */
	public static ItemCommand findItemCommand(String key) {
		if (synonyms.isEmpty()) {
			readSynonyms();
		}
		for (ItemCommand r : ItemCommand.values()) {
			if (key.equalsIgnoreCase(r.toString()))
				return r;

			ItemCommand ic = ItemCommand.synonyms.get(key);
			if ((ic != null) && (ic != UNKNOWN))
				return ic;
		}

		return UNKNOWN;
	}

	private ItemCommand() {
	}

	private static void readSynonyms() {
		Properties p = new Properties();
		FileInputStream fis = null;
		try {
			File f = new File(RESOURCE_DIR + ITEM_COMMAND_FILE + ".properties");
			fis = new FileInputStream(f);
			p.load(fis);
			for (Object o : p.keySet()) {
				String syn = (String) o;
				String item = p.getProperty(syn);
				ItemCommand trueCmd = ItemCommand.valueOf(item);
				synonyms.put(syn, trueCmd);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) { }
		}
	}

	/**
	 * Returns the lower case String value of this enum value
	 * 
	 * @return this ItemCommand's value as a String in lower case.
	 */
	public String getId() {
		return this.toString().toLowerCase();
	}
}

