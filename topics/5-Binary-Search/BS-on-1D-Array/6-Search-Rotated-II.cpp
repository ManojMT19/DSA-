#include <bits/stdc++.h>
using namespace std;
//Leetcode 81 --->> similar to LC 33 but this is with duplicates
bool search_rotated_array_2(vector<int> &arr, int target) 
{
    int n = arr.size();
    int low = 0;
    int high = n - 1;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (arr[mid] == target)
            return true;

        if (arr[low] == arr[mid] && arr[mid] == arr[high])
        {
            low = low + 1;
            high = high - 1;
            continue;
        }
        
        // Left sorted
        if (arr[low] <= arr[mid])
        {
            if (arr[low] <= target && target < arr[mid]) //Note < and <= 
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
    return false;
}
int main()
{
    vector<int> nums{5,6,7,8,1,2,3,4,5,5,5};
    
    cout << search_rotated_array_2(nums , 8);

    return 0;
}