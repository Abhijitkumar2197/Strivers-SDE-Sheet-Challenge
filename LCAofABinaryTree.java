import java.util.* ;
import java.io.*; 
/************************************************************

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

************************************************************/

public class Solution 
{
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y)
    {
        int[] ans = {-1};
        lowestHelper(root,x,y,ans);
        return ans[0];
    }
    public static boolean lowestHelper(TreeNode<Integer> root, int x, int y, int[] ans){
        if(root == null) return false;
        boolean left = lowestHelper(root.left,x,y,ans);
        boolean right = lowestHelper(root.right,x,y,ans);
        if(left && right) if(ans[0] == -1){
            ans[0] = root.data;
            return false;
        } 
        if((left && (root.data == x  || root.data == y)) || (right && (root.data == x  || root.data == y))) ans[0] = root.data;
        if(ans[0] != -1) return false;
        return left || right || (root.data == x  || root.data == y);
    }
}
