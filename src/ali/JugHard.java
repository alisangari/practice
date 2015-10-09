package ali;

public class JugHard {
	// http://acm.student.cs.uwaterloo.ca/~acm00/150927/E.html
	// Problem E: Jug Hard
	//
	// You have two empty jugs and tap that may be used to fill a jug. When
	// filling a jug from the tap, you can only fill it completely (i.e., you
	// cannot partially fill it to a desired level, since there are no volume
	// measurements on the jug).
	// You may empty either jug at any point.
	//
	// You may transfer water between the jugs: if transferring water from a
	// larger jug to a smaller jug, the smaller jug will be full and there will
	// be water left behind in the larger jug.
	//
	// Given the volumes of the two jugs, is it possible to have one jug with
	// some specific volume of water?
	//
	// Input Specification
	//
	// The first line contains T, the number of test cases (1 <= T 100 000).
	// Each test case is composed of three integers: a b d where a and b (1 <=
	// a, b <= 10 000 000) are the volumes of the two jugs, and d is the desired
	// volume of water to be generated. You can assume that d <= max(a,b).
	// Output Specification
	//
	// For each of the T test cases, output either Yes or No, depending on
	// whether the specific volume of water can be placed in one of the two
	// jugs.
	// Sample Input
	//
	// 3
	// 8 1 5
	// 4 4 3
	// 5 3 4
	// Output for Sample Input
	//
	// Yes
	// No
	// Yes

	public static void main(String[] args) {
		Jug a = new Jug(5);
		Jug b = new Jug(3);
		
		while(true){
			// fill a to cap
			a = fillToCap(a);
			
			
			//fill b from a
			Jug[] = fillToCapFrom(b,a);
		}
	}

	private static Jug[] fillToCapFrom(Jug b, Jug a) {
		int n = b.cap-b.curr;
		a.curr -=n;
		b.curr=b.cap;
		Jug[] res = new Jug[2];
		res[0]=a;
		res[1]=b;
	}

	private static Jug fillToCap(Jug a) {
		a.curr=a.cap;
		return a;
	}

	
	
}

class Jug {
	int cap;
	int curr;

	Jug(int cap) {
		this.cap = cap;
	}
}