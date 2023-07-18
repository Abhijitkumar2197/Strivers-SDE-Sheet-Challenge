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

    public  static int findCeil(TreeNode<Integer> node, int x) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        int maxi = Integer.MAX_VALUE;
        while (!q.isEmpty()){
            TreeNode t = q.poll();
            if((int)t.data == x) return x;
            if((int)t.data < x){
                if(t.right != null) q.add(t.right);
            }else{
                maxi = Math.min(maxi,(int)t.data);
                if(t.left != null)q.add(t.left);
            }

        }
        if(maxi == Integer.MAX_VALUE) return -1;
        return maxi;

    }
}
