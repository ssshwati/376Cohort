package com.str.Utility;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Hello";
		String s2 = new String("Hello");
		if (s1 == s2) {
			System.out.println("both are pointing to same memory location");
		} else {
			System.out.println("both are pointing to different memory location");
		}
		
		if (s1.equals(s2)) {
			System.out.println("both are equal");
		} else {
			System.out.println("both are unequal");
		}
		
		String s3 = s1.concat("world");
		System.out.println(s3);
		System.out.println(s3.substring(2));
		System.out.println(s3.substring(2,5));
		System.out.println(s3.indexOf('l'));
		System.out.println(s3.lastIndexOf('l'));
		System.out.println(s3.indexOf("ll"));
		System.out.println(s3.replace("l", "p"));
		String[] strarr = s3.split("ll");
		for(String s : strarr)
		{
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println(s3.startsWith("hell"));
		System.out.println(s3.toUpperCase());
		System.out.println(s3.toLowerCase());
	}

}
