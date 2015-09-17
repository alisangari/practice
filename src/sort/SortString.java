package sort;

public class SortString {

	public static String[] selectionSort(String[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j].compareTo(nums[i])<0) {
					String t = nums[i];
					nums[i] = nums[j];
					nums[j] = t;
				}
			}
		}
		return nums;
	}
	
	
	public static String[] mergeSort(String[] nums) {
		// metge sort
		// time complexity nlg(n)
		if (nums.length < 2) {
			return nums;
		}
		int leftLen = (int) Math.ceil((double) nums.length / 2);
		int rightLen = (int) Math.floor((double) nums.length / 2);
		String[] leftArr = new String[leftLen];
		String[] rightArr = new String[rightLen];
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

	private static String[] merge(String[] leftArr, String[] rightArr, String[] nums) {
		int leftLen = leftArr.length;
		int rightLen = rightArr.length;
		int i = 0, j = 0, k = 0;
		while (i < leftLen && j < rightLen) {
			if (leftArr[i].compareTo(rightArr[j])<=0) {
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
