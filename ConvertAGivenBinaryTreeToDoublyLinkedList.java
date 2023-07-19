import java.util.* ;
import java.io.*; 

/*************************************************************
 class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

*************************************************************/


public class Solution {
	
	public static BinaryTreeNode BTtoDLL(BinaryTreeNode root) {
        ArrayList<BinaryTreeNode> ans= new ArrayList<>();
        btinorder(root,ans);
        BinaryTreeNode head = ans.get(0);
        BinaryTreeNode temp = head;
        for(int i = 1; i < ans.size(); i++){
            BinaryTreeNode left = temp;
            temp.right = ans.get(i);
            temp = temp.right;
            temp.left = left;
        }
        return head;
    }

    public static void btinorder(BinaryTreeNode root, ArrayList<BinaryTreeNode> ans){
        if(root == null) return;
        btinorder(root.left,ans);
        ans.add(root);
        btinorder(root.right, ans);
    }
	

}
