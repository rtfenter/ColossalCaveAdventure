////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     KeysTest.java
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
import edu.waketech.ccave.item.Keys;

public class KeysTest {
	
	/**
	 * Testing long description
	 */

	@Test
	public void testGetLongDescription() {
		CCaveItem cci = new Keys();
		assertEquals("There are some golden keys on the ground here.", cci.getLongDescription());
	}
	
	/**
	 * Testing short description
	 */

	@Test
	public void testGetShortDescription() {
		CCaveItem cci = new Keys();
		assertEquals("Set of keys", cci.getShortDescription());
	}
	
	/**
	 * Testing ID
	 */

	@Test
	public void testGetId() {
		CCaveItem cci = new Keys();
		assertEquals("keys", cci.getId());
	}
	
	/**
	 * Testing location
	 */

	@Test
	public void testGetLocation() {
		CCaveItem cci = new Keys();
		assertEquals("wellhouse", cci.getLocation());
	}
	
	/**
	 * Testing ID- upper/lower case
	 */

	@Test
	public void testIsId0() {
		CCaveItem cci = new Keys();
		assertTrue(cci.isId("KeyS"));
	}
	
	/**
	 * Testing ID- false 
	 */

	@Test
	public void testIsId1() {
		CCaveItem cci = new Keys();
		assertFalse(cci.isId("sophie"));
	}
	
	/**
	 * Testing keys unlock
	 */
	
	 @Test
	 public void testUnlock() {
		 Keys l = new Keys();
		 l.Unlock();
		 assertTrue(l.isUnlock());
		 }
	 
	 /**
		 * Testing keys lock- false 
		 */
	 
	 @Test
	 public void testLock() {
		 Keys l = new Keys();
		 l.Lock();
		 assertFalse(l.isUnlock());
	    }
}


