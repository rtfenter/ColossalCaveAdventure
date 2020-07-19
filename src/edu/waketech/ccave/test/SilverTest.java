////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     SilverTest.java
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
import edu.waketech.ccave.item.Silver;

public class SilverTest {
	
	/**
	 * Testing long description
	 */

	@Test
	public void testGetLongDescription() {
		CCaveItem cci = new Silver();
		assertEquals("There are pieces of silver strewn about the ground here.", cci.getLongDescription());
	}
	
	/**
	 * Testing short description
	 */

	@Test
	public void testGetShortDescription() {
		CCaveItem cci = new Silver();
		assertEquals("Silver ", cci.getShortDescription());
	}
	
	/**
	 * Testing ID
	 */

	@Test
	public void testGetId() {
		CCaveItem cci = new Silver();
		assertEquals("silver", cci.getId());
	}
	
	/**
	 * Testing location
	 */

	@Test
	public void testGetLocation() {
		CCaveItem cci = new Silver();
		assertEquals("chamberwithhole", cci.getLocation());
	}
	
	/**
	 * Testing ID- upper/lower case
	 */

	@Test
	public void testIsId0() {
		CCaveItem cci = new Silver();
		assertTrue(cci.isId("silveR"));
	}
	
	/**
	 * Testing ID- false 
	 */

	@Test
	public void testIsId1() {
		CCaveItem cci = new Silver();
		assertFalse(cci.isId("sophie"));
	}

}



