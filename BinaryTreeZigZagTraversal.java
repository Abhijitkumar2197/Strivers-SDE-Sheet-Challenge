import java.util.* ;
import java.io.*; 
/*
	Following is the class used to represent the object/node of the Binary Tree

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}
*/

public class Solution {
	public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
		Stack<BinaryTreeNode> stack = new Stack<>();
        stack.add(root);
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        boolean check = true;
        while(!stack.isEmpty()){
            Stack<BinaryTreeNode> s2 = new Stack<>();
            while(!stack.isEmpty()){
                BinaryTreeNode a = stack.pop();
                ans.add((int)a.data);
                if(check){
                    if(a.left != null)s2.add(a.left);
                    if(a.right != null)s2.add(a.right);

                }else{
                    if(a.right != null)s2.add(a.right);
                    if(a.left != null)s2.add(a.left);
                }
            }
            if(check){
                check = false;
            }else{
                check = true;
            }
            stack = s2;
        }
        return ans;

	}
}
