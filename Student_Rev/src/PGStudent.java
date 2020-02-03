
public class PGStudent extends Student
{
	int sems, creds;
	PGStudent(String name, String addr, String usn, String type, int fees, int age, int sems, int creds)
	{
		super(name, addr, usn, type, fees, age);
		this.sems=sems;
		this.creds=creds;
		try
		{
			if (creds<100 && type.equals("reg"))
				throw new CreditException();
		}
		catch(CreditException e)
		{
			System.out.println(e);
		}
	}
	void disp(){
		super.display();
		System.out.println("Sem: "+ sems);
		System.out.println("Credsd: "+ creds);
	}
}