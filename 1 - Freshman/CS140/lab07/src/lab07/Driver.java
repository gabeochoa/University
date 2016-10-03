package lab07;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {
	public static void main(String[] args){
		ArrayList<Student> list = new ArrayList<Student>();
		Person p1 = new Person("James", "chai");
		list.add(new Student(p1, "B08"));
		Person p2 = new Person("jk", "moon");
		list.add(new GraduateStudent(p2, "B02", "Accounting"));
		Person p3 = new Person("Mike", "Miller");
		list.add(new Student(p3, "B07"));
		
		Collections.sort(list, new studentComparator());
		System.out.println(list);
	}
}
