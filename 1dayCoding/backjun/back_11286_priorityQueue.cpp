#include <cstdio>
#include <algorithm>
#include <queue>
#include <cstdlib>

using namespace std;

typedef pair <int, int> pi;
int main()
{
    int N, num, i;
    pi temp;

    priority_queue<pi, vector<pi>, greater<pi>> q;

    scanf("%d", &N);
    if(num == 0)
    {
        if(q.empty())
        {
            printf("0\n");
        }else
        {
            temp = q.top();
            printf("%d\n", temp.second);
            q.pop();
        }
    }
    else{
        q.push(make_pair(abs(num), num));
    }

    return 0;
}
