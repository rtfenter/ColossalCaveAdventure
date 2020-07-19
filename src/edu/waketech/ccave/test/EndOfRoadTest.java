////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     EndOfRoadTest.java
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
import edu.waketech.ccave.location.EndOfRoad;


public class EndOfRoadTest {
	
	/**
	 * Testing long description
	 */

	@Test
	public void testGetLongDescription() {
		CCaveRoom cci = new EndOfRoad();
		assertEquals("You are at a road. It looks as if you should turn back. ", cci.getLongDescription());
	}
	
	/**
	 * Testing short description
	 */

	@Test
	public void testGetShortDescription() {
		CCaveRoom cci = new EndOfRoad();
		assertEquals("You are at a road. ", cci.getShortDescription());
	}
	
	/**
	 * Testing ID
	 */

	@Test
	public void testGetId() {
		CCaveRoom cci = new EndOfRoad();
		assertEquals("endofroad", cci.getId());
	}
	
	
	/**
	 * Testing ID- upper/lower case
	 */

	@Test
	public void testIsId0() {
		CCaveRoom cci = new EndOfRoad();
		assertTrue(cci.isId("endOFRoad"));
	}
	
	/**
	 * Testing ID- false 
	 */

	@Test
	public void testIsId1() {
		CCaveRoom cci = new EndOfRoad();
		assertFalse(cci.isId("sophie"));
	}

}



