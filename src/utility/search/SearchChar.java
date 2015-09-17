package utility.search;


public class SearchChar {

	public static boolean sequentialSearchOne(String str, String target) {
		// find if at least one exists
		if (str.contains(target)) {
			return true;
		}
		return false;
	}

	public static int sequentialSearchAll(String str, String target) {
		// find first occurrence
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.contains(target)) {
				count++;
				str = str.substring(str.indexOf(target) + target.length(),
						str.length());
			}
		}
		return count;
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
