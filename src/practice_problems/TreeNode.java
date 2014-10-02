package practice_problems;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class TreeNode{
	Integer myVal;
	TreeNode myLeft;
	TreeNode myRight;
	public TreeNode(Integer val, TreeNode left, TreeNode right) {
		myVal = val;
		myLeft = left;
		myRight = right;
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null) ), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
		levelOrder(root);
	}
	public static TreeNode buildTree(ArrayList<Integer> lst){
		if(lst.size() <=2){
			return null;
		}
		TreeNode cur = new TreeNode(lst.get(0), buildTree(new ArrayList<>(lst.subList(1, lst.size()/2 - 1))), buildTree(new ArrayList<>(lst.subList(lst.size() / 2 , lst.size() - 1))));
		return cur;
	}
	public static void preOrder(TreeNode root){
		if(root == null){
			return;
			
		}
		System.out.println(root.myVal);
		preOrder(root.myLeft);
		preOrder(root.myRight);
		
	}
	public static void inOrder(TreeNode root){
		if(root == null){
			return;
		}
		inOrder(root.myLeft);
		System.out.println(root.myVal);
		inOrder(root.myRight);
	}
	public static void levelOrder(TreeNode root){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode breakNode = new TreeNode(null, null, null);
		q.add(root);
		q.add(breakNode);
		TreeNode current = root;
		while(current != null){
			current = q.poll();
			if(current.myVal==null){
				System.out.print("\n________\n");
				q.add(breakNode);
				continue;
			}
			System.out.print(current.myVal);
			q.add(current.myLeft);
			q.add(current.myRight);
		}
			
			

	}

}
