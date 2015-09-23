package ali;

public class Array_PlusOne {

	// Given a non-negative number represented as an array of digits, plus one
	// to the number.
	// The digits are stored such that the most significant digit is at the head
	// of the list.

	public static void main(String[] args) {
		int[] digits = { 9 };
		digits = plusOne(digits);
		for (int i = 0; i < digits.length; i++) {
			System.out.print(digits[i]);
		}

	}

	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] + 1 > 9) {
				if (i == 0) {
					digits = addOneCell(digits);
					digits[1] = 0;
					digits[0] = 1;
					break;
				} else {
					digits[i] = 0;
				}
			} else {
				digits[i] = digits[i] + 1;
				break;
			}
		}
		return digits;
	}

	private static int[] addOneCell(int[] digits) {
		int[] arr = new int[digits.length + 1];
		arr[0] = 0;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = digits[i-1];
		}
		return arr;
	}
}
