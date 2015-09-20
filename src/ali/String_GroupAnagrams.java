package ali;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utility.sort.SortChar;
import utility.sort.SortString;

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
	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> res = new ArrayList<List<String>>();
		long t1;

		t1 = System.nanoTime();
		res = groupAnagrams(strs);
		System.out.println(System.nanoTime() - t1 + " - " + res.toString());

		t1 = System.nanoTime();
		res = groupAnagrams2(strs);
		System.out.println(System.nanoTime() - t1 + " - " + res.toString());

		t1 = System.nanoTime();
		res = groupAnagrams3(strs);
		System.out.println(System.nanoTime() - t1 + " - " + res.toString());
	}

	private static List<List<String>> groupAnagrams3(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (strs.length < 2) {
			ArrayList<String> a = new ArrayList<String>();
			a.add(strs[0]);
			res.add(a);
			return res;
		}
		HashMap<String, ArrayList<String>> group = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < strs.length; i++) {
			String str = SortChar.mergeSort(strs[i]);
			ArrayList<String> list = new ArrayList<>();
			if (group.containsKey(str)) {
				list = group.get(str);
				list.add(strs[i]);
				group.put(str, list);
			} else {
				list.add(strs[i]);
				group.put(str, list);
			}
		}
		for (Map.Entry<String, ArrayList<String>> entry : group.entrySet()) {
			String[] s = new String[entry.getValue().size()];
			Object[] o = entry.getValue().toArray();
			for (int i = 0; i < o.length; i++) {
				if (o[i] instanceof String) {

					s[i] = (String) o[i];
				} else {
					s[i] = "";
				}
			}
			s = SortString.selectionSort(s);
			res.add(Arrays.asList(s));
		}

		return res;
	}

	private static List<List<String>> groupAnagrams2(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (strs.length < 2) {
			ArrayList<String> a = new ArrayList<String>();
			a.addAll(Arrays.asList(strs));
			res.add(a);
			return res;
		}
		HashMap<String, ArrayList<String>> group = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < strs.length; i++) {
			String str = SortChar.mergeSort(strs[i]);
			ArrayList<String> list = new ArrayList<>();
			if (group.containsKey(str)) {
				list = group.get(str);
				list.add(strs[i]);
				group.put(str, list);
			} else {
				list.add(strs[i]);
				group.put(str, list);
			}
		}
		for (Map.Entry<String, ArrayList<String>> entry : group.entrySet()) {
			String[] s = new String[entry.getValue().size()];
			Object[] o = entry.getValue().toArray();
			for (int i = 0; i < o.length; i++) {
				if (o[i] instanceof String) {

					s[i] = (String) o[i];
				} else {
					s[i] = "";
				}
			}
			s = SortString.selectionSort(s);
			res.add(Arrays.asList(s));
		}

		return res;
	}

	private static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		String[] sorted = new String[strs.length];
		for (int i = 0; i < strs.length; i++) {
			sorted[i] = SortChar.mergeSort(strs[i]);
		}
		for (int i = 0; i < sorted.length; i++) {
			if (sorted[i] != null) {
				List<String> group = new ArrayList<>();
				group.add(strs[i]);
				for (int j = i + 1; j < sorted.length; j++) {
					if (sorted[i].equalsIgnoreCase(sorted[j])) {
						group.add(strs[j]);
						sorted[j] = null;
					}
				}
				res.add(group);
			}
		}

		return res;
	}
}
