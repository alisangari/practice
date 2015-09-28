package ali;
import java.util.ArrayList;

import utility.file.FileLineImport;
import utility.sort.SortChar;
import utility.string.StringClean;

public class Anagram1 {
	public static void main(String[] args) {

		ArrayList<String> arrList = FileLineImport.readTextFileToArrayList("files/Anagram1.txt");
		
		for(String line: arrList){
			String[] pair = line.split(",");
			pair[0] = StringClean.removeSubString(pair[0], "\"");
			pair[0] = StringClean.removeSubString(pair[0], "\\s+");
			
			pair[1] = StringClean.removeSubString(pair[1], "\"");
			pair[1] = StringClean.removeSubString(pair[1], "\\s+");
			
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
