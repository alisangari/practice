public class FindDulicateNumber {

	public static void main(String[] args) {
		int[] numbers = Commons.randomNumbers(20, 1, 100);
		Commons.printArray(numbers);

		// Commons.printArray(findDuplicate(numbers));
		// Commons.printArray(findDuplicate2(numbers));

		int[] numbers2 = Commons.randomNumbers(20, 1, 100);
		Commons.printArray(numbers2);
		Commons.printArray("Duplicates between arrays: ",
				findDuplicatesInLists(numbers, numbers2));

	}

	private static int[] findDuplicatesInLists(int[] nums, int[] nums2) {
		nums = sort(nums);
		nums2 = sort(nums2);
		int[] res = new int[nums.length];
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums[i] == nums2[j]) {
					res[k] = nums[i];
					k++;
					break;
				}
			}
		}
		return res;
	}

	private static int[] findDuplicate(int[] numbers) {
		int[] res = new int[numbers.length];
		int k = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					res[k] = numbers[i];
					k++;
					break;
				}
			}
		}
		return res;
	}

	private static int[] findDuplicate2(int[] nums) {
		int[] res = new int[nums.length];
		int k = 0;
		nums = sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				res[k] = nums[i];
				k++;
			}
		}
		return res;
	}

	private static int[] sort(int[] nums) {
		// selection Sort
		// time complexity on2
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					int t = nums[i];
					nums[i] = nums[j];
					nums[j] = t;
				}
			}
		}
		return nums;
	}
}
