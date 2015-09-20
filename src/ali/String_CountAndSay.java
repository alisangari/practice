package ali;

import java.util.ArrayList;

public class String_CountAndSay {

	public static void main(String[] args) {
		String res = countAndSay(10);
		System.out.println(res);
	}

	public static String countAndSay(int n) {
		if (n < 2) {
			return "1";
		}
		ArrayList<String> res = new ArrayList<>();
		res.add("1");
		for (int i = 1; i < n; i++) {
			res.add(countAndSay2(res.get(i - 1)));
		}
		return res.get(res.size()-1);
	}

	public static String countAndSay2(String num) {
		Character prev = num.charAt(0);
		int count = 1;
		String res = "";
		for (int i = 1; i < num.length(); i++) {
			if (prev.compareTo(num.charAt(i)) != 0) {
				res += Integer.toString(count) + prev;
				prev = num.charAt(i);
				count = 1;
			} else {
				count++;
			}
		}
		res += Integer.toString(count) + prev;
		return res;
	}

}
