package ali;

import utility.sort.SortInt;

public class Array_ContainsDuplicate {

	// Given an array of integers, find if the array contains any duplicates.
	// Your function should return true if any value appears at least twice in
	// the array,
	// and it should return false if every element is distinct.

	public static void main(String[] args) {

	}

	public static boolean containsDuplicate(int[] nums) {
		if (nums.length < 2) {
			return false;
		}
		nums = SortInt.selectionSort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}
}
