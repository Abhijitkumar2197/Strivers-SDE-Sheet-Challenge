#include <bits/stdc++.h> 
vector<pair<pair<int, int>, int>> calculatePrimsMST(int vertices, int edges, vector<pair<pair<int, int>, int>> &edgesList) {
    vector<vector<pair<int, int>>> adjacencyList(vertices + 1);
    for(auto edge : edgesList) {
        adjacencyList[edge.first.first].push_back(make_pair(edge.first.second, edge.second));
        adjacencyList[edge.first.second].push_back(make_pair(edge.first.first, edge.second));
    }
    vector<int> key(vertices + 1, INT_MAX);
    vector<bool> mst(vertices + 1, false);
    vector<int> parent(vertices + 1, -1);
    key[1] = 0;
    for(int i = 0; i < vertices; i++) {
        int mini = INT_MAX;
        int u = -1;
        for(int j = 1; j <= vertices; j++) {
            if(key[j] < mini && !mst[j]) {
                mini = key[j];
                u = j;
            }
        }
        mst[u] = true;
        for(auto neighbour : adjacencyList[u]) {
            if(!mst[neighbour.first] && key[neighbour.first] > neighbour.second) {
                key[neighbour.first] = neighbour.second;
                parent[neighbour.first] = u;
            }
        } 
    }
    vector<pair<pair<int,int>,int>> result;
    for(int i = 2; i <= vertices; i++) {
        result.push_back(make_pair(make_pair(i, parent[i]), key[i]));
    }
    return result;
}
