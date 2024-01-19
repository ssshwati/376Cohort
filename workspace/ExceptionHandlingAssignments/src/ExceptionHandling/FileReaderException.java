package ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderException {
	public static void main(String[] args) {
		try {
			String filePath = "C:\\C376\\abc.txt"; 
			String fileContent = readFile(filePath);
			System.out.println("File content:\n" + fileContent);
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found " + e.getMessage());
		} 
		catch (IOException e) {
			System.out.println("Error reading the file " + e.getMessage());
		}
	}

	// Method to read a file and throw an exception if the file is not found
	public static String readFile(String filePath) throws FileNotFoundException, IOException {
		FileReader file = new FileReader(filePath);
		try (BufferedReader reader = new BufferedReader(file)) {
			StringBuilder content = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append("\n");
			}
			return content.toString();
		}
	}
}
