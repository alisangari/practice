package ali;

import java.util.ArrayList;
import java.util.List;

public class String_GroupAnagrams {

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
	public static void main(String[] args){
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		groupAnagrams(strs);
	}
	
	 private static List<List<String>> groupAnagrams(String[] strs) {
	        List<List<String>> res = new ArrayList<List<String>>();
	        String[] sortedCharStrs = new String[strs.length];
	        for(int i=0; i<strs.length; i++){
	        	
	        }
	        
	        return res;
	    }
	 
}
