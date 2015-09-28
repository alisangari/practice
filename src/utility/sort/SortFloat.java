package utility.sort;

public class SortFloat {

	public static float[] selectionSort(float[] nums) {// the name might not be correct
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					float t = nums[i];
					nums[i] = nums[j];
					nums[j] = t;
				}
			}
		}
		return nums;
	}

	
	public static Float[] selectionSort(Float[] nums) {// the name might not be correct
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j].floatValue() < nums[i].floatValue()) {
					float t = nums[i];
					nums[i] = nums[j];
					nums[j] = t;
				}
			}
		}
		return nums;
	}

	
	public static float[] reversedSelectionSort(float[] nums) {// the name might not be correct
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > nums[i]) {
					float t = nums[i];
					nums[i] = nums[j];
					nums[j] = t;
				}
			}
		}
		return nums;
	}

	public static Float[] reversedSelectionSort(Float[] nums) {// the name might not be correct
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > nums[i]) {
					float t = nums[i];
					nums[i] = nums[j];
					nums[j] = t;
				}
			}
		}
		return nums;
	}

}
