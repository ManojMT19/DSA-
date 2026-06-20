#include <bits/stdc++.h>
using namespace std;
int maxProduct_brute(vector<int> &nums)
{
    int n = nums.size(); 
    if(n == 1)return nums[0];
    int maxx = INT_MIN;
    for (int i = 0; i < n ; i++)
    {
        int product = 1;
        for (int j = i; j < n; j++)
        {
            product *= (nums[j]);
            maxx = max(maxx , product);
        }
    }
    if (maxx == INT_MIN)return 0;
    else return maxx;
    // Time Complexity: O(n²)
    // Space Complexity: O(1)
}
//One-line intuition (memorize this)
// Maximum product subarray is either a prefix or suffix of a zero-free segment.
int maxProduct_optimal(vector<int> &nums) // Leetcode 152
{
    int n = nums.size();
    int prefix = 1;
    int suffix = 1;
    int ans = INT_MIN;
    for (int i = 0; i < n; i++)
    {
        if (prefix == 0)prefix = 1;
        if (suffix == 0)suffix = 1;
        prefix = prefix * nums[i];
        suffix = suffix * nums[n-i-1];
        ans = max(ans, max(prefix,suffix));
    }
    return ans;
    // Time Complexity: O(n)
    // Space Complexity: O(1)
}
int main()
{
    // vector<int> a{2,3,-2,4};
    // vector<int> a{-3,-1,-1};
    vector<int> a{-2,3,4,1,0,2,3,1,4};
    // int r = maxProduct_brute(a);
    int r = maxProduct_optimal(a);
    cout << r;

    return 0;
}