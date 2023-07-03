import java.util.* ;

import java.io.*; 
/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/

public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
		List<Integer> preorder = new ArrayList<>();
		List<Integer> inorder = new ArrayList<>();
		List<Integer> postorder = new ArrayList<>();
		helper(root, preorder, inorder, postorder);
		List<List<Integer>> ans = new ArrayList<>();
		ans.add(inorder);
		ans.add(preorder);
		
		ans.add(postorder);
		return ans;


    }

	public static void helper(BinaryTreeNode<Integer> root,List<Integer> preorder,List<Integer> inorder,List<Integer> postorder){
		if(root == null) return;
		preorder.add(root.data);
		helper(root.left, preorder, inorder, postorder);
		inorder.add(root.data);
		helper(root.right, preorder, inorder, postorder);
		postorder.add(root.data);
	}
}
