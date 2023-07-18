import java.util.* ;
import java.io.*; 
/*************************************************************
    Following is the Binary Search Tree node structure

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************/

import java.util.ArrayList;

public class Solution {
	 static int t ;
	public static int KthLargestNumber(TreeNode<Integer> root, int k) {
		t = k;
		int[] ans = {-1};
		inorder(root,ans);
		t = -1;
		return ans[0];
	}

	public static void inorder(TreeNode<Integer> root,  int[] ans){
		if(root == null) return;
		inorder(root.right, ans);
		t--;
		if(ans[0] == -1 && 0 == t) ans[0] = (int)root.data; 
		inorder(root.left,ans);

	}
}
