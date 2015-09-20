package ali;
import java.util.ArrayList;

public class Anagram1 {
	public static void main(String[] args) {

		ArrayList<String> fileContent = Commons
				.readTextFileToArrayList("files/Anagram1.txt");
		for (String line : fileContent) {
//			System.out.println(line);
		}
		prep(fileContent);
	}

	private static ArrayList<ArrayList<String>> prep(
			ArrayList<String> rawContent) {
		ArrayList<ArrayList<String>> prepedList = new ArrayList<ArrayList<String>>();
		for (String line : rawContent) {
			if (!isEmpty(line)) {
				ArrayList<String> tempList = new ArrayList<String>();
				String[] str = line.split(",");
				str[0] = removeWhiteSpace(str[0]);
				str[1] = removeWhiteSpace(str[1]);

				str[0] = removeCotations(str[0]);
				str[1] = removeCotations(str[1]);

				
				str[0] = str[0].toLowerCase();
				str[1] = str[1].toLowerCase();
				tempList.add(str[0]);
				tempList.add(str[1]);
				prepedList.add(tempList);
				System.out.println(str[0]+"[ - ]"+str[1]);
			}
		}

		return prepedList;
	}

	private static String removeCotations(String str) {
		str = str.replaceAll("\"", "");
		return str;
	}
	
	private static String removeWhiteSpace(String str) {
		str = str.replaceAll("\\s+", "");
		str = str.trim();
		return str;
	}

	private static boolean isEmpty(String str) {
		if (str != null && str.trim().length() > 0) {
			return false;
		}
		return true;
	}
}
