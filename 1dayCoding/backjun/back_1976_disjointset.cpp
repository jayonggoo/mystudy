#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

const int MAX = 200 + 1;

int N, M;
int arr[MAX];

int findParent(int num)
{
    if (arr[num] < 0)
    {
        return num;
    }

    int parent = findParent(arr[num]);
    arr[num] = parent;
    return parent;
}

void merge(int aParent, int bParent)
{
    if(abs(aParent) >= abs(bParent))
    {
        arr[aParent] += arr[bParent];
        arr[bParent] = aParent;
    }else{
        arr[bParent] += arr[aParent];
        arr[aParent] = bParent;
    }
}

int main(void)
{
    cin >> N >> M;

    memset(arr, -1, sizeof(arr));

    for(int i = 1 ; i <= N ; i++)
    {
        for(int j = 1 ; j<= N ; j++)
        {
            int connected;
            cin >> connected;

            if(connected)
            {
                int aParent = findParent(i);
                int bParent = findParent(j);
                if(aParent == bParent)
                {
                    continue;
                }

                merge(aParent, bParent);
            }
        }
    }

    int root;
    bool possible = true;

    for(int i = 0 ; i < M ; i++)
    {
        int city;
        cin >> city;

        if(i == 0)
        {
            root = findParent(city);
        }else
        {
            if (root != findParent(city))
            {
                possible = false;
                break;
            }
        }
    }

    if(possible)
    {
        cout << "YES\n";
    }else{
        cout << "NO\n";
    }

    return 0;
}