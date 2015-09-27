package moji;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utility.sort.SortString;

public class GFinder {
	public static void main(String[] args) {
		List<String> mySet = Arrays.asList("A", "B", "A", "C");
		List<List<String>> lst = getSubset(mySet);
		List<String> result = new ArrayList<>();
		for (List<String> list : lst) {
			String tmp = "";
			for (String str : list) {
				tmp += str;
			}
			if (!tmp.equals(""))
				result.add(tmp);
		}
		System.out.println(result);
	}

	public static String[] mutations(String virus) {
		List<String> mySet = setMaker(virus);
		List<List<String>> lst = getSubset(mySet);
		String[] result = new String[(int) Math.pow(2, virus.length()) - 1];
		for (List<String> list : lst) {
			int i = 0;
			String tmp = "";
			for (String str : list) {
				tmp += str;
			}
			if (!tmp.equals("")) {
				result[i] = tmp;
				i++;
			}
		}
		return result;
	}

	public static Set<String> sortedMutations(String[] mutations) {
		Set<String> sorted_mutations = new HashSet<>();
		String[] strs = SortString.selectionSort(mutations);
		for (String str : strs) {
			sorted_mutations.add(str);
		}
		return sorted_mutations;
	}

	public static List<List<String>> getSubset(List<String> mySet) {
		List<List<String>> subsetList = new ArrayList<>();
		double count = Math.pow(2, mySet.size());
		for (int i = 0; i < count; i++) {
			List<String> subset = new ArrayList<String>();
			for (int bitIndex = 0; bitIndex < mySet.size(); bitIndex++) {
				if (bitMap(i, bitIndex) == 1) {
					subset.add(mySet.get(bitIndex));
				}
			}
			subsetList.add(subset);
		}
		return subsetList;
	}

	public static int bitMap(int value, int position) {
		int bit = value & (int) Math.pow(2, position);
		return (bit > 0 ? 1 : 0);
	}

	public static List<String> setMaker(String input) {
		List<String> lst = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			lst.add(input.charAt(i) + "");
		}
		return lst;
	}

}
