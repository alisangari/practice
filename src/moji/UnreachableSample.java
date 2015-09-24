package moji;

import java.util.ArrayList;
import java.util.List;

import moji.LoopFinderInArray.Pair;
import utility.file.FileLineImport;

public class UnreachableSample {
	public static void main(String[] args) {
		LoopFinderInArray lf = new LoopFinderInArray();
		ArrayList<String> lines = FileLineImport
				.readTextFileToArrayList("files/moji/unreachable.txt");
		Pair[] array = new Pair[lines.size()];
		for (int i = 0; i < array.length; i++) {
			if (lines.get(i).split("\\s+")[0].equals("GOTO"))
				array[i] = lf.new Pair(Integer.parseInt(lines.get(i).split(
						"\\s+")[1]) - 1);
			else {
				array[i] = lf.new Pair(i + 1);
			}
		}
		List<Integer> circle = LoopFinderInArray.getInfinitCircle(array);
		System.out.println("circle contains: " + circle.toString());
		for (int i = 0; i < array.length; i++) {
			if (array[i].isVisited == false)
				System.out.println(i + 1);
		}
	}
}
