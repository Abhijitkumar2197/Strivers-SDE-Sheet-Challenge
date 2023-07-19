import java.util.* ;
import java.io.*; 
/*
    Definition of Node class for reference

    class TreeNode<T> 
    {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

*/
public class Solution {

    static class BSTIterator{

        ArrayList<Integer> list = new ArrayList<>();
            int i = 0;
            BSTIterator(TreeNode<Integer> root){
                // Write your/ code here
                inorder(root);
            }

            int next(){
                return list.get(i++);
                // Write your code here
            }

            boolean hasNext(){
                return i < list.size();
                // Write your code here
            }

            void inorder(TreeNode root){
                if(root == null) return;
                inorder(root.left);
                list.add((int)root.data);
                inorder(root.right);
            }
    }
}

/*
    Your BSTIterator object will be instantiated and called as such:
    BSTIterator iterator = new BSTIterator(root);
    while(iterator.hasNext())
    {
       print(iterator.next()+" ");
    }
*/
