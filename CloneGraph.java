import java.util.* ;
import java.io.*; 
/***************************************************************************

  Class for graph node is as follows:

  class graphNode {
      public int data;
      public ArrayList<graphNode> neighbours;

      graphNode() {
          data = 0;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int data) {
          data = data;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int data, ArrayList<graphNode> neighbours) {
          data = data;
          this.neighbours = neighbours;
      }
    }

******************************************************************************/

public class Solution {
    public static graphNode cloneGraph(graphNode node) {
        if(node == null){
            return null;
        }
        graphNode copy = new graphNode(node.data);
        graphNode[] visited = new graphNode[100001];
        Arrays.fill(visited, null);
        dfs(node, copy, visited);
        return copy;
    }

    public static void dfs(graphNode node , graphNode copy , graphNode[] visited ){
        visited[copy.data] = copy;
        for(graphNode n : node.neighbours){
            if(visited[n.data] == null){
                graphNode a = new graphNode(n.data);
                copy.neighbours.add(a);
                visited[a.data] = a;
                dfs(n, a, visited);
            }else{
                copy.neighbours.add(visited[n.data]);
            }
        }
    }


}
