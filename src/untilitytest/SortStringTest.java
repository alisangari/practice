package untilitytest;

import utility.SortString;

public class SortStringTest {

	public static void main(String[] args) {
		String str = "ASFGdfRWEWdfEGsdfgDSA";
		System.out.println(str + " -> " + SortString.selectionSort(str));
		System.out.println(str + " -> " + SortString.mergeSort(str));
		System.out.println(4);
	}
}
