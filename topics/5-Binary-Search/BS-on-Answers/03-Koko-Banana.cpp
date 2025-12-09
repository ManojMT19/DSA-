#include<bits/stdc++.h>
using namespace std;
//Leetcode Question 875
long long func1(vector<int> &ex , int hour)
{
    long long totalhrs = 0;
    for (int x : ex)
    {
        // totalhrs += (x + hour - 1)/hour;
        totalhrs += ceil((double)x / hour);
    }
    return totalhrs;   
}
int koko_brute(vector<int> &koko, int h)
{
    int m = *max_element(koko.begin(), koko.end());
    int n = koko.size();
    int count = 0;
    for (int j = 1; j <= m ; j++)
    {
        int ans = func1(koko , j);
        if(ans <= h)
        {
            return j;
        }
    }
    return m;
}
int koko_optimal(vector<int> &koko , int h)
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
    return ans ;
}
int main()
{
    vector<int> ex{3,6,7,11};
    int h = 8;
    // cout << koko_brute(ex,h);
    cout << koko_optimal(ex,h);

    return 0;
}