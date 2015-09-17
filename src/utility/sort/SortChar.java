package utility.sort;

public class SortChar {

	public static String selectionSort(String str) {
		String[] chars = new String[str.length()];
		chars = str.split("");
		for (int i = 0; i < chars.length - 1; i++) {
			for (int j = i + 1; j < chars.length; j++) {
				if (chars[j].compareTo(chars[i]) < 0) {
					String t = chars[i];
					chars[i] = chars[j];
					chars[j] = t;
				}
			}
		}
		String result = "";
		for (int i = 0; i < chars.length; i++) {
			result += chars[i];
		}
		return result;
	}

	public static String mergeSort(String str) {
		// metge sort
		// time complexity nlg(n)
		String[] chars = new String[str.length()];
		chars = str.split("");
		if (chars.length < 2) {
			return str;
		}

		int leftLen = (int) Math.ceil((double) chars.length / 2);
		int rightLen = (int) Math.floor((double) chars.length / 2);
		String leftArr = "";
		String rightArr = "";
		for (int i = 0; i < leftLen; i++) {
			leftArr += chars[i];
		}
		for (int i = 0; i < rightLen; i++) {
			rightArr += chars[leftLen + i];
		}

		leftArr = mergeSort(leftArr);
		rightArr = mergeSort(rightArr);
		String result = merge(leftArr, rightArr, chars);

		return result;
	}

	private static String merge(String left, String right, String[] str) {
		int leftLen = left.length();
		int rightLen = right.length();
		String[] leftArr = new String[leftLen];
		String[] rightArr = new String[rightLen];
		leftArr = left.split("");
		rightArr = right.split("");
		int i = 0, j = 0, k = 0;
		while (i < leftLen && j < rightLen) {
			if (leftArr[i].compareTo(rightArr[j]) <= 0) {
				str[k] = leftArr[i];
				i++;
			} else {
				str[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while (i < leftLen) {
			str[k] = leftArr[i];
			i++;
			k++;
		}
		while (j < rightLen) {
			str[k] = rightArr[j];
			j++;
			k++;
		}

		String result = "";
		for (int c = 0; c < str.length; c++) {
			result += str[c];
		}
		return result;
	}
}
