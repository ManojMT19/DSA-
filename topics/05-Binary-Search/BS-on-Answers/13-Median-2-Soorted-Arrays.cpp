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
double median_2_sorted_optimal(vector<int> &arr1 ,vector<int>&arr2)
{
    int n1 = arr1.size();
    int n2 = arr2.size();
    int n = n1+n2;
    if(n1>n2) return median_2_sorted_optimal(arr2, arr1);
    int low = 0, high = n1;
    int left = (n+1)/2;
    while (low <= high)
    {
        int mid1 = (low + high) / 2;
        int mid2 = left - mid1;
        int l1 = INT_MIN , l2 = INT_MIN;
        int r1 = INT_MAX , r2 = INT_MAX;
        if(mid1 < n1) r1 = arr1[mid1];
        if(mid2 < n2) r2 = arr2[mid2];
        if(mid1-1 >= 0) l1 = arr1[mid1-1];
        if(mid2-1 >= 0) l2 = arr2[mid2-1];
        if(l1 <= r2 && l2 <= r1)
        {
            if(n % 2 == 1)return max(l1,l2);
            return (double)(max(l1,l2) + min(r1,r2)) / 2.0;
        }
        else if (l1 > r2) high = mid1 - 1;

        else low = mid1 + 1;
    }
    return 0;
}
int main()
{
    vector<int>nums1{1,4};
    vector<int>nums2{2,6};

    cout << median_2_sorted_brute(nums1,nums2) << endl;
    cout << median_2_sorted_optimal(nums1,nums2);

    
    return 0;
}