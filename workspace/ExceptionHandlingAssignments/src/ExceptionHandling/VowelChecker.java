package ExceptionHandling;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class NoVowelsException extends Exception {
    public NoVowelsException(String message) {
        super(message);
    }
}

public class VowelChecker {
	public static void main(String[] args) {
		 try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter any string ");
	            String inputString = scanner.next(); 
	            checkForVowels(inputString);
	            System.out.println("The string contains vowels.");
	        } catch (NoVowelsException e) {
	            System.out.println(e.getMessage());
	        }
	}
	
	 public static void checkForVowels(String input) throws NoVowelsException  {
	        Set<Character> vowels = new HashSet<>();
	        vowels.add('a');
	        vowels.add('e');
	        vowels.add('i');
	        vowels.add('o');
	        vowels.add('u');
	        input = input.toLowerCase();
	        for (char c : input.toCharArray()) {
	            if (vowels.contains(c)) {
	                return; 
	            }
	        }
	        throw new NoVowelsException("Error: The string does not contain any vowels.");
	    }
}
