import java.util.*;

public class Solution {
    
    public static String cycleDetection(int[][] edges, int n, int m) {
       ArrayList<ArrayList<Integer>> ed = new ArrayList<>();
        boolean[] vis = new boolean[n + 1];
        for(int i = 0; i  <= n ; i++) ed.add(new ArrayList<>());
        for(int i = 0; i < edges.length; i++){
            ed.get(edges[i][0]).add(edges[i][1]);
            ed.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] found = {false};
        for(int i = 1; i <= n; i ++){
            if(found[0]) return "Yes";
            if(vis[i])continue;
            
            dfs2(ed,i,new HashSet<>(),-1,found,vis);
        }
        if(found[0]) return "Yes";
        else return "No";
    }
    public static void dfs2(ArrayList<ArrayList<Integer>> ed , int node , HashSet<Integer> set , int prev , boolean[] found , boolean[] vis){
        for(int i  = 0; i < ed.get(node).size(); i++){
            if(found[0]) return;
            if(ed.get(node).get(i) == prev) continue;
            if(set.contains(ed.get(node).get(i))){
                found[0] = true;
                return;
            }
            set.add(ed.get(node).get(i));
            dfs2(ed,ed.get(node).get(i),set,node,found,vis);
            set.remove(ed.get(node).get(i));
        }
        vis[node] = true;
    }
    
}
