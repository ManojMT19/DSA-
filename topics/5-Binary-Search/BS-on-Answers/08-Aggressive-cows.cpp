#include<bits/stdc++.h>
using namespace std;

// LeetCode 1552 – Magnetic Force Between Two Balls
// This is literally Aggressive Cows under a different name

bool can_we_place(vector<int>&stalls , int d  ,int cows)
{
    int count = 1;
    int last = stalls[0];
    for (int i = 1; i < stalls.size(); i++)
    {
        if ((stalls[i] - last) >= d)
        {
            count++;
            last = stalls[i];
        }
        if(count >= cows)
            return true;
    }
        return false;
}
int aggressive_cows_brute(vector<int> &stalls , int cows)
{
    sort(stalls.begin(),stalls.end());
    int n = stalls.size();
    int maxDist = stalls[n - 1] - stalls[0];
    int ans = 0;
    for (int dist = 1; dist <= maxDist ; dist++)
    {
        if (can_we_place(stalls, dist ,cows))
        { 
            ans = dist;
        }
    }
    return ans;
}
int aggressive_cows_optimal(vector<int> &stalls , int cows)
{
    sort(stalls.begin(),stalls.end());
    int n = stalls.size();
    int ans = -1;
    int low = 1;
    int high = stalls[n-1] - stalls[0];
    while (low <= high)
    {
        int mid = (low + high)/2;
        if(can_we_place(stalls,mid,cows))
        {
            ans = mid;
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }
    return ans;
}
int main()
{
    vector<int> stall {0,3,4,7,10,9};
    int k = 4;

    // cout << aggressive_cows_brute(stall , k) << endl;
    cout << aggressive_cows_optimal(stall , k) << endl;

    return 0;
}