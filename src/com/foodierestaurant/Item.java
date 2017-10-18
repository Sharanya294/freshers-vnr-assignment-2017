package com.foodierestaurant;

public class Item {
	private int id;

	private String name;

	private int cost;

	Item(int id, String name, int cost) {
		this.id = id;
		this.name = name;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setId(int id) {
		this.id = id;
	}

}
