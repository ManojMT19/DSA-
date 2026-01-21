#include <bits/stdc++.h>
using namespace std;
int findPeakElement_brute(vector<int> &nums)
{
    int n = nums.size();
    if (nums[0] > nums[1])
        return 0;
    if (nums[n - 1] > nums[n - 2])
        return n - 1;
    for (int i = 1; i < n - 1; i++)
    {
        if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
        {
            return i;
        }
    }
    return -1;
}
int findPeakElement_binary(vector<int> &nums) //Leetcode 162
{
    int n = nums.size();
    if(n == 1)return 0;
    
    if (nums[0] > nums[1])
    return 0;
    if (nums[n - 1] > nums[n - 2])
    return n - 1;
    
    int low = 1, high = n - 2; // Important 

    // here we use Binary search on slopes concept
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
        {
            return mid;
        }
        else if (nums[mid] > nums[mid - 1])
        {
            // If you are on an increasing slope, a peak exists on the right.
            low = mid + 1;
        }
        else
        {
            // If you are on a decreasing slope, a peak exists on the left.
            high = mid - 1;
        }
    }
    return -1;
}
int main()
{
    vector<int> ex{1, 10, 13, 7, 1, 2, 4, 5, 6, 0, 1, 0};
    vector<int> ex1{1, 2, 1, 3, 5, 6, 4};
    // vector<int> ex{5,4,3,2,1};
    cout << findPeakElement_brute(ex) << endl;
    cout << findPeakElement_binary(ex1);

    return 0;
}