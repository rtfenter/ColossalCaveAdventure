package edu.waketech.ccave.common;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

/**
 * 
 * Common interface for everything in the game.  Items such as Food and Keys are elements.
 * Rooms such as the well house are elements.
 * 
 * This is a minimal function of a cave element.  It will have an identifier, a long description
 * and a short description.  Many (most) elements will have other data or behaviors, but they will
 * be supported by the code unique to that item or room.
 * 
 * We exploit the Java 8 Interface enhancement of static methods that can have code supplied
 * in them.  
 * 
 * We will cover the Serializable interface later in the semester.  You can either remove it, or ignore it.
 * Leaving it will cause Warnings, and Java want a "serial version id" static final String.  Leaving the warning 
 * won't hurt anything.  Removing it will not require an inordinate amount of pain later.  Either decision is fine.
 * 
 * @author parks
 *
 */
public interface CCaveElement extends Serializable {

	public static final String RESOURCE_DIR = "resources/";
	public static final String LONG_DESCRIPTION = "longdescription";
	public static final String SHORT_DESCRIPTION = "shortdescription";

	/**
	 * Getter for a long description
	 * 
	 * @return the long description for &lt;whatever&gt;
	 */
	String getLongDescription();

	/**
	 * Getter for a short description
	 * 
	 * @return the short description for &lt;whatever&gt;
	 */
	String getShortDescription();

	/**
	 * Getter for "this" item's identifier
	 * 
	 * @return the identifier for this item
	 */
	String getId();

	/**
	 * Tests whether this element has the given id
	 * 
	 * @param identifier
	 *            identifier to compare to this element's id
	 * 
	 * @return true if the given identifier is equal to ignoring case this element's
	 *         id, false otherwise
	 */
	boolean isId(String identifier);

	/**
	 * Utility to create the properties for a given identifier of a cave element.
	 * 
	 * The properties from RESOUCE_DIR/identifier.properties file is read into a
	 * Properties object and returned.
	 * 
	 * @param id
	 *            identifier of a cave element.
	 * 
	 * @return properties from the properties file associated with identifier. This
	 *         Properties object will be empty if there is no such properties file.
	 */
	static Properties getPropertiesForId(String id) {

		Properties p = new Properties();
		FileInputStream fis = null;
		try {
			File f = new File(RESOURCE_DIR + id + ".properties");
			fis = new FileInputStream(f);
			p.load(fis);
		} catch (IOException e) {
			System.err.println("no prop file for " + id);
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
				}
			fis = null;
		}
		return p;
	}

}
