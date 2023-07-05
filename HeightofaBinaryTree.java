import java.util.* ;
import java.io.*; 

 class Tree{
        int height ;
        int left;
        int right;
        Tree(int h, int l , int r){
            this.height = h;
            this.left = l;
            this.right = r;
        }
    }
public class Solution {
	public static int heightOfTheTree(int[] inorder, int[] levelOrder, int N){
		if(levelOrder.length == 1) return 0;
        int maxHeight = 0;
        HashMap<Integer,Integer> inmap = new HashMap<>();
        for(int i = 0;i  < N; i++){
            inmap.put(inorder[i] , i);
        }
        Queue<Tree> q = new LinkedList<>();
        q.add(new Tree(0,0,N -1));
        for(int i = 0; i < N; i++){
            Tree a = q.poll();
            int height = a.height;
            maxHeight = Math.max(height,maxHeight);
            int left  = a.left;
            int right = a.right;
            int index = inmap.get(levelOrder[i]);
            if(index > left) q.add(new Tree(height + 1, left , index -1));
            if(index < right) q.add(new Tree(height + 1, index +1,right));

        }
        return maxHeight;
	}
}
