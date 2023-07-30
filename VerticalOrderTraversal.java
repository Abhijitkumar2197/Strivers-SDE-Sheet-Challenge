import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
public class Solution 
{
     static class Pair{
        int hd;
        TreeNode node;
        public Pair(int hd, TreeNode node){
            this.hd = hd;
            this.node = node;
        }
    }
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        q.add(new Pair(0, root));
        while(!q.isEmpty()){
            Pair cur = q.poll();
            TreeNode<Integer> node = cur.node;
            if(map.containsKey(cur.hd)){
                map.get(cur.hd).add(node.data);
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(node.data);
                map.put(cur.hd, temp);
            }
            if(cur.node.left != null){
                q.add(new Pair(cur.hd - 1, cur.node.left));
            }
            if(cur.node.right != null){
                q.add(new Pair(cur.hd + 1, cur.node.right));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
            ans.addAll(entry.getValue());
        }
        return ans;
    }
}
