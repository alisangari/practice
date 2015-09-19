package misc;

import java.util.ArrayList;

public class String_CompareVersionNumbers {
//	Compare two version numbers version1 and version2.
//	If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
//
//	You may assume that the version strings are non-empty and contain only digits and the . character.
//	The . character does not represent a decimal point and is used to separate number sequences.
//	For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
//
//	Here is an example of version numbers ordering:
//
//	0.1 < 1.1 < 1.2 < 13.37
	
	
	public static void main(String[] args) {
		int res = compareVersion("01", "1");
		System.out.println(res);

	}

	public static int compareVersion(String version1, String version2) {

		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");

		ArrayList<Integer> v1 = new ArrayList<>();
		ArrayList<Integer> v2 = new ArrayList<>();
		for (int i = 0; i < ver1.length; i++) {
			v1.add(new Integer(ver1[i]));
		}

		for (int i = 0; i < ver2.length; i++) {
			v2.add(new Integer(ver2[i]));
		}

		int i = 0;
		while (i < ver1.length && i < ver2.length) {
			if (v1.get(i).compareTo(v2.get(i)) < 0) {
				return -1;
			}
			if (v1.get(i).compareTo(v2.get(i)) > 0) {
				return 1;
			}
			i++;
		}
		if (v1.size() > v2.size()) {
			for (int j = i; j < v1.size(); j++) {
				if (v1.get(j).compareTo(0) > 0) {
					return 1;
				}
			}
		}
		if (v1.size() < v2.size()) {
			for (int j = i; j < v2.size(); j++) {
				if (v2.get(j).compareTo(0) > 0) {
					return -1;
				}
			}
		}

		return 0;
	}
}
