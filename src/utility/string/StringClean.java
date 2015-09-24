package utility.string;

public class StringClean {

/*
 * for space use \\s+  --> also removes the line break char !!!
 * for dot use \\.
 * for quotation use \"
 * for line break use \\n
 */
	public static String removeSubString(String str, String substr){
		return str.replaceAll(substr, "");
	}
}
