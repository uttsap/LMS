package bookManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Issue {
	static ArrayList<Book> library = new ArrayList<Book>();
	
	void reserveBook() throws IOException {
	System.out.println("Please the Index Number");
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	String indexDisplayed = reader.readLine();
	int index = Integer.parseInt(indexDisplayed);
	//ArrayList <Issue> issue = new ArrayList<Issue>();
	for (Book i : library) {
		if (i.getIndex() == index) {
			i.reserve();
			break;
		}
		System.out.println("reserved book with index: " +index);
		System.out.println("The reserved book is:" +i);
	}
	
	
	
	
}

static void returnBook() throws IOException {
	System.out.println("Please the Index Number");
	BufferedReader reader = new BufferedReader(new InputStreamReader(
			System.in));
	String indexDisplayed = reader.readLine();
	int index = Integer.parseInt(indexDisplayed);

	for (Book i : library) {
		if (i.getIndex() == index) {
			i.returnThisBook();
			break;
		}
	}
}
}
