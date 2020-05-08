import java.util.Comparator;

public class PriceSort implements Comparator<Book>{
	public int compare(Book b1, Book b2) {
		return (int) Math.ceil(b1.price-b2.price);
	}
}
