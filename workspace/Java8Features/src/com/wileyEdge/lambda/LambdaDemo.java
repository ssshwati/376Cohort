package com.wileyEdge.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

@FunctionalInterface
interface Greetable {
	String greet(String name);
}

@FunctionalInterface
interface Addable {
	int add(int a, int b);
}

class AddableImpl implements Addable {
	@Override
	public int add(int a, int b) {
		return a + b;
	}
}

class GreetableImpl implements Greetable {
	@Override
	public String greet(String name) {
		System.out.println("inside child class GreetableImpl");
		return "welcome " + name;
	}
}

class Student implements Comparable<Student>{
	private int roll;
	private String name;

	public Student(int roll, String name) {
		this.roll = roll;
		this.name = name;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Student s) {
		if(this.roll < s.roll){
			return -1;
		}else if(this.roll == s.roll) {
			return 0;
		}else {
			return 1;
		}
	}

}

public class LambdaDemo {

	public void useLambdaInForLoop() {
		List<String> list = new ArrayList<>();
		list.add("Shwati");
		list.add("Harsh");
//		list.add("Sumit");
		Consumer<String> c1 = new Consumer<>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		list.forEach((t) -> System.out.println(t));

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public void useLambdaInThreading() {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {

			}
		};

		Runnable r2 = () -> System.out.println("Thread is spawn ");
		Thread t1 = new Thread(r2);
		t1.start();

		Thread t2 = new Thread(() -> System.out.println("Thread is spawned"));
		t2.start();
	}

	public void useLambdaInCollection() {
		List<Student> list = new ArrayList<>();
		list.add(new Student(33, "Shwati"));
		list.add(new Student(32, "Shweta"));
		list.add(new Student(15, "Soumya"));
		
		System.out.println("========ANonymous class===========");
		Comparator<Student> comp1 = new Comparator<>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.getName().compareTo(s2.getName());
			}
		};
		Collections.sort(list, comp1);
		Consumer<Student> cons1 = new Consumer<>() {
			@Override
			public void accept(Student t) {
				System.out.println(t);
			}		
		};
		list.forEach(cons1);
		
		System.out.println("========Lambda function===========");
		
		Collections.sort(list,(Student s1, Student s2)->s1.getName().compareTo(s2.getName()));
		list.forEach((Student t) -> System.out.println(t));
		
		System.out.println("========Reversed method===========");
		Collections.sort(list,comp1.reversed());
		list.forEach((Student t) -> System.out.println(t));
		
		System.out.println("========Reversed order method===========");
		Comparator<Student> comp2 = (Comparator<Student>) Comparator.reverseOrder();
		Collections.sort(list,comp2);
		list.forEach((Student t) -> System.out.println(t));
		
		System.out.println("===================");
		Stream<Student> filteredData = list.stream().filter(s -> s.getRoll()>5);
		System.out.println("No of students having roll number greater than 5 : " + filteredData.count());
	}

	public void doBehaviourPassing() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int result1 = sumAll(numbers);
		System.out.println(result1);
		int result2 = sumAllEven(numbers);
		System.out.println(result2);
		System.out.println("============Predicate Lambdas==============");
		int result3 = sumAll(numbers,n -> true);
		System.out.println(result3);
		int result4 = sumAll(numbers,n -> n % 2 == 0);
		System.out.println(result4);
		int result5 = sumAll(numbers,n -> n >3);
		System.out.println(result5);
	}
	
	private int sumAll(List<Integer> numbers) {
		int total = 0;
		for(int num :numbers) {
			total+=num;
		}
		return total;
	}
	
	private int sumAllEven(List<Integer> numbers) {
		int total = 0;
		for(int num :numbers) {
			if(num%2==0) {
				total+=num;
			}			
		}
		return total;
	}
	
	private int sumAll(List<Integer> numbers, Predicate<Integer> p) {
		int total = 0;
		for(int num : numbers) {
			if(p.test(num)) {
				total+=num;
			}
		}
		return total;
	}
	
	public void doBinaryOperations() {
		BinaryOperator<Integer> binop1 = new BinaryOperator<>() {
			@Override
			public Integer apply(Integer t, Integer u) {
				return t+u;
			}		
		};
		
		BinaryOperator<Integer> binop2 = (t,u) -> t+u ;
		List<Integer> numbers = Arrays.asList(20, 10);
		int result1 = performBinaryOp(numbers,(i,j)->i+j);
		int result2 = performBinaryOp(numbers,(i,j)->i-j);
		System.out.println(result1);
		System.out.println(result2);
	}
	
	private int performBinaryOp(List<Integer> numbers,BinaryOperator<Integer> bin) {
		return bin.apply(numbers.get(0),numbers.get(1) );
	}
	
	public static void main(String[] args) {
		Greetable gt1 = new GreetableImpl();
		System.out.println(gt1.greet("Shwati"));

		Greetable gt2 = new Greetable() {
			@Override
			public String greet(String name) {
				System.out.println("inside anonymous inner class");
				return "welcome " + name;
			}
		};
		System.out.println(gt2.greet("Kaju"));

		Greetable gt3 = (name) -> "welcome in lambda " + name;
		System.out.println(gt3.greet("Zoya"));

		Addable a1 = new AddableImpl();
		System.out.println("adding normal " + a1.add(5, 7));

		Addable a2 = new AddableImpl() {
			@Override
			public int add(int a, int b) {
				return a + b;
			}
		};
		System.out.println("adding in anonymous function " + a2.add(5, 3));

		Addable a3 = (a, b) -> (a + b);
		System.out.println("adding in lambda " + a3.add(5, 1));

		LambdaDemo demo = new LambdaDemo();
		demo.useLambdaInForLoop();
		demo.useLambdaInThreading();

		System.out.println("==========================");
		demo.useLambdaInCollection();
		
		System.out.println("==========================");
		demo.doBehaviourPassing();
		
		System.out.println("==========================");
		demo.doBinaryOperations();
	}

}
