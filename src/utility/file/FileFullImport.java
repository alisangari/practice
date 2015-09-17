package utility.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileFullImport {
	
	public static String readTextFile(String path){
		StringBuilder content = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       content.append(line);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return content.toString();
	}
}
