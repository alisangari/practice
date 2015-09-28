package moji;

import java.util.ArrayList;

import utility.file.FileGridImport;
import utility.sort.SortChar;
import utility.string.Strings;

public class AnagramSample {
	public static void main(String[] args) {
		System.out.println("$$$$$$$$$$$$$$$$$$");
		ArrayList<ArrayList<String>> fileContent3 = FileGridImport.readTextFileTo2dArrayList("files/Anagram1.txt",",");
		for (ArrayList<String> list : fileContent3) {
			String s1= getNormalized(list.get(0));
			String s2= getNormalized(list.get(1));
			s1 = SortChar.selectionSort(s1.toString().toLowerCase());
			s2 = SortChar.selectionSort(s2.toString().toLowerCase());
			if(s1.equalsIgnoreCase(s2)){
				System.out.println("Valid");
			}else
				System.out.println("Invalid");
		}
	}
	public static boolean isAnagram(String first, String second){
		return false;
	}
	public static String getNormalized(String str){
		return Strings.removeSubString(str, "\\s+");
	}
}
