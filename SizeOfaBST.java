import java.util.* ;
import java.io.*; 
/*************************************************************************

    Following is the class structure of the Node class:

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************************/

public class Solution {

    static class Node {
        public int size;
        public int minValue;
        public int maxValue;

        public Node(int size, int minValue, int maxValue) {
            this.size = size;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }

    public static int largestBST(TreeNode<Integer> root) {
        return compute(root).size;
    }

    public static Node compute(TreeNode<Integer> node) {
        if (node == null) {
            return new Node(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Node left = compute(node.left);
        Node right = compute(node.right);

        if (node.data >= left.maxValue && node.data <= right.minValue) {
            return new Node(left.size + right.size + 1, Math.min(left.minValue, node.data), Math.max(node.data, right.maxValue)
            );
        }

        return new Node(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

