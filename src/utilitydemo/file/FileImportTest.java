package utilitydemo.file;

import java.util.ArrayList;

import utility.file.FileFullImport;
import utility.file.FileGridImport;
import utility.file.FileLineImport;


public class FileImportTest {
	public static void main(String[] args){
		String fileContent = FileFullImport.readTextFile("src/Anagram1.txt");
		System.out.println(fileContent);
		
		ArrayList<String> fileContent2 = FileLineImport.readTextFileToArrayList("src/Anagram1.txt");
		System.out.println(fileContent2);
		
		
		ArrayList<ArrayList<String>> fileContent3 = FileGridImport.readTextFileTo2dArrayList("src/Anagram1.txt",",");
		System.out.println(fileContent3);
	}
}
