package bookManager;

import java.util.ArrayList;

public class Updater {
	static ArrayList<Book> library = new ArrayList<Book>();
	public void update(Book b, String name1, String ISBN1, String author1) {
		int a = library.indexOf(b);
		Book boo= new Book(name1,ISBN1,author1);
		b = new Book(name1, ISBN1, author1);
		library.add(a,boo);
	}
}
