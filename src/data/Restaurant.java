package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Restaurant {

	public static void main(String[] args) {
		System.out.println("Enter name of file to test:");
		
		Scanner inputScanner = new Scanner(System.in);
		String fileName = inputScanner.next();
				
		BufferedReader inFile = null;
		
		try {
			inFile = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file!");
			e.printStackTrace();
			return;
		}
		
		int numWaiters;
		try {
			numWaiters = Integer.parseInt(inFile.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid number of waiters!");
			e.printStackTrace();
			try {
				inFile.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		} catch (IOException e) {
			e.printStackTrace();
			try {
				inFile.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}
		
		try {
			while(inFile.ready()) {
				try {
					parseLine(inFile.readLine());
				} catch (IOException e) {
					System.out.println("invalid input!");
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			inFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void parseLine(String line) {
		Scanner wordScanner = new Scanner(line);
		String waiterName = wordScanner.next();
		int numCustomers  = Integer.parseInt(wordScanner.next());
		
		Table[] tables = new Table[numCustomers];
		String[] customerNames = new String[numCustomers];
		String[][] courses = new String[numCustomers][Waiter.N_COURSES];
		
		for(int i = 0; i < numCustomers; ++i) {
			tables[i] = new Table();
			customerNames[i] = wordScanner.next();
			new Thread( new Customer(tables[i], customerNames[i])).start();
			
			for(int m = 0; m < Waiter.N_COURSES; ++m) {
				courses[i][m] = wordScanner.next();
				System.out.println(courses[i][m]);
			}
		}
		
		
		
		new Thread(new Waiter(tables, waiterName, customerNames, courses)).start();
		
		wordScanner.close();
	}

}
