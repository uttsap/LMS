package bookManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Issue {
	ArrayList <user> user = new ArrayList<user>();
	static void reserveBook(List<Book> library) throws IOException {
		System.out.println("Please the Book Index Number");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String indexDisplayed = reader.readLine();
		String name = reader.readLine();
		int index = Integer.parseInt(indexDisplayed);

		for (Book i : library) {
			if (i.getIndex() == index) {
				i.reserve();
				break;
			} 
			
		}
	} 

	static void returnBook(List<Book> library) throws IOException {
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
