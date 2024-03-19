package enumDemo;

enum Gender {
	MALE, FEMALE;
}

enum MathOperator {
	PLUS, MINUS, MULTIPLY, DIVIDE;
}

enum Days {
	MONDAY(100), TUESDAY(101), WEDNESDAY(102), THURSDAY(103), FRIDAY(104), SATURDAY(105), SUNDAY(106);

	int n;

	Days(int x) {
		n = x;
	}

	public int getValue() {
		return n;
	}
}

public class EnumDemo {
	public static int calculate(MathOperator operator, int num1, int num2) {
		switch (operator) {
		case PLUS:
			return num1 + num2;
		case MINUS:
			return num1 - num2;
		case MULTIPLY:
			return num1 * num2;
		case DIVIDE:
			return num1 / num2;
		default:
			throw new UnsupportedOperationException();
		}
	}

	public static void main(String[] args) {
		System.out.println(Gender.MALE);
		System.out.println("===============================");
		System.out.println(calculate(MathOperator.PLUS, 4, 2));
		System.out.println(calculate(MathOperator.MINUS, 4, 2));
		System.out.println(calculate(MathOperator.MULTIPLY, 4, 2));
		System.out.println(calculate(MathOperator.DIVIDE, 4, 2));
		System.out.println("===============================");
		Days aday = Days.FRIDAY;
		switch (aday) {
		case MONDAY:
			System.out.println("oh it's monday..");
			break;
		case FRIDAY:
			System.out.println("yeah it's friday..");
			break;
		case SUNDAY:
			System.out.println("nooooo it's sunday..");
			break;
		}
		System.out.println("===============================");
		Days d = Days.MONDAY;
		switch (d.getValue()) {
		case 100:
			System.out.println("oh it's monday..");
			break;
		case 104:
			System.out.println("yeah it's friday..");
			break;
		case 106:
			System.out.println("nooooo it's sunday..");
			break;
		}
		/*
		 * We use enums to define a set of predefined, related constants We use enums to
		 * define a set of predefined, related constants
		 */
	}
}
