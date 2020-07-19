////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC.251.0001
// 
//  Project:  ColossalCaveProject
//  File:     DirectionTest.java
//  
//  Name:     Rebecca Fenter
//  Email:    rtfenter@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////
package edu.waketech.ccave.test;

/**
 * This is a simple test program to check all possible
 * directions a player can play. 
 * 
 * @author Rebecca Fenter
 *
 */

import static org.junit.Assert.*;
import org.junit.Test; 

import edu.waketech.ccave.common.Direction;

public class DirectionTest
{
	
	/**
	  * This test is just to verify my understanding of enums.
	  * It tests that Direction.N.toString().equalsIgnoreCase("n") is true.
	  * */
	
	@Test
	public void testEquals() 
	{
		assertTrue(Direction.N.toString().equalsIgnoreCase("n"));
	}
	
	 /**
	  * It tests that Direction.NE.toString().equalsIgnoreCase("ne") is true.
	  * */
	
	@Test
	public void testEquals0() 
	{
		assertTrue(Direction.NE.toString().equalsIgnoreCase("ne"));
	}
	
	 /**
	  * It tests that Direction.NW.toString().equalsIgnoreCase("nw") is true.
	  * */
	
	@Test
	public void testEquals1() 
	{
		assertTrue(Direction.NW.toString().equalsIgnoreCase("nw"));
	}
	
	 /**
	  * It tests that Direction.S.toString().equalsIgnoreCase("s") is true.
	  * */
	
	@Test
	public void testEquals2() 
	{
		assertTrue(Direction.S.toString().equalsIgnoreCase("s"));
	}
	
	 /**
	  * It tests that Direction.SE.toString().equalsIgnoreCase("se") is true.
	  * */
	
	@Test
	public void testEquals3() 
	{
		assertTrue(Direction.SE.toString().equalsIgnoreCase("se"));
	}
	
	 /**
	  * It tests that Direction.SW.toString().equalsIgnoreCase("sw") is true.
	  * */
	
	@Test
	public void testEquals4() 
	{
		assertTrue(Direction.SW.toString().equalsIgnoreCase("sw"));
	}
	
	 /**
	  * It tests that Direction.W.toString().equalsIgnoreCase("e") is false.
	  * */
	
	@Test
	public void testEquals5() 
	{
		assertFalse(Direction.W.toString().equalsIgnoreCase("e"));
	}
	
	 /**
	  * It tests that Direction.E.toString().equalsIgnoreCase("w") is false.
	  * */
	
	@Test
	public void testEquals6() 
	{
		assertFalse(Direction.E.toString().equalsIgnoreCase("w"));
	}
	
	 /**
	  * It tests that Direction.SE.toString().equalsIgnoreCase("sw") is false.
	  * */
	
	@Test
	public void testEquals7() 
	{
		assertFalse(Direction.SE.toString().equalsIgnoreCase("sw"));
	}
	
	 /**
	  * It tests that Direction.SW.toString().equalsIgnoreCase("se") is false.
	  * */
	
	@Test
	public void testEquals8() 
	{
		assertFalse(Direction.SW.toString().equalsIgnoreCase("se"));
	}
	
	 /**
	  * It tests that Direction.NE.toString().equalsIgnoreCase("nw") is false.
	  * */
	
	@Test
	public void testEquals9() 
	{
		assertFalse(Direction.NE.toString().equalsIgnoreCase("nw"));
	}
	
	 /**
	  * It tests that Direction.NW.toString().equalsIgnoreCase("ne") is false.
	  * */
	
	@Test
	public void testEquals10() 
	{
		assertFalse(Direction.NW.toString().equalsIgnoreCase("ne"));
	}
	
	/**
	 * Test that Direction.findSynonym("north") returns Direction.N
	 * */
	
	@Test
	public void testIsSynonym()
	{
		Direction d = Direction.findSynonym("north");
		assertEquals(Direction.N, d);
	}
	
	/**
	 * Test that Direction.findSynonym("misspelled") returns Direction.UNKNOWN
	 * */
	
	@Test
	public void testIsSynonym0()
	{
		Direction d = Direction.findSynonym("misspelled");
		assertEquals(Direction.UNKNOWN, d);
	}
	
	/**
	 * Test that Direction.findSynonym("n") returns Direction.N
	 * */ 
	
	
	@Test
	public void testIsSynonym1() 
	{
		Direction d = Direction.findSynonym("n");
		assertEquals(Direction.N, d);
	}
	
	/**
	 * Test that Direction.findSynonym("down") returns Direction.DOWN
	 * */
	
	@Test
	public void testIsSynonym2()
	{
		Direction d = Direction.findSynonym("down");
		assertEquals(Direction.DOWN, d);
	}
	
	
	/**
	 * Test that Direction.findSynonym("d") returns Direction.DOWN
	 * */
	
	@Test
	public void testIsSynonym3()
	{
		Direction d = Direction.findSynonym("d");
		assertEquals(Direction.DOWN, d);
	}
	
	/**
	 * Test that Direction.N.isSynonym("North") is true
	 * */
	
	@Test
	public void testIsSynonym4() 
	{
		Direction d = Direction.N;
		assertTrue(d.isSynonym("North"));
	}
	
	/**
	 * Test that Direction.N.isSynonym("south") is false
	 * */
	
	@Test
	public void testIsSynonym5() 
	{
		Direction d = Direction.N;
		assertFalse(d.isSynonym("south"));
	}
	
	/**
	 * Test that Direction.N.isSynonym("south") is false
	 * */
	
	@Test
	public void testIsSynonym6() 
	{
		Direction d = Direction.S;
		assertFalse(d.isSynonym("North"));
	}
	
	/**
	 * Test that Direction.UP.isSynonym("d") is false
	 * */
	
	@Test
	public void testIsSynonym7() 
	{
		Direction d = Direction.UP;
		assertFalse(d.isSynonym("d"));
	}
	
	/**
	 * Test that Direction.NE.isSynonym("NorthEast") is true
	 * */
	
	@Test
	public void testIsSynonym8() 
	{
		Direction d = Direction.NE;
		assertTrue(d.isSynonym("NorthEast"));
	}
	
	/**
	 * Test that Direction.NW.isSynonym("SW") is false
	 * */
	
	@Test
	public void testIsSynonym9() 
	{
		Direction d = Direction.NW;
		assertFalse(d.isSynonym("SW"));
	}
	
	/**
	 * Test that Direction.SE.isSynonym("SouthEast") is true
	 * */
	
	@Test
	public void testIsSynonym10() 
	{
		Direction d = Direction.SE;
		assertTrue(d.isSynonym("SouthEast"));
	}
	
	
	 }

