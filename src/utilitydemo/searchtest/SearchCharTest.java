package utilitydemo.searchtest;

import utility.search.SearchChar;

public class SearchCharTest {

	public static void main(String[] args) {
		String[] arr = { "ali", "Ali", "Mojlili", "Leon" };
		boolean isFound;
		for (int i = 0; i < arr.length; i++) {
			isFound = SearchChar.sequentialSearchOne(arr[i], "ji");
			System.out.println(isFound);
			int occurrances = SearchChar.sequentialSearchAll(arr[i], "li");
			System.out.println(occurrances);
		}
		// arr = SortInt.selectionSort(arr);
		// Commons.printArray(arr);
		// i = SearchInt.binarySearch(arr, 0, 9, 25);
		// System.out.println(i);

	}
}
