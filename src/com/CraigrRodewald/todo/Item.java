package com.CraigrRodewald.todo;

public class Item {
	private String itemName;

	public Item(){
		
	}
	public Item(String itemName) {
		super();
		this.itemName = itemName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
