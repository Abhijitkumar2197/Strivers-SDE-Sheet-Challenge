import java.util.*;

public class Solution {

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
        int n = edges.size();
        ArrayList<ArrayList<Integer>> ed = new ArrayList<>();
        for(int i = 0; i  < n ; i++) ed.add(new ArrayList<>());
        
        for(int i = 0; i < edges.size(); i++){
            for(int j = 0; j < edges.get(i).size() ; j++){
                if(edges.get(i).get(j) == 1){
                    ed.get(i).add(j);
                    ed.get(j).add(i);
                }
            
            }
            
        }
        int[] store = new int[n];
        Arrays.fill(store,-1);
        boolean vis[] = new boolean[n];
        for(int i  = 0 ; i < n; i++){
            if(vis[i]) continue;
            vis[i] = true;
            store[i] = 0;
            boolean check = isBipartiteHelper(ed,store,vis,i, 0);
            if(!check) return false;
        }
        return true;

    }

    public static boolean isBipartiteHelper(ArrayList<ArrayList<Integer>> graph, int[] store,boolean[] vis,int node,int val){
        store[node] = val;
        for(int i = 0; i < graph.get(node).size(); i++ ){
            if(vis[graph.get(node).get(i)]){
                if(store[graph.get(node).get(i)] == val) return false;
                continue;
            }
            vis[graph.get(node).get(i)] = true;
            boolean check = isBipartiteHelper(graph,store,vis,graph.get(node).get(i),(val == 0) ? 1 : 0);
            if(check == false) return false;
        }
        return true;
    }
}
