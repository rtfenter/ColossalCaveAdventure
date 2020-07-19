package edu.waketech.ccave.provided;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import edu.waketech.ccave.common.CCaveElement;
import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.common.RoomDirectory;
import edu.waketech.ccave.item.CCaveItem;
import edu.waketech.ccave.location.CCaveRoom;
import edu.waketech.ccave.location.Chamber;

/**
 * Main method and user interface for our console-based Colossal Cave Adventure
 * Game.
 */


public class Cave {
	
	public static final String START_ROOM = "wellhouse";
	public static final String SAVE_FILE_NAME = "cave.sav";

	public static void main(String[] args) throws IOException {

		// Let's start to play the game.
		Spelunker caveMan;
		caveMan = new Spelunker(START_ROOM);
		InputParser playerInput = InputParser.getInputParser();
		
		CCaveRoom saveRoom = caveMan.getCurrentLocation();

		// restore saved game
		if (Files.exists(Paths.get(SAVE_FILE_NAME)))
		{
		   Scanner ans = new Scanner(System.in);
		   System.out.println("Restore game (Y/N)?");
		   String restore = ans.next();
		   if (restore.equalsIgnoreCase("Y"))
		   {
		      restoreGame(caveMan);
		   }
		}

		boolean running = true;
		while (running) {
		   System.out.println(caveMan.getLongDescription());
		   playerInput.readInput();
		   if (playerInput.getInputType() == InputType.SAVE) saveGame(caveMan);
		   else if (playerInput.getInputType() == InputType.MOVE) caveMan.move(playerInput.getDirection());
		   
		   else if (playerInput.getInputType() == InputType.MAGIC)
		   {
		       if (caveMan.getCurrentLocation().isId("debrisroom"))
		    {
		     System.out.println("Whooooosh - you have been transported ....");
		     saveRoom = caveMan.getCurrentLocation();
		     caveMan.setLocation(RoomDirectory.getInstance().get("wellhouse"));
		    }
		    else if (caveMan.getCurrentLocation().isId("wellhouse"))
		    {
		     caveMan.setLocation(saveRoom);
		    }

		   }
		   else if (playerInput.getInputType() == InputType.MAGIC2)
		   {
		      // todo for plugh
		   }
		     else if (playerInput.getInputType() == InputType.INVENTORY) 
		     {
		     ItemCommand cmd = playerInput.getItemCommand();
		     String item = playerInput.getcCaveItemName();
		     caveMan.changeInventory(cmd, item);
		     }
		     else if (playerInput.getInputType() == InputType.OTHER) 
		     {
		     ItemCommand cmd = playerInput.getItemCommand();
		     String item = playerInput.getcCaveItemName();
		     caveMan.otherCommand(cmd, item);
		     }
		}

	}

	private static void saveGame(Spelunker caveMan)
	{
		try
		{
			FileOutputStream fileOutputStream = new FileOutputStream(SAVE_FILE_NAME);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			Map<String, CCaveElement> itemMap = new HashMap<>();
			for (CCaveItem cci: ItemDirectory.getInstance().getAllItems())
			{
				itemMap.put(cci.getId(), cci);
			}
			//for (CCaveRoom ccr: RoomDirectory.getInstance().getAllRooms())
			//{
			//	itemMap.put(ccr.getId(), ccr);
			//}

			// Add the spluenker
			itemMap.put(caveMan.getId(), caveMan);

			objectOutputStream.writeObject(itemMap);
			objectOutputStream.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception saving game");
		}
	}


	private static void restoreGame(Spelunker caveMan)
	{
		try
		{
			FileInputStream fileInputStream = new FileInputStream(SAVE_FILE_NAME);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			Map<String, CCaveElement> itemMap = (HashMap<String, CCaveElement>)objectInputStream.readObject();

			for (String id : itemMap.keySet())
			{
				CCaveElement cce = itemMap.get(id);
				if (cce instanceof CCaveItem)
				{
					ItemDirectory.getInstance().remove((CCaveItem) cce);
					ItemDirectory.getInstance().add((CCaveItem)cce);
				}
				//else if (cce instanceof CCaveRoom)
				//{
				//	RoomDirectory.getInstance().remove((CCaveRoom) cce);
				//	RoomDirectory.getInstance().add((CCaveRoom)cce);
				//}
				else if (cce instanceof Spelunker)
				{
					Spelunker s = (Spelunker)cce;
					caveMan.setLocation(s.getCurrentLocation());
				}
			}

			objectInputStream.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception restoring game");
		}
	}

}
