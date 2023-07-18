import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

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
	public static int t;
	public static int kthSmallest(TreeNode<Integer> root, int k) 
	{
		t = k;
		int[] ans = {-1};
		inorder(root,ans);
		t = -1;
		return ans[0];
	}
	public static void inorder(TreeNode<Integer> root,  int[] ans){
		if(root == null) return;
		inorder(root.left,ans);
		t--;
		if(ans[0] == -1 && 0 == t) ans[0] = (int)root.data; 
		
		inorder(root.right, ans);

	}

}
