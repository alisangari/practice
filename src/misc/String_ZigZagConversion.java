package misc;

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
		String cstr = convert("AB", 3);
		System.out.println(cstr);
	}

	private static String convert(String str, int rows) {
		
		if (rows < 2) {
			return str;
		}
		char[][] arr = new char[str.length()][rows];

		int i = 0;
		int x = 0;
		int y = 0;
		int c = 0;
		boolean dir = true;
		String res = "";
		while (i < str.length()) {
			arr[x][y] = str.charAt(i);
			i++;
			if (c == rows - 1) {
				dir = false;
			}
			if (dir) {
				y++;
				c++;
			} else {
				// at the end of each reverse, i end up going into this "else"
				// one extra time.
				y--;
				x++;
				c--;
			}

			if (c < 0) {
				// to avoid indexOutOfBound because of entering the previous
				// "else" one too many times, i have this extra "if" to fix it.
				y = 1;
				x--;
				c = 1;
				dir = true;
			}
		}
		for (y = 0; y < rows; y++) {
			for (x = 0; x < str.length(); x++) {
				if ((int) arr[x][y] > 0) {
					res += arr[x][y];
				}
			}
		}
		return res;
	}
}
