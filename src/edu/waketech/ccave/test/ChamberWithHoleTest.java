////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     ChamberWithHoleTest.java
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
import edu.waketech.ccave.location.ChamberWithHole;


public class ChamberWithHoleTest {
	
	/**
	 * Testing long description
	 */

	@Test
	public void testGetLongDescription() {
		CCaveRoom cci = new ChamberWithHole();
		assertEquals("You are in a rounded chamber where there seems to be another room you can enter.", cci.getLongDescription());
	}
	
	/**
	 * Testing short description
	 */

	@Test
	public void testGetShortDescription() {
		CCaveRoom cci = new ChamberWithHole();
		assertEquals("You are in a rounded chamber where there seems to be another room you can enter.", cci.getShortDescription());
	}
	
	/**
	 * Testing ID
	 */

	@Test
	public void testGetId() {
		CCaveRoom cci = new ChamberWithHole();
		assertEquals("chamberwithhole", cci.getId());
	}
	
	
	/**
	 * Testing ID- upper/lower case
	 */

	@Test
	public void testIsId0() {
		CCaveRoom cci = new ChamberWithHole();
		assertTrue(cci.isId("chambERwithHOLE"));
	}
	
	/**
	 * Testing ID- false 
	 */

	@Test
	public void testIsId1() {
		CCaveRoom cci = new ChamberWithHole();
		assertFalse(cci.isId("sophie"));
	}

}


