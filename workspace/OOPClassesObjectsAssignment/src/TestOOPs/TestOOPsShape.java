package TestOOPs;

import com.OOPClassesObjects.Rectangle;
import com.OOPClassesObjects.Shape;
import com.OOPClassesObjects.Triangle;

public class TestOOPsShape {

	public static void main(String[] args) {
		
		Rectangle rectangle1=new Rectangle();
		System.out.println("Rectangle Area: " + rectangle1.calculateArea());
		System.out.println("Rectangle Perimeter: " + rectangle1.calculatePerimeter());

		Rectangle rectangle2 = new Rectangle(5, 7);
		System.out.println("Rectangle Area: " + rectangle2.calculateArea());
		System.out.println("Rectangle Perimeter: " + rectangle2.calculatePerimeter());

		// Creating a Triangle
		Triangle triangle = new Triangle(4, 6);
		System.out.println("Triangle Area: " + triangle.calculateArea());

		// Using Shape reference to demonstrate polymorphism
		Shape shape;

		// Assigning a Rectangle to Shape reference
		shape = new Rectangle(3,9);
		System.out.println("Shape (Rectangle) Area: " + shape.calculateArea());

		// Assigning a Triangle to Shape reference
		shape = new Triangle(3,7);
		System.out.println("Shape (Triangle) Area: " + shape.calculateArea());

	}

}
