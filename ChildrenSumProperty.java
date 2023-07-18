import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode < Integer > {
        int data;
        BinaryTreeNode < Integer > left;
        BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/

public class Solution {
    public static void changeTree(BinaryTreeNode < Integer > root) {
        dfsChangeTree(root);    
    }
    public  static void dfsChangeTree(BinaryTreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        int a = 0, b = 0;

        if(root.left != null) a = root.left.data;
        if(root.right != null) b = root.right.data;
        int diff = root.data - (a + b);
        if(diff > 0){
            if(root.left != null) root.left.data = root.data;
            if(root.right != null) root.right.data = root.data;
        }
        dfsChangeTree(root.left);
        dfsChangeTree(root.right);
        root.data = (root.right != null) ? root.right.data : 0 ;
        root.data += (root.left != null) ? root.left.data : 0;
        return;
    }
}
