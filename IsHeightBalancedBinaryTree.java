import java.util.* ;
import java.io.*; 
/*************************************************************

Following is the Binary Tree node structure

class BinaryTreeNode<T> 
{
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

*************************************************************/
public class Solution {

	static boolean gt2 = false;
    public static boolean isBalancedBT(BinaryTreeNode root) {
        if(root == null) return true;
        isBalancedBT3(root);
        if(gt2) {
            gt2 = false;
            return false;
        } 

        return true;
    }
    public static int isBalancedBT3(BinaryTreeNode root) {
        if(root == null) return 0;
        int a = isBalancedBT3(root.left);
        int b=  isBalancedBT3(root.right);
        if(Math.abs(a - b) > 1) gt2 = true;
        return Math.max(a,b) + 1;
    }
}
