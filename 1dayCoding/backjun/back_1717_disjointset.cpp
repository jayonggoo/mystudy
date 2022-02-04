#include <cstdio>

using namespace std;

long long parent[1000001];
int n;

long long do_find(long long x)
{
    if(x == parent[x]) 
    {
        return x;
    }
    return parent[x] = do_find(parent[x]);
}

void do_union(long long x, long long y)
{
    long long px = do_find(x);
    long long py = do_find(y);

    if(px > py) parent[px] = py;
    else if(px < py) parent[py] = px;
}

int main()
{
    int m;

    scanf("%d %d", &n, &m);

    for(int i = 0 ; i <= n ; i++)
    {
        parent[i] = i;
    }

    for(int i = 0 ; i < m ; i++)
    {
        int op, x, y;
        scanf("%d %d %d", &op, &x, &y);

        if(op == 0)
        {
            do_union(x, y);
        }else{
            if(do_find(x) == do_find(y))
            {
                printf("YES\n");
            }else{
                printf("NO\n");
            }
        }
    }

    return 0;
}