package edu.waketech.ccave.test;

import edu.waketech.ccave.common.ItemDirectory;
import edu.waketech.ccave.item.CCaveItem;

public class ItemsLister {

	public static void main(String[] args) {
		ItemDirectory itemDirec = ItemDirectory.getInstance();
		int sz = itemDirec.size();
		for (int i = 0; i < sz; i++) {
			CCaveItem cci = itemDirec.get(i);
			System.out.println("item " + i + ": " + cci);
		}
	}

}
