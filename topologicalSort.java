import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int count[] = new int[v];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i < v; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < e; i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }
        for(int i  = 0; i < v ; i++){
            ArrayList<Integer> l = adj.get(i);
            for(int a : l){
                count[a]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < v ; i++){
            if(count[i] == 0){
                q.add(i);
            }
        }
        int k = 0;
        while(!q.isEmpty()){
            int a = q.poll();
            ans.add(a);
            for(int  i : adj.get(a)){
                count[i]--;
                if(count[i] == 0){
                    q.add(i);
                }
            }
        }
        return ans;
    }
}
