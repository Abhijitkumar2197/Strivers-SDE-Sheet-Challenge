import java.util.* ;
import java.io.*; 
 
 
/*************************************************************
	Following is the Binary Tree node structure
	class TreeNode<T> {
		public T data;
		public TreeNode<T> left;
		public TreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = right = null;
		}

};************************************************************/
public class Solution {
 
	public static TreeNode<Integer> preOrderTree(int[] preOrder) {
 		return bst(preOrder);
	}
	public static TreeNode bst(int[] preorder){
        if(preorder.length == 0){
            return null;
        }
        if(preorder.length == 1){
            return new TreeNode(preorder[0]);
        }
        TreeNode node = new TreeNode(preorder[0]);
        int data = (int)node.data;
        int index = 0;
        for(int i = 1; i < preorder.length; i++){
            if(preorder[i] > data
){
                index = i;
                break;
            }
        }
        if(index >0 )node.right = bst(Arrays.copyOfRange(preorder,index,preorder.length));
        if(index == 0){
            index = preorder.length;
        }
        if(index >= 1)node.left = bst(Arrays.copyOfRange(preorder , 1,index));
        return node;
    }

}
