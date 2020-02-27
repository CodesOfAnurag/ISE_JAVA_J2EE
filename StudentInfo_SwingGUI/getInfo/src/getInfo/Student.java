package getInfo;

public class Student {
	String name, age, sex, usn, addr, cgpa;
	Student(String name, String age, String sex, String usn, String addr, String cgpa){
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.usn = usn;
		this.addr = addr;
		this.cgpa = cgpa;
	}
	public String toString() {
		return name + " | " + age  + " | " + sex + " | " + usn + " | " + addr + " | " + cgpa + "\n";
	}
}
