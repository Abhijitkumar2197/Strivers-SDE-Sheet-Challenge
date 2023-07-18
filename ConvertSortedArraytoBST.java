import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the TreeNode class:

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


*****************************************************************/

import java.util.ArrayList;

public class Solution {
    public static TreeNode sortedArrToBST(ArrayList<Integer> arr, int n) {
        return makeBST(arr,0,arr.size() - 1);
    }

    public static TreeNode makeBST(ArrayList<Integer> arr, int s, int e){
        if(s - e > 0) return null;
        if(s == e){
            TreeNode t = new TreeNode(arr.get(s));
            return t;
        }
        int mid = (s + e) / 2;
        TreeNode t = new TreeNode(arr.get(mid));
        t.left = makeBST(arr,s,mid - 1);
        t.right = makeBST(arr, mid + 1, e);
        return t;
    }
}
