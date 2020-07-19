////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     AxeTest.java
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
import edu.waketech.ccave.item.Axe;



public class AxeTest {

	/**
	 * Testing long description
	 */
	
	@Test
	public void testGetLongDescription() {
		CCaveItem cci = new Axe();
		assertEquals("There is a discarded sharpened axe lying here on the forest floor.", cci.getLongDescription());
	}
	
	/**
	 * Testing short description
	 */

	@Test
	public void testGetShortDescription() {
		CCaveItem cci = new Axe();
		assertEquals("Sharpened axe", cci.getShortDescription());
	}
	
	/**
	 * Testing ID
	 */

	@Test
	public void testGetId() {
		CCaveItem cci = new Axe();
		assertEquals("axe", cci.getId());
	}
	
	/**
	 * Testing location
	 */

	@Test
	public void testGetLocation() {
		CCaveItem cci = new Axe();
		assertEquals("forest", cci.getLocation());
	}
	
	/**
	 * Testing ID with upper/lower case
	 */

	@Test
	public void testIsId0() {
		CCaveItem cci = new Axe();
		assertTrue(cci.isId("AxE"));
	}

	/**
	 * Testing ID is false
	 */
	
	@Test
	public void testIsId1() {
		CCaveItem cci = new Axe();
		assertFalse(cci.isId("sophie"));
	}
	
	/**
	 * Testing axe is thrown
	 */
	
	
	 @Test
	 public void testAxeThrown() {
		 Axe l = new Axe();
		 l.AxeThrown();
		 assertTrue(l.isThrown());
		 }
	 
	 /**
		 * Testing axe is not thrown- false 
		 */
	 
	 @Test
	 public void testAxeNotThrown() {
		 Axe l = new Axe();
		 l.AxeNotThrown();
		 assertFalse(l.isThrown());
	    }
}


