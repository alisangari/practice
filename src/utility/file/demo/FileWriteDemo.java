package utility.file.demo;

import java.util.ArrayList;

import utility.file.FileWrite;

public class FileWriteDemo {
	public static void main(String[] args) {
		boolean res = false;

		String str = "test";
		res = FileWrite.write("test1.txt", str);
		System.out.println(res);

		String[] strs = { "line 1", "line 2" };
		res = FileWrite.write("test2.txt", strs);
		System.out.println(res);

		ArrayList<String> strArrList = new ArrayList<>();
		strArrList.add("line 1");
		strArrList.add("line 2");
		res = FileWrite.write("test3.txt", strArrList);
		System.out.println(res);
	}
}
