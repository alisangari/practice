package utility.string.demo;

import utility.string.StringClean;

public class StringCleanDemo {
	public static void main(String[] args){
		String str = "aA#2 d  \" .f\ndf";
		System.out.println("original:"+str);
		System.out.println("********");
		System.out.println(StringClean.removeSubString(str, "\\s"));//also removes the line break char !!!
		System.out.println("********");
		System.out.println(StringClean.removeSubString(str, "\n"));
		System.out.println("********");
		System.out.println(StringClean.removeSubString(str, "#"));
		System.out.println("********");
		System.out.println(StringClean.removeSubString(str, "\\."));
	}
}
