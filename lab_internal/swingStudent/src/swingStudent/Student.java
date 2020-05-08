package swingStudent;

public class Student {
	String name, usn, sex;
	int age;
	double cgpa;
	Student(String n, String u, String s, int a, double c){
		name = n;
		usn = u;
		sex = s;
		age = a;
		cgpa = c;
	}

	public String toString() {
		return "Name: "+name+
				"\nUSN: "+usn+
				"\nSex: "+sex+
				"\nAge: "+age+
				"\nCGPA: "+cgpa+"\n";
	}

}
