package misc;

public class String_ValidPalindrome {

	public static void main(String[] args) {
		boolean res = isValidPalindrome("A man, a plan, a canal: Panama");
		System.out.println(res);
		res = isValidPalindrome("race a car");
		System.out.println(res);
		res = isValidPalindrome("");
		System.out.println(res);
	}

	private static boolean isValidPalindrome(String str) {
		str = str.toLowerCase();
		str = cleanseString(str);
		if (str.length() < 1) {
			return true;
		}
		StringBuilder sb = new StringBuilder(str);
		String str2 = sb.reverse().toString();
		return str.equals(str2);
	}

	private static String cleanseString(String str) {
		str = str.replaceAll("[^A-Za-z0-9]", "");
		return str.replaceAll("\\s", "");
	}

}
