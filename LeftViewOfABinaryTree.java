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
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        helper(root, new HashSet<>(), ans, 0);
        return ans;
    }
    public static void helper(TreeNode<Integer> root , HashSet<Integer> set, ArrayList<Integer> list, int h){
        if(root == null) return;
        if(!set.contains(h)){
            list.add(root.data);
            set.add(h);
        }
        helper(root.left, set, list, h + 1);
        helper(root.right, set, list, h + 1);

    }
}
