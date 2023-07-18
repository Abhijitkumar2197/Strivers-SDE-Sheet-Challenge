import java.util.* ;
import java.io.*; 
/*************************************************************
    
    Following is the Binary Tree node structure:

    class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	   }
    }

*************************************************************/

public class Solution {
	public static boolean pairSumBst(BinaryTreeNode root, int k) {
		HashSet<Integer> set = new HashSet<>();
		Queue<BinaryTreeNode> q = new LinkedList();
		q.add(root);
		set.add(root.data);
		while(!q.isEmpty()){
			int len = q.size();
			for(int i= 0;i  < len; i++){
				BinaryTreeNode a = q.poll();
				if(set.contains(k - a.data)) return true;
				set.add(a.data);
				if(a.left != null) q.add(a.left);
				if(a.right != null) q.add(a.right);
			}
		}
		return false;
	}
}

