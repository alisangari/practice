package ali;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Commons {

	public static ArrayList<String> readTextFileToArrayList(String path){
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
	
	public static int[] randomNumbers(int quantity) {
		int[] nums = new int[quantity];
		for (int i = 0; i < quantity; i++) {
			nums[i] = random(0, 1000000);
		}
		return nums;
	}

	public static int[] randomNumbers(int quantity, int bottomEdge, int upperEdge) {
		int[] nums = new int[quantity];
		for (int i = 0; i < quantity; i++) {
			nums[i] = random(bottomEdge, upperEdge);
		}
		return nums;
	}

	private static int random(int bottomEdge, int upperEdge) {
		Random r = new Random();
		if (upperEdge > bottomEdge) {
			return r.nextInt(upperEdge - bottomEdge) + bottomEdge;
		} else {
			return 1;
		}
	}

	public static void printArray(int[] nums) {
		if (nums.length < 50) {
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + ", ");
			}
		} else {
			System.out.println("list length: " + nums.length);
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}

	public static void printArray(String msg, int[] nums) {
		System.out.print(msg + ": ");
		if (nums.length < 50) {
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + ", ");
			}
		} else {
			System.out.println("list length: " + nums.length);
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}

	public static boolean isEmpty(String str) {
		if (str != null && str.trim().length() > 0) {
			return false;
		}
		return true;
	}
}
