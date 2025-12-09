#include<bits/stdc++.h>
using namespace std;
double median_2_sorted(vector<int> &arr1 ,vector<int>&arr2)
{
    vector<int> temp(arr1.begin(), arr1.end());
    temp.insert(temp.end(),arr2.begin(),arr2.end());
    sort(temp.begin(), temp.end());
    int n = temp.size();
    int z = -1;
    double ans = 0;
    if (n % 2 == 0)
    {
        double a1 = n/2;
        double b1 = a1 + 1;
        double c1 = (a1 + b1)/2;
        ans = temp[c1];
    }
    else
    {
        double a1 = n/2;
        ans = temp[a1];
    }
    return ans;
}
int main()
{
    vector<int>nums1{1,3};
    vector<int>nums2{2,4};

    cout << median_2_sorted(nums1,nums2);

    
    return 0;
}