
public class MissedCall extends Contact{
	String time;
	public MissedCall(String n, long p, String t){
		super(n,p);
		time = t;
	}
	public String toString() {
		return super.toString()+"\nTime: "+time;
	}
}
