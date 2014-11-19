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
	public static int findMiddleList(LinkedListNode root){
		//Excludes circular linked lists
		LinkedListNode currentNode = root;
		LinkedListNode aheadNode = root;
		while(aheadNode!=null){
			if(aheadNode.myNext==null){
				break;
			}
			currentNode = currentNode.myNext;
			aheadNode = aheadNode.myNext.myNext;
		}
		return currentNode.myVal;
	}
	
	
	public static void main(String[] args){
		LinkedListNode seventh = new LinkedListNode(7, null);
		LinkedListNode sixth = new LinkedListNode(6, seventh);
		LinkedListNode fifth = new LinkedListNode(5, sixth);
		LinkedListNode fourth = new LinkedListNode(4, fifth);
		LinkedListNode third = new LinkedListNode(3, fourth);
		LinkedListNode second = new LinkedListNode(2, third);
		LinkedListNode first = new LinkedListNode(1, second);
		
		LinkedListNode root = first;
		printList(root);
		System.out.println();
		//printList(recursiveReverse(null, root));
		System.out.println(findMiddleList(root));

	}
	
	

}
