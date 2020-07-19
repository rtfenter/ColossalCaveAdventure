////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC 251
// 
//  Project:  ColossalCave
//  File:     ItemDirectoryTest.java
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

import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.item.Food;
import edu.waketech.ccave.item.Water;
import edu.waketech.ccave.item.Lamp;
import edu.waketech.ccave.item.Rod;
import edu.waketech.ccave.item.Keys;
import edu.waketech.ccave.item.Axe;
import edu.waketech.ccave.item.Bird;
import edu.waketech.ccave.item.Cage;
import edu.waketech.ccave.item.Coins;
import edu.waketech.ccave.item.Diamonds;
import edu.waketech.ccave.item.Gold;
import edu.waketech.ccave.item.Jewels;
import edu.waketech.ccave.item.Silver;

public class ItemDirectoryTest {

	@Test
	public void testContainsString0() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Food());
		direc.add(new Water()); 
		direc.add(new Lamp());
		direc.add(new Keys());
		direc.add(new Axe());
		direc.add(new Gold());
		direc.add(new Silver());
		direc.add(new Cage()); 
		direc.add(new Bird());
		direc.add(new Coins());
		direc.add(new Jewels());
		direc.add(new Rod());
		direc.add(new Diamonds());
		assertEquals(13, direc.size());
	}
	
	/**********************************************************************/
	
	@Test
	public void testContainsString1() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Food());
		assertTrue(direc.contains("FOod"));
	}
	
	@Test
	public void testContainsString2() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Water());
		assertTrue(direc.contains("WAter"));
	}
	
	@Test
	public void testContainsString3() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Lamp());
		assertTrue(direc.contains("LAmp"));
	}
	
	@Test
	public void testContainsString4() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Keys());
		assertTrue(direc.contains("KEys"));
	}
	
	@Test
	public void testContainsString5() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Axe());
		assertTrue(direc.contains("AXe"));
	}
	

	@Test
	public void testContainsString6() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Cage());
		assertTrue(direc.contains("CAge"));
	}

	
	@Test
	public void testContainsString8() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Gold());
		assertTrue(direc.contains("GOld"));
	}
	
	@Test
	public void testContainsString9() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Silver());
		assertTrue(direc.contains("SIlver"));
	}
	
	@Test
	public void testContainsString10() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Bird());
		assertTrue(direc.contains("bIrd"));
	}
	
	@Test
	public void testContainsString11() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Coins());
		assertTrue(direc.contains("CoINS"));
	}
	
	@Test
	public void testContainsString12() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Jewels());
		assertTrue(direc.contains("jewELs"));
	}
	
	@Test
	public void testContainsStringNew() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Rod()); 
		assertTrue(direc.contains("RoD")); 
	}
	
	@Test
	public void testContainsStringNew1() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Diamonds()); 
		assertTrue(direc.contains("diAMONds")); 
	}
	
	/******************************************************************/
	
	@Test
	public void testContainsString13() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		direc.add(new Food());
		direc.add(new Water()); 
		direc.add(new Lamp());
		direc.add(new Keys());
		direc.add(new Axe());
		direc.add(new Gold());
		direc.add(new Silver());
		direc.add(new Cage());
		direc.add(new Bird());
		direc.add(new Coins());
		direc.add(new Jewels());
		direc.add(new Rod()); 
		direc.add(new Diamonds());
		assertEquals(direc.get(0), direc.get("FoOd"));
		assertEquals(direc.get(1), direc.get("WaTEr"));
		assertEquals(direc.get(2), direc.get("LAMP"));
		assertEquals(direc.get(3), direc.get("kEYs"));
		assertEquals(direc.get(4), direc.get("AxE"));
		assertEquals(direc.get(5), direc.get("gOLD"));
		assertEquals(direc.get(6), direc.get("SiLvEr"));
		assertEquals(direc.get(7), direc.get("caGE")); 
		assertEquals(direc.get(8), direc.get("BiRD")); 
		assertEquals(direc.get(9), direc.get("COIns"));
		assertEquals(direc.get(10), direc.get("JEwelS"));
		assertEquals(direc.get(11), direc.get("rOD")); 
		assertEquals(direc.get(12), direc.get("diaMONDs")); 
	}
	
	/******************************************************************/
	
	@Test
	public void testContainsString14() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		assertEquals(0, direc.size());
		direc.add(new Food());
		assertTrue(direc.remove("fOOd"));
		assertEquals(0, direc.size());
	}
	
	@Test
	public void testContainsString15() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		assertFalse(direc.contains("food"));
		assertEquals(null, direc.get("fooD"));
	}
	
	@Test
	public void testContainsString16() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		assertEquals(null, direc.get("fooD"));
	}
	
	@Test
	public void testContainsString17() {
		ItemDirectory direc= ItemDirectory.getInstance();
		direc.clear();
		assertEquals(null, direc.get("wateR")); 
	}
	
	@Test
	public void testContainsString18() {
		ItemDirectory direc= ItemDirectory.getInstance();
		direc.clear();
		assertFalse(direc.contains("food"));
		assertEquals(null, direc.get("wateR"));
	}
	
	@Test
	public void testContainsString19() {
		ItemDirectory direc = ItemDirectory.getInstance();
		direc.clear();
		assertEquals(0, direc.size());
		direc.add(new Water());
		assertTrue(direc.remove("wATer"));
		assertEquals(0, direc.size());
	}
		
		
		
	}


