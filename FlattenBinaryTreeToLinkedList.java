import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure.

	class TreeNode<T> 
	{
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) 
	    {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

************************************************************/

public class Solution 
{
    public static TreeNode flattenBinaryTree(TreeNode root)
    {
        TreeNode head = root;
        flattenHelper(root);

        return head;
    }
    
    public static void flattenHelper(TreeNode root){
        if(root == null || (root.right == null && root.left == null) ) return;
        if(root.left != null)flattenHelper(root.left);
        if(root.right != null)flattenHelper(root.right);
        TreeNode a = root.right;
        TreeNode t = root.left;
		if(t == null) return;
        while(t.right != null){
            t = t.right;
        }
        t.right = a;
        root.right = root.left;
        root.left = null;
        
    }
}
