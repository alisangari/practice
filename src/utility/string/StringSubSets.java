package utility.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StringSubSets {

	public static void main(String[] args) {
		String str = "GCC";
		String[] strs = getAllSubSets(str);
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
	}

	public static String[] getAllSubSets(String virus) {
		List<String> set = setMaker(virus);
		List<List<String>> lst = getSubset(set);
		String[] result = new String[(int) Math.pow(2, virus.length()) - 1];
		int i = 0;
		for (List<String> list : lst) {
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

	private static List<String> setMaker(String input) {
		List<String> lst = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			lst.add(input.charAt(i) + "");
		}
		return lst;
	}

	private static int bitMap(int value, int position) {
		int bit = value & (int) Math.pow(2, position);
		return (bit > 0 ? 1 : 0);
	}

	private static List<List<String>> getSubset(List<String> mySet) {
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

}
