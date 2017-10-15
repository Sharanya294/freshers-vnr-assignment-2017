package com.foodierestaurant;

import java.util.ArrayList;
import java.util.Scanner;

public class Table{
		private int tableId;
		private int capacity;
		private   ArrayList<Table> tableList;
		
		
		public Table(int id, int capacity){
			this.tableId = id;
			this.capacity = capacity;
			
		}
		
		public Table() {
			initialzeTables();
		}
		
		public int getTableId() {
			return tableId;
		}
	
		public  void initialzeTables() {
		Table t1 = new Table(1,2);
		Table t2= new Table (2,4);
		Table t3= new Table (3,2);
		Table t4= new Table (4,4);
		Table t5= new Table (5,4);
		Table t6= new Table (6,4);
		Table t7=new Table (7,8);
		Table t8=new Table (8,10);
		
		tableList = new ArrayList<Table>();
		tableList.add(t1);
		tableList.add(t2);
		tableList.add(t3);
		tableList.add(t4);
		tableList.add(t5);
		tableList.add(t6);
		tableList.add(t7);
		tableList.add(t8);
		
		//return tableList;
		}
		
		public ArrayList<Integer> findTable(int persons) {
			ArrayList<Integer> availableTables=new ArrayList<Integer>();
			System.out.println("Finding for suitable tables...");
			for (Table tables : tableList ) {
				
				if (tables.capacity>=persons)
					availableTables.add(tables.getTableId());		
				
			}
			return availableTables;
		}


		/* This method will list all the tables based on number of persons and will 
		 * allocate a table chosen by manager.
		 * Returns the table number which is allocated*/
		public int allocateTable(Customer customerObj,int persons) {
			 // creates the table object and initializes all the tables
			Table tableObject = new Table(); 
			ArrayList<Integer> availableTables=tableObject.findTable(persons);
			if (availableTables.isEmpty())
				System.out.println("Sorry! there are no vacant tables");
				
			else
				System.out.println("Available Tables are: " + availableTables);
			System.out.println("Choose a table to allocate from above tables");
			int choosenTable=new Scanner(System.in).nextInt();
			System.out.println("Customer " + customerObj.getName() + " is allocated to table number "+ choosenTable);
			return choosenTable;
			
		}
		
		public void serveWater(int tableNumber) {
			try {
			
			System.out.println("... \n...");
			Thread.sleep(3000);
			System.out.println("Water is served on " + tableNumber+ "\n");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		


		
		
		
}
	
