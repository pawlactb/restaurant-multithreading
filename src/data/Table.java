package data;

public class Table {
	private String course;
	public boolean isEmpty;
//	public Object waiter; //Synchronization object
	
	public Table() {
		this.course = null;
		this.isEmpty = true;
//		this.waiter = null;
	}
	
	public synchronized void serve(String course) {
		this.course = course;
		this.isEmpty = false;
	}
	
	public synchronized String  eat() {
		this.isEmpty = true;
		this.course = null;
		return this.course;
	}
}
