package utility.sort.demo;

import utility.sort.SortChar;


public class SortCharDemo {

	public static void main(String[] args) {
		String str = "ASFGdfRWEWdfEGsdfgDSA";
		String sortedStr1 = SortChar.selectionSort(str);
		String sortedStr2 = SortChar.mergeSort(str);
		System.out.println(str +"(len:"+str.length() + ") -> " + sortedStr1 +"(len:"+str.length() + ")");
		System.out.println(str +"(len:"+str.length() + ") -> " + sortedStr2 +"(len:"+str.length() + ")");
	}
}
