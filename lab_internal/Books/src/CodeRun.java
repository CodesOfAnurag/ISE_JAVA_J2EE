import java.util.*;

public class CodeRun {
	static void display(ArrayList<Book> arr) {
		for(Book x: arr)
			System.out.println(x);
	}
	
	public static void main(String args[]) {
		ArrayList<Book> bookList = new ArrayList<Book>();
		HashMap<Integer, Book> hmBook = new HashMap<Integer, Book>();
		Scanner sc = new Scanner(System.in);
		char res = '1';
		int isbn = 1000;
		
		while(res=='1') {
			sc.nextLine();
			System.out.println("Enter Details");
			
			System.out.println("ISBN: "+isbn);
			System.out.print("Enter Name: ");
			String name = sc.nextLine();
			
			System.out.print("Enter Publisher: ");
			String pub = sc.nextLine();
			
			System.out.print("Enter Author: ");
			String auth = sc.nextLine();
			
			System.out.print("Enter Price: ");
			float price = sc.nextFloat();
			
			Book temp = new Book(name, auth, pub, price);
			bookList.add(temp);
			hmBook.put(isbn++, temp);
			System.out.println("Added Book\n"+"ISBN: "+(isbn-1)+"\n"+temp);
			
			System.out.print("To Continue adding books, press 1, else press any other key: ");
			res = sc.next().charAt(0);
			
		}
		/*
		bookList.add(new Book("Bharat", "Shyam", "Mohan", (float)169.99));
		bookList.add(new Book("Ram", "Shyam", "Mohan", (float)149.99));

		
		hmBook.put(isbn, new Book("Ram", "Shyam", "Mohan", (float)149.99));
		hmBook.put(++isbn, new Book("Bharat", "Shyam", "Mohan", (float)169.99));
		*/
		System.out.println("All Books added: ");
		display(bookList);
		
		ArrayList<Book> sortedBookList = new ArrayList<Book>(bookList);
		Collections.sort(sortedBookList, new PriceSort());
		System.out.println("Books sorted by price: ");
		display(sortedBookList);
		
		ArrayList<Book> aboveCheckPrice = new ArrayList<Book>();
		System.out.print("Enter lower price: ");
		int checkPrice = sc.nextInt();
		for (Book x: bookList)
			if (x.price>checkPrice)
				aboveCheckPrice.add(x);
		System.out.println("Books with price above "+checkPrice);
		display(aboveCheckPrice);
		sc.nextLine();
		System.out.print("Enter search element: ");
		
		String sub =sc.nextLine();
		System.out.println("BookTitle with subString: "+sub);
		for (Book x: bookList) {
			if (x.name.contains(sub))
				System.out.println(x);
		}
		
		System.out.print("Enter Publisher: ");
		String pub =sc.nextLine();
		System.out.println("Books with publisher: "+pub);
		for (Book x: bookList) {
			if (x.pub.equals(pub))
				System.out.println(x);
		}
		/*
		Set<Map.Entry<Integer, Book>> hmVal= hmBook.entrySet();
		for(Map.Entry<Integer, Book> x: hmVal)
			System.out.println(x.getKey()+"\n"+ x.getValue());
		
		Set<Integer> hmKeys = hmBook.keySet();
		for(Integer x: hmKeys)
			System.out.println(x);
		
		Collection<Book> hmData = hmBook.values();
		for(Book x: hmData)
			System.out.println(x);
		*/
		
	}
	
}
