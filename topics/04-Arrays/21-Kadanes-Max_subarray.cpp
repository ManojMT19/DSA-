#include <bits/stdc++.h>
using namespace std;
int maxAbsoluteSum_brute(vector<int> &nums) // Leetcode 1749
{
    int n = nums.size();
    int maxi = INT_MIN;
    for (int i = 0; i < n; i++)
    {
        int sum = 0;
        for (int j = i; j < n; j++)
        {
            sum += nums[j];
            maxi = max(maxi, abs(sum)); // Remember here we used absolute for sum
        }
    }
    return maxi;
}

int kadane(vector<int> &nums) // this is the original Kadanes Algorithm not Leetcode solution
{
    int n = nums.size();

    int currentSum = nums[0];
    int maxSum = nums[0];

    for (int i = 1; i < n; i++)
    {
        currentSum = max(nums[i], currentSum + nums[i]);
        maxSum = max(maxSum, currentSum);
    }

    return maxSum;
}

/*

Kadane’s Algorithm finds the maximum sum of any contiguous subarray in \\(O(n)\\) time and \\(O(1)\\) extra space.

### The core idea

At every element, decide between two choices:

1. Extend the previous subarray by adding the current element.
2. Start a new subarray from the current element.

Choose whichever gives the larger sum.

currentSum = max(nums[i], currentSum + nums[i])

Keep updating the maximum sum found so far.

### Example

nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

The maximum-sum subarray is [4, -1, 2, 1].

Its sum is 4-1+2+1=6.

Remember: At each element, decide whether to continue the existing subarray or discard it and start fresh.

For LC 1749, we adapt this idea to find both the maximum and minimum subarray sums, then take the larger absolute value.

*/

int maxAbsoluteSum_optimal_kadanes(vector<int> &nums)
{
    int n = nums.size();
    int maxsum = 0, maxi = INT_MIN;
    int minsum = 0, mini = INT_MAX;
    for (int i = 0; i < n; i++)
    {
        maxsum += nums[i];
        maxi = max(maxi, maxsum);
        if (maxsum < 0)
            maxsum = 0;
    }
    for (int i = 0; i < n; i++)
    {
        minsum += nums[i];
        mini = min(mini, minsum);
        if (minsum > 0)
            minsum = 0;
    }
    return max(abs(maxi), abs(mini));
}
int main()
{
    vector<int> v{2, -5, 1, -4, 3, -2};
    // cout << maxAbsoluteSum_optimal_kadanes(v);
    cout << kadane(v);

    return 0;
}