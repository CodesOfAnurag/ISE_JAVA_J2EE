public class Student 
{
 int fees, age;
 String name, addr, usn, type;
 Student(String name, String addr, String usn, String type, int fees, int age)
 {
	 this.name=name;
	 this.addr=addr;
	 this.usn=usn;
	 this.type=type;
	 this.fees=fees;
	 this.age=age;	 
 }
 void display()
 {
	 System.out.println("Name: "+this.name);
	 System.out.println("Address: "+this.addr);
	 System.out.println("USN: "+this.usn);
	 System.out.println("Type: "+this.type);
	 System.out.println("Fees: "+this.fees);
	 System.out.println("Age: "+this.age);	 
 }
}