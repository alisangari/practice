package ali;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utility.file.FileLineImport;
import utility.search.SearchChar;
import utility.search.SearchString;
import utility.sort.SortFloat;
import utility.sort.SortString;

public class CureTheVirus {

	public static void main(String[] args) {
		ArrayList<String> lines = FileLineImport
				.readTextFileToArrayList("files/ali/CureTheVirus1.txt");
		ArrayList<Person> inhabitants = new ArrayList<>();
		for (int i = 1; i < lines.size() - 1; i++) {
			inhabitants.add(new Person(lines.get(i)));
		}
		String virus = lines.get(lines.size() - 1);

		// calc all permutations of the virus
//		String[] permutations = { "GCC", "GC", "CC", "G", "C" };
		String[] mut = mutations(virus);
		List<String> permutations = sortedMutations(mut);
System.out.println(permutations);		

		
		// calc probability
		for (String permutation : permutations) {
			for (Person person : inhabitants) {
				if (person.infectionProbability == -1) {
					// if (person.dna.contains(permutation)) {
					if (SearchChar.sequentialSearchOne(person.dna, permutation)) {
						person.infectionProbability = new Float(
								permutation.length())
								/ new Float(virus.length());
					}
				}
			}
		}
		for (Person person : inhabitants) {
			if (person.infectionProbability == -1) {
				person.infectionProbability = 0;
			}
		}

		Set<Float> probabilities = new TreeSet<Float>();
		for (Person person : inhabitants) {
			probabilities.add(person.infectionProbability);
		}

		Object[] probsObj = probabilities.toArray();
		float[] probs = new float[probsObj.length];
		for (int i = 0; i < probsObj.length; i++) {
			probs[i] = ((Float) probsObj[i]).floatValue();
		}
		probs = SortFloat.reversedSelectionSort(probs);
		for (Person person : inhabitants) {
			for (int i = 0; i < probs.length; i++) {
				if (person.vaccinationOrder == -1
						&& person.infectionProbability == probs[i]) {
					person.vaccinationOrder = i + 1;
				}
			}
		}

		for (int i = 0; i < inhabitants.size(); i++) {
			// System.out.println(person);
			System.out.println("Person" + i + ": "
					+ inhabitants.get(i).vaccinationOrder);
		}

	}

	// ******************8

	public static String[] mutations(String virus) {
		List<String> set = setMaker(virus);
		List<List<String>> lst = getSubset(set);
		String[] result = new String[(int) Math.pow(2, virus.length()) - 1];
		int i = 0;
		for (List<String> list : lst) {
			String tmp = "";
			for (String str : list) {
				tmp += str;
			}
			if (!tmp.equals("")) {
				result[i] = tmp;
				i++;
			}
		}
		return result;
	}

	public static List<String> sortedMutations(String[] mutations) {
		List<String> sorted_mutations = new ArrayList<>();
		sorted_mutations = SortString.sortByLength(mutations);
//		for (String str : mutations) {
//			sorted_mutations.add(str);
//		}
		return sorted_mutations;
	}

//	public static void sort(String[] mutations) {
//		// TODO
//	}

	public static List<List<String>> getSubset(List<String> mySet) {
		List<List<String>> subsetList = new ArrayList<>();
		double count = Math.pow(2, mySet.size());
		for (int i = 0; i < count; i++) {
			List<String> subset = new ArrayList<String>();
			for (int bitIndex = 0; bitIndex < mySet.size(); bitIndex++) {
				if (bitMap(i, bitIndex) == 1) {
					subset.add(mySet.get(bitIndex));
				}
			}
			subsetList.add(subset);
		}
		return subsetList;
	}

	public static int bitMap(int value, int position) {
		int bit = value & (int) Math.pow(2, position);
		return (bit > 0 ? 1 : 0);
	}

	public static List<String> setMaker(String input) {
		List<String> lst = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			lst.add(input.charAt(i) + "");
		}
		return lst;
	}

	// *******************

}

class Person {
	String dna;
	float infectionProbability;
	int vaccinationOrder;

	Person(String dna) {
		this.dna = dna;
		this.infectionProbability = -1;
		this.vaccinationOrder = -1;
	}

	public String toString() {
		return (dna + " - " + infectionProbability + " - " + vaccinationOrder);
	}
}
