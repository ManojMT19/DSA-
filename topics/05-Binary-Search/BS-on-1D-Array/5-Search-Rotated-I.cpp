#include <bits/stdc++.h>
using namespace std;
int search_rotated_array(vector<int> &arr, int n, int target) //Leetcode 33
{
    int low = 0;
    int high = n - 1;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (arr[mid] == target)
            return mid;

        // Left sorted
        if (arr[low] <= arr[mid])
        {
            if (arr[low] <= target && target < arr[mid]) //Note <= and <
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        // Right sorted
        else
        {
            if (arr[mid] < target && target <= arr[high]) //Note < and <= 
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
    }
    return -1;
}
int main()
{
    vector<int> nums{7,8,9,1,2,3,4,5,6};
    int n = nums.size();
    cout << search_rotated_array(nums , n , 9);

    return 0;
}