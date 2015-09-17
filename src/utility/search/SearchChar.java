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

}
