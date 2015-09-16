package utility;

public class SortInt {

	public static int[] selectionSort(int[] nums) {
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
	
	
	public static int[] mergeSort(int[] nums) {
		// metge sort
		// time complexity nlg(n)
		if (nums.length < 2) {
			return nums;
		}
		int leftLen = (int) Math.ceil((double) nums.length / 2);
		int rightLen = (int) Math.floor((double) nums.length / 2);
		int[] leftArr = new int[leftLen];
		int[] rightArr = new int[rightLen];
		for (int i = 0; i < leftLen; i++) {
			leftArr[i] = nums[i];
		}
		for (int i = 0; i < rightLen; i++) {
			rightArr[i] = nums[leftLen + i];
		}

		mergeSort(leftArr);
		mergeSort(rightArr);
		nums = merge(leftArr, rightArr, nums);

		return nums;
	}

	private static int[] merge(int[] leftArr, int[] rightArr, int[] nums) {
		int leftLen = leftArr.length;
		int rightLen = rightArr.length;
		int i = 0, j = 0, k = 0;
		while (i < leftLen && j < rightLen) {
			if (leftArr[i] <= rightArr[j]) {
				nums[k] = leftArr[i];
				i++;
			} else {
				nums[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while (i < leftLen) {
			nums[k] = leftArr[i];
			i++;
			k++;
		}
		while (j < rightLen) {
			nums[k] = rightArr[j];
			j++;
			k++;
		}
		return nums;
	}
}
