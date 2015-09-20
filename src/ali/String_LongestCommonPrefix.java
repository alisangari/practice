package ali;

public class String_LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = { "abab", "aba", "abc" };
		String res = "";
		res = longestCommonPrefix(strs);
		System.out.println(res);
	}

	private static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		int shortest = 0;
		for (int i = 1; i < strs.length; i++) {
			if (strs[i].length() < strs[shortest].length()) {
				shortest = i;
			}
		}
		if (strs[shortest].trim().length() == 0) {
			return "";
		}
		String commPrefix = "";
		for (int i = strs[shortest].length(); i > 0; i--) {
			boolean flag = false;
			commPrefix = strs[shortest].substring(0, i);
			for (int j = 0; j < strs.length; j++) {
				if (!strs[j].substring(0, i).equalsIgnoreCase(commPrefix)) {
					if (commPrefix.length() == 1) {
						return "";
					}
					flag = true;
					break;
				}
			}
			if (!flag) {
				return commPrefix;
			}
		}
		return commPrefix;
	}

}
