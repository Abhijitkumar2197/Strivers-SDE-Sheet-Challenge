import java.util.* ;
import java.io.*; 
/*

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

*/

public class Solution 
{

	public static TreeNode LCAinaBST(TreeNode root, TreeNode p, TreeNode q) 
    {		
        int min = Math.min((int)p.data,(int) q.data);
        int max = Math.max((int)p.data, (int)q.data);
        return dfs(root,min,max);
    }
    public static TreeNode dfs(TreeNode root, int min, int max){
        if(root == null) return null;
        if(root.data.equals(min) || root.data.equals(max)) return root;
        TreeNode left = ((int)root.data < min) ? null : dfs(root.left, min, max);
        TreeNode right = ((int)root.data > max) ? null : dfs(root.right, min, max);
        return (right == null) ? left : left == null ? right : root;
    }
}
