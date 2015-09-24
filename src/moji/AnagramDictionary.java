package moji;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import utility.file.FileGridImport;
import utility.file.FileLineImport;
import utility.sort.SortChar;
import utility.string.StringClean;

// Given an array of strings, group anagrams together.
//
// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Return:
//
// [
// ["ate", "eat","tea"],
// ["nat","tan"],
// ["bat"]
// ]
// Note:
// For the return value, each inner list's elements must follow the
// lexicographic order.
// All inputs will be in lower-case.
public class AnagramDictionary {

	public static void main(String[] args) {
		getAnagrams(FileGridImport.readTextFileTo2dArrayList("files/moji/AnagramDictionary.txt",",").get(0));
	}
	public static void getAnagrams(ArrayList<String> strs){
		Map<String,ArrayList<String>> dictionary = new HashMap<>();
		for (String str : strs) {
			str = StringClean.removeSubString(str, "\\s+");
			String key = SortChar.selectionSort(str);
			if(dictionary.get(key) != null){
				dictionary.get(key).add(str);
			}else{
				ArrayList<String> lst = new ArrayList<>();
				lst.add(str);
				dictionary.put(key,lst);
			}
		}
		for (Entry<String, ArrayList<String>> entry : dictionary.entrySet()) {
			System.out.println(entry.getValue().toString());
			System.out.println();
		}
	}

}
