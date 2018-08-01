package PrototypePattern;

import java.util.List;

public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		Employees emp = new Employees();
		emp.loadData();
		
		Employees emp1 =  (Employees) emp.clone();
		Employees emp2 =  (Employees) emp.clone();
		
		List<String> list1 = emp1.getList();
		List<String> list2 = emp2.getList();
		
		list1.add("Abhijeet");
		list2.add("Pratibha");
		
		System.out.println(list1);
		System.out.println(list2);
	}
}
