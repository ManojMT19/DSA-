#include <bits/stdc++.h>
using namespace std;
int single_sorted_brute(vector<int> &arr) // Leetcode 540
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
    // TC = O(n)
    // SC = O(1)
}
int single_sorted_ooptimise(vector<int> &nums)
{
    /*
        Simple memory version:
        
        Binary search invariant (this is the key)

        Before the single element
        pairs start at even index

        After the single element
        pairs start at odd index

        So at any mid, we can decide:

        “Am I left of the single?”

        or “Am I right of the single?”
    */
    int low = 0, high = nums.size() - 1;

    while (low < high)
    {
        int mid = low + (high - low) / 2;

        // force mid to be even --- most IMPORTANT
        if (mid % 2 == 1)
            mid--;

        if (nums[mid] == nums[mid + 1])
        {
            // pair intact → single is right
            low = mid + 2;
        }
        else
        {
            // pair broken → single is here or left
            high = mid;
        }
    }
    return  nums[low];
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
int single_XOR(vector<int> &arr) // best and most optimal soln
{
    int ans = 0;
    for (int x : arr)
        ans ^= x;
    return ans;
}
//----------------------------------------------------------------------------------------------------------------------------------
