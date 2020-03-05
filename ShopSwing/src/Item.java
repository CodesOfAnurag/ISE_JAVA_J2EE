
public class Item {
	String name;
	int id, cost;
	Item(int i, int c, String n){
		name=n;
		id=i;
		cost=c;
	}
	public String toString(){
		return "Item ID: "+id+"\nItem Name: "+name+"\nPrice: "+cost;
	}
}
