public class Student 
{
 int age;
 float avg;
 String name, addr, usn;
 public Student(String name, int age, String usn, String addr,  float avg)
 {
	 this.name=name;
	 this.age=age;
	 this.usn=usn;
	 this.addr=addr; 
	 this.avg=avg;	 	 
 }
 public String toString()
 {
	 return"Name: "+this.name+"\nAddress: "+this.addr+"\nUSN: "+this.usn+"\nAvg: "+this.avg+"\nAge: "+this.age;
	 
 }
}