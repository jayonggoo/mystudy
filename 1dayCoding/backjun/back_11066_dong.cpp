#include <iostream>
#include <algorithm>

using namespace std;

int T, n, a[502], dp[502][502] = {}, sum[502];

int f(int a, int b)
{
    if(dp[a][b] != 987654321)
    {
        return dp[a][b];
    }

    for(int i = 0 ; a + i < b ; i++)
    {
        dp[a][b] = min(dp[a][b], f(a, a + i) + f(i + a + 1, b));
    }

    if(a != 1 || b != n)
    {
        dp[a][b] += sum[b] - sum[a-1];
    }

    return dp[a][b];
}

int main()
{
    cin >> T;
    while(T--)
    {
        cin >> n;
        for(int i = 1; i <=n; i++)
        {
            for(int t = 1; t<=n; t++)
            {
                dp[i][t] = 987654321;
            }
        }

        for(int i =1 ; i<=n ; i++)
        {
            cin >> a[i];
            dp[i][i] = a[i];
            sum[i] = a[i] + sum[i - 1];
        }
        cout << f(1, n) << endl;
    }
}