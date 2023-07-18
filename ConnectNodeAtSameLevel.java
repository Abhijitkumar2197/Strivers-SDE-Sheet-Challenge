import java.util.* ;
import java.io.*; 
/*
    ----------------- Binary Tree node class for reference -----------------

    class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;
	    public BinaryTreeNode<T> next;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	        next = null;
	    }
	};

*/

public class Solution {
	public static void connectNodes(BinaryTreeNode<Integer> root) {
    	Queue<BinaryTreeNode> q = new LinkedList<>();
        if(root == null) return;
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len ; i++){
                BinaryTreeNode a = q.poll();
                a.next = (i == len -1) ? null : q.peek();
                if(a.left != null) q.add(a.left);
                if(a.right != null) q.add(a.right);
            }
        }
	}
}
