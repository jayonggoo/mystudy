#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, x;

int main(){
    cin >> n;
    vector<int> arr;

    for(int i= 0 ; i < n ; i++)
    {
        int x;
        cin >> x;
        arr.push_back(x);
    }

    cin >> x;

    int start = 0, end = n-1;
    int count = 0;

    sort(arr.begin(), arr.end());

    while(start < end){
        if(arr[start] + arr[end] == x){
            count++;
            end--;
        }else if(arr[start] + arr[end] > x){
            end --;
        }else{
            start++;
        }
    }

    cout << count;
}
