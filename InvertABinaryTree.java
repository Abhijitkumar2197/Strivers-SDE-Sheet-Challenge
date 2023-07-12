import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {
    public static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root, TreeNode<Integer> leaf) {
        if (root == null) return root;

        ArrayList<TreeNode<Integer>> stack = new ArrayList<>();
        boolean foundLeaf = findNode(root, leaf, stack);

        TreeNode<Integer> newHead = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        TreeNode<Integer> parent = newHead;
        TreeNode<Integer> currentNode = null;

        while (!stack.isEmpty()) {
            currentNode = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            parent.left = currentNode;

            if (currentNode.left != parent) {
                currentNode.right = currentNode.left;
                currentNode.left = null;
            } else {
                currentNode.left = null;
            }

            parent = parent.left;
        }

        return newHead;
    }

    public static boolean findNode(TreeNode<Integer> root, TreeNode<Integer> leaf, ArrayList<TreeNode<Integer>> stack) {
        stack.add(root);

        if (root.left == null && root.right == null) {
            if (root.data.equals(leaf.data)) return true;
            else {
                stack.remove(stack.size() - 1);
                return false;
            }
        }

        boolean foundLeft = false, foundRight = false;

        if (root.left != null) foundLeft = findNode(root.left, leaf, stack);
        if (foundLeft) return true;

        if (root.right != null) foundRight = findNode(root.right, leaf, stack);
        if (foundRight) return true;

        stack.remove(stack.size() - 1);
        return false;
    }
}

