package bookManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book {
	static ArrayList<user> user = new ArrayList<user>();
	static ArrayList<Book> library = new ArrayList<Book>();

	static int PresentIndex = 1;

	private boolean available;
	private String name;
	private String ISBN;
	private String author; 
	private int index;
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

	public String getName(Book b) {
		return name;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public String getAuthor() {
		
		return author;
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
			System.out.println("Reserved by " +nameOfReserver);
			//else System.out.println("Name not Found");
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}

		this.available = false;
	

	} 
	public void update(Book b, String name, String ISBN, String author) {
		//Book boo= new Book(name,ISBN,author);
		b = new Book(name, ISBN, author);
		library.add(b);
	}
	


	void returnThisBook() {
		this.available = true;
		this.reservedBy = name;
		//System.out.println("Returned by:"+name);
	}	

	void printInfo() {
		System.out.printf("%s  %s  %s  %s %s", this.index, this.name,
				this.ISBN, this.author);
	}
	
	public void setName(String name, String ISBN, String author) {
		this.name=name;
		this.ISBN=ISBN;
		this.author = author;
	}
}
