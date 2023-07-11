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

import java.util.ArrayList;

public class Solution 
{
    
    public static TreeNode<Integer> buildBinaryTree(ArrayList<Integer>  inorder, ArrayList<Integer>  preorder)
    {
        int[] index= {0};
        TreeNode<Integer> a = buidTreeHelper(inorder,preorder , 0 ,inorder.size() - 1, index);
        return a;
    }
      public static TreeNode<Integer> buidTreeHelper(ArrayList<Integer> inorder, ArrayList<Integer> preorder , int start , int end , int[] index){
        if(start > end) return null;
        if(start == end){
            index[0]++;
            return new TreeNode(inorder.get(end));
            
        } 
        int a = preorder.get(index[0]++);
        TreeNode<Integer> t = new TreeNode(a);
        int i  = start;
        while(i <= end && !(inorder.get(i)).equals(a)) i++;
        t.left = buidTreeHelper( inorder, preorder, start , i - 1, index);
        t.right = buidTreeHelper(inorder, preorder , i + 1 ,end, index);
        return t;
    }
}
