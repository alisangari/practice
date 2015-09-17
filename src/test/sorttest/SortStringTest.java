package test.sorttest;

import utility.sort.SortString;


public class SortStringTest {

	public static void main(String[] args) {
		String[] str = {"ali", "Ali", "Leon", "Moji"};
		String[] sortedStr1 = SortString.selectionSort(str);
		String[] sortedStr2 = SortString.mergeSort(str);
		printResult("", 0, str);
		printResult("", 0, sortedStr1);
		printResult("", 0, sortedStr2);
	}
	
	
	private static void printResult(String msg, long deltaTime, String[] nums) {
		System.out.println(msg + " -- time taken: " + deltaTime);
		if (nums.length < 50) {
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + ", ");
			}
		} else {
			System.out.println("list length: " + nums.length);
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}

}
