#include<bits/stdc++.h>
using namespace std;
long long func1(vector<int> &ex , int hour)
{
    long long totalhrs = 0;
    for (int x : ex)
    {
        // ceil_division formula = ceil(a/b) = (a + b - 1)/b;
        // totalhrs += (x + hour - 1)/hour;  
        totalhrs += ceil((double)x / hour);  // Converting to double is very important
    }
    return totalhrs;   
}
int koko_brute(vector<int> &koko, int h)
{
    int m = *max_element(koko.begin(), koko.end());
    for (int j = 1; j <= m ; j++)
    {
        int ans = func1(koko , j);
        if(ans <= h)
        {
            return j;
        }
    }
    return m;
    //TC = O(n*m), where n = size of array, m = maximum element in koko
    //SC = O(1)
}
int koko_optimal(vector<int> &koko , int h)   //Leetcode 875
{
    int m = *max_element(koko.begin(),koko.end());
    int low = 1;
    int high = m;
    int  ans = m;
    while (low <= high) 
    {
        int mid = (low + high) / 2;
        long long hours = func1(koko,mid);
        if (hours <= h)
        {
            ans = mid;
            high = mid-1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return ans;
    //TC = O(n*log m), where n = size of koko, m = maximum element in the array
    //SC = O(1)
}
int main()
{
    vector<int> ex{3,6,7,11};
    int h = 8;
    // cout << koko_brute(ex,h);
    cout << koko_optimal(ex,h);

    return 0;
}