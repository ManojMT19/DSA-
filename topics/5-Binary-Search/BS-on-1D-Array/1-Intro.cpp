#include <bits/stdc++.h>
using namespace std;
//Remember This  --- >>>>>   Binary search works only in sorted array
int search(vector<int> &nums, int target)
{
    int n = nums.size();
    int low = 0;
    int high = n-1;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (target == nums[mid])
        {
            return mid;
        }
        else if (target > nums[mid])
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
int search_recursion(vector<int> &nums, int target,int low , int high)
{
    if (low > high)
    {
        return -1;
    }
    int mid = (low + high) / 2;
    if (target == nums[mid])
    {
        return mid;
    }
    else if (target > nums[mid])
    {
        low = mid + 1;
        return search_recursion(nums, target , low ,high);
    }
    else
    {
        high = mid - 1;
        return search_recursion(nums , target , low , high);
    }
}
int main()
{
    vector<int> bs{-1, 0, 3, 5, 9, 12, 14};
    // vector<int> bs{-1};
    // cout << search(bs, 12);
    int high = bs.size() - 1;
    cout << search_recursion(bs,11,0,high);

    return 0;
}