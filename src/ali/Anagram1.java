package ali;
import java.util.ArrayList;

import utility.file.FileLineImport;
import utility.sort.SortChar;
import utility.string.Strings;

public class Anagram1 {
	public static void main(String[] args) {

		ArrayList<String> arrList = FileLineImport.readTextFileToArrayList("files/Anagram1.txt");
		
		for(String line: arrList){
			String[] pair = line.split(",");
			pair[0] = Strings.removeSubString(pair[0], "\"");
			pair[0] = Strings.removeSubString(pair[0], "\\s+");
			
			pair[1] = Strings.removeSubString(pair[1], "\"");
			pair[1] = Strings.removeSubString(pair[1], "\\s+");
			
			pair[0] = SortChar.selectionSort(pair[0].toLowerCase());
			pair[1] = SortChar.selectionSort(pair[1].toLowerCase());
			
			if(pair[0].equalsIgnoreCase(pair[1])){
				System.out.println("Valid");
			}
			else{
				System.out.println("Invalid");
			}
			
					
		}
		
	}

	}
