#include <vector>
#include <unordered_set>

bool dfs(int current, vector<vector<int>>& adj, vector<int>& visited, vector<int>& dfsVisited) {
    visited[current] = 1;
    dfsVisited[current] = 1;

    for (auto child : adj[current]) {
        if (!visited[child]) {
            if (dfs(child, adj, visited, dfsVisited))
                return true;
        } else if (dfsVisited[child]) {
            return true;
        }
    }

    dfsVisited[current] = 0;
    return false;
}

int detectCycleInDirectedGraph(int n, vector<pair<int, int>>& edges) {
    vector<vector<int>> adj(n + 1);
    for (int i = 0; i < edges.size(); i++) {
        adj[edges[i].first].push_back(edges[i].second);
    }

    vector<int> visited(n + 1, 0);
    vector<int> dfsVisited(n + 1, 0);

    for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
            if (dfs(i, adj, visited, dfsVisited))
                return true;
        }
    }

    return false;
}
