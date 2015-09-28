package ali;

import java.util.ArrayList;

import utility.file.FileLineImport;

public class UnreachableStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> lines = FileLineImport
				.readTextFileToArrayList("files/ali/UnreachableStatement1.txt");

		System.out.println(lines.toString());
		int[] visited = new int[lines.size()];
		visited[0] = 1;
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).trim().equalsIgnoreCase("NEXT")) {
				visited[i + 1] = 1;
			}
			// else if()
		}

	}

}
