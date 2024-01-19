package ExceptionHandling;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class DuplicateNumberException extends Exception {
	public DuplicateNumberException(String message) {
		super(message);
	}
}

public class DuplicateNumberChecker {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the number of integers: ");
			int count = scanner.nextInt();
			System.out.println("Enter the integers, one by one:");
//			Set<Integer> numberSet = new HashSet<>();
//			for (int i = 0; i < count; i++) {
//				int num = scanner.nextInt();
//				// Check for duplicates
//				if (!numberSet.add(num)) {
//					throw new DuplicateNumberException("Error: Duplicate number found : " + num);
//				}
//			}
			
			List<Integer> numberList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                int num = scanner.nextInt();
                // Check for duplicates
                if (numberList.contains(num)) {
                    throw new DuplicateNumberException("Error: Duplicate number found : " + num);
                }
                numberList.add(num);
            }
			System.out.println("No duplicates found. All numbers are unique.");
		} catch (DuplicateNumberException e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("ALL DONE !!");
		}
	}
}

