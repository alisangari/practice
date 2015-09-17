package utility.search;

import java.util.ArrayList;

public class SearchString {

	public static int sequentialSearchOne(String[] arr, int lowerBound,
			int upperBound, String target) {
		// find first occurrence's index
		for (int i = lowerBound; i < upperBound; i++) {
			if (arr[i].contains(target)) {
				return i;
			}
		}
		return -1;
	}

	public static ArrayList<String> sequentialSearchAll(String[] arr,
			String target) {
		// find all occurrence
		ArrayList<String> results = new ArrayList<>();
		int lowerBound = 0;
		int upperBound = arr.length;
		for (int i = lowerBound; i < upperBound; i++) {
			if (arr[i].contains(target)) {
				results.add(arr[i]);
			}
		}
		return results;
	}

}
