package data;

public class Customer implements Runnable {
	public static final int MAX_WAITER_MILLIS = 4000;
	
	private Table table;
	private String customerName;
	
	public Customer(Table table, String name) {
		this.table = table;
		this.customerName = name;
	}

	public void run() {
		
		if(!table.isEmpty) {
			System.out.println(this.customerName + " is eating " + table.eat());
			
			try { Thread.sleep((long) Math.random() * MAX_WAITER_MILLIS); }
			catch(InterruptedException e) {e.printStackTrace();}
		}
	}
}
