#include <bits/stdc++.h>
using namespace std;
int minimum(vector<int> &arr) // Leetcode 153 & 154
{
    int n = arr.size();
    int low = 0, high = n - 1, ans = INT_MAX;
    while (low <= high)
    {
        // int mid = (low + high) / 2;
        int mid = low + (high - low) / 2; // we use this to avoid integer overflow

        //-----------------------------------------------------------------------------
        // we added this part to work when an array contains duplicate elements  also
        if (arr[low] == arr[mid] && arr[mid] == arr[high])
        {
            ans = min(ans, arr[mid]);
            low = low + 1;
            high = high - 1;
            continue;
        }
        //------------------------------------------------------------------------------

        if (arr[low] <= arr[mid])
        {
            ans = min(ans, arr[low]);
            low = mid + 1;
        }
        else
        {
            ans = min(ans, arr[mid]);
            high = mid - 1;
        }
    }
    return ans;
    //TC = O(n)
    //SC = O(1)
}
int findMin(vector<int> &nums)  // Better soln 
{
    int low = 0;
    int high = nums.size() - 1;

    while (low < high)
    {
        int mid = low + (high - low) / 2;

        if (nums[mid] > nums[high])  //  min is right
        {
            low = mid + 1;
        }
        else if (nums[mid] < nums[high])  // min is left or mid
        {
            high = mid;
        }
        else // nums[mid] == nums[high]
        {
            high--;
        }
    }

    return nums[low];
    //TC = O(n)
    //SC = O(1)
}
int main()
{
    // vector<int> nums {4,5,6,6,7,7,7,8,9,1,1,1,1,2};
    vector<int> nums = {2,3,3,4,5,5,6,7,1,1,2};
    cout << minimum(nums);

    return 0;
}