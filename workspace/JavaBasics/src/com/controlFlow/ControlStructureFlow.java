package com.controlFlow;

public class ControlStructureFlow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2;
		if(a==1)
		{
			System.out.println("good morning");
		}else if(a==2){
			System.out.println("good noon");
		}else
		{
			System.out.println("good evening");
		}
		
		
		int i = 0;
		System.out.println("while");
		while(i<5)
		{
			System.out.println(i);
			i++;
		}
		
		i=0;
		do {
			System.out.println(i);
			i++;
		}while(i<5);
	}
	

}
