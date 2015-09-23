package ali;

public class Array_RemoveElement {

	// Given an array and a value, remove all instances of that value in place
	// and return the new length.
	//
	// The order of elements can be changed. It doesn't matter what you leave
	// beyond the new length.

	public static void main(String[] args) {
		// int[] nums = { 0, 4, 4, 0, 4, 4, 4, 0, 2 };
		// int[] nums = { 4,5 };
		int[] nums = { 4 };
		int val = 4;
		removeElement(nums, val);

	}

	public static int removeElement(int[] nums, int val) {
		if (nums.length < 1) {
			return 0;
		}
		int c = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				nums[i] = -1;
				c++;
			}
		}
		if (c == nums.length) {
			return 0;
		}
		for (int i = nums.length - c - 1; i < nums.length; i++) {
			if (nums[i] != -1) {
				for (int j = 0; j < nums.length - c; j++) {
					if (nums[j] == -1) {
						nums[j] = nums[i];
						nums[i] = -1;
					}
				}
			}
		}
		return nums.length - c;
	}
}
