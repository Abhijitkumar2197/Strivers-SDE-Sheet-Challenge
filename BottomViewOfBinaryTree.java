import java.util.* ;
import java.io.*; 
/*********************************************

    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

*********************************************/


public class Solution {
    static class Pair{
        int index ;
        BinaryTreeNode node;
        
        Pair(int a , BinaryTreeNode node){
            this.index = a;
            this.node = node;
        }
    }
    
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0;i  < len ; i++){
                Pair p = q.poll();
                map.put(p.index,p.node.val);
                if(p.node.left != null) q.add(new Pair(p.index - 1, p.node.left));
                if(p.node.right != null) q.add(new Pair(p.index + 1, p.node.right));
            }
        }
        while (!map.isEmpty()){
            ans.add(map.get(map.firstKey()));
            map.remove(map.firstKey());
        }
        return ans;
    }
}
