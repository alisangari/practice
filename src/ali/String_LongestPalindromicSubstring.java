package ali;

import java.util.ArrayList;

import utility.sort.SortString;
import utility.string.StringSubSets;
import utility.string.Strings;

public class String_LongestPalindromicSubstring {

	public static void main(String[] args) {

		String str = "palindromic";
		System.out.println(longestPalindrome(str));

	}

	public static String longestPalindrome(String s) {
		// get all sub strings
		String[] subs = StringSubSets.getAllSubSets(s);
		
		// remove duplicates
		ArrayList<String> uniqueSubs = Strings.removeDuplicates(subs);
		
		// sort from longest to shortest
		String[] t = new String[uniqueSubs.size()];
		for(int i=0; i<t.length; i++){
			t[i] = uniqueSubs.get(i);
		}
		ArrayList<String> sortedSubs = SortString.sortByLength(t);
		
		// get the longest palindormic substring
		for(String str2: sortedSubs){
			if(Strings.isPalindromic(str2)){
				return str2;
			}
		}
		
		return "";
	}

}
