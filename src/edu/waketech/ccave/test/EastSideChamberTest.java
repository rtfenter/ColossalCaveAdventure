////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     EastSideChamberTest.java
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
import edu.waketech.ccave.location.EastSideChamber;


public class EastSideChamberTest {
	
	/**
	 * Testing long description
	 */

	@Test
	public void testGetLongDescription() {
		CCaveRoom cci = new EastSideChamber();
		assertEquals("You are in a rounded chamber with no other exits. ", cci.getLongDescription());
	}
	
	/**
	 * Testing short description
	 */

	@Test
	public void testGetShortDescription() {
		CCaveRoom cci = new EastSideChamber();
		assertEquals("You are in a rounded chamber with no other exits. ", cci.getShortDescription());
	}
	
	/**
	 * Testing ID
	 */

	@Test
	public void testGetId() {
		CCaveRoom cci = new EastSideChamber();
		assertEquals("eastsidechamber", cci.getId());
	}
	
	
	/**
	 * Testing ID- upper/lower case
	 */

	@Test
	public void testIsId0() {
		CCaveRoom cci = new EastSideChamber();
		assertTrue(cci.isId("EAStsiDEChamBER"));
	}
	
	/**
	 * Testing ID- false 
	 */

	@Test
	public void testIsId1() {
		CCaveRoom cci = new EastSideChamber();
		assertFalse(cci.isId("sophie"));
	}

}



