#include<bits/stdc++.h>
using namespace std;
double median_2_sorted_brute(vector<int> &arr1 ,vector<int>&arr2)
{
    vector<int> temp(arr1.begin(), arr1.end());
    temp.insert(temp.end(),arr2.begin(),arr2.end());
    sort(temp.begin(), temp.end());
    int n = temp.size();
    double ans = 0;
    if (n % 2 == 0)
    {
        ans = ((double)temp[n/2] + (double)temp[n/2-1])/2.0;
    }
    else
    {
        ans = temp[n/2];
    }
    return ans;
    /*
    ✅ Time Complexity (TC)
    Merging into temp → O(N)
    Sorting temp → O(N log N)
    Finding median → O(1)
    👉 Final TC = O(N log N)

    ✅ Space Complexity (SC)
    Extra array temp of size N → O(N)
    Recursive stack from sort() → O(log N)
    👉 Final SC = O(N) (log N stack is negligible)
    */
}

int main()
{
    vector<int>nums1{1,4};
    vector<int>nums2{2,6};

    cout << median_2_sorted_brute(nums1,nums2);

    
    return 0;
}