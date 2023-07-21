import java.util.ArrayList;

public class Solution {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ed = new ArrayList<>();
        for(int i = 0; i  < v ; i++) ed.add(new ArrayList<>());
        for(int i = 0; i < edges.size(); i++){
            ed.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            ed.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
        boolean[] vis = new boolean[v];
        for(int i= 0; i < v; i++){
            if(vis[i]) continue;
            ArrayList<Integer> list = new ArrayList<>();
            dfs(i,ed,list,vis);
            ans.add(list);
        }
        return ans;
    }
    public static void dfs(int node , ArrayList<ArrayList<Integer>> edges ,ArrayList<Integer> list, boolean[] vis  ){
        if(vis[node]) return;
        list.add(node);
        vis[node] = true;
        for(int a : edges.get(node)){
            dfs(a, edges,list,vis);
        }
    }
}
