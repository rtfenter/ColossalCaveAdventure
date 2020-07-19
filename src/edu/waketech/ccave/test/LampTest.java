////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     LampTest.java
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

public class LampTest {
	
	/**
	 * Testing long description
	 */

	@Test
	public void testGetLongDescription() {
		CCaveItem cci = new Lamp();
		assertEquals("There is a shiny brass lamp here.", cci.getLongDescription());
	}
	
	/**
	 * Testing short description
	 */

	@Test
	public void testGetShortDescription() {
		CCaveItem cci = new Lamp();
		assertEquals("Brass lantern", cci.getShortDescription());
	}
	
	/**
	 * Testing ID
	 */

	@Test
	public void testGetId() {
		CCaveItem cci = new Lamp();
		assertEquals("lamp", cci.getId());
	}
	
	/**
	 * Testing location
	 */

	@Test
	public void testGetLocation() {
		CCaveItem cci = new Lamp();
		assertEquals("wellhouse", cci.getLocation());
	}
	
	/**
	 * Testing ID- upper/lower case
	 */

	@Test
	public void testIsId0() {
		CCaveItem cci = new Lamp();
		assertTrue(cci.isId("LamP"));
	}
	
	/**
	 * Testing ID- false 
	 */

	@Test
	public void testIsId1() {
		CCaveItem cci = new Lamp();
		assertFalse(cci.isId("sophie"));
	}
	
	/**
	 * Testing lamp is on
	 */
	
	 @Test
	 public void testLampOn() {
		 Lamp l = new Lamp();
		 l.LampOn();
		 assertTrue(l.isOn());
		 }
	 
	 /**
		 * Testing lamp is off- false
		 */
	 
	 @Test
	 public void testLampOff() {
		 Lamp l = new Lamp();
		 l.LampOff();
		 assertFalse(l.isOn());
	    }
}

