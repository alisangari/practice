package utility.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class FileLineImport {

	public static ArrayList<String> readTextFileToArrayList(String path) {
		ArrayList<String> content = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				content.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return content;
	}

	public static ArrayList<String> readUtf8TextFileToArrayList(String path) {
		ArrayList<String> content = new ArrayList<>();
		try {
			File fileDir = new File(path);

			BufferedReader in;
			in = new BufferedReader(new InputStreamReader(new FileInputStream(
					fileDir), "UTF8"));

			String str;

			while ((str = in.readLine()) != null) {
				content.add(str);
			}

			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
		return content;
	}
}
