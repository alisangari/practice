package ali;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utility.file.FileFullImport;
import utility.sort.SortChar;

public class String_ValidAnagram {

	// Given two strings s and t, write a function to determine if t is an
	// anagram of s.
	//
	// For example,
	// s = "anagram", t = "nagaram", return true.
	// s = "rat", t = "car", return false.
	//
	// Note:
	// You may assume the string contains only lowercase alphabets.
	public static void main(String[] args) {
		String str = FileFullImport
				.readTextFile("files/String_ValidAnagram.txt");
		String[] strs = str.split(",");
		strs[0] = strs[0].replaceAll("\"", "");
		strs[0] = strs[0].trim();

		strs[1] = strs[1].replaceAll("\"", "");
		strs[1] = strs[1].trim();

		boolean res;

		long t1;

		// t1 = System.nanoTime();
		// res = isAnagram(strs[0], strs[1]);
		// System.out.println(System.nanoTime() - t1 + " - " + res);

		t1 = System.nanoTime();
		 res = isAnagram2(strs[0], strs[1]);
//		res = isAnagram2("aaacc", "accac");
		System.out.println(System.nanoTime() - t1 + " - " + res);

		t1 = System.nanoTime();
		 res = isAnagram3(strs[0], strs[1]);
//		res = isAnagram3("aacc", "ccac");
		System.out.println(System.nanoTime() - t1 + " - " + res);
	}

	private static boolean isAnagram3(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		StringBuilder sbt = new StringBuilder(t);
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < sbt.length(); j++) {
				if (s.charAt(i) == sbt.charAt(j)) {
					sbt.deleteCharAt(j);
					break;
				}
				if (j >= sbt.length() - 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isAnagram2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		List<String> arrS = Arrays.asList(s.split(""));
		List<String> arrT = new ArrayList<String>();
		String[] tarr = t.split("");
		for(int i=0; i<t.length(); i++){
			arrT.add(tarr[i]); 
		}

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < arrT.size(); j++) {
				if (arrS.get(i).equalsIgnoreCase(arrT.get(j))) {
					arrT.remove(j);
					break;
				}
				if (j >= arrT.size() - 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isAnagram(String s, String t) {
		return (SortChar.mergeSort(s).equalsIgnoreCase(SortChar.mergeSort(t)));
	}

}
