package com.wileyEdge;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class FileDemo {
	public static void main(String[] args) {
		System.out.println("inside main");
		System.out.println("file copying starts..");
		long startTime = System.currentTimeMillis();		
//		Reader rd = null;
//		Writer fr = null;
		InputStream fis = null;
		OutputStream fos = null;	
		//Buffer IO
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;		
		try {
			// rd = new FileReader("C:\\C376\\abc.txt");
			// fr = new FileWriter("C:\\C376\\pqr.txt");
			File file = new File("C:\\C376\\img.jpg");
			System.out.println("isDirectory " + file.isDirectory());
			System.out.println("isFile "+file.isFile());
			System.out.println("isReadable "+file.canRead());
			System.out.println("isWriteable "+file.canWrite());
			File file2 = new File("C:\\\\C376");
			System.out.println("isDirectory " + file2.isDirectory());
			System.out.println("isFile "+file2.isFile());
			System.out.println("isReadable "+file2.canRead());
			System.out.println("isWriteable "+file2.canWrite());
			File file3 = new File("C:\\\\C376\\myFolder");
			file3.mkdir();
			file3.delete();
//			fis = new FileInputStream("C:\\C376\\img.jpg");
			fis = new FileInputStream(file);
			fos = new FileOutputStream("C:\\C376\\newImg.jpg");
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			try {
				int a = 0;
				while (a != -1) {
//					a = fis.read();
//					fos.write(a);
					a = bis.read();
					bos.write(a);
					// System.out.print((char)a);
				} // end of while
			} // end of inner try
			catch (IOException e) {
				e.printStackTrace();
			} // end of inner catch
		} // end of try
		catch (IOException e) {
			e.printStackTrace();
		} // end of catch
		finally {
			try {
				fis.close();
				fos.close();
				bis.close();
				bos.close();				
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println();
		} // end of finally
		long endTime = System.currentTimeMillis();
		System.out.println("file copied successfully..");
		long timeDuration = endTime - startTime;
		System.out.println("Total time taken in ms "+timeDuration);
		System.out.println("exiting main");
	}
}
