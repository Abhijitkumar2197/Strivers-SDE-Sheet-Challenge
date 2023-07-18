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

public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxi = Integer.MIN_VALUE;
        while (!q.isEmpty()){
            TreeNode t = q.poll();
            if((int)t.data == X) return X;
            if((int)t.data > X){
                if(t.left != null) q.add(t.left);
            }else{
                maxi = Math.max(maxi,(int)t.data);
                if(t.right != null)q.add(t.right);
            }
            
        }
        return maxi;
    }
}
