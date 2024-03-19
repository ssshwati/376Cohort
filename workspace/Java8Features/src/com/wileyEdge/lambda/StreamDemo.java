package com.wileyEdge.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Status {
	OPEN, CLOSED
}

class Student1 {
	String name;
	private Set<String> certifications;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getCertifications() {
		return certifications;
	}

	public void setCertifications(Set<String> certifications) {
		this.certifications = certifications;
	}

	public void addCertification(String certi) {
		if (this.certifications == null) {
			this.certifications = new HashSet<>();
		}
		this.certifications.add(certi);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", certifications=" + certifications + "]";
	}

}

class Person {
	private String name;
	private String gender;
	private int age;

	public Person(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}

}

class Task {
	private int points;
	private Status status;

	public Task(int points, Status status) {
		this.points = points;
		this.status = status;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}

public class StreamDemo {
	public static void main(String[] args) {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(8, Status.OPEN));
		tasks.add(new Task(5, Status.OPEN));
		tasks.add(new Task(10, Status.CLOSED));

		// calculate some of points of only OPEN tasks
		/*
		 * Firstly, the tasks collection is converted to its stream representation.
		 * Then, the filter operation on stream filters out all CLOSED tasks. On next
		 * step, the mapToInt operation converts the stream of Tasks to the stream of
		 * Integers using Task::getPoints method of the each task instance. And lastly,
		 * all points are summed up using sum method, producing the final result.
		 */
		/*
		 * Stream operations are divided into intermediate and terminal operations.
		 * Intermediate operations return a new stream. e.g. Filter filter does not
		 * actually perform any filtering, but instead creates a new stream that, when
		 * traversed, contains the elements of the initial stream that match the given
		 * predicate. Intermediate operations are always Lazy.
		 */
		/*
		 * Terminal operations may traverse the stream to produce a result or a
		 * side-effect. e.g. forEach or sum After the terminal operation is performed,
		 * the stream pipeline is considered consumed, and can no longer be used.
		 * Terminal operations are eager.
		 */
		int result = tasks.stream().filter(task -> task.getStatus() == Status.OPEN).mapToInt((t) -> t.getPoints())
				.sum();
		System.out.println(result);
		System.out.println("==========================");
		Set<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(2);
		list.add(9);
		list.add(7);
		System.out.println("=====forEach with Lambda=========");
		list.forEach((t) -> System.out.println(t));
		System.out.println("=====forEach with Method Inference=======");
		list.forEach(System.out::println);
		System.out.println("======forEach on Stream=========");
		list.stream().forEach(System.out::println);
		System.out.println("====forEach on Stream.parallel()=======");
		list.stream().parallel().forEach(System.out::println);
		/*
		 * parallel() : the stream is split into multiple chunks, with each chunk
		 * processed independently and with the result summarized at the end.
		 */
		System.out.println("=====for each with stream and parallel but maintaing order=====");
		list.stream().parallel().forEachOrdered(System.out::println);
		System.out.println("==========================");

		Set<Object> set1 = new HashSet<>();
		set1.add(5);
		set1.add("amit");
		set1.add("3");
		set1.stream().mapToInt(new ToIntFunction<Object>() {
			@Override
			public int applyAsInt(Object value) {
				if (value instanceof String) {
					try {
						return Integer.parseInt(value.toString());
					} catch (NumberFormatException nfe) {
						return 0;
					}
				} else if (value instanceof Integer) {
					return ((Integer) value).intValue();
				} else {
					return 0;
				}
			}
		}).forEach(System.out::println);

		System.out.println("==========================");
		set1.stream().mapToInt((value) -> {
			if (value instanceof String) {
				try {
					return Integer.parseInt(value.toString());
				} catch (NumberFormatException nfe) {
					return 0;
				}
			} else if (value instanceof Integer) {
				return ((Integer) value).intValue();
			} else {
				return 0;
			}
		}).forEach(System.out::println);

		System.out.println("=====square of numbers of list========");
		list.stream().mapToInt(number -> number * number).forEach(System.out::println);

		System.out.println("==============");
		OptionalDouble od = list.stream().mapToInt(number -> number * 2).average();
		if (od.isPresent()) {
			System.out.println("average value " + od.getAsDouble());
		}

		System.out.println("==============");
		// Returns an OptionalInt describing some element of the stream, or an empty
		// OptionalInt if the stream is empty.
		OptionalInt opInt1 = list.stream().mapToInt(number -> number * 2).findAny();
		if (opInt1.isPresent()) {
			System.out.println("findAny " + opInt1.getAsInt());
		}

		System.out.println("==============");
		// Returns an OptionalInt describing the first element of this stream, or an
		// empty OptionalInt if the stream is empty.
		OptionalInt opInt2 = list.stream().mapToInt(number -> number * 2).findFirst();
		if (opInt2.isPresent()) {
			System.out.println("findFirst " + opInt2.getAsInt());
		}

		System.out.println("==============");
		OptionalInt opInt3 = list.stream().mapToInt(number -> number * 2).max();
		if (opInt3.isPresent()) {
			System.out.println("The max number = " + opInt3.getAsInt());
		}
		System.out.println("The max number = " + list.stream().mapToInt(number -> number * 2).max().getAsInt());

		System.out.println("==============");
		System.out.println("The sum is = " + list.stream().mapToInt(number -> number * 2).sum());

		System.out.println("===isAnyMatch, isALlMatch====");
		boolean isAnyMatch = list.stream().mapToInt(number -> number * 2).anyMatch(new IntPredicate() {
			@Override
			public boolean test(int value) {
				if (value == 10) {
					return true;
				} else {
					return false;
				}
			}
		});
		isAnyMatch = list.stream().mapToInt((s) -> (int) s * 2).anyMatch((n) -> n == 10);
		System.out.println("isAnyMatch : " + isAnyMatch);

		boolean isAllMatch = list.stream().mapToInt((s) -> (int) s * 2).allMatch((n) -> n > 3);
		System.out.println("isAllMatch : " + isAllMatch);

		System.out.println("==============");
		// The Collectors class has a few imp methods like averagingInt and groupingBy
		List<Integer> intlist = Arrays.asList(5, 9, 7, 2);
		Double db = intlist.stream().map(new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer t) {
				return t * 2;
			}
		}).collect(Collectors.averagingInt(x -> x * 2));
		System.out.println(db);

		System.out.println("==============");
		Double db1 = intlist.stream().map((x) -> x * 2).collect(Collectors.averagingInt((x) -> x * 2));
		System.out.println(db1);

		System.out.println("==============================");
		List<Person> persons = Arrays.asList(new Person("Amit", "Male", 38), new Person("Prachi", "Female", 34),
				new Person("Banesh", "Male", 22));
		OptionalDouble averageAgeOfMales = persons.stream().filter(person -> "Male".equals(person.getGender()))
				.mapToInt(Person -> Person.getAge()).average();
		if (averageAgeOfMales.isPresent()) {
			System.out.println("Average age of males: " + averageAgeOfMales.getAsDouble());
		}

		System.out.println("==============================");
//		Map<String,List<Person>> namesPerGender = persons.stream().collect(Collectors.groupingBy(new Function<Person,String>(){
//			@Override
//			public String apply(Person t) {
//				return t.getGender();
//			}
//		}));
//		System.out.println(namesPerGender);

		Map<String, List<Person>> namesPerGender1 = persons.stream()
				.collect(Collectors.groupingBy((person) -> person.getGender()));
		System.out.println(namesPerGender1);

//		persons.removeIf((Person p)-> p.getName().equalsIgnoreCase("Amit") );
		namesPerGender1.computeIfPresent("Male", (gender, personlist) -> {
			personlist.removeIf((Person p) -> {
				return (p.getName().equalsIgnoreCase("Banesh"));
			});
			return personlist;
		});
		System.out.println(namesPerGender1);

		System.out.println("==============================");
		System.out.println("==============================");
		// flatmap works in case of nested fors - { {1,2}, {3,4}, {5,6} } -> flatMap ->
		// {1,2,3,4,5,6}
		Student1 s1 = new Student1();
		s1.setName("Amit");
		s1.addCertification("SCJP");
		s1.addCertification("SCWCD");
		s1.addCertification("OCJP");
		Student1 s2 = new Student1();
		s2.setName("Sujay");
		s2.addCertification("BCD");
		s2.addCertification("Oracle");
		List<Student1> studList = new ArrayList<>();
		studList.add(s1);
		studList.add(s2);
		//studList.stream().map((x)->x.getCertifications());
		//it will return Stream<Set<String>>  
		studList.stream().map((x)->x.getCertifications()).flatMap((x)->x.stream()).forEach(System.out :: println);
		//it will return stream of strong
	}
}
