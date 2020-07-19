////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 251 Spring 2018
//  Section:  CSC.251.0001
// 
//  Project:  ColossalCave
//  File:     Direction.java
//  
//  Name:     Rebecca Fenter
//  Email:    rtfenter@my.waketech.edu
////////////////////////////////////////////////////////////////////////////////
/**
 *All possible directions that a player can travel. 
 *We read a properties file to determine the synonyms for each direction. 
 *This enum reads a properties file for each enum value in the resources directory, such as
	n.properties
    s.properties
    etc. 
 *The keys of these properties files don't really matter--the values do. 
 *So for Direction.N, in n.properties
	n=north
    n1=othernorthvalue
    n2=anothernorthvalue 
 *will all define synonym String values for Direction.N.
 *Author: parks 
 * 
 * @author Rebecca Fenter
 */
package edu.waketech.ccave.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties; 

public enum Direction 
{
	
	/**
	 * We are creating an enum to hold constants for our directions, 
	 * and be able to read from our properties files to determine synonyms for ea direction
	 * so that we may define all possible directions that a player can travel.
	 *
	 */
    
    N(), S(), E(), W(), NE(), NW(), SE(), SW(), UP(), DOWN(), UNKNOWN();//Declare enum constants
	
	private ArrayList<String> directions = new ArrayList<>();//Create arraylist to hold enum's given synonyms from 
															//corresponding properties files
	/**
	 * We are providing a way to import our .properties files and check our 
	 * key values in correspondence to our enum values. 
	 * We are adding a try/catch block for filenotfound and io exceptions- we 
	 * are going to 'ignore' files not found as we will not have properties files matching our
	 * enum (ie UNKNOWN)
	 */
   
    private Direction() 
    {
    	Properties dir; 
    	
    	dir = new Properties();
    			
        File f = new File("resources/" + this.toString() + ".properties");
	
		FileInputStream fis = null;
		
		try 
		{
			fis = new FileInputStream(f);
			dir.load(fis);
			} 
		catch (FileNotFoundException e) 
		{
			//System.out.println("Ignore missing properties files"); //We don't have an UNKNOWN properties as well as others we will be adding so we want
																		//to ignore this exception
			} 
		catch (IOException e) 
		{
			e.printStackTrace();
			}
		finally 
		{
			if (fis != null)
				try
			{
					fis.close();
					} 
			catch (IOException e) 
			{
				e.printStackTrace();
				}
			fis = null;
		}
		
		/**
		 * Enhanced for loop to walk through our properties files 
		 */
		
		String s = " ";
		for (Object o: dir.keySet())//Walking through the properties obj to pull our values and put into an array
								//while ignoring our keys 
		{
			String k = (String) o;
			String v = dir.getProperty(k);
			s+= directions.add(v); 
			 
			
			//System.out.println("enum value " + this.toString() + " file contains " + s);
			//System.out.println(directions); 
		}
    }
    
    /**
	 * public static Direction findSynonym(java.lang.String possibleAlt)
	 * 
	 * enum-wide method to provide a more friendly valueOf method. 
	 * We take a String representation of an enum value or synonym and, ignoring case, 
	 * return the corresponding Direction enum value. This method steps through every possible enum value, 
	 * which it can do using values(). It then tests whether possibleAlt matches one of those values. 
	 * (See isSynonym)
	 * Parameters:
	 * possibleAlt - String representing a case-insensitive, synonym-based Direction value
	 * Returns:
	 * the Direction value associated with possibleAlt, or Direction.UNKNOWN 
	 * @return 
	 */
    
    public static Direction findSynonym(String possibleAlt) 
    {
    	for(Direction s: values())//Enhanced for loop to loop through arraylist 
    	{
        if(s.isSynonym(possibleAlt))//If s is a synonym to possible alt return s 
            return s;
        }
    	return Direction.UNKNOWN;//If not return UNKNOWN 
    }
    
    /**
	 * public boolean isSynonym(java.lang.String possibleAlt)
	 * Determine whether a given String value represents this Direction value ignoring case, 
	 * or one of its synonyms ignoring case.
	 * Parameters:
	 * possibleAlt - a possible String representation of this Direction or one of its synonym values
	 * Returns:
	 * true if possibleAlt is a valid String value for this Direction or one of its synonyms, all ignoring case 
	 */
    
    public boolean isSynonym(String possibleAlt) 
    {  
    	if(this.name().equalsIgnoreCase(possibleAlt)) return true;//If enum name is possible alt ignoring the case	
    															//return true
    
    	for(String s: directions) //Enhanced for loop to loop through arraylist 
    	{
        if(s.equalsIgnoreCase(possibleAlt))//If s equals possibleAlt ignoring case then return true
            return true;
        }
    	return false;//Else return false
    	}	
    }

