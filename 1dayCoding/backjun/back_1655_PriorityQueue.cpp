#include <iostream>
#include <queue>
#include <vector>

#define endl "\n"
#define MAX 100010
using namespace std;

int N;
int Arr[MAX];

void Input()
{
    cin >> N;
    for(int i = 0 ; i < N ; i++)
    {
        cin >> Arr[i];
    }
}

void Solution()
{
    priority_queue<int> Max_PQ;
    priority_queue<int, vector<int>, greater<int>> Min_PQ;
    for(int i = 0 ; i < N ; i++)
    {
        if(Max_PQ.size() > Min_PQ.size())
        {
            Min_PQ.push(Arr[i]);
        }else
        {
            Max_PQ.push(Arr[i]);
        }

        if(Max_PQ.empty() == false && Min_PQ.empty() == false)
        {
            if(Max_PQ.top() > Min_PQ.top())
            {
                int Max_value = Max_PQ.top();
                int Min_value = Min_PQ.top();

                Max_PQ.pop();
                Min_PQ.pop();

                Max_PQ.push(Min_value);
                Min_PQ.push(Max_value);

            }
        }

        cout << Max_PQ.top() << endl;
    }
}

void Solve()
{
    Input();
    Solution();
}

int main(void)
{
    Solve();

    return 0;
}