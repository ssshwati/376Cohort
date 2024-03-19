package com.wileyEdge;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class DESerialisationDemo {
	public static void main(String[] args) {
		InputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("C:\\C376\\student.ser");
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			Object obj = ois.readObject();
			if(obj instanceof Student) {
				Student s = (Student)obj;
				System.out.println(s);
			}
			//System.out.println(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("deserialisation done ");
	}
}
