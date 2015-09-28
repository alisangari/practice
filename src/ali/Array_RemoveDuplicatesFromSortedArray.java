package ali;

/*
 * not solved yet!
 * order of elements needs to be preserved.
 */
public class Array_RemoveDuplicatesFromSortedArray {

	// Given a sorted array, remove the duplicates in place such that each
	// element appear only once and return the new length.
	//
	// Do not allocate extra space for another array, you must do this in place
	// with constant memory.
	//
	// For example,
	// Given input array nums = [1,1,2],
	//
	// Your function should return length = 2, with the first two elements of
	// nums being 1 and 2 respectively. It doesn't matter what you leave beyond
	// the new length.

	public static void main(String[] args) {
		// int[] nums = {1,1,2};
		// int[] nums = { -3, -3, -2, -1, -1, 0, 0, 0, 0, 0 };
		int[] nums = { 0, 0, 0, 0, 0, 1, 2, 2, 3, 3, 4, 4 };
		removeDuplicates(nums);
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		int c = 0;
		int prev = nums[0];
		int[] indx = new int[nums.length - 1];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == prev) {
				indx[c] = i;
				c++;
			} else {
				for(int j=c; j>=0; j--){
					
				}
				if (indx > 0) {
					nums[indx] = nums[i];
					indx = i;
				}
				prev = nums[i];
			}
		}
		if (c == nums.length - 1) {
			return 1;
		}
		printme(nums, nums.length - c);
		return nums.length - c;
	}

	private static void printme(int[] nums, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + ", ");
		}
	}
}
