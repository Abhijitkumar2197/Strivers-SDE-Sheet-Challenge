import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }

    }

************************************************************/

import java.util.ArrayList;

// import javax.swing.tree.TreeNode;

public class Solution {
	public static  ArrayList<Integer> traverseBoundary(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();

    if (root == null) return ans;
    if (root.left == null && root.right == null) {
        ans.add(root.data);
        return ans;
    }

    // Add the root node
    ans.add(root.data);

    // Traverse the left boundary
    TreeNode curr = root.left;
    while (curr != null) {
        if (curr.left != null || curr.right != null) {
            ans.add(curr.data);
        }
        if (curr.left != null) {
            curr = curr.left;
        } else {
            curr = curr.right;
        }
    }

    dfshel(root, ans);

    Stack<Integer> stack = new Stack<>();
    curr = root.right;
    while (curr != null) {
        if (curr.left != null || curr.right != null) {
            stack.push(curr.data);
        }
        if (curr.right != null) {
            curr = curr.right;
        } else {
            curr = curr.left;
        }
    }

    while (!stack.isEmpty()) {
        ans.add(stack.pop());
    }

    return ans;
    }

    public static void dfshel(TreeNode root, ArrayList<Integer> ans){
        if(root == null) return;
        if(root.right == null && root.left == null){
            ans.add(root.data);
            return;
        }
        dfshel(root.left, ans);
        dfshel(root.right, ans);
    }
}
