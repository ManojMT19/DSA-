#include <bits/stdc++.h>
using namespace std;
int lowerbound(vector<int> v, int t)
{
    int n = v.size();
    int low = 0;
    int  high = n-1;
    int ans = n;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (v[mid] >= t)
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
int upperbound(vector<int> v, int t)
{
    int n = v.size();
    int low = 0;
    int  high = n-1;
    int ans = n;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (v[mid] > t)  //   " = " is the diff between lowerbound and upperbound
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

/*
Floor and  Ceil in Sorted array
Floor - Largest No <= target
Ceil - Smallest No >= target

arr1[] = {10,20,30,40,50}
target = 25
Floor = 20
Ceil = 30

arr2[] = {10,20,25,40,50}
target = 25
Floor = 25
Ceil = 25

Remember this ------>>>>>>   "floor_index = ceil_index - 1"

Actually Ceil is not equal to lowerbound bcz lowerbound return the index but ceil want value not index but when we r coding we use lowerbound as ceil

*/

int floor(vector<int> arr, int t)
{
    int n = arr.size();
    int ans = -1;
    int low = 0;
    int high = n-1;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (arr[mid] <= t)
        {
            ans = arr[mid];
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
    vector<int> l{1,2,6,7,9,10,11,12,14,17,19};

    // auto it1 = lower_bound(l.begin(),l.end(),9); // We can find lowerbound using inbuilt func 
    // int x1 = it1 - l.begin();
    // cout << x1 << endl;
    // cout << lowerbound(l,9)<<endl;

    // auto it2 = upper_bound(l.begin(),l.end(),9); // We can find upperbound using inbuilt func 
    // int x2 = it2 - l.begin();
    // cout << x2 << endl;
    // cout << upperbound(l,9)<<endl;

    cout << floor(l , 15);





    return 0;

}