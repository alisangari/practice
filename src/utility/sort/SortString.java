package utility.sort;

public class SortString {

	public static String[] selectionSort(String[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[i]) < 0) {
					String t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}
			}
		}
		return arr;
	}

	public static String[] mergeSort(String[] arr) {
		// metge sort
		// time complexity nlg(n)
		if (arr.length < 2) {
			return arr;
		}
		int leftLen = (int) Math.ceil((double) arr.length / 2);
		int rightLen = (int) Math.floor((double) arr.length / 2);
		String[] leftArr = new String[leftLen];
		String[] rightArr = new String[rightLen];
		for (int i = 0; i < leftLen; i++) {
			leftArr[i] = arr[i];
		}
		for (int i = 0; i < rightLen; i++) {
			rightArr[i] = arr[leftLen + i];
		}

		mergeSort(leftArr);
		mergeSort(rightArr);
		arr = merge(leftArr, rightArr, arr);

		return arr;
	}

	private static String[] merge(String[] leftArr, String[] rightArr,
			String[] nums) {
		int leftLen = leftArr.length;
		int rightLen = rightArr.length;
		int i = 0, j = 0, k = 0;
		while (i < leftLen && j < rightLen) {
			if (leftArr[i].compareTo(rightArr[j]) <= 0) {
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
