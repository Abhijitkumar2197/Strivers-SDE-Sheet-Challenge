import java.util.* ;
import java.io.*; 
/*
    Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        this.left = null;
	        this.right = null;
	    }
	}
*/

public class Solution {
	public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
		Queue<BinaryTreeNode> q = new LinkedList<>();
        if(root == null) return false;
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len ; i++){
                BinaryTreeNode a = q.poll();
                if(a.data.equals(x)) return true;
                if(a.left != null) q.add(a.left);
                if(a.right != null) q.add(a.right);
            }
        }
		return false;
	}
}
