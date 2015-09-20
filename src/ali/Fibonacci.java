package ali;

public class Fibonacci {
	public static void main(String[] args) {
		int n = 3;
		fibo1(n);
		fibo2(n);
		System.out.println(fibo3(n));
	}

	private static void fibo1(int n) {
		//with array
		//time complexity On
		//space complexity: array
		int[] arr = new int[n + 1];
		arr[0] = arr[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		System.out.println(arr[arr.length - 1]);
	}

	private static void fibo2(int n) {
//		time complexity: On
		int a = 1;
		int b = 1;
		int r = 1;
		for (int i = 2; i < n + 1; i++) {
			r = a + b;
			a = b;
			b = r;
		}
		System.out.println(r);
	}
	
	private static int fibo3(int n){
		//recursive
//		time complexity: On2
		if(n>1){
			return fibo3(n-1)+fibo3(n-2);
		}
		return 1;
	}
}
