package com.wileyedge.annotationDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

@interface Test {
	String info() default "";
}

class Annotated {
	@Test(info = "AWESOME")
	public void foo(String myParam) {
		System.out.println("This is foo " + myParam);
	}

	@Test(info = "GOOD")
	public void zoo(String myParam) {
		System.out.println("This is zoo " + myParam);
	}
}

class TestAnnotationParser {
	public void parse(Class cls) throws Exception {
		Method[] methods = cls.getMethods();
		for (Method m : methods) {
			if (m.isAnnotationPresent(Test.class)) {
				Test test = m.getAnnotation(Test.class);
				String info = test.info();
				if ("AWESOME".equals(info)) {
					m.invoke(Annotated.class.newInstance(), "cool");
				}
			}
		}
	}
}

public class AnnotationDemo {
	public static void main(String[] args) throws Exception {
		TestAnnotationParser demo = new TestAnnotationParser();
		demo.parse(Annotated.class);
	}
}
