package utilitydemo.searchtest;

import java.util.ArrayList;

import utility.search.SearchString;

public class SearchStringTest {

	public static void main(String[] args){
		String[] nums = {"ali","Ali","Moji","Leon"};

		int i = SearchString.sequentialSearchOne(nums, 0, 9, "ji");
		System.out.println(i);
		ArrayList<String> res = SearchString.sequentialSearchAll(nums, "li");
		System.out.println(res);
//		nums = SortInt.selectionSort(nums);
//		Commons.printArray(nums);
//		i = SearchInt.binarySearch(nums, 0, 9, 25);
//		System.out.println(i);
		
	}
}
