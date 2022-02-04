#include <cstdio>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

void dfs(vector<vector<int>> &adj, vector<int> &depth, vector<vector<int>> & parent, int cur)
{
    for(int next : adj[cur]){
        if(depth[next] == -1)
        {
            depth[next] = depth[cur] + 1;
            parent[next][0] = cur;
            dfs(adj, depth, parent, next);
        }
    }

    return;
}

void connect(vector<vector<int>> &parent, int n, int len)
{
    for(int k = 1 ; k < len ; ++k){
        for(int i = 1 ; i <= n ; ++i)
        {
            parent[i][k] = parent[parent[i][k-1]][k-1];
        }
    }

    return;
}

int LCA(vector<int> &depth, vector<vector<int>> & parent, int u, int v, int len)
{
    if(depth[u] < depth[v]){
        swap(u, v);
    }

    int diff = depth[u] - depth[v];

    for(int k = 0 ; diff != 0 ; ++k)
    {
        if(diff % 2 == 1)
        {
            u = parent[u][k];
        }
        diff /= 2;
    }

    if(u!=v)
    {
        for(int k = len -1 ; k >= 0 ; --k)
        {
            if(parent[u][k] != parent[v][k])
            {
                u = parent[u][k];
                v = parent[v][k];            
            }
            u = parent[u][0];
        }
    }

    return u;
}


int main()
{
    int t;
    scanf("%d", &t);
    
    while(t--)
    {
        int n, root, len;
        scanf("%d", &n);
        vector<vector<int>> adj(n+1);
        vector<int>depth(n+1);
        vector<vector<int>> parent(n+1);
        int u, v;

        len = (int)ceil(log2(n)) + 1;

        for(int i = 0 ; i<=n ; ++i)
        {
            parent[i].resize(len);
        }

        for(int i = 0 ; i < n-1 ; ++i)
        {
            int p, c;
            scanf("%d %d", &p, &c);
            adj[p].push_back(c);
            ++depth[c];
        }

        for(int i = 1 ; i<=n ; ++i)
        {
            if(depth[i] == 0)
            {
                root = i;
            }
        }

        fill(depth.begin(), depth.end(), -1);
        depth[root] = 0;

        dfs(adj, depth, parent, root);
        connect(parent, n, len);


        scanf("%d %d", &u, &v);
        printf("%d\n", LCA(depth, parent, u, v, len));
    }

    return 0;
}