package utility.string;

import java.math.BigInteger;
import java.util.regex.Matcher;

public class Strings {

	public static boolean isPalindromic(String str){
		str = str.toLowerCase();
		if (str.length() < 1) {
			return true;
		}
		StringBuilder sb = new StringBuilder(str);
		String str2 = sb.reverse().toString();
		return str.equals(str2);
	}
	
	public static String convertToHex(String str) {
		try {
			// byte[] b = str.getBytes(StandardCharsets.UTF_8);
			byte[] b = str.getBytes("UTF-8");
			int num = new BigInteger(b).intValue();
			return Integer.toHexString(num);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static boolean isLetter(char ch){
		return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
	}

	public static boolean isDigit(char ch){
		return (ch >= '0' && ch <= '9');
	}
	
	/*
	 * for space use \\s+  --> also removes the line break char !!!
	 * for dot use \\.
	 * for quotation use \"
	 * for line break use \\n
	 */
	public static String removeSubString(String str, String substr){
		return str.replaceAll(substr, "");
	}

	// for chars like $ or \
	public static String removeSpecialSubString(String str, String substr){
		return str.replaceAll(Matcher.quoteReplacement(substr), "");
	}

}
