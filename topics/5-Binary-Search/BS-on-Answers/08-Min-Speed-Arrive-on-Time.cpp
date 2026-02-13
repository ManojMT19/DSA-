#include <bits/stdc++.h>
using namespace std;
bool func(vector<int>&dist , double hour , long long mid)
{
    double time = 0;
    int n = dist.size();
    for(int x = 0 ; x < n ; x++)
    {
        if(x == n-1)
        {
            time += ((double)dist[x]/mid);
        }
        else
        {
            // time += ((double)dist[x] + mid - 1)/mid;
            time += (dist[x] + mid - 1)/mid;
        }
    }
    return time <= hour;
}
int minSpeedOnTime(vector<int> &dist, double hour)
{
    if(hour <= (double)dist.size() - 1)
        return -1;

    long long low = 1;
    long long high = INT_MAX;
    int ans = -1;
    while (low <= high)
    {
        long long mid = low + (high - low)/2;
        if(func(dist , hour , mid))
        {
            ans = mid;
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }        
    }
    return ans;
}
int main()
{
    vector<int> d = {1,3,2};
    double hour = 2.7;

    cout << minSpeedOnTime(d , hour);

    return 0;
}