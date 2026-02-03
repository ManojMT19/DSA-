#include <bits/stdc++.h>
using namespace std;
//Leetcode 2226
bool func(vector<int>&candies , int k ,int mid)
{
    int count = 0;
    for(int x : candies)
    {
        count += x / mid;
    }
    return count>= k;
}
/*

Why we use x / mid here and not (x + mid - 1) / mid?
Ceil (x+mid-1)/mid: Use this when you need to "cover" every item and want to know the minimum number of containers needed.
Floor x/mid: Use this when you have a fixed container size (mid) and want to know how many full containers you can create from a resource.

*/
int maximumCandies(vector<int> &candies, long long k)
{
    int low = 1;
    int high = *max_element(candies.begin() , candies.end());
    int ans = 0;
    while (low <= high)
    {
        int mid = low + (high - low)/2;
        if(func(candies , k , mid))
        {
            ans = mid;
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }
    return  ans;
    
}

int main()
{
    vector<int>candy = {5,8,6};
    int k = 3;

    cout << maximumCandies(candy , k);

    return 0;
}