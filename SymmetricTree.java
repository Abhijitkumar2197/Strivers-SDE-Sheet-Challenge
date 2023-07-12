/*****************************************************************

    Following is the representation for the Binary Tree Node:

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

****************************************************************/

public class Solution {

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        if(root == null) return true;
        return istrue(root.left , root.right );
    }

    public static boolean istrue(BinaryTreeNode<Integer> left , BinaryTreeNode<Integer> right){
        if(left == null && right == null){
            return true;
        }
        if((left == null && right != null) || (left != null && right == null)){
            return false;
        }
        if(!(left.data).equals(right.data)){
            return false;
        }
        boolean c1  = istrue(left.left,right.right);
        boolean c2  = istrue(left.right,right.left);
        return c1 && c2;
    }
}
