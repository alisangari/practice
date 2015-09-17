package utility.search;

public class SearchInt {

	public static int sequentialSearch(int[] arr, int lowerBound,
			int upperBound, int target) {
		//find first occurrence
		for (int i = lowerBound; i < upperBound; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	public static int binarySearch(int[] arr, int lowerBound,
			int upperBound, int target){
		//arr must be sorted
		//find first occurrence
		while(true){
			int m = (int)Math.floor((lowerBound + upperBound)/2);
			if(target<arr[m]){
				upperBound = m-1;
			}
			else if(target>arr[m]){
				lowerBound = m+1;
			}
			else{
				return m;
			}
			if(lowerBound>upperBound){
				return -1;
			}
		}
	}
}
