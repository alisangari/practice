package utility.search;

import java.util.ArrayList;

public class SearchString {

	public static int sequentialSearchOne(String[] arr, int lowerBound,
			int upperBound, String target) {
		// find first occurrence
		for (int i = lowerBound; i < upperBound; i++) {
			if (arr[i].contains(target)) {
				return i;
			}
		}
		return -1;
	}

	public static ArrayList<String> sequentialSearchAll(String[] arr,
			String target) {
		// find first occurrence
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

//	public static int binarySearch(int[] arr, int lowerBound, int upperBound,
//			int target) {
//		// arr must be sorted
//		// find first occurrence
//		while (true) {
//			int m = (int) Math.floor((lowerBound + upperBound) / 2);
//			if (target < arr[m]) {
//				upperBound = m - 1;
//			} else if (target > arr[m]) {
//				lowerBound = m + 1;
//			} else {
//				return m;
//			}
//			if (lowerBound > upperBound) {
//				return -1;
//			}
//		}
//	}
}
