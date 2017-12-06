package data;

public class ServeThread extends Thread {
	
	private Table table;
	private String[] courses;
	private String customerName;
	private String waiterName;

	public ServeThread(Table table, String custName, String waitName, String[] courses) {
		this.table = table;
		this.customerName = custName;
		this.waiterName = waitName;
		this.courses = courses;
	}
	
	@Override
	public void run() {
//		if(table.waiter == null) {
//			table.waiter = this;
//		}
//		else throw new IllegalArgumentException();
		
		int courseNum = 0;
		while(courseNum < Waiter.N_COURSES) {
			if(table.isEmpty) {
				table.serve(this.courses[courseNum]);
				++courseNum;
				System.out.println(this.waiterName + " serves " + this.customerName + " " + courses[courseNum]);
				
				try { Thread.sleep((long) (Math.random() * Waiter.MAX_WAITER_MILLIS)); }
				catch(InterruptedException e) {}
			}
		}
		super.run();
	}

}
