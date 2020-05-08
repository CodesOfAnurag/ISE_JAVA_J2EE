
public class Contact {
	String name;
	long number;
	public Contact(String n, long p){
		name = n;
		number = p;
	}
	public String toString() {
		return "Name: "+name+"\nPhone: "+number;
	}
}
