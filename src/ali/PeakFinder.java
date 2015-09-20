package ali;
public class PeakFinder {

	public static void main(String[] args) {
		int[] nums = Commons.randomNumbers(10, 1, 10);
		Commons.printArray("Original list", nums);
		Commons.printArray("FindAll", findAll(nums));
		Commons.printArray("FindAllMax", findAllMax(nums));
		Commons.printArray("FindOneMax", findOneMax(nums));
		// Commons.printArray("FindOneMax", findOneMax2(nums));

	}

	private static int[] findAll(int[] nums) {
		// finds all local max and mins
		int[] peaks = new int[nums.length];
		int j = 0;
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
				peaks[j] = nums[i];
				j++;
			}
			if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
				peaks[j] = nums[i];
				j++;
			}
		}
		return peaks;
	}

	private static int[] findAllMax(int[] nums) {
		// finds all local max and mins
		int[] peaks = new int[nums.length];
		int j = 0;
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
				peaks[j] = nums[i];
				j++;
			}
		}
		return peaks;
	}

	private static int[] findOneMax(int[] nums) {
		// finds one local max
		int[] peaks = new int[nums.length];
		int j = 0;
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
				peaks[j] = nums[i];
				break;
			}
		}
		return peaks;
	}

	// private static int[] findOneMax2(int[] nums) {
	// // Given an array [a,b,c,d,e,f,g] where a-g are numbers, b is a peak if
	// // and only if a <= b and b>= c
	// //one dimentional - O(logn)
	// int[] res = new int[1];
	//
	// int leftLen = (int) Math.ceil((double) nums.length / 2);
	// int rightLen = (int) Math.floor((double) nums.length / 2);
	//
	//
	// if (nums[leftLen] < nums[leftLen - 1]) {
	// int[] leftArr = new int[leftLen];
	// for (int i = 0; i < leftLen; i++) {
	// leftArr[i] = nums[i];
	// }
	// findOneMax2(leftArr);
	// } else if (nums[leftLen] < nums[leftLen - 1]) {
	// int[] rightArr = new int[rightLen];
	// for (int i = 0; i < rightLen; i++) {
	// rightArr[i] = nums[leftLen + i];
	// }
	// findOneMax2(rightArr);
	// } else {
	//
	// res[0] = nums[leftLen];
	// return res;
	// }
	// return res;
	// }
}
