package data;

public class Customer implements Runnable {
	public static final int MAX_CUSTOMER_MILLIS = 4000;
	
	private Table table;
	private String customerName;
	
	public Customer(Table table, String name) {
		this.table = table;
		this.customerName = name;
	}

	public void run() {

			String course = table.eat();
			System.out.println(this.customerName + " is eating " + course);

			try { Thread.sleep((long) Math.random() * MAX_CUSTOMER_MILLIS); }
			catch(InterruptedException e) {}
	}
}
