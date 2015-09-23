package ali;

/*
* Performance needs to be enhanced.
* The current submission has one of the lowest performances amongst submissions by other members.
*/

public class Array_RotateArray {

	// Rotate an array of n elements to the right by k steps.
	//
	// For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated
	// to [5,6,7,1,2,3,4].
	//
	// Note:
	// Try to come up as many solutions as you can, there are at least 3
	// different ways to solve this problem.
	//
	// [show hint]
	//
	// Hint:
	// Could you do it in-place with O(1) extra space?

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		int[] res;
		res = rotate(nums, 2);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + ",");
		}
	}

	public static int[] rotate(int[] nums, int k) {
		for (int c = 0; c < k; c++) {
			int t = nums[nums.length - 1];
			for (int i = nums.length - 1; i > 0; i--) {
				nums[i] = nums[i - 1];
			}
			nums[0] = t;
		}
		return nums;
	}

}
