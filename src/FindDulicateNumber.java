
public class FindDulicateNumber {

		public static void main(String[] args){
			int[] numbers = {1,2,3,4,4,3,4,5,6,6};
			
			findDuplicate(numbers);
			
		}
		
		private static void findDuplicate(int[] numbers){
			for(int i=0; i<numbers.length-2; i++){
				for(int j=i+1; j<numbers.length-1; j++){
					if(numbers[i] == numbers[j]){
						System.out.println(numbers[i]);
						break;
					}
				}
			}
		}
}
