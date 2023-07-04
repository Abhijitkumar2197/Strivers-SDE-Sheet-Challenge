/*************************************************************

Following is the Binary Tree Node structure:

    class TreeNode<T> {
		public T data;
		public BinaryTreeNode<T> left;
		public BinaryTreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = null;
			right = null;
	  	}
    }

*************************************************************/

public class Solution {
	static int maxi = 0;

	public static int diameterOfBinaryTree(TreeNode<Integer> root) {
		if(root == null) return 0;
        int a = helper(root.left);
        int b = helper(root.right);
		int c = Math.max(a + b , maxi);
		maxi = 0;
        return c ;
	}
	public static int helper(TreeNode<Integer> root) {
		if(root == null) return 0;
        int a = helper(root.left);
        int b = helper(root.right);
		maxi = Math.max(maxi, a + b);
        return Math.max(a , b) + 1;
	}
}
