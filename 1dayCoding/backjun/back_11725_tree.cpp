#include <iostream>
#include <vector>
#include <queue>

using namespace std;

const int MAX = 100001;

int N;
vector<vector<int>> v;

int parent[MAX];
bool isChecked[MAX];


void input()
{
    cin >> N;
    v.resize(N+1);
    for(int i = 0 ; i < N - 1 ; i++)
    {
        int x, y;
        cin >> x >> y;
        v[x].push_back(y);
        v[y].push_back(x);
    }
}

void bfs()
{
    queue<int> q;
    q.push(1);
    isChecked[1] = true;

    while(!q.empty())
    {
        int x = q.front();
        q.pop();

        for(int nx : v[x])
        {
            if(!isChecked[nx])
            {
                parent[nx] = x;
                isChecked[nx] = true;
                q.push(nx);
            }
        }
    }
}

void printAnswer()
{
    for(int i = 2;  i <= N ; i++)
    {
        cout << parent[i] << "\n";
    }
}

int main()
{
    input();
    bfs();
    printAnswer();

    return 0;
}
