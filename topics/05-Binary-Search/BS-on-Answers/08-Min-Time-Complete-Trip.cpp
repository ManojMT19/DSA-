#include <bits/stdc++.h>
using namespace std;
bool fun(vector<int>&time , int totaltrips , int mid)
{
    int actual_trips = 0;
    for(int x : time)
    {
        actual_trips += (mid/x);
    }
    return actual_trips >= totaltrips;
}
long long minimumTime(vector<int> &time, int totalTrips)
{
    int low = 1;
    int fastest = *min_element(time.begin() , time.end()); 
    int high = fastest * totalTrips;
    int ans = high;
    while (low <= high)
    {
        int mid = low + (high - low)/2;
        if(fun(time, totalTrips , mid))
        {
            ans = mid ;
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
    vector<int>time = {1,2,3};
    int totaltrip = 5;
    cout << minimumTime(time , totaltrip);
    return 0;
}