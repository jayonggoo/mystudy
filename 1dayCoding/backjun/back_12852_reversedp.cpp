#include <bits/stdc++.h>

using namespace std;

int dp[1000001];
int before[1000001];


int solve(int x)
{
    dp[1] = 0;
    before[1] = -1;

    for( int i = 2; i <= x; ++i){
        dp[i] = dp[i - 1] + 1;
        before[i] = i - 1;

        if(i % 2 == 0 && dp[i] > dp[i/2] + 1)
        {
            dp[i] = dp[i/2] + 1;
            before[i] = i / 2;
        }

        if(i % 3 == 0 && dp[i] > dp[i / 3] + 1)
        {
            dp[i] = dp[i / 3] + 1;
            before[i] = i / 3;
        }
    }

    return dp[x];
}


int main()
{
    int n;
    cin >> n;
    cout << solve(n) << endl;

    while ( n != -1)
    {
        cout << n << endl;
        n = before[n];
    }

    cout << "\n";

    return 0;
}