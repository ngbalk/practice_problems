package practice_problems;

public class LinkedListNode {
	int myVal;
	LinkedListNode myNext;

	public LinkedListNode(int val, LinkedListNode next) {
		myVal = val;
		myNext = next;
	}
	
	public static LinkedListNode reverseList(LinkedListNode root){
		LinkedListNode prev = null;
		LinkedListNode cur = root;
		LinkedListNode next = cur.myNext;
		while(next != null){
			cur.myNext = prev;
			prev = cur;
			cur = next;
			next = next.myNext;
		}
		cur.myNext = prev;
		return cur;
		
	}
	
	public static LinkedListNode recursiveReverse(LinkedListNode previous, LinkedListNode current){
		if(current.myNext==null){
			current.myNext = previous;
			return current;
		}
		LinkedListNode next = current.myNext;
		current.myNext = previous;
		previous = current;
		current = next;
		return recursiveReverse(previous, current);
	}
	public static void printList(LinkedListNode root){
		LinkedListNode current = root;
		while(current != null){
			System.out.println(current.myVal);
			current = current.myNext;
		}
		
	}
	
	
	public static void main(String[] args){
		LinkedListNode last = new LinkedListNode(4, null);
		LinkedListNode third = new LinkedListNode(3, last);
		LinkedListNode second = new LinkedListNode(2, third);
		LinkedListNode first = new LinkedListNode(1, second);
		
		LinkedListNode root = first;
		printList(root);
		System.out.println();
		printList(recursiveReverse(null, root));

	}
	
	

}
