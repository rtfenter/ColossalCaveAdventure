package edu.waketech.ccave.test;

import java.io.IOException;

import edu.waketech.ccave.common.Direction;
import edu.waketech.ccave.provided.Spelunker;


/**
 * A place with a main method where we can code some tests of our cave code.
 * 
 * @author parks
 *
 */
public class CaveTestMain {

	public static void main(String[] args) throws IOException {

		// First some sanity checks.
		// CCaveMap caveMap = CCaveMap.accessMap();
		//Spelunker me = new Spelunker("end_of_road");
		
		Spelunker me = new Spelunker("wellhouse");
		
		System.out.println(me.getLongDescription());//get keys, lamp, food, water
		
		me.move(Direction.N);  // -> spring
		System.out.println(me.getLongDescription());
		
		me.move(Direction.N);  //  -> forest
		System.out.println(me.getLongDescription());//grab axe
		
		me.move(Direction.S);  //  -> spring
		System.out.println(me.getLongDescription());
		
		me.move(Direction.DOWN);  //  -> slit in rock 
		System.out.println(me.getLongDescription()); 
		
		me.move(Direction.S);  //  -> grate
		System.out.println(me.getLongDescription());//use keys
		
		/**
		
		me.move(Direction.W);  //  -> chamber
		System.out.println(me.getLongDescription());//turn on lamp and grab cage
		
		me.move(Direction.N);  //  -> debris room
		System.out.println(me.getLongDescription());//get rod
		
		me.move(Direction.W);  //  -> sloping room
		System.out.println(me.getLongDescription());//drop rod
		
		me.move(Direction.W);  //  -> orange river chamber
		System.out.println(me.getLongDescription());//grab bird
		
		me.move(Direction.E);  //  -> sloping room
		System.out.println(me.getLongDescription());//grab rod
		
		me.move(Direction.W);  //  -> orange river chamber
		System.out.println(me.getLongDescription());
		
		me.move(Direction.W);  //  -> pit
		System.out.println(me.getLongDescription());
		
		me.move(Direction.DOWN);  //  -> hall of mists 
		System.out.println(me.getLongDescription());//grab gold
		
		me.move(Direction.N);  //  -> hall of the mountain king  
		System.out.println(me.getLongDescription());//release bird
		
		me.move(Direction.W);  //  -> west side chamber
		System.out.println(me.getLongDescription());
		
		me.move(Direction.E);  //  -> hall of the mountain king
		System.out.println(me.getLongDescription());//grab coins
		
		me.move(Direction.E);  //  -> east side chamber
		System.out.println(me.getLongDescription());
		
		me.move(Direction.W);  //  -> hall of the mountain king
		System.out.println(me.getLongDescription());//grab jewels 
		
		me.move(Direction.N);  //  -> chamber with hole 
		System.out.println(me.getLongDescription());//grab silver
		
		me.move(Direction.N);  //  -> y2 room
		System.out.println(me.getLongDescription());//
		
		me.move(Direction.S);  //  -> chamber with hole
		System.out.println(me.getLongDescription());//
		
		me.move(Direction.S);  //  -> hall of the mountain king
		System.out.println(me.getLongDescription());//
		
		me.move(Direction.S);  //  -> hall of mists
		System.out.println(me.getLongDescription());//
		
		me.move(Direction.W);  //  -> fissure
		System.out.println(me.getLongDescription());//wave rod
		
		me.move(Direction.S);  //  -> crystal bridge
		System.out.println(me.getLongDescription());//get diamonds
		
		*/
		
		
		//end for now 
		

	}

}
