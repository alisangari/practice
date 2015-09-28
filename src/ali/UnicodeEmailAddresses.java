package ali;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import utility.file.FileLineImport;
import utility.string.Strings;

public class UnicodeEmailAddresses {

	public static void main(String[] args) {
//		String[] strs = {"é", "ŷ", "ಠ","🍚"};//"é", "ŷ", "ಠ",
		ArrayList<String> emails = FileLineImport
				.readUtf8TextFileToArrayList("files/ali/UnicodeEmailAddress1.txt");
		try {
			convert(emails);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void convert(ArrayList<String> emails)
			throws UnsupportedEncodingException {
		for (String email : emails) {
			String[] sections = split(email);
			String spChars = "";
			String out = "";
			for (int j = 0; j < 3; j++) {
				String section = sections[j];
				String utfStrs = "";
				for (int i = 0; i < section.length(); i++) {
					int code = (int) section.charAt(i);
					if (code > 33 && code < 126) {
						out += section.charAt(i);
					} else {
						spChars += section.charAt(i);
						String[] temp = section.split("");
						utfStrs += "+"
								+ i
								+ "?"
								+ Strings.convertToHex(temp[i]);
					}
				}
				if (utfStrs.length() > 0) {
					out += utfStrs;
				}
				if (j == 0) {
					out += "@";
				} else if (j == 1) {
					out += ".";
				}
			}
			if (spChars.length() > 0) {
				out += "~" + spChars;
				System.out.println(email + " : " + out);
			}
		}

	}

	private static String hex3(String str){
		char[] chars = str.toCharArray();
		if(chars.length>1){
		System.out.println("---> "+chars.length);
		}
		Character[] chars2 = new Character[chars.length];
		for(int i=0; i<chars.length; i++){
			chars2[i] = new Character(chars[i]);
		}
return null;
	}
	
	private static String hex2(String str){
		try {
			String utf8Bytes = new String(str.getBytes(), "UTF-8");
		String strFormat = String.format("%04x", (int) str.charAt(0));
//		Integer.toHexString(String)
//		return Integer.toHexString(Character.codePointAt(strFormat, 0));
		return strFormat;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	private static String[] split(String email) {
		String[] a = email.split("\\.");
		String[] b = a[0].split("@");
		String[] sections = new String[3];
		sections[0] = b[0].toLowerCase();
		sections[1] = b[1].toLowerCase();
		sections[2] = a[1].toLowerCase();
		return sections;
	}

}
