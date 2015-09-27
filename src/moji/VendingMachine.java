package moji;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class VendingMachine {
	public class ItemInventory {
		public String id;
		public int id_number;
		public String name;
		public int cost;
		public int quantity;

		public ItemInventory() {
			// TODO Auto-generated constructor stub
		}

		public ItemInventory(String id, int id_number, String name, int cost, int quantity) {
			super();
			this.id = id;
			this.id_number = id_number;
			this.name = name;
			this.cost = cost;
			this.quantity = quantity;
		}

		@Override
		public boolean equals(Object obj) {
			if ((((ItemInventory) obj).id).equals(this.id) && (((ItemInventory) obj).id_number) == this.id_number) {
				return true;
			}
			return false;
		}

	}

	public class Change {
		public int id;
		public int value;
		public int quantity;

		public Change() {
			// TODO Auto-generated constructor stub
		}

		public Change(int id, int value, int quantity) {
			super();
			this.id = id;
			this.value = value;
			this.quantity = quantity;
		}

	}

	public static void main(String[] args) {
		// ArrayList<ArrayList<String>> input =
		// FileGridImport.readTextFileTo2dArrayList("files/Anagram1.txt",",");
		// A1,Candy1,0.05,1
		// B1,Candy7,0.65,12
		// $1,0.05,100
		// $2,0.25,200
		VendingMachine machine = new VendingMachine();
		List<ItemInventory> items = new ArrayList<>();
		items.add(machine.new ItemInventory("A", 1, "Candy1", 5, 1));
		items.add(machine.new ItemInventory("B", 1, "Candy7", 65, 12));
		// List<Change> changes = new ArrayList<>();
		// changes.add(machine.new Change(1, 0.05, 100));
		// changes.add(machine.new Change(2, 0.25, 200));
		Map<Integer, Integer> changes_order = new HashMap<>();
		changes_order.put(5, 1);
		changes_order.put(25, 2);

		Map<Integer, Integer> unsorted_changes = new HashMap<>();
		unsorted_changes.put(5, 100);
		unsorted_changes.put(25, 200);
		Map<Integer, Integer> changes = new TreeMap<Integer, Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}

		});
    	changes.putAll(unsorted_changes);
//		greedyChangeCalc(changes, 75);

		String action = "$1,A,1,$1,B,1,$1,B,1,$1,B,1,$1,B,1,$1,B,1,$1,B,1,$1,B,1,$1,B,1";
		List<ItemInventory> requested = new ArrayList<>();

		String[] actions = action.split(",");
		int coins = 0;
		int group_coins = 0;
		for (int i = 0; i < actions.length; i++) {
			if (actions[i].startsWith("$")) {
				group_coins += (Integer.parseInt((actions[i].charAt(1))+"")* 100);
			}
			if ((int) actions[i].charAt(0) >= 65 && (int) actions[i].charAt(0) <= 90) {

				// letter
				ItemInventory it = machine.new ItemInventory();
				it.id = actions[i];
				requested.add(it);
				i++;
				while (i < actions.length && it.id_number == 0) {
					if (actions[i].equals("#")
							|| ((int) actions[i].charAt(0) >= 65 && (int) actions[i].charAt(0) <= 90)) {
						requested.remove(requested.size() - 1);
						i++;
						break;
					}
					if ((int) actions[i].charAt(0) >= 49 && (int) actions[i].charAt(0) <= 57) {// agar
																								// addad
																								// dade
																								// bood
						ItemInventory tmp = requested.get(requested.size() - 1);
						tmp.id_number = Integer.parseInt(actions[i]);
						for (ItemInventory ite : items) {
							if (ite.equals(tmp)) {
								tmp.cost= ite.cost;
								break;
							}
						}
						// bebin azash darim yana ?
						// age nadarim remove mishe break;
						if (checkItemInventory(tmp, items)) {
							// mohaseb baraye inke darad ya na age nadasht
							// hazfesh
							// kon
							if (tmp.cost == group_coins && tmp.cost > 0) {
								for (ItemInventory ite : items) {
									if (ite.equals(tmp)) {
										if (ite.quantity > 0) {
											ite.quantity--;
											coins = 0;
										} else {
											requested.remove(requested.size() - 1);
										}
										i++;
										break;
									}
								}
								i++;
								break;
							}
							if (tmp.cost > group_coins) {
								// TODO
								// i++;
								// break;
							}
							if (tmp.cost < group_coins) {
								if (outOfMoney(changes)) {
									requested.remove(requested.size() - 1);
									break;
								}
								greedyChangeCalc(changes, tmp.cost);
								group_coins = 0;
							}
							break;
						}
					}
					if (actions[i].startsWith("$")) {
						group_coins += new Double(actions[i].charAt(1));
						break;
					}
				}
				continue;
			} else if (actions[i].equals("#")) {
				if (requested.size() > 0) {
					requested.remove(requested.size() - 1);
					group_coins = 0;
				}
				continue;
			}
			coins += group_coins;
			
		}

		System.out.println("$$" + coins);
	}

	

	private static boolean checkItemInventory(ItemInventory item, List<ItemInventory> items) {
		for (ItemInventory it : items) {
			if (item.equals(it)) {
				if (it.quantity > 0) {
					it.quantity--;
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	// public static void changeOperation(Map<Integer, Integer> changes,
	// ItemInventory item) {
	// greedyChangeCalc(Map<Integer, Integer> changes, int change)
	// }

	public static boolean outOfMoney(Map<Integer, Integer> changes) {
		for (Entry<Integer, Integer> entry : changes.entrySet()) {
			if (entry.getValue() > 0)
				return false;
		}
		return true;
	}

	public static void greedyChangeCalc(Map<Integer, Integer> changes, int change) {

		Map<Integer, Integer> needed_coins = new HashMap<>();

		for (Entry<Integer, Integer> entry : changes.entrySet()) {
			if (change < entry.getKey())
				continue;
			else if (change > entry.getKey()) {
				int needed = (int) (change / entry.getKey());
				if (entry.getValue() >= 1) {
					if (entry.getValue() >= needed) {
						change = change - (needed * entry.getKey());
						needed_coins.put(entry.getKey(), needed);
						changes.put(entry.getKey(), entry.getValue() - needed);
					} else {
						change = change - (entry.getKey() * entry.getValue());
						needed_coins.put(entry.getKey(), entry.getValue());
						changes.put(entry.getKey(), 0);
					}

				}
			} else if (change == entry.getKey()) {
				needed_coins.put(entry.getKey(), 1);
				changes.put(entry.getKey(), entry.getValue() - 1);
				change = 0;
			}
		}
		//
		// for (Map.Entry<Integer, Integer> en : needed_coins.entrySet()) {
		// System.out.println(en.getKey() + " currency : " + en.getValue());
		// }

	}

}
