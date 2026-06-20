#include<bits/stdc++.h>
using namespace std;
int how_many_rotated(vector<int> arr)
{
    
    // This code works because the index of the minimum element is equal to the number of times the array was rotated.
    // This works when  array is rotated right side or Clockwise 
    
    int n = arr.size();
    int low = 0;
    int high = n-1;
    int ans = INT_MAX;
    int in = -1;
    while (low <= high)
    {
        int mid = (high + low) / 2;
        
        //-----------------------------------------------------------------------------
        // we added this part to work when an array contains duplicate elements  also 
        if (arr[low] == arr[mid] && arr[mid] == arr[high])  
        {
            low = low + 1;
            high = high - 1;
            continue;
        }
        //------------------------------------------------------------------------------
        
        if (arr[low] <= arr[mid])
        {
            if (arr[low] < ans)
            {
                ans = arr[low];
                in = low;
            }
            low = mid + 1;
        }
        else
        {
            if (arr[mid] < ans)
            {
                ans = arr[mid];
                in = mid;
            }
            high = mid - 1;
        }
    }
    return in;
}
int how_many_rotated_better(vector<int> nums)  // Better soln 
{
    // This code works because the index of the minimum element is equal to the number of times the array was rotated.
    // This works when  array is rotated right side or Clockwise 

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

    return low;
    //TC = O(n)
    //SC = O(1)
}
int main()
{
    vector<int> nums{3,4,5,6,1,2};
    cout << how_many_rotated(nums) << endl;
    cout << how_many_rotated_better(nums);

    return 0;
}