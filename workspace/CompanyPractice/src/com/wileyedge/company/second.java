package com.wileyedge.company;

import java.util.Stack;

public class second {

	public static boolean valid(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				st.push(ch);
			} else {
				if (st.isEmpty()) {
					return false;
				}
				char top = st.pop();
				if(ch==')' && top!= '(')
				{
					return false;
				}
			}
		}

		return st.isEmpty();
	}

	public static void main(String[] args) {
		String s = "(())";
		boolean res = valid(s);
		System.out.println(res);
	}

}
