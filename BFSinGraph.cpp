#include <bits/stdc++.h> 
vector<int> BFS(int vertex, vector<pair<int, int>> edges)
{
    int n = vertex;
    int m = edges.size();

    vector<int> adj[n];
    for (int i = 0; i < m; i++) {
        int u = edges[i].first;
        int v = edges[i].second;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int i = 0; i < n; i++) {
        sort(adj[i].begin(), adj[i].end());
    }

    int visited[n] = {0};
    visited[0] = 1;

    queue<int> q;
    q.push(0);

    vector<int> bfsTraversal;

    while (!q.empty()) {
        int node = q.front();
        bfsTraversal.push_back(node);
        q.pop();

        for (auto neighbor : adj[node]) {
            if (!visited[neighbor]) {
                visited[neighbor] = 1;
                q.push(neighbor);
            }
        }
    }

    for (int i = 0; i < n; i++) {
        if (visited[i] == 0) {
            bfsTraversal.push_back(i);
        }
    }

    return bfsTraversal;
}
