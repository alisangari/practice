package misc;

public class IntSort {

	public static void main(String[] args) {
		long t1, deltaTime;
		t1 = System.currentTimeMillis();
		int[] nums = Commons.randomNumbers(100000);
		deltaTime = System.currentTimeMillis() - t1;
		printResult("Original List", deltaTime, nums);

		t1 = System.currentTimeMillis();
		int[] sort1 = selectionSort(nums);
		deltaTime = System.currentTimeMillis() - t1;
		printResult("Selection Sort", deltaTime, sort1);

		t1 = System.currentTimeMillis();
		int[] sort2 = mergeSort(nums);
		deltaTime = System.currentTimeMillis() - t1;
		printResult("Merge Sort", deltaTime, sort2);
	}

	private static int[] selectionSort(int[] nums) {
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

	private static int[] mergeSort(int[] nums) {
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
		while (i < rightLen) {
			nums[k] = rightArr[j];
			j++;
			k++;
		}
		return nums;
	}

	
	//other methods 
	private static void printResult(String msg, long deltaTime, int[] nums) {
		System.out.println(msg + " -- time taken: " + deltaTime);
		if (nums.length < 50) {
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + ", ");
			}
		} else {
			System.out.println("list length: " + nums.length);
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}


}
