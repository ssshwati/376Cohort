package com.wileyedge.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

class StudentComparator implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		return s1.getName().compareTo(s2.getName());
	}
}

class StudentNameComparator implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		int ret = s2.getName().compareTo(s1.getName());
		return ret;
	}
}

class StudentIdComparator implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		if (s1.getRollno() < s2.getRollno()) {
			return -1;
		} else if (s1.getRollno() == s2.getRollno()) {
			return 0;
		} else {
			return 1;
		}
	}
}

class Student implements Comparable<Student> {
	private int rollno;
	private String name;

	public Student() {
	}

	public Student(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}

	public int getRollno() {
		return this.rollno;
	}

	@Override
	public String toString() {
		return "Student [ rollno=" + rollno + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		System.out.println("inside hashCode method");
		return this.rollno; // hashCode
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("inside equals method");
		if (obj instanceof Student) {
			Student s = (Student) obj;
			if (this.rollno == s.rollno && this.name.equals(s.name)) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	@Override
	public int compareTo(Student s) {
		System.out.println("inside compareTo method");
		if (this.rollno < s.rollno) {
			return -1;
		} else if (this.rollno == s.rollno) {
			return 0;
		} else {
			return 1;
		}
	}

	public String getName() {
		return this.name;
	}
}

class ScienceStudent extends Student {

}

class EngineeringStudent extends ScienceStudent{
	
}

public class COllectionDemo {
	public void testList() {
		List<Object> list = new ArrayList<>(); // ordered, unsorted and allows duplicates
		// List list = new LinkedList();
		// List list = new Vector();
		list.add(5);
		list.add(5);
		list.add(3);
		list.add(7);
		list.add("abc");
		list.add("pqr");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("===================");
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			Object obj = iter.next();
			System.out.println(obj);
		}
	}

	public void testSets() {
//		Set set = new HashSet(); // unique elements, unordered & unsorted
//		Set set = new TreeSet();
//		Set set = new TreeSet(new StudentComparator());
//		Comparator<Student> com = new StudentNameComparator();
		Comparator<Student> com = new StudentIdComparator();
//		Set<Student> set = new TreeSet<>(com);
		Set<? super Student> set = new TreeSet<>(com); //set of anything whose super is student
		set.add(new ScienceStudent());
		set.add(new EngineeringStudent());
//		set.add(5);
//		set.add(5);
//		set.add(3);
//		set.add(7);
//		set.add("abc");
//		set.add("pqr");
		Student s1 = new Student(10, "Adam");
		Student s2 = new Student(5, "Robin");
		Student s3 = new Student(15, "Gary");
		Student s4 = new Student(10, "Adam");
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			Object obj = iter.next();
			System.out.println(obj);
		}
	}
	
	public void testMaps() {
		//Map<Integer,String> map = new HashMap<>();
//		Map<Integer,String> map = new TreeMap<>();
//		map.put(1, "abc");
//		map.put(2, "pqr");
//		map.put(3, "xyz");
		Student s1 = new Student(10, "Adam");
		Student s2 = new Student(5, "Robin");
		Student s3 = new Student(15, "Gary");
		Student s4 = new Student(10, "Adam");
		
		Comparator<Student> comp = new StudentNameComparator();
		Map<Student,Integer> map = new TreeMap<>(comp);
		map.put( s1,10);
		map.put(s2,5);
		map.put( s3,15);
		map.put(s4,20);
		//map.put("1", "lmn");
		Set<Student> set = map.keySet();
		Iterator<Student> iter = set.iterator();
		while (iter.hasNext()) {
			Student key = iter.next();
			Integer value = map.get(key);
			System.out.println(key + " " + value );
		}
	}

	public static void main(String[] args) {
		COllectionDemo demo = new COllectionDemo();
		// demo.testList();
		//demo.testSets();
		demo.testMaps();
	}

}
