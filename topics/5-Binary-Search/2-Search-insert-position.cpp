#include <bits/stdc++.h>
using namespace std;
void lowerbound(vector<int> lb, int t)
{
    int n = lb.size();
    int lowerbound = 0;
    int low = 0;
    int high = n - 1;
    if (low == high)
    {
        cout << n <<endl;
        return;
    }
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (lb[mid] > t)
        {
            high = mid-1;
        }
        else if (lb[mid] < t)
        {
            low = mid + 1;
        }
        else
        {
            cout<<mid<<endl;
            return; 
        }
    }
    cout << n << endl;
}
int loowwweerr(vector<int> v, int t)
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
int main()
{
    vector<int> l{1,2,6,7,8,10,11,12,14};

    lowerbound(l,11);
    cout << loowwweerr(l , 9);

    return 0;

}