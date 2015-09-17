package sorttest;

import misc.Commons;
import sort.SortInt;

public class SortIntTest {

	public static void main(String[] args) {
		long t1, deltaTime;
		t1 = System.currentTimeMillis();
		int[] nums = Commons.randomNumbers(10, 20,30);
		deltaTime = System.currentTimeMillis() - t1;
		printResult("Original List", deltaTime, nums);

		t1 = System.currentTimeMillis();
		int[] sort1 = SortInt.selectionSort(nums);
		deltaTime = System.currentTimeMillis() - t1;
		printResult("Selection Sort", deltaTime, sort1);

		t1 = System.currentTimeMillis();
		int[] sort2 = SortInt.mergeSort(nums);
		deltaTime = System.currentTimeMillis() - t1;
		printResult("Merge Sort", deltaTime, sort2);
	}

	private static void printResult(String msg, long deltaTime, int[] nums) {
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
