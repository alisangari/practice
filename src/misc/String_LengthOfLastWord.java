package misc;

public class String_LengthOfLastWord {
	// Given a string s consists of upper/lower-case alphabets and empty space
	// characters ' ', return the length of last word in the string.
	//
	// If the last word does not exist, return 0.
	//
	// Note: A word is defined as a character sequence consists of non-space
	// characters only.
	//
	// For example,
	// Given s = "Hello World",
	// return 5.
	public static void main(String[] args) {
		int res = lengthOfLastWord("Hello World");
		System.out.println(res);
	}

	private static int lengthOfLastWord(String s) {
		if (s.trim().length() < 1) {
			return 0;
		}
		String[] arr = s.split(" ");
		return arr[arr.length - 1].length();
	}

}
