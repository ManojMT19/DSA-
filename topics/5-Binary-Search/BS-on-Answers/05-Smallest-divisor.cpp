#include <bits/stdc++.h>
using namespace std;
int smallest_divisor_brute(vector<int> &nums, int threshold)
{
    int n = nums.size();
    int m = *max_element(nums.begin(), nums.end());

    for (int i = 1; i <= m; i++)
    {
        int sum = 0;
        for (int x : nums)
        {
            sum += (x + i - 1) / i; // ceil division
        }
        if (sum <= threshold)
            return i; // found smallest divisor
    }
    return -1;
}
int smallest_divisor_optimised(vector<int> &nums, int threshold)
{
    int n = nums.size();
    int m = *max_element(nums.begin(), nums.end());
    int low = 1, high = m, ans = -1;

    if (n > threshold)
        return -1; // this is to check if their is no divisor

    while (low <= high)
    {
        int mid = (low + high) / 2;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += (nums[i] + mid - 1) / mid; // ceil division
            // ceil(a / b) = (a + b - 1) / b
            // (5 + 2 - 1) / 2 = 6 / 2 = 3   ✅ ceil(5/2)
            // (10 + 3 - 1) / 3 = 12 / 3 = 4 ✅ ceil(10/3)
        }
        if (sum <= threshold)
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
    vector<int> arr{1, 2, 5, 9};
    cout << smallest_divisor_optimised(arr, 6);

    return 0;
}