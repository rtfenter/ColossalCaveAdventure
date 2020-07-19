////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     CageTest.java
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
import edu.waketech.ccave.item.Cage;

public class CageTest {
	
	/**
	 * Testing long description
	 */

	@Test
	public void testGetLongDescription() {
		CCaveItem cci = new Cage();
		assertEquals("There is an abandoned bird cage here.", cci.getLongDescription());
	}
	
	/**
	 * Testing short description
	 */

	@Test
	public void testGetShortDescription() {
		CCaveItem cci = new Cage();
		assertEquals("Bird Cage", cci.getShortDescription());
	}
	
	/**
	 * Testing ID
	 */

	@Test
	public void testGetId() {
		CCaveItem cci = new Cage();
		assertEquals("cage", cci.getId());
	}
	
	/**
	 * Testing location
	 */

	@Test
	public void testGetLocation() {
		CCaveItem cci = new Cage();
		assertEquals("chamber", cci.getLocation());
	}
	
	/**
	 * Testing ID- upper/lower case
	 */

	@Test
	public void testIsId0() {
		CCaveItem cci = new Cage();
		assertTrue(cci.isId("CAge"));
	}
	
	/**
	 * Testing ID- false 
	 */

	@Test
	public void testIsId1() {
		CCaveItem cci = new Cage();
		assertFalse(cci.isId("sophie"));
	}
	
	/**
	 * Testing cage is open
	 */
	
	 @Test
	 public void testCageOpen() {
		 Cage l = new Cage();
		 l.CageOpen();
		 assertTrue(l.isOpen());
		 }
	 
	 /**
		 * Testing cage is shut- false
		 */
	 
	 @Test
	 public void testCageShut() {
		 Cage l = new Cage();
		 l.CageShut();
		 assertFalse(l.isOpen());
	    }
}


