import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	   }
	}


************************************************************/

public class Solution {
	public static int getMaxWidth(TreeNode root) {
		if(root == null) return 0;
        int width = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            int len = q.size();
            width = Math.max(width,len);
            for(int i = 0; i < len; i++){
                Pair a = q.poll();
                min = Math.min(min,a.index);
                max = Math.max(max,a.index);
                if(a.node.left != null) q.add(new Pair(a.index - 1, a.node.left));
                if(a.node.right != null) q.add(new Pair(a.index + 1, a.node.right));
            }
//            width = Math.max(max - min, width);
        }
        return width;
	}
	static class Pair{
        int index ;
        TreeNode node;

        Pair(int a , TreeNode node){
            this.index = a;
            this.node = node;
        }
    }
}
