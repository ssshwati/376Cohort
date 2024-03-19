package com.wileyedge.practice;

import java.io.*;
import java.util.*;
class CharacterFrequency {
	static void characterCount(String inputString)
	{
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		char[] strArray = inputString.toCharArray();

		for (char c : strArray) {
			if (charCountMap.containsKey(c)) {
				charCountMap.put(c, charCountMap.get(c) + 1);
			}
			else {
				charCountMap.put(c, 1);
			}
		}

		// Printing the charCountMap
		for (Map.Entry entry : charCountMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	public static void main(String[] args)
	{
		String str = "Shwati";
		characterCount(str);
	}
}
