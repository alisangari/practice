package utilitydemo.searchtest;

import misc.Commons;
import utility.search.SearchInt;
import utility.sort.SortInt;

public class SearchIntTest {

	public static void main(String[] args){
		int[] nums = Commons.randomNumbers(10, 20,30);
		Commons.printArray(nums);
		int i = SearchInt.sequentialSearch(nums, 0, 9, 25);
		System.out.println(i);
		nums = SortInt.selectionSort(nums);
		Commons.printArray(nums);
		i = SearchInt.binarySearch(nums, 0, 9, 25);
		System.out.println(i);
		
	}
}
