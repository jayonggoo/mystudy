#include <stdio.h>
#include <string.h>
#include <queue>
#include <vector>

using namespace std;

int tc, n, m, a, b;
int mat[501][501], order[501], in[501];

int main(){
    scanf("%d", &tc);
    while(tc--)
    {
        memset(mat, 0, sizeof(mat));
        memset(in, 0, sizeof(in));

        scanf("%d", &n);

        for(int i = 1 ; i<= n ; ++i)
        {
            scanf("%d", &order[i]);
        }

        for(int i = 1 ; i <= n ; ++i)
        {
            for(int j = i + 1 ; j <= n ; ++j)
            {
                mat[order[i]][order[j]] = 1;
                in[order[j]]++;
            }
        }

        scanf("%d", &m);
        for(int i = 0 ; i < m ; ++i)
        {
            scanf("%d %d", &a, &b);
            if(mat[a][b])
            {
                mat[a][b] = 0;
                mat[b][a] = 1;
                in[b]--;
                in[a]++;
            }else{
                mat[b][a] = 0;
                mat[a][b] = 1;
                in[a]--;
                in[b]++;
            }
        }

        queue<int> q;
        for(int i = 1 ; i<= n ; ++i)
        {
            if(!in[i])
            {
                q.push(i);
            }
        }

        bool certain = true;

        vector<int> ans;
        while(!q.empty())
        {
            if(q.size() > 1)
            {
                certain = false;
                break;
            }

            int cur = q.front();
            q.pop();
            ans.push_back(cur);

            for(int next = 1 ; next <= n; ++next)
            {
                if(mat[cur][next])
                {
                    in[next]--;
                    if(!in[next])
                    {
                        q.push(next);
                    }
                }
            }
        }

        if(!certain)
        {
            puts("?");
        }else if(ans.size() == n)
        {
            for(int i = 0 ; i <n ; ++i)
            {
                printf("%d ", ans[i]);
            }
            puts("");
        }else
        {
            puts("IMPOSSIBLE");
        }
    }
    return 0;
}