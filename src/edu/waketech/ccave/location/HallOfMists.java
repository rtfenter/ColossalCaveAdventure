////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     HallOfMists.java
//  
//  Name:     Rebecca Fenter
//  Email:    rtfenter@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////
package edu.waketech.ccave.location;

/**
 * Subclass for Hall Of Mists Room
 * 
 * @author Rebecca Fenter 
 *
 */
public class HallOfMists extends CCaveRoom
{
	public static final String MY_NAME = "hallofmists";


	public HallOfMists() {
		super(MY_NAME);
	}
	
	/**
	
	private int state = 0;
	
	public void AxeThrown()
	{
		state = 1;
	    }
	
	public void AxeNotThrown()
	{
		state = 0;
	    }
	
	public boolean isThrown()
	{
		return state == 1;
	    }
	
	@Override
	public String getLongDescription()
	{
		String desc = super.getLongDescription();
		desc = desc + "\nThe axe is being " + ((isThrown()) ? "thrown.": "not thrown.");
		return desc;
	}
	
	*/

}

