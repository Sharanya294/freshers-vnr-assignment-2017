package com.foodierestaurant;


public class Table{
		private int tableId;
		private int capacity;
	//	private   ArrayList<Table> tableList;
		
		
		public Table(int id, int capacity){ // Parameterized constructor
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
		/* All the tables will be initialized and added to a list when an Object is created
		 * for Table class
		 */
		public Table() {  
			//initialzeTables();
		}
		
		public int getTableId() {
			return tableId;
		}
		
		
		
		
		
}
	
