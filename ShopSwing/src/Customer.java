
public class Customer {
	int id, phone;
	String name;
	Customer(int i, int no, String n){
		id=i;
		phone=no;
		name=n;
	}
	public String toString(){
		return "Customer Id: "+id+"\nCustomer Name: "+name+"\nCustomer Phone: "+phone;
	}
}
