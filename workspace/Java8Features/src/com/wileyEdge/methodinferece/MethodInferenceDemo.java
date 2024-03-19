package com.wileyEdge.methodinferece;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MethodInferenceDemo {
	public static void main(String[] args) {
		// four supported types of Method References
		// 1. Constructor Reference with the syntax Class::new and using generics
		// Class<T>:
		// 2. Static method reference with the syntax Class::static_method
		// 3. Instance method of arbitrary object of specific type with the syntax
		// Class::method
		// 4. Instance method of particular object of specific type with
		// instance::method

		// without lambda
		Car c1 = Car.create(new Supplier<Car>() {
			@Override
			public Car get() {
				return new Car();
			}
		});

		// with lambda
		Car c2 = Car.create(() -> new Car());

		// methodInference
		Car c3 = Car.create(Car::new);

		MySupplier<Car> mysup1 = Car::new;
		Car c4 = Car.create1(mysup1, "Maruti");
		MySupplier<Car> mysup2 = Car::new;
		Car c5 = Car.create1(mysup2, "Audi");
		MySupplier<Car> mysup3 = Car::new;
		Car c6 = Car.create1(mysup3, "RR");

		List<Car> cars = new ArrayList<Car>();
		cars.add(c4);
		cars.add(c5);
		cars.add(c6);

		// without lambda
		cars.forEach(new Consumer<Car>() {
			@Override
			public void accept(Car c) {
				Car.doServicing(c);
			}
		});

		// with lambda
		cars.forEach((c) -> Car.doServicing(c));

		// withmethodInference
		cars.forEach(Car::doServicing);

		// arbitrary instance method inference
		cars.forEach(Car::drive);

		// instance method inference
		final Car police = Car.create(Car::new);
		cars.forEach(police::follow);
	}
}
