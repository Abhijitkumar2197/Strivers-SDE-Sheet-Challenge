import java.util.* ;
import java.io.*; 
public class Solution {
	
	public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source){
		ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
    for (int i = 0; i < vertices; i++) {
        adj.add(new ArrayList<>());
    }
    for (ArrayList<Integer> edge : vec) {
        int i = edge.get(0);
        int j = edge.get(1);
        int w = edge.get(2);
        adj.get(i).add(new int[]{j, w});
        adj.get(j).add(new int[]{i, w});
    }

    int[] dist = new int[vertices];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[source] = 0;

    int[] parent = new int[vertices];
    Arrays.fill(parent, -1);

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    pq.add(new int[]{0, source});

    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int dis = curr[0];
        int node = curr[1];

        if (dis > dist[node]) {
            continue; // Skip outdated distances
        }

        for (int[] edge : adj.get(node)) {
            int adjNode = edge[0];
            int eW = edge[1];

            if (dis + eW < dist[adjNode]) {
                dist[adjNode] = dis + eW;
                parent[adjNode] = node;
                pq.add(new int[]{dist[adjNode], adjNode});
            }
        }
    }

    ArrayList<Integer> ans = new ArrayList<>();
    for (int d : dist) {
        ans.add(d);
    }
    return ans;
	}
}
