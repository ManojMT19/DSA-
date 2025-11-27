#include<bits/stdc++.h>
using namespace std;
int power(int i ,int N)
{
    int ans = 1;
    for (int j = 0; j < N; j++)
    {
        ans *= i;
    }
    return ans;
}
int Nth_root_brute(int N,int M)
{
    for (int i = 1; i <= M; i++)
    {
        int ans = power(i,N);
        if (ans == M)
        {
            return i;
        }
        else if(ans > M)
        {
            break;
            
        }
    }
    return -1;
}
int func(int mid , int n , int m)
{
    long long ans = 1;
    for (int i = 1; i <= n; i++)
    {
        ans *= mid;
        if(ans > m) 
            return 2;
    }
    if(ans == m)return 1;
    return 0;
}
int Nth_root_optimal(int N ,int M)
{
    int low = 1;
    int high = M;
    while(low <= high)
    {
        int mid  = (low + high ) / 2;
        int a = func(mid,N,M);
        if (a == 1)
        {
            return mid;
        }
        else if (a == 2)
        {
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return -1;
}
int main()
{
    // cout << Nth_root_brute(4,144);
    // cout << Nth_root_optimal(3,27);
    cout << Nth_root_optimal(4,69);

    return 0;
}