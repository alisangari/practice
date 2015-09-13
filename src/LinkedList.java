public class LinkedList {
	Node linkedList;

	public static void main(String[] args) {
		LinkedList list = new LinkedList(5);
		System.out.println(list.toString());
		list.append(3);
		list.append(8);
		list.append(7);
		System.out.println(list.toString());
		int len = list.getLen();
		System.out.println("len: " + len);
		int find = list.find(3);
		System.out.println("find: " + find);
		list.remove(3);
		System.out.println(list);

		// insert(9, 2)

		LinkedList list2 = new LinkedList(4);
		list2.append(8);
		list2.append(7);
		System.out.println(list2);
		System.out.println(list.findHitchHikeIndex(list2));

	}

	public LinkedList(int val) {
		linkedList = new Node(null, val);
		// System.out.println(linkedList.getVal());
	}

	/**
	 * @param externalList
	 * @return
	 */
	public int findHitchHikeIndex(LinkedList externalList) {
		Node list1 = this.linkedList;
		Node list2 = externalList.linkedList;
		int i1 = -1;
		int i2 = -1;
		int i3 = -1;
		int startPoint = -1;
		boolean flag = false;
		while (list1.getHead()!=null) {
			i1++;
			i2 = -1;
			while (list2.getHead()!=null) {
				i2++;
				if (get(i1) == externalList.get(i2)) {
					startPoint = i1;
					i3 = i1;
					flag = true;
					while(flag){
						i2++;
						i3++;
						if(get(i3) != externalList.get(i2)){
							flag = false;
							startPoint = -1;
							break;
						}
					}
				}
				list2 = list2.getHead();
			}
			list1 = list1.getHead();
		}
		return startPoint;
	}

	public void insert(int val, int indx) {// TODO
	// //find node at index
	// Node node = this.linkedList;
	// int i = 0;
	// while (node.getHead() != null) {
	// i++;
	// if (i == indx) {
	// //make node point to a new node and the new node to node's prev head
	//
	// } else {
	// node = node.getHead();
	// }
	// }
	//
	//
	}

	public void append(int val) {
		Node node = this.linkedList;
		while (true) {
			if (node.getHead() == null) {
				node.setHead(new Node(null, val));
				break;
			}
			node = node.getHead();
		}
	}

	public void remove(int val) {
		Node node = this.linkedList;
		Node prevNode = this.linkedList;
		while (node.getHead() != null) {
			if (node.getVal() == val) {
				prevNode.setHead(node.getHead());
				break;
			} else {
				prevNode = node;
				node = node.getHead();
			}
		}
	}

	public int get(int indx) {
		Node node = this.linkedList;
		int i = 0;
		int val = -1000;
		while (node.getHead() != null) {
			i++;
			if (i == indx) {
				return node.getVal();
			} else {
				node = node.getHead();
			}
		}
		return val;
	}

	public int find(int val) {
		Node node = this.linkedList;
		int indx = -1;
		while (node.getHead() != null) {
			indx++;
			if (node.getVal() == val) {
				return indx;
			} else {
				node = node.getHead();
			}
		}
		return indx;
	}

	public int getLen() {
		Node node = this.linkedList;
		int len = 1;
		while (node.getHead() != null) {
			node = node.getHead();
			len++;
		}
		return len;
	}

	public String toString() {
		Node node = this.linkedList;
		String str = "";
		while (node.getHead() != null) {
			str += node.getVal() + ", ";
			node = node.getHead();
		}
		str += node.getVal() + ", ";
		return str;
	}
}

class Node {
	private Node head;
	private int val;

	Node(Node head, int val) {
		this.head = head;
		this.val = val;
	}

	void setHead(Node head) {
		this.head = head;
	}

	Node getHead() {
		return this.head;
	}

	void setVal(int val) {
		this.val = val;
	}

	int getVal() {
		return this.val;
	}
}