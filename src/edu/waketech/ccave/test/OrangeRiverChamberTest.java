////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     OrangeRiverChamber.java
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
import edu.waketech.ccave.location.OrangeRiverChamber;


public class OrangeRiverChamberTest {
	
	/**
	 * Testing long description
	 */

	@Test
	public void testGetLongDescription() {
		CCaveRoom cci = new OrangeRiverChamber();
		assertEquals("You are in a dusty chamber. I think I hear a bird. ", cci.getLongDescription());
	}
	
	/**
	 * Testing short description
	 */

	@Test
	public void testGetShortDescription() {
		CCaveRoom cci = new OrangeRiverChamber();
		assertEquals("You are in a dusty chamber. ", cci.getShortDescription());
	}
	
	/**
	 * Testing ID
	 */

	@Test
	public void testGetId() {
		CCaveRoom cci = new OrangeRiverChamber();
		assertEquals("orangeriverchamber", cci.getId());
	}
	
	
	/**
	 * Testing ID- upper/lower case
	 */

	@Test
	public void testIsId0() {
		CCaveRoom cci = new OrangeRiverChamber();
		assertTrue(cci.isId("oRANGEriverChamBER"));
	}
	
	/**
	 * Testing ID- false 
	 */

	@Test
	public void testIsId1() {
		CCaveRoom cci = new OrangeRiverChamber();
		assertFalse(cci.isId("sophie"));
	}

}







