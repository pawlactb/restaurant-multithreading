package data;

public class Table {
	private String course;
	private boolean isEmpty;
//	public Object waiter; //Synchronization object
	
	public Table() {
		this.course = null;
		this.isEmpty = true;
//		this.waiter = null;
	}
	
	public synchronized void serve(String course) {
		while(!this.isEmpty) {
			try { wait(); }
			catch(InterruptedException e) {}
		}
		
		this.course = course;
		this.isEmpty = false;
		
		notifyAll();
	}
	
	public synchronized String eat() {
		while(this.isEmpty) {
			try { wait(); }
			catch(InterruptedException e) {}
		}
		
		this.isEmpty = true;
		notifyAll();
		return this.course;
	}
}
