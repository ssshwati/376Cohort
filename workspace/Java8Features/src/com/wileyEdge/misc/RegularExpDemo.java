package com.wileyEdge.misc;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegularExpDemo {

	public static void main(String[] args) {
		// first way
		Pattern p = Pattern.compile("..i.");
		Matcher m = p.matcher("amit");
		boolean b1 = m.matches(); // true bcoz 3rd char of p contains i
		System.out.println(b1);

		// second way
		boolean b2 = Pattern.compile(".s").matcher("as").matches();
		System.out.println(b2);

		// third way
		boolean b3 = Pattern.matches(".s", "as");
		System.out.println(b3);

		/// fourth way
		System.out.println(Pattern.matches("[amt]", "t"));
		System.out.println(Pattern.matches("[amt]*", "t"));
		System.out.println("hello " + Pattern.matches("[a-zA-z]+", "tt"));
		System.out.println(Pattern.matches("\\d*", "123"));
		System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "amit41"));
		String password = "12%password";
		System.out.println("myPassword " + Pattern.matches("(?=.*[a-zA-Z])(?=.*\\d)(?=.*[^a-zA-Z\\d]).{5,}", password));

		/*
		 * (?=.*[a-zA-Z]): Positive lookahead assertion for at least one alphabetic
		 * character. This part ensures that the password contains at least one letter.
		 * 
		 * (?=.*\d): Positive lookahead assertion for at least one digit. This part
		 * ensures that the password contains at least one digit.
		 * 
		 * (?=.*[^a-zA-Z\d]): Positive lookahead assertion for at least one character
		 * that is neither alphabetic nor a digit. This part ensures that the password
		 * contains at least one non-alphanumeric character.
		 * 
		 * .{5,}: Matches any character (except for a newline character) at least 5
		 * times. This part ensures that the total length of the password is at least 5
		 * characters.
		 */
	}

}
