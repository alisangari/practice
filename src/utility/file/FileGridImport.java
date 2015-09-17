package utility.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileGridImport {
	public static ArrayList<ArrayList<String>> readTextFileTo2dArrayList(
			String path, String colSeparator) {
		ArrayList<ArrayList<String>> content = new ArrayList<ArrayList<String>>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				ArrayList<String> cols = new ArrayList<>();
				cols.addAll(Arrays.asList(line.split(colSeparator)));
				content.add(cols);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return content;
	}
}
