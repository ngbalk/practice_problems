package practice_problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode{
	int myVal;
	TreeNode myLeft;
	TreeNode myRight;
	public TreeNode(int val, TreeNode left, TreeNode right) {
		myVal = val;
		myLeft = left;
		myRight = right;
	}


	public static void main(String[] args) {
		int[] toBuild = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = toBuild.length - 1; i>=0; i--){
			stack.push(toBuild[i]);
		}
		TreeNode root = buildTree(stack);
		levelOrder(root);
	}
	public static TreeNode buildTree(Stack<Integer> stack){
		if(stack.isEmpty()){
			return null;
		}
		TreeNode cur = new TreeNode(stack.pop(), buildTree(stack), buildTree(stack));
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
		TreeNode breakNode = new TreeNode(100, null, null);
		q.add(root);
		q.add(breakNode);
		while(true){
			TreeNode cur = q.poll();
			while(cur.myVal != 100){
				System.out.print(cur.myVal + " ");
				if(cur.myLeft != null){
					q.add(cur.myLeft);
				}
				if(cur.myRight != null){
					q.add(cur.myRight);
				}
				cur = q.poll();
			}
			if(q.isEmpty()){
				break;
			}
			System.out.println();
			q.add(breakNode);
		}
	}

}
