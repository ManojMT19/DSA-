#include<bits/stdc++.h>
using namespace std;
int minimum(vector<int> &arr)
{
    int n = arr.size();
    int low = 0 , high = n-1 , ans = INT_FAST32_MAX;
    while (low <= high)
    {
        int mid = (low + high) / 2;

        if (arr[low] <= arr[high])
        {
            ans = min(ans, arr[low]);
            break;
        }
        
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
    vector<int> nums {4,5,6,7,8,9,-1,1,2};
    cout << minimum(nums);


    return 0;
}