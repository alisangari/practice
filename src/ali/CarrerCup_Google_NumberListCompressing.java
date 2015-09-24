package ali;

public class CarrerCup_Google_NumberListCompressing {

	/*
	 * Number list compressing. Given an sorted array. Input: sorted number list
	 * 1, 2, 3,10, 25, 26, 30, 31, 32, 33
	 * 
	 * Output: find consecutive segments print: 1-3, 10, 25-26, 30-33
	 */

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 10, 25, 26, 30, 31, 32, 33, 40};
		String res;
		res = compress(nums);
		System.out.println(res);

	}

	private static String compress(int[] nums) {
		int a;
		int interim;
		a = nums[0];
		interim = a;
		boolean flag = false;
		String res = "";
		for (int i = 1; i < nums.length; i++) {
			if (!flag) {
				if (nums[i] == a + 1) {
					interim = nums[i];
					flag = true;
				} else {
					res += a + ", ";
					a = nums[i];
				}
			} else {
				if (nums[i] == interim + 1) {
					interim = nums[i];
				} else {
					flag = false;
					res += a + "-" + interim + ", ";
					a = nums[i];
				}
			}
		}
		if (flag) {
			res += a + "-" + interim;
		} else {
			res += a;
		}

		return res;
	}
}
