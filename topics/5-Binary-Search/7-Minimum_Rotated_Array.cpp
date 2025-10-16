#include<bits/stdc++.h>
using namespace std;
int minimum(vector<int> &arr)
{
    int n = arr.size();
    int low = 0 , high = n-1 , ans = INT_MAX;
    while (low <= high)
    {
        //int mid = (low + high) / 2;
        int mid = low + (high - low) / 2;  // we use this to avoid integer overflow

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
            ans = min(ans,arr[low]);
            low = mid + 1;
        }
        else
        {
            ans = min(ans,arr[mid]);
            high = mid - 1;
        }
    }
    return ans;
}
int main()
{
    vector<int> nums {4,5,6,6,7,7,7,8,9,1,1,1,1,2};
    cout << minimum(nums);


    return 0;
}