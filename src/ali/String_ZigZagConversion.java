package ali;

public class String_ZigZagConversion {

	// The string "PAYPALISHIRING" is written in a zigzag pattern on a given
	// number of rows like this: (you may want to display this pattern in a
	// fixed font for better legibility)
	// (ignore the "-" )
	// P - A - H - N
	// A P L S I I G
	// Y - I - R
	// And then read line by line: "PAHNAPLSIIGYIR"
	// Write the code that will take a string and make this conversion given a
	// number of rows:
	//
	// string convert(string text, int nRows);
	// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	public static void main(String[] args) {
		long t0 = 0;
		String str = "ABCDEFGHIJKLMNOPQRSTWXYZABCDEFGHIJKLMNOPQRSTWXYZABCDEFGHIJKLMNOPQRSTWXYZABCDEFGHIJKLMNOPQRSTWXYZABCDEFGHIJKLMNOPQRSTWXYZ";
		int rows = 4;
		String cstr = "";

		t0 = System.nanoTime();
		cstr = convert22(str, rows);
		System.out.println(System.nanoTime() - t0 + " -2 " + cstr);

		// t0 = System.nanoTime();
		// cstr = convert(str, rows);
		// System.out.println(System.nanoTime() - t0 + " - " + cstr);
		//
		// t0 = System.nanoTime();
		// cstr = convert2(str, rows);
		// System.out.println(System.nanoTime() - t0 + " - " + cstr);
		//
		// t0 = System.nanoTime();
		// cstr = convert21(str, rows);
		// System.out.println(System.nanoTime() - t0 + " -1 " + cstr);
		//
		// t0 = System.nanoTime();
		// cstr = convert3(str, rows);
		// System.out.println(System.nanoTime() - t0 + " - " + cstr);
		//
		// t0 = System.nanoTime();
		// cstr = convert4(str, rows);
		// System.out.println(System.nanoTime() - t0 + " - " + cstr);

	}

	private static String convert22(String str, int rows) {
		if (rows < 2 || str.length() < rows) {
			return str;
		}
		StringBuilder[] arr = new StringBuilder[rows];
		for (int c = 0; c < rows; c++) {
			arr[c] = new StringBuilder();
		}

		int x = 0;
		int prevX = 0;
		for (int i = 0; i < str.length(); i++) {
			arr[x].append(str.charAt(i));

			if (x == 0) {
				prevX = x;
				x++;
			} else if (x == rows - 1) {
				prevX = x;
				x--;
			} else if (x < rows && prevX < x) {
				prevX = x;
				x++;
			} else {
				prevX = x;
				x--;
			}
		}
		String res = "";
		for (StringBuilder entry : arr) {
			res += entry.toString();
		}
		return res;
	}

	// private static String convert4(String str, int rows) {
	// if (rows < 2 || str.length() < rows) {
	// return str;
	// }
	// String[] arr = new String[rows];
	// for (int i = 0; i < rows; i++) {
	// arr[i] = new String();
	// }
	//
	// int x = 0;
	// int prevX = 0;
	// for (int i = 0; i < str.length(); i++) {
	// arr[x] += str.substring(i, i + 1);
	// if (x == 0) {
	// prevX = x;
	// x++;
	// } else if (x == rows - 1) {
	// prevX = x;
	// x--;
	// } else if (x < rows && prevX < x) {
	// prevX = x;
	// x++;
	// } else {
	// prevX = x;
	// x--;
	// }
	// }
	// String res = "";
	// for (int i = 0; i < rows; i++) {
	// res += arr[i];
	// }
	// return res;
	// }
	//
	// private static String convert3(String str, int rows) {
	// if (rows < 2 || str.length() < rows) {
	// return str;
	// }
	// String[] arr = new String[rows];
	// for (int i = 0; i < rows; i++) {
	// arr[i] = new String();
	// }
	//
	// int x = 0;
	// int prevX = 0;
	// for (int i = 0; i < str.length(); i++) {
	// arr[x] += str.charAt(i);
	// if (x == 0) {
	// prevX = x;
	// x++;
	// } else if (x == rows - 1) {
	// prevX = x;
	// x--;
	// } else if (x < rows && prevX < x) {
	// prevX = x;
	// x++;
	// } else {
	// prevX = x;
	// x--;
	// }
	// }
	// String res = "";
	// for (int i = 0; i < rows; i++) {
	// res += arr[i];
	// }
	// return res;
	// }
	//
	// private static String convert2(String str, int rows) {
	// if (rows < 2 || str.length() < rows) {
	// return str;
	// }
	// StringBuilder[] arr = new StringBuilder[rows];
	// for (int c = 0; c < rows; c++) {
	// arr[c] = new StringBuilder();
	// }
	//
	// int i = 0;
	// int x = 0;
	// int prevX = 0;
	// while (i < str.length()) {
	// arr[x].append(str.charAt(i));
	//
	// if (x == 0) {
	// prevX = x;
	// x++;
	// } else if (x == rows - 1) {
	// prevX = x;
	// x--;
	// } else if (x < rows && prevX < x) {
	// prevX = x;
	// x++;
	// } else {
	// prevX = x;
	// x--;
	// }
	// i++;
	// }
	// String res = "";
	// for (int c = 0; c < rows; c++) {
	// res += arr[c].toString();
	// }
	// return res;
	// }
	//
	// private static String convert21(String str, int rows) {
	// if (rows < 2 || str.length() < rows) {
	// return str;
	// }
	// StringBuilder[] arr = new StringBuilder[rows];
	// for (int c = 0; c < rows; c++) {
	// arr[c] = new StringBuilder();
	// }
	//
	// int i = 0;
	// int x = 0;
	// int prevX = 0;
	// while (i < str.length()) {
	// arr[x].append(str.charAt(i));
	//
	// if (x == 0) {
	// prevX = x;
	// x++;
	// } else if (x == rows - 1) {
	// prevX = x;
	// x--;
	// } else if (x < rows && prevX < x) {
	// prevX = x;
	// x++;
	// } else {
	// prevX = x;
	// x--;
	// }
	// i++;
	// }
	// String res = "";
	// for (StringBuilder entry : arr) {
	// res += entry.toString();
	// }
	// return res;
	// }
	//
	// private static String convert(String str, int rows) {
	// if (rows < 2) {
	// return str;
	// }
	// char[][] arr = new char[str.length()][rows];
	//
	// int i = 0;
	// int x = 0;
	// int y = 0;
	// int c = 0;
	// boolean dir = true;
	// String res = "";
	// while (i < str.length()) {
	// arr[x][y] = str.charAt(i);
	// i++;
	// if (c == rows - 1) {
	// dir = false;
	// }
	// if (dir) {
	// y++;
	// c++;
	// } else {
	// // at the end of each reverse, i end up going into this "else"
	// // one extra time.
	// y--;
	// x++;
	// c--;
	// }
	//
	// if (c < 0) {
	// // to avoid indexOutOfBound because of entering the previous
	// // "else" one too many times, i have this extra "if" to fix it.
	// y = 1;
	// x--;
	// c = 1;
	// dir = true;
	// }
	// }
	// for (y = 0; y < rows; y++) {
	// for (x = 0; x < str.length(); x++) {
	// if ((int) arr[x][y] > 0) {
	// res += arr[x][y];
	// }
	// }
	// }
	// return res;
	// }
}
