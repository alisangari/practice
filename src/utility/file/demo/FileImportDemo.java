package utility.file.demo;

import java.util.ArrayList;

import utility.file.FileFullImport;
import utility.file.FileGridImport;
import utility.file.FileLineImport;


public class FileImportDemo {
	public static void main(String[] args){
		String fileContent = FileFullImport.readTextFile("files/Anagram1.txt");
		System.out.println(fileContent);
		
		ArrayList<String> fileContent2 = FileLineImport.readTextFileToArrayList("files/Anagram1.txt");
		System.out.println(fileContent2);
		
		
		ArrayList<ArrayList<String>> fileContent3 = FileGridImport.readTextFileTo2dArrayList("files/Anagram1.txt",",");
		System.out.println(fileContent3);
	}
}
