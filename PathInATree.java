import java.util.* ;
import java.io.*; 
/*   
    Following is the Binary Tree node structure for referance:

    class TreeNode
    {
        int data;
        TreeNode left, right;
    
        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
*/

public class Solution {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        ArrayList<Integer> ans= new ArrayList<>();
        pathhelper(root,x,ans);

        return ans;
    }
    public static boolean pathhelper(TreeNode root , int x, ArrayList<Integer> ans){
        if(root == null) return false;
        ans.add(root.data);
        if(root.data == x) return true;
        if (pathhelper(root.left , x, ans) || pathhelper(root.right , x, ans)) return true;
        ans.remove(ans.size() - 1);
        return  false;
    }
}
