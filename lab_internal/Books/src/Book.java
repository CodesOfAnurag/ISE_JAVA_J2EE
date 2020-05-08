public class Book {
	float price;
	String name, pub, auth;
	Book(String n, String a, String p, float c){
		name=n;
		auth=a;
		pub=p;
		price=c;
	}
	public String toString() {
		return 	"Name: "+name+"\n"+
				"Author: "+auth+"\n"+
				"Publisher: "+pub+"\n"+
				"Price: "+price+"\n";
	}
}
