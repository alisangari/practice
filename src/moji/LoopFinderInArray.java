package moji;

import java.util.ArrayList;
import java.util.List;

public class LoopFinderInArray {
	public static void main(String[] args) {
		// int[] array = {1,2,3,4,5,6,7,8,9};
		LoopFinderInArray a = new LoopFinderInArray();
		Pair[] array = { a.new Pair(1),// next0
				a.new Pair(2),// next1
				a.new Pair(3),// next2
				a.new Pair(4),// next3
				a.new Pair(5),// next4
				a.new Pair(6),// next5
				a.new Pair(8),// Goto 8 6
				a.new Pair(10),// next7
				a.new Pair(7),// goto 2 8
				a.new Pair(9),//
				a.new Pair(4), a.new Pair(11), a.new Pair(1) };

		List<Integer> circle = getInfinitCircle(array);
		System.out.println("circle contains: " + circle.toString());
		for (int i = 0; i < array.length; i++) {
			if (array[i].isVisited == false)
				System.out.println(i + 1);
		}
	}

	public static List<Integer> getInfinitCircle(Pair[] array) {

		boolean has_circle = false;
		List<Integer> circle = null;
		int check_point = -1;
		int i = 0;
		while (true) {

			if(array[i].value == 357){
				System.out.println("ssssssssssssssssss");
			}
			array[i].isVisited = true;
			System.out.println(i + "-->" + array[i].value + "::"
					+ array[i].isVisited);
			if (check_point != -1) {
				circle.add(array[i].value);
				if (array[i].value == check_point) {
					has_circle = true;
					break;
				}
			}
			i = (array[i].value);
			if (i >= array.length)
				break;
			if (array[i].value <= i) {
				if ( array[i].isVisited != true) {
					check_point = i;
					circle = new ArrayList<>();
				}
			}
		}
		if (has_circle)
			return circle;
		else
			return null;
	}

	public class Pair {
		int value;
		boolean isVisited = false;

		public Pair(int value) {
			super();
			this.value = value;
		}
	}

}
