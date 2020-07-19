////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     CoinsTest.java
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

import edu.waketech.ccave.item.CCaveItem;
import edu.waketech.ccave.item.Coins;

public class CoinsTest {
	
	/**
	 * Testing long description
	 */

	@Test
	public void testGetLongDescription() {
		CCaveItem cci = new Coins();
		assertEquals("There are coins piled up here.", cci.getLongDescription());
	}
	
	/**
	 * Testing short description
	 */

	@Test
	public void testGetShortDescription() {
		CCaveItem cci = new Coins();
		assertEquals("Coins", cci.getShortDescription());
	}
	
	/**
	 * Testing ID
	 */

	@Test
	public void testGetId() {
		CCaveItem cci = new Coins();
		assertEquals("coins", cci.getId());
	}
	
	/**
	 * Testing location
	 */

	@Test
	public void testGetLocation() {
		CCaveItem cci = new Coins();
		assertEquals("westsidechamber", cci.getLocation());
	}
	
	/**
	 * Testing ID- upper/lower case
	 */

	@Test
	public void testIsId0() {
		CCaveItem cci = new Coins();
		assertTrue(cci.isId("cOins"));
	}
	
	/**
	 * Testing ID- false 
	 */

	@Test
	public void testIsId1() {
		CCaveItem cci = new Coins();
		assertFalse(cci.isId("sophie"));
	}

}


