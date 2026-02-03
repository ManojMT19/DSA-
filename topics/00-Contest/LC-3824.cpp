#include <bits/stdc++.h>
using namespace std;
bool nonPositive(vector<int> nums, int k)
{
    int c = 0;
    for (int x : nums)
    {
        if (x > 0)
        {
            x = x - k;
            c++;
        }
    }
    if (c <= k * k)
    {
        return true;
    }

    return false;
}
int minimumK(vector<int> &nums)
{
    int n = nums.size();
    int low = 0;
    int high = *max_element(nums.begin(), nums.end());
    int ans = INT_MAX;
    while (low <= high)
    {
        int k = low + (high - low) / 2;
        if (nonPositive(nums, k))
        {
            ans = k;
            high = k - 1;
        }
        else
        {
            low = k + 1;
        }
    }
    return ans;
}
//--------------OPTIMAL BEST SOLN -----------------------------------------------------------------------------
bool canSatisfy(const vector<int> &nums, int k)
{
    // Use long long to prevent overflow when calculating k*k
    long long operations_needed = 0;
    long long k_squared = (long long)k * k;

    for (int x : nums)
    {
        if (x > 0)
        {
            // Ceiling division: (x + k - 1) / k
            // This replaces the while loop and runs in O(1)
            operations_needed += (1LL * x + k - 1) / k;
        }

        // Optimization: Stop immediately if we exceed the limit
        if (operations_needed > k_squared)
            return false;
    }
    return operations_needed <= k_squared;
}

int minimumK(vector<int> &nums)
{
    int low = 1;

    // Find the maximum element to set a reasonable upper bound
    int max_val = 0;
    for (int x : nums)
        if (x > max_val)
            max_val = x;

    // For cases like [1,1], k must be at least 2.
    // A safe upper bound for k is max(max_val, sqrt(total_ops)).
    // 1,000,000 is safe and covers all standard LeetCode constraints.
    int high = max(max_val, (int)nums.size() + 1);
    if (high < 1000)
        high = 1000; // Small buffer for safety

    int ans = high;

    while (low <= high)
    {
        int mid = low + (high - low) / 2;

        if (canSatisfy(nums, mid))
        {
            ans = mid;
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return ans;
}
int main()
{

    return 0;
}