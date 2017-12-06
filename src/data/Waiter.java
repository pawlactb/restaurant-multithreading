package data;

public class Waiter implements Runnable {
	
	public static final int MAX_WAITER_MILLIS = 4000;
	public static final int N_COURSES = 3;
	
	private Table[] tables;
	private String waiterName;
	private String[] customerNames;
	private String[][] courses;
	private int[] currentCourse;
	
	public Waiter(Table[] tables, String waiterName,
			String[] customerNames, String[][] courses) {
		this.tables = tables;
		this.waiterName = waiterName;
		this.customerNames = customerNames;
		this.courses = courses;
		
		currentCourse = new int[courses.length];
	}

	public void run() {
		Table table = null;
		for(int t = 0; t < this.tables.length; ++t) {
			table = this.tables[t];
			table.serve(this.courses[t][this.currentCourse[t]]);
			System.out.println(this.waiterName + " serves " + this.customerNames[t] + " " + courses[t][currentCourse[t]]);
			this.currentCourse[t] = this.currentCourse[t] + 1;
			
			try { Thread.sleep((long) Math.random() * MAX_WAITER_MILLIS); }
			catch(InterruptedException e) {}
			
			
		}
	}
}

