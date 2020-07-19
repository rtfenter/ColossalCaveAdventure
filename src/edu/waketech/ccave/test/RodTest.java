////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     RodTest.java
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
import edu.waketech.ccave.item.Lamp;
import edu.waketech.ccave.item.Rod;

public class RodTest {
	
	/**
	 * Testing long description
	 */

	@Test
	public void testGetLongDescription() {
		CCaveItem cci = new Rod();
		assertEquals("There is a rod. I think it may be a wand.", cci.getLongDescription());
	}
	
	/**
	 * Testing short description
	 */

	@Test
	public void testGetShortDescription() {
	CCaveItem cci = new Rod();
	assertEquals("Rod", cci.getShortDescription());
	}
	
	/**
	 * Testing ID
	 */

	@Test
	public void testGetId() {
		CCaveItem cci = new Rod();
		assertEquals("rod", cci.getId());
	}
	
	/**
	 * Testing location
	 */

	@Test
	public void testGetLocation() {
		CCaveItem cci = new Rod();
		assertEquals("debrisroom", cci.getLocation());
	}
	
	/**
	 * Testing ID- upper/lower case
	 */

	@Test
	public void testIsId0() {
		CCaveItem cci = new Rod();
		assertTrue(cci.isId("rOd"));
	}
	
	/**
	 * Testing ID- false 
	 */

	@Test
	public void testIsId1() {
		CCaveItem cci = new Rod();
		assertFalse(cci.isId("sophie"));
	}
	
	/**
	 * Testing rod is waved
	 */
	
	 @Test
	 public void RodIsWaved() {
		 Rod l = new Rod();
		 l.isNotEmpty();
		 assertTrue(l.isntEmpty());
		 }
	 
	 /**
		 * Testing rod is not waved- false
		 */
	 
	 @Test
	 public void RodIsNotWaved() {
		 Rod l = new Rod();
		 l.Empty();
		 assertFalse(l.isntEmpty());
	    }

}



