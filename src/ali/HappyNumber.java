package ali;

import java.util.HashSet;

public class HappyNumber {

//	Write an algorithm to determine if a number is "happy".
//
//	A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
//
//	Example: 19 is a happy number
//
//	1 pow 2 + 9 pow 2 = 82
//	8 pow 2 + 2 pow 2 = 68
//	6 pow 2 + 8 pow 2 = 100
//	1 pow 2 + 0 pow 2 + 0 pow 2 = 1
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isHappy(19));

	}

	public static boolean isHappy(int n) {
		HashSet<Integer> prev = new HashSet<>();
		boolean flag = false;
		int[] digits = split(n);
		while (true) {
			int res = sum(digits);
			digits = split(res);
			if (res != 1 && !prev.add(res)) {
				break;
			}
			if (res == 1) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	private static int sum(int[] digits) {
		int res = 0;
		for (int n : digits) {
			System.out.print(n + "+");
			res += n * n;
		}
		System.out.println(" = " + res);
		return res;
	}

	private static int[] split(int n) {
		String str = new Integer(n).toString();
		String[] strs = str.split("");
		int[] res = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			res[i] = new Integer(strs[i]).intValue();
		}
		return res;
	}

}
