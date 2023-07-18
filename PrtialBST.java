import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

 *************************************************************/

public class Solution {
    public static boolean validateBST(BinaryTreeNode root) {
        return valiBST(root, Integer.MAX_VALUE);
    }
    
    public static boolean valiBST(BinaryTreeNode root, int bound){
        if(root == null) return true;
        if(root.left != null){
            if(root.left.data > root.data){
                return false;
            }
        }if(root.right != null){
            if(root.right.data < root.data){
                return false;
            }
        }
        return valiBST(root.left , root.data) && valiBST(root.right , bound);
    }
}
