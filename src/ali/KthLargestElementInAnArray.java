package ali;

public class KthLargestElementInAnArray {

	// Find the kth largest element in an unsorted array. Note that it is the
	// kth largest element in the sorted order, not the kth distinct element.
	//
	// For example,
	// Given [3,2,1,5,6,4] and k = 2, return 5.
	//
	// Note:
	// You may assume k is always valid, 1 <= k <= array's length.
	
	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		int res = findKthLargest(nums, k);
		System.out.println(res);
	}

	public static int findKthLargest(int[] nums, int k) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > nums[i]) {
					int t = nums[i];
					nums[i] = nums[j];
					nums[j] = t;
				}
			}
		}
		return nums[k-1];
	}
	

}
