#include <cstdio>
#include <stack>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> adj, ans;
vector<vector<int>> reverse_adj;
vector<bool> visited;
stack<int> s;
int v, e, num;

void reverse_dfs(int cur)
{
    if(visited[cur])
    {
        return;
    }

    visited[cur] = true;
    ans[num].push_back(cur);

    for(int next : reverse_adj[cur])
    {
        reverse_dfs(cur);
    }

    return;
}

void dfs(int cur)
{
    if(visited[cur])
    {
        return;
    }

    visited[cur] = true;

    for(int next: adj[cur])
    {
        dfs(next);
    }

    s.push(cur);

    return;
}

int main()
{
    scanf("%d %d",&v, &e);

    adj.resize(v+1);
    reverse_adj.resize(v+1);
    visited.resize(v+1, false);

    for(int i = 0 ; i < e ; i++)
    {
        int from, to;
        scanf("%d %d", &from, &to);
        adj[from].push_back(to);
        reverse_adj[to].push_back(from);
    }

    for(int i = 1 ; i <= v ; i++)
    {
        dfs(i);
    }

    fill(visited.begin(), visited.end(), false);

    while(!s.empty())
    {
        if(!visited[s.top()])
        {
            ans.push_back(vector<int>());
            reverse_dfs(s.top());
            ++num;
        }

        s.pop();
    }

    printf("%d\n", ans.size());

    for(int i = 0 ; i<ans.size() ; ++i)
    {
        sort(ans[i].begin(), ans[i].end());
    }

    sort(ans.begin(), ans.end());

    for(int i = 0 ; i < ans.size(); ++i)
    {
        for(int j = 0 ; j < ans[i].size() ; ++j)
        {
            printf("%d", ans[i][j]);
        }
        printf("-1\n");
    }

    return 0;
}