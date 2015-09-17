package utility.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileLineImport {

	public static ArrayList<String> readTextFileToArrayList(String path){
		ArrayList<String> content = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       content.add(line);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return content;
	}
}
