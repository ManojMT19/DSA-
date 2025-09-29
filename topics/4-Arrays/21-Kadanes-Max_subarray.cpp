#include <bits/stdc++.h>
using namespace std;
int longest_subarray_better(vector<int> a, int n)
{
    int maxi = INT32_MIN;
    for (int i = 0; i < n; i++)
    {
        int sum = 0;
        for (int j = i; j < n; j++)
        {
            sum += a[j];
            maxi = max(maxi, sum);
        }
    }
    return maxi;
}
long long maxsumarray_kadanes(int arr[], int n) 
{
    long long sum = 0, maxi = LONG_LONG_MIN;
    for (int i = 0; i < n; i++)
    {
        sum += arr[i];
        if (sum > maxi)
            maxi = sum;
        if (sum < 0)
            sum = 0;
    }
    // To consider the sum of the empty subarray
    // uncomment the following check:
    // if (maxi < 0) maxi = 0;
    return maxi;
}
int maxAbsoluteSum_brute(vector<int> &nums) // Leetcode 1749
{
    int n = nums.size();
    int maxi = 0;
    for (int i = 0; i < n; i++)
    {
        int sum = 0;
        for (int j = i; j < n; j++)
        {
            sum += nums[j];
            maxi = max(maxi, abs(sum));//Here we used absolute for sum
        }
    }
    return maxi;
}
int maxAbsoluteSum_optimal_kadanes(vector<int> &nums) // Leetcode 1749
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
    cout << maxAbsoluteSum_optimal_kadanes(v);

    return 0;
}