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

/**
 * Testing all aspects of our class
 */
package edu.waketech.ccave.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.waketech.ccave.location.CCaveRoom;
import edu.waketech.ccave.location.HallOfTheMountainKing;


public class HallOfTheMountainKingTest {
	
	/**
	 * Testing long description
	 */

	@Test
	public void testGetLongDescription() {
		CCaveRoom cci = new HallOfTheMountainKing();
		assertEquals("You are in an eerie hallway with something that seems to be slithering your way. ", cci.getLongDescription());
	}
	
	/**
	 * Testing short description
	 */

	@Test
	public void testGetShortDescription() {
		CCaveRoom cci = new HallOfTheMountainKing();
		assertEquals("You are in an eerie hallway with something that seems to be slithering your way. ", cci.getShortDescription());
	}
	
	/**
	 * Testing ID
	 */

	@Test
	public void testGetId() {
		CCaveRoom cci = new HallOfTheMountainKing();
		assertEquals("hallofthemountainking", cci.getId());
	}
	
	
	/**
	 * Testing ID- upper/lower case
	 */

	@Test
	public void testIsId0() {
		CCaveRoom cci = new HallOfTheMountainKing();
		assertTrue(cci.isId("haLLofTHEMountAINKing"));
	}
	
	/**
	 * Testing ID- false 
	 */

	@Test
	public void testIsId1() {
		CCaveRoom cci = new HallOfTheMountainKing();
		assertFalse(cci.isId("sophie"));
	}

}






