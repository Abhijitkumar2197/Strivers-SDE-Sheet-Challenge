import java.util.*;
public class Solution {

    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> st = new Stack();
        ArrayList<ArrayList<Integer>> ed = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for(int i = 0; i  < n ; i++) ed.add(new ArrayList<>());
        for(int i = 0; i < edges.length; i++){
            ed.get(edges[i][0]).add(edges[i][1]);
        }
        for(int i= 0; i < n; i++){
            if(vis[i]) continue;
            dfsscc(i,ed,vis,st);
        }
        ArrayList<ArrayList<Integer>> edt = new ArrayList<>();
        for(int i = 0; i  < n ; i++) edt.add(new ArrayList<>());
        for(int i = 0;i  < edges.length;i++){
            edt.get(edges[i][1]).add(edges[i][0]);
        }
        Arrays.fill(vis,false);
        while(!st.isEmpty()){
            int a = st.pop();
            if(vis[a]) continue;
            List<Integer> list = new ArrayList<>();
            dfsT(a, edt,vis,st , list);
            ans.add(list);
        }
        return ans;

    }
    public static void dfsT(int node ,ArrayList<ArrayList<Integer>> edt , boolean[] vis, Stack<Integer> st,List<Integer> list ){
        if(vis[node]) return;
        vis[node] = true;
        list.add(node);
        for(int i = 0; i < edt.get(node).size(); i++){
            dfsT(edt.get(node).get(i),edt,vis,st,list);
        }

    }
    public static void dfsscc(int node , ArrayList<ArrayList<Integer>> edges , boolean[] vis ,Stack<Integer> st ){
        if(vis[node]) return;
        vis[node] = true;
        for(int a : edges.get(node)){
            dfsscc(a, edges,vis,st);
        }
        st.push(node);
    }
}
