package bookManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Book {
	static ArrayList<Book> library = new ArrayList<Book>();
	


	static int PresentIndex = 1;

	private boolean available;
	private String name;
	private String ISBN;
	private String author; 
	private int index;
	private String fullReturnDate = "";
	private String reservedBy = "";

	public Book(String name, String ISBN, String author) {
		this.name = name;
		this.ISBN = ISBN;
		this.author = author;
		this.index = PresentIndex;
		PresentIndex += 1;
		this.available = true;
	}

	

	public void setReservedBy(String reserver) {
		this.reservedBy = reserver;
	}

	public boolean isAvailable() {
		if (this.available == true)
			return true;
		else
			return false;
	}

	int getIndex() {
		return index;
	}

	public String getName() {
		return name;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public String getAuthor() {
		
		return author;
	}


	public String getFullReturnDate() {
		return fullReturnDate;
	}

	public String getReservedBy() {
		return reservedBy;
	}

	void reserve() {
		System.out.println("Please enter your Name");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String nameOfReserver = reader.readLine();
			this.reservedBy = nameOfReserver;
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		this.available = false;
	//DateManager d = new DateManager();
		//this.fullReturnDate = d.reserveFor2Weeks();

	} 


	void returnThisBook() {
		this.available = true;
		this.fullReturnDate = " ";
		this.reservedBy = "";
	}	

	void printInfo() {
		System.out.printf("%s  %s  %s  %s %s", this.index, this.name,
				this.ISBN, this.author);
	}



	


	
	

}
