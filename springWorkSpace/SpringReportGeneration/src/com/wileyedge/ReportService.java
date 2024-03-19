package com.wileyedge;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ReportService {

	private String filename;
	private PrintWriter writer;
	
	public ReportService() {
		System.out.println("default cons of ReportService");
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		System.out.println("setFilename of ReportService");
		this.filename = filename;
	}
	
	public void doinit() {
		System.out.println("doinit of ReportService");
		try {
			this.writer = new PrintWriter(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void generateReport() {
		System.out.println("generateReport of ReportService");
	}
	
	public void close() {
		System.out.println("close of ReportService");
		this.writer.close();
	}
}
