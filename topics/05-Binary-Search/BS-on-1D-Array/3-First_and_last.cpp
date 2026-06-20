#include <bits/stdc++.h>
using namespace std;
// Leetcode 34
vector<int> firstandlast1(vector<int> &arr, int target) // linear search most simplest
{
    int n = arr.size();
    int low = -1;
    int high = -1;
    for (int i = 0; i < n; i++)
    {
        if (arr[i] == target)
        {
            if (low == -1)
                low = i;
            high = i;
        }
    }
    vector<int> temp{low, high};
    return temp;
    // TC = O(n)
    // SC = O(1)
}
vector<int> firstandlast2(vector<int> &arr, int target) // Using Lower and Upperbound
{
    int n = arr.size();
    auto it1 = lower_bound(arr.begin(), arr.end(), target);
    int low = it1 - arr.begin();
    auto it2 = upper_bound(arr.begin(), arr.end(), target);
    int high = it2 - arr.begin() - 1;

    if (low == n || arr[low] != target)
    {
        return {-1, -1};
    }

    return {low, high};
    // TC = O(log n)
    // SC = O(1)
}
vector<int> firstandlast3(vector<int> &arr, int target) // Binary search
{
    int n = arr.size();
    int low = -1;
    int high = -1;
    int first = 0;
    int last = n - 1;
    while (first <= last) // First loop to find first element
    {
        int mid = first + (last - first) / 2;

        if (arr[mid] == target)
        {
            low = mid;
            last = mid - 1; // move left
        }
        else if (arr[mid] < target)
        {
            first = mid + 1;
        }
        else
        {
            last = mid - 1;
        }
    }
    if (low == -1 || arr[low] != target)
    {
        return {-1, -1};
    }
    first = 0;
    last = n - 1;
    while (first <= last) // SSecond loop to find last element
    {
        int mid = first + (last - first) / 2;

        if (arr[mid] == target)
        {
            high = mid;
            first = mid + 1; // move right
        }
        else if (arr[mid] < target)
        {
            first = mid + 1;
        }
        else
        {
            last = mid - 1;
        }
    }

    return {low, high};
    // TC = O(log n)
    // SC = O(1)
}

int main()
{
    vector<int> arr{1, 2, 3, 4, 4, 4, 4, 6, 7, 8};
    vector<int> result = firstandlast3(arr, 5);
    for (auto it : result)
    {
        cout << it << " ";
    }
    return 0;
}