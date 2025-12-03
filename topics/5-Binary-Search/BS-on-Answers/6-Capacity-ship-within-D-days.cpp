#include<bits/stdc++.h>
using namespace std;

int check1(vector<int>&ship, int m)
{
    int days = 1 , load = 0;
    int n = ship.size();
    for (int i : ship)
    {
        if ((load + i) > m)
        {
            days += 1;
            load = i;
        }
        else
        {
            load += i;
        }
    }
    return days; //check1 returns NUMBER OF DAYS REQUIRED to ship all packages with a given ship capacity m
}
int minimum_capacity_brute(vector<int>&ship , int days)
{
    int low  = *max_element(ship.begin(), ship.end());
    int high = accumulate(ship.begin(), ship.end(), 0);
    for (int cap = low; cap <= high; ++cap)
    {
        int ans = check1(ship , cap );
        if (ans <= days)
        {
            return cap;
        }
    }
    return -1;
}
int minimum_capacity_optimal(vector<int>&ship , int days)
{
    int low = *max_element(ship.begin(),ship.end());
    int high = accumulate(ship.begin(), ship.end(),0);
    int ans = -1;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        int temp = check1(ship ,mid); 
        if(temp <= days)
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
    vector<int> s1 = {1,2,3,4,5,6,7,8,9,10};
    vector<int> s2 = {3,2,2,4,1,4};

    cout << minimum_capacity_brute(s2 , 3) << endl;
    cout << minimum_capacity_optimal(s1 , 5);

    return 0;
}