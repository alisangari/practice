
public class Factorial {

	public static void main(String[] args){
		int n = 4;
		
		factorial1(n);
		System.out.println(factorial2(n));
	}
	
	private static void factorial1(int n){
		//simple loop
		//time complexity: On
		double result = 1;
		for(int i=2; i<=n; i++){
			result = result*i;
		}
		System.out.println(result);
	}
	
	
	private static double factorial2(int n){
		//recursive
		//time complexity: On2
		if(n>1){
			return n*factorial2(n-1);
		}
		return 1;
	}
}
