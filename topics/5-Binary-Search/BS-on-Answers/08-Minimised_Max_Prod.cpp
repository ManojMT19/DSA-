#include <bits/stdc++.h>
using namespace std;

// LC - 2064  Minimized Maximum of Products Distributed to Any Store

bool no_of_stores(int n , vector<int>&quantities , int mid)
{
    int stores_needed = 0;
    for(int q : quantities)
    {
        stores_needed += (q + mid - 1)/mid;
    }
    return stores_needed <= n;
}
int minimizedMaximum(int n, vector<int> &quantities)
{
    int low = 1 ;
    int high = *max_element(quantities.begin() , quantities.end());
    int ans = high;
    while (low <= high)
    {
        int mid = low + (high - low)/2;
        if(no_of_stores(n , quantities , mid))
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
    vector<int>q {15,10,10};
    int n = 7;
    cout << minimizedMaximum(n , q);


    return 0;
}