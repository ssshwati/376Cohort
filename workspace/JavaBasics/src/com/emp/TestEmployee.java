package com.emp;

import com.emp.utility.Address;

public class TestEmployee {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to java");
//		Employee e1 = new Employee(239, "Shwati", "Kumari");
//		e1.setId(239);
//		e1.setfName("Shwati");
//		e1.setlName("Kumari");
//		Employee e2 = new Employee(240, "Harsh", "Kankane");
//		e2.setId(240);
//		e2.setfName("Shweta");
//		e2.setlName("Kumari");
		
		Address a1 = new Address("India", "Bangalore", 560068);
//		a1.setCountry("India");
//		a1.setCity("Purnea");
//		a1.setZip(560068);
//		e1.setAddr(a1);
		Employee e1 = new Employee(239, "Shwati", "Kumari",a1);
		
		
		Address a2 = new Address("India", "Orai", 285001);
//		a2.setCountry("India");
//		a2.setCity("Bangalore");
//		a2.setZip(854301);
//		e2.setAddr(a2);
		Employee e2 = new Employee(240, "Harsh", "Kankane",a2);
		
		
		a1.setCity("Purnea");
		e1.setAddr(a1);
		
//		System.out.println(e1.getId() +" " + e1.getfName()+ " "+ e1.getlName());
//		System.out.println(e1.getfName()+ " " + e1.getAddr().getCountry());
//		System.out.println(e1.getfName()+ " " + e1.getAddr().getCity());
//		System.out.println(e1.getfName()+ " " + e1.getAddr().getZip());
//		System.out.println(e2.getId() +" " + e2.getfName()+ " "+ e2.getlName());
//		System.out.println(e2.getfName()+ " " + e2.getAddr().getCountry());
//		System.out.println(e2.getfName()+ " " + e2.getAddr().getCity());
//		System.out.println(e2.getfName()+ " " + e2.getAddr().getZip());

		System.out.println(e1.toString());
		System.out.println(e2.toString());
		
	}
	
}
