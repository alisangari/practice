package moji;

public class LinkedList<Key, Value> {
	private Node first;

	public class Node {
		Key key;
		Value val;
		Node next;

		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	public Node findByKey(Key key) {
		for (Node x = first; x != null; x = x.next)
			if (x.key == key)
				return x;
		return null;
	}

	public Node findPrevious(Node node) {
		for (Node x = first; x != null; x = x.next) {
			if (x.next == node)
				return x;
		}
		return null;
	}

	public Node findLatter(Node node) {
		for (Node x = first; x != null; x = x.next)
			if (x.next != null)
				return x.next;
		return null;
	}

	public void put(Key key, Value value) {
		Node node = findByKey(key);
		if (node != null)
			node.val = value;
		else
			first = new Node(key, value, first);
	}

	public Value get(Key key) {
		if (findByKey(key) != null)
			return findByKey(key).val;
		else
			return null;
	}

	public String print(Key start) {
		Node s = findByKey(start);
		String str = "";
		if (s != null) {
			for (Node x = s; x != null; x = x.next)
				str += makeVisual(x);
		} else
			str = "can not finde this element in link for start";
		return str;
	}

	public String makeVisual(Node node) {
		String str = "";
		if (node != null) {
			if (node.next != null)
				str += "(" + node.key + "," + node.val + ")" + "->";
			else
				str += "(" + node.key + "," + node.val + ")";
		} else
			str = "Null";
		return str;
	}

	public void remove(Key key) {
		Node node = findByKey(key);
		Node pre = findPrevious(node);
		Node latter = findLatter(node);
		if (pre != null)
			pre.next = latter;
		else
			first = latter;
	}

	public Node findLast(LinkedList<Key, Value> linkdList) {
		Node flag = linkdList.first;
		for (Node x = linkdList.first; x != null; x = x.next)
			if (x.next != null)
				flag = x.next;
			else
				flag = x;
		return flag;
	}

	public void add(Key key, LinkedList<Key, Value> lst) {
		Node x = findByKey(key);
		if (x != null) {
			Node latest = lst.findLast(lst);
			latest.next = x.next;
			x.next = lst.first;
		}
	}

	public boolean isCircle() {// brent algorithm
		Node fast = first;
		Node slow = first;
		int counter = 0;
		int limit = 2;
		while (slow.next != null || fast.next != null) {
			if (fast == null)
				return false;
			fast = fast.next;
			counter++;
			if (fast == slow)
				return true;
			if (counter == limit) {
				counter = 0;
				limit = limit * 2;
				slow = fast;
			}
		}
		return false;
	}

}
