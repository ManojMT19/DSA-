#include<bits/stdc++.h>
using namespace std;
int sqrt_brute(int n )
{
    int sqrt = -1;
    for (int i = 1; i <= n; i++) 
    {
        if (i*i <= n)
        {
            sqrt =  i;
        }
        else if (i*i > n)
        {
            break;
        }     
    }
    return sqrt;
}
int sqrt_optimal(int n)
{
    int low = 1;
    int high = n;  // u can also take n/2
    int ans = 1;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        
        if (mid * mid <= n)
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
    cout << sqrt_optimal(27);

    return 0;
}