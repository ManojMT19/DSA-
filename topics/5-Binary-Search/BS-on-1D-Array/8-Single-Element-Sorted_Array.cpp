#include <bits/stdc++.h>
using namespace std;
int single_sorted_brute(vector<int> &arr)
{
    int n = arr.size();
    if (n == 1)
        return arr[0];

    for (int i = 0; i < n; i++)
    {
        if (i == 0)
        {
            if (arr[i + 1] != arr[i])
                return arr[i];
        }
        else if (i == n - 1)
        {
            if (arr[i] != arr[i - 1])
                return arr[i];
        }
        else
        {
            if (arr[i] != arr[i + 1] && arr[i] != arr[i - 1])
            {
                return arr[i];
            }
        }
    }
    return -1;
}
int single_sorted_ooptimise(vector<int> &arr)
{
    int n = arr.size();
    if (n == 1)
        return arr[0];
    if (arr[0] != arr[1])
        return arr[0];
    if (arr[n - 1] != arr[n - 2])
        return arr[n - 1];

    /*
    ⚡ Simple memory version:

    Even index = first of pair
    Odd index = second of pair

    When this pattern breaks → you’ve crossed the single element.

    If pattern holds → go right, else → go left.
    */
    int low = 1, high = n - 2;
    while (low <= high)
    {
        int mid = low + (high - low) / 2;
        if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1])
            return arr[mid];

        if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1]))
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }
    return -1;
}
int main()
{
    vector<int> nums{11, 11, 12, 12, 13, 13, 14, 14, 15, 16, 16, 17, 17};
    // cout << single_sorted_brute(nums);
    cout << single_sorted_ooptimise(nums);

    return 0;
}

// These two will work if the array is not  sorted also
//--------------------------------------------------------------------------------------------------------
int single_map(vector<int> &arr)
{
    int n = arr.size();
    unordered_map<int, int> mm;
    for (int i = 0; i < n; i++)
    {
        mm[arr[i]]++;
    }
    for (auto &p : mm)
    {
        if (p.second == 1)
        {
            return p.first;
        }
    }
    return -1;
}
int single_hash(vector<int> &arr)
{
    int n = arr.size();
    int maxVal = *max_element(arr.begin(), arr.end());
    vector<int> hash(maxVal + 1, 0);
    for (int i = 0; i < n; i++)
    {
        hash[arr[i]]++;
    }
    for (int x : arr)
    {
        if (hash[x] == 1)
        {
            return x;
        }
    }
    return -1;
}
int single_XOR(vector<int> &arr)
{
    int ans = 0;
    for (int x : arr)
        ans ^= x;
    return ans;
}
//----------------------------------------------------------------------------------------------------------------------------------
