import java.util.* ;
import java.io.*; 
public class Solution {
    static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
      int[] dist = new int[n + 1];
      Arrays.fill(dist, (int)1e9);
      dist[src] = 0;
      for (int i = 1; i <= n; i++) {
          for (int j = 0; j < m; j++) {
              int u = edges.get(j).get(0);
              int v = edges.get(j).get(1);
              int w = edges.get(j).get(2);

              if (dist[u] != (int)1e9 && dist[u] + w < dist[v]) {
                  dist[v] = dist[u] + w;
              }
          }
      }
    for (int j = 0; j < m; j++) {
        int u = edges.get(j).get(0);
        int v = edges.get(j).get(1);
        int w = edges.get(j).get(2);

        if (dist[u] != (int)1e9 && dist[u] + w < dist[v]) {
            return -1;
        }
    }

    return dist[dest];
    }
    
}
