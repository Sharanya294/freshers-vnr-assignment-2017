package foodierestaurant;

public class Table {
	private int tableId;
	private int capacity;

	public Table(int id, int capacity) { // Parameterized constructor
		this.tableId = id;
		this.capacity = capacity;

	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public int getTableId() {
		return tableId;
	}

}
