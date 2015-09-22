package ali;
//not completed yet!
public class Sort_InsersionSortList {

	public static void main(String[] args) {
		ListNode ln = new ListNode(3);
		ln.next = new ListNode(6);
		ln.next.next=new ListNode(2);
		insertionSortList(ln);
		
	}

    public static ListNode insertionSortList(ListNode head) {
        while(head.next != null){
        	
        }
    	return null;
    }

}



// Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

