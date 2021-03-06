package bookManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Book> library = new ArrayList<Book>();
	static ArrayList <user> user = new ArrayList<user>();
	//static ArrayList <Updater> updater = new ArrayList<Updater>();
	static Issue issue = new Issue();
	static int inputInteger;
	static int inputa;

	public static void main(String args[]) throws IOException {
		
		initialize();
		//printAllBooks(library);
		startLibraryEngine();
	}

	private static void displayMenu() {
		System.out.println("Enter any option" + "\n" + "1: View all books"
				+ "\n" + "2: Search a book using Name or ISBN number" + "\n"
				+ "3: Add a book" + "\n" + "4: Update Book" + "\n"+ 
				"5: Delete a book" + "\n"+ "6: Add User"+ 
				"\n"+ "7: View all users" + "\n" + "8: Issue" +"\n"+ "9: Return" + "\n"
				+ "10: Exit"+"\n");

	}
	

	private static void startLibraryEngine() throws IOException {
		

		do {
			displayMenu();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				String input = reader.readLine();
				inputInteger = Integer.parseInt(input);
			} catch (IOException e) {
				
				e.printStackTrace();
			}

			switch (inputInteger) {
			case 1:
				printAllBooks(library);
				if (wouldLikeToContinue() == true)
					continue;
				else
					seeYouAgain();
			case 2:
				searchAndPrint();
				if (wouldLikeToContinue() == true)
					continue;
				else
					seeYouAgain();
			case 3:
				addBook();
				if (wouldLikeToContinue() == true)
					continue;
				else
					seeYouAgain();
			case 4:
				updateBook();
				if (wouldLikeToContinue() == true)
					continue;
				else
					seeYouAgain();
			case 5:
				deleteBook();
				if (wouldLikeToContinue() == true)
					continue;
				else
					seeYouAgain();
			case 6:
				addUser();
				if (wouldLikeToContinue() == true)
					continue;
				else
					seeYouAgain();
			case 7:
				printAlluser(user);
				if (wouldLikeToContinue() == true)
					continue;
				else
					seeYouAgain();
			case 8:
				Issue.reserveBook(library);
				if (wouldLikeToContinue() == true)
					continue;
				else
					seeYouAgain();
			case 9:
				Issue.returnBook(library);
				if (wouldLikeToContinue() == true)
					continue;
				else
					seeYouAgain();
			
			case 10:
				seeYouAgain();
			}

		} while (true);

	}

	private static void seeYouAgain() {
		
		System.out.println("Thanks");
		System.exit(0);
	}

	private static boolean wouldLikeToContinue() throws IOException {
		
		System.out.println("Press 1 to continue, any other number to exit");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String input = reader.readLine();
		int inputVal = Integer.parseInt(input);
		switch (inputVal) {
		case 1:
			return true;

		}

		return false;
	}

	static void initialize() {
		Book cpp = new Book("C++", "1011-2018", "abc");
		library.add(cpp);
		Book java = new Book("Java", "100-2011","xyz");
		library.add(java);
		Book python = new Book("Ruby", "011-2017","ishan");
		library.add(python);
		Book maths = new Book("Math", "100-2016","nishan");
		library.add(maths);
		Book phy = new Book("Phy", "000-2010", "abcd");
		library.add(phy);
		Book javac = new Book("Perl", "500-2017","subash");
		library.add(javac);
		
		user user1 = new user("Uttam", "2018-01");
		user.add(user1);
		
		

	}

	static void addBook() throws IOException {

		System.out.println("Please the Name of the book");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String name = reader.readLine();
		System.out.println("Please the ISBN Number");
		BufferedReader reader1 = new BufferedReader(new InputStreamReader(
				System.in));
		String ISBN = reader1.readLine();
		System.out.println("Please the name of the author");
		BufferedReader buff = new BufferedReader(new InputStreamReader(
				System.in));
		String author = buff.readLine();

		Book a = new Book(name, ISBN, author);
		library.add(a);
		System.out.println("Book Added!"+"\n");
		printAllBooks(library);
	}
	
	static void addUser() throws IOException {

		System.out.println("Please the Name of the user");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String name = reader.readLine();
		System.out.println("Please the Library Number");
		BufferedReader reader1 = new BufferedReader(new InputStreamReader(
				System.in));
		String libno = reader1.readLine();

		user a = new user(name, libno);
		user.add(a);
	}


	static void searchAndPrint() throws IOException {
		System.out.println("Please enter the Name or ISBN Number");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String query = reader.readLine();
		boolean found = false;
		ArrayList<Book> searchResultArray = new ArrayList<Book>();
		for (Book i : library) {
			// System.out.println(i.name);
			if (i.getName(i).contains(query)
					|| i.getISBN().contains(query)) {
				searchResultArray.add(i);
				found = true;
			}

		}
		if (found = true) {
			printAllBooks(searchResultArray);
		}
		if (found == false) {
			System.out.println("Sorry, no matches found!");
		}
	}

	static void deleteBook() throws IOException {
		System.out.println("Please the Index Number");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String indexDisplayed = reader.readLine();
		int index = Integer.parseInt(indexDisplayed);

		for (Book i : library) {

			if (i.getIndex() == index) {

				library.remove(i);
				break;
			}

		}
		System.out.println("Book with index " +index +" is deleted"+"\n");
		printAllBooks(library);
	}
	
	static void updateBook() throws IOException {
	boolean op = true;
		while(op) {
			System.out.println("enter the index of book");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String indexDisplayed = reader.readLine();
			int index = Integer.parseInt(indexDisplayed);
			for (Book b: library) {
				System.out.println(b.getIndex());
				if (b.getIndex()==index) {
					
					System.out.println("Please the Name of the book");
					BufferedReader reader12 = new BufferedReader(new InputStreamReader(
							System.in));
					String name1 = reader12.readLine();
					System.out.println("Enter ISBN");
					BufferedReader reader123 = new BufferedReader(new InputStreamReader(
							System.in));
					String isbn1 = reader123.readLine();
					System.out.println("Enter author name");
					BufferedReader reader1234 = new BufferedReader(new InputStreamReader(
							System.in));
					String author1 = reader1234.readLine();
					System.out.println("dd");
					b.setName(name1,isbn1,author1);
					library.set(index,b);
					System.out.println("Book is upddated");
					op=false;
					break;
				
				}
				op =false;
			}
		}
		
	}
	
	
	static void printAllBooks(ArrayList<Book> lib) {

		System.out.println("Index" + "\t" + "Name"+"\t"+ "ISBN"
				+ "\t"+"\t"+ "Author"+ "\t");
		for (Book i : lib) {
			System.out.printf("%s \t %s \t %s \t %s \t",
					i.getIndex(), i.getName(i), i.getISBN(), i.getAuthor());
			System.out.println();
		}

	}
	
	static void printAlluser(ArrayList<user> use) {
		System.out.println("Name"+"\t"+"libno"+"\t");
		for (user j : use) {
			System.out.printf("%s \t %s \t", j.getName(), j.getLibno());
			System.out.println();
		}
	}

}
