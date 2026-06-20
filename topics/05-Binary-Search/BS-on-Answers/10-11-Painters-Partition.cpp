#include<bits/stdc++.h>
using namespace std;

// Painter's Partition Problem - Leetcode 410
//Split Array Largest Sum - Leetcode 410

int countPainters(vector<int>& boards, int maxLoadAllowed)
{
    int load = 0;
    int paintersUsed = 1;

    for (int board : boards)
    {
        if (load + board <= maxLoadAllowed)
        {
            load += board;
        }
        else
        {
            load = board;
            paintersUsed++;
        }
    }
    return paintersUsed;
}

int paintersBrute(vector<int>& boards, int totalPainters)
{
    int low = *max_element(boards.begin(), boards.end());
    int high = accumulate(boards.begin(), boards.end(), 0);

    for (int maxLoad = low; maxLoad <= high; maxLoad++)
    {
        if (countPainters(boards, maxLoad) == totalPainters)
        {
            return maxLoad;
        }
    }
    return -1;
}

int paintersOptimal(vector<int>& boards, int totalPainters)
{
    int low = *max_element(boards.begin(), boards.end());
    int high = accumulate(boards.begin(), boards.end(), 0);
    int answer = -1;

    while (low <= high)
    {
        int mid = (low + high) / 2;

        if (countPainters(boards, mid) <= totalPainters)
        {
            answer = mid;
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return answer;
}

int main()
{
    vector<int> boards {10, 20, 30, 40};
    int totalPainters = 2;

    cout << paintersBrute(boards, totalPainters) << endl;
    cout << paintersOptimal(boards, totalPainters) << endl;

    return 0;
}
