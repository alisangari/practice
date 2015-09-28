package ali;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import utility.file.FileLineImport;
import utility.sort.SortFloat;
import utility.string.Strings;

public class VendingMachine {

	public static void main(String[] args) {
		// read file line by line
		ArrayList<String> lines = FileLineImport
				.readTextFileToArrayList("files/ali/VendingMachine1.txt");

		// store items
		TreeMap<String, ArrayList<Float>> items = (TreeMap<String, ArrayList<Float>>) extractItems(lines);

		// store change
		TreeMap<Float, ArrayList<String>> changeSlots = (TreeMap<Float, ArrayList<String>>) extractChangeSlots(lines);
		// store actions

		// split actions into valid actions and remove all invalid actions
		ArrayList<ArrayList<String>> actions = extractActions(lines);
//		System.out.println(actions);

		sysoutInput(items, changeSlots, actions);
		// process actions
		float depositBox = 0;
		processActions(actions, items, changeSlots, depositBox);

		// generate output
		generateOutput(items, changeSlots, depositBox);

	}

	private static void sysoutInput(TreeMap<String, ArrayList<Float>> items,
			TreeMap<Float, ArrayList<String>> changeSlots, ArrayList<ArrayList<String>> actions) {
		for (Map.Entry<String, ArrayList<Float>> entry : items.entrySet()) {
			System.out.println(entry.getKey() + "," + entry.getValue().get(0) + "," + entry.getValue().get(1));
		}
		for (Map.Entry<Float, ArrayList<String>> entry : changeSlots.entrySet()) {
			System.out.println(entry.getKey() + "," + entry.getValue().get(1));
		}
		System.out.println(actions);
		System.out.println("*****************************");

	}

	private static void generateOutput(TreeMap<String, ArrayList<Float>> items,
			TreeMap<Float, ArrayList<String>> changeSlots, float depositBox) {
		for (Map.Entry<String, ArrayList<Float>> entry : items.entrySet()) {
			System.out.println(entry.getKey() + "," + entry.getValue().get(1));
		}

		for (Map.Entry<Float, ArrayList<String>> entry : changeSlots.entrySet()) {
			System.out.println(entry.getKey() + "," + entry.getValue().get(1));
		}

		System.out.println("$$," + depositBox);

	}

	private static void processActions(ArrayList<ArrayList<String>> actions,
			TreeMap<String, ArrayList<Float>> items,
			TreeMap<Float, ArrayList<String>> changeSlots, float depositBox) {
		for (ArrayList<String> action : actions) {
			String key = action.get(0) + action.get(1);
			if (items.containsKey(key)) {
				double quantity = (items.get(key)).get(1);
				float cost = (items.get(key)).get(0);
				double deposit = 0;
				for (int i = 2; i < action.size(); i++) {
					deposit += new Double(Strings.removeSpecialSubString(
							action.get(i), "$"));
				}
				if (quantity > 0) {
					if (cost == deposit) {
						// user paid exact amount. process payment.
						updateItemInventory(items, key);
						depositBox += deposit;
					}
					if (cost < deposit) {
						// user paid more.
						if ((deposit - cost) < cashInChangeSlots(changeSlots)) {
							// calculate change to be returned & update change
							// slots.
							updateChangeSlots(cost, deposit, changeSlots);
							// process payment.
							updateItemInventory(items, key);
							depositBox += deposit;
						}
					}
				}
			}
		}

	}

	private static void updateChangeSlots(double cost, double deposit,
			TreeMap<Float, ArrayList<String>> changeSlots) {
		double change = deposit - cost;
		for (Map.Entry<Float, ArrayList<String>> entry : changeSlots.entrySet()) {
			double coin = entry.getKey();
			if (change > coin) {
				int c = (int) Math.floor(change / coin);
				ArrayList<String> slot = entry.getValue();
				String newQuantity = new Integer(new Integer(slot.get(1)) - c)
						.toString();
				slot.set(1, newQuantity);
				change = change % coin;
			}
		}
		if (change > 0) {
			Set<Float> coinArr = changeSlots.keySet();
			Object[] objArr = coinArr.toArray();
			Float[] sorted = new Float[coinArr.size()];
			for(int i=0; i<sorted.length; i++){
				sorted[i] = (Float) objArr[i];
			}
			sorted = SortFloat.selectionSort(sorted);
			for (Float coin : sorted) {
				if (coin > change) {
					ArrayList<String> slot = changeSlots.get(coin);
					String newQuantity = new Integer(
							new Integer(slot.get(1)) - 1).toString();
					slot.set(1, newQuantity);
					break;
				}
			}
		}

	}

	private static void updateItemInventory(
			TreeMap<String, ArrayList<Float>> items, String key) {
		ArrayList<Float> item = items.get(key);
		item.set(1, item.get(1) - 1);
	}

	private static double cashInChangeSlots(
			TreeMap<Float, ArrayList<String>> changeSlots) {
		double availableCash = 0;
		for (Map.Entry<Float, ArrayList<String>> entry : changeSlots.entrySet()) {
			float coinVal = entry.getKey();
			int quantity = new Integer(entry.getValue().get(1));
			availableCash += coinVal * quantity;
		}
		return availableCash;
	}

	private static ArrayList<ArrayList<String>> extractActions(
			ArrayList<String> lines) {
		ArrayList<String> actionItems = new ArrayList<String>();
		for (String line : lines) {
			String[] elems = line.split(",");
			if (elems[0].equalsIgnoreCase("actions")) {
				for (int i = 1; i < elems.length; i++) {
					actionItems.add(elems[i].trim());
				}
				break;
			}
		}
		ArrayList<ArrayList<String>> grouppedActionItems = groupActions(actionItems);
		return grouppedActionItems;
		// ArrayList<ArrayList<String>> validActionItems =
		// extractValidActions(grouppedActionItems);
		// return validActionItems;
	}

	private static ArrayList<ArrayList<String>> extractValidActions(
			ArrayList<ArrayList<String>> grouppedActionItems) {
		// remove all types of invalid action sets.
		return grouppedActionItems;
	}

	private static ArrayList<ArrayList<String>> groupActions(
			ArrayList<String> actionItems) {
		ArrayList<ArrayList<String>> groupedActions = new ArrayList<ArrayList<String>>();
		String itemLetter = "";
		String itemNumber = "";
		ArrayList<String> deposits = new ArrayList<String>();
		for (String actionItem : actionItems) {

			if (actionItem.length() > 0 && actionItem.length() < 2) {
				if (Strings.isLetter(actionItem.charAt(0))) {// letter
					if (itemLetter.length() > 0) {
						groupedActions.add(groupItems(itemLetter, itemNumber,
								deposits));
						itemLetter = "";
						itemNumber = "";
						deposits = new ArrayList<String>();
					}
					itemLetter = actionItem;
				} else if (actionItem.equalsIgnoreCase("#")) {
					// do something ... cancel prev action set
					groupedActions.remove(groupedActions.size() - 1);
					itemLetter = "";
					itemNumber = "";
					deposits = new ArrayList<String>();
				}

				else if (Strings.isDigit(actionItem.charAt(0))) {// number
					if (itemNumber.length() > 0) {
						if(isCombinationValid(itemLetter, itemNumber,
								deposits, items, changeSlots))
						groupedActions.add(groupItems(itemLetter, itemNumber,
								deposits));
						itemLetter = "";
						itemNumber = "";
						deposits = new ArrayList<String>();
					}
					itemNumber = actionItem;
				}
			} else if (actionItem.length() >= 2) {
				if (actionItem.charAt(0) == '$') {
					deposits.add(actionItem);
				}
			}

		}
		return groupedActions;
	}

	private static ArrayList<String> groupItems(String itemLetter,
			String itemNumber, ArrayList<String> deposits) {
		ArrayList<String> groupped = new ArrayList<>();
		groupped.add(itemLetter);
		groupped.add(itemNumber);
		for (String deposit : deposits) {
			groupped.add(deposit);
		}
		return groupped;
	}

	private static Map<Float, ArrayList<String>> extractChangeSlots(
			ArrayList<String> lines) {
		Map<Float, ArrayList<String>> changeSlots = new TreeMap<Float, ArrayList<String>>();
		for (String line : lines) {
			String[] lineArr = line.split(",");
			if (lineArr[0].length() == 2 && (lineArr[0].charAt(0)) == '$') {
				ArrayList<String> slotAndQuantity = new ArrayList<String>();
				slotAndQuantity.add(lineArr[0].trim());
				slotAndQuantity.add(lineArr[2].trim());
				changeSlots.put(new Float(lineArr[1]), slotAndQuantity);
			}
		}
		return changeSlots;
	}

	private static Map<String, ArrayList<Float>> extractItems(
			ArrayList<String> lines) {
		Map<String, ArrayList<Float>> items = new TreeMap<String, ArrayList<Float>>();
		for (String line : lines) {
			String[] lineArr = line.split(",");
			if (lineArr[0].length() == 2 && (lineArr[0].charAt(0)) != '$') {
				ArrayList<Float> nums = new ArrayList<Float>();
				nums.add(new Float(lineArr[2]));
				nums.add(new Float(lineArr[3]));
				items.put(lineArr[0].trim(), nums);
			}
		}
		return items;
	}

}
