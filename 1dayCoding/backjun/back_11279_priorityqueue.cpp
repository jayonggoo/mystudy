
/*
#include <stdio.h>
#include <iostream>
#include <queue>

using namespace std;

int n;
priority_queue<int> pq;
int main()
{
    cin >> n;
    while(n--)
    {
        int x;
        cin >> x;
        if(x==0){
            if(pq.empty()){
                cout << "0\n";
            }else{
                cout << pq.top() << "\n";
                pq.pop();
            }
        }else{
            pq.push(x);
        }
    }
    return 0;

}*/


#include <stdio.h>
#define MAX_N 100001

int heap[MAX_N];
int size = 0;

void swap(int *a, int *b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

void insert(int data) {
	int idx = ++size;

	while ((idx != 1) && (data>heap[idx / 2])) {
		heap[idx] = heap[idx / 2];
		idx /= 2;
	}
	heap[idx] = data;
}

int deleteheap() {
	if (size == 0)
		return 0;
	int value = heap[1];
	//1에  힙에 제일 마지막에 있는 데이터 삽입 
	heap[1] = heap[size--];
	int parent = 1;
	int child;

	while (1) {
		child = parent * 2;
		//왼쪽 오른쪽 선택하는거 
		if (child + 1 <= size && heap[child] <heap[child + 1])
			child++;

		if (child > size || heap[child] < heap[parent])
			break;

		swap(&heap[parent], &heap[child]);
		parent = child;
	}

	return value;

}
int main() {
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		int x;
		scanf("%d", &x);
		if (x == 0)
		{
			printf("%d\n", deleteheap());
		}
		else
		{
			insert(x);
		}
	}


}