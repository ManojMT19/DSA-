#include <bits/stdc++.h>
using namespace std;
// Leetcode 3818 Minimum Prefix Removal to Make Array Strictly Increasing

int minimumPrefixLength(vector<int> &nums)
{
    int n = nums.size();
    if (n <= 1)
        return 0;

    int i = n - 2;
    while (i >= 0 && nums[i] < nums[i + 1])
    {
        i--;
    }
    return i + 1;
}

int main()
{
    vector<int> nums = {1,-1,2,3,3,4,5};
    cout << minimumPrefixLength(nums);

    return 0;
}