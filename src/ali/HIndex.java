package ali;

import utility.sort.SortInt;

public class HIndex {

	// Given an array of citations (each citation is a non-negative integer) of
	// a researcher, write a function to compute the researcher's h-index.
	//
	// According to the definition of h-index on Wikipedia:
	// "A scientist has index h if h of his/her N papers have at least h
	// citations each,
	// and the other N - h papers have no more than h citations each."
	//
	// For example, given citations = [3, 0, 6, 1, 5], which means the
	// researcher has 5 papers in total and each of them had received 3, 0, 6,
	// 1, 5 citations respectively. Since the researcher has 3 papers with at
	// least 3 citations each and the remaining two with no more than 3
	// citations each, his h-index is 3.
	//
	// Note: If there are several possible values for h, the maximum one is
	// taken as the h-index.
	public static void main(String[] args) {
		int[] citations = { 3, 0, 6, 1, 5 };
		int res = 0;
		res = hIndex(citations);
		System.out.println(res);
	}

	private static int hIndex(int[] citations) {
		if (citations.length < 1) {
			return 0;
		}
		citations = SortInt.reversedSelectionSort(citations);

		int l = citations.length;
		int c = 0;
		for (int j = 0; j < citations.length; j++) {
			for (int i = 0; i < citations.length; i++) {
				if (citations[i] >= l) {
					c++;
				}
				if (c >= l) {
					return l;
				}
			}
			c = 0;
			l--;
		}
		return 0;
	}
}
