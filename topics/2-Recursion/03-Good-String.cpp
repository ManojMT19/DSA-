#include <bits/stdc++.h>
using namespace std;
long long myPow1(long long x, long long n)
{
    long long nn = n;
    if (nn < 0)
        nn = nn * (-1);

    long long ans = 1.0;

    // If nn is even multiply x*x and divide nn by 2
    // If nn is odd we multiply the ans*x and we reduce the nn by 1
    while (nn)
    {
        if (nn % 2 == 1)
        {
            ans = ans * x;
            nn = nn - 1;
        }
        else
        {
            x = x * x;
            nn = nn / 2;
        }
    }

    if (n < 0)
    {
        ans = (long long)1.0 / (long long)ans;
    }
    return ans;
}

long long myPow(long long x, long long n, long long MOD)
{
    long long ans = 1;

    while (n)
    {
        if (n % 2 == 1)
        {
            ans = (ans * x) % MOD;
            n = n - 1;
        }
        else
        {
            x = (x * x) % MOD;
            n = n / 2;
        }
    }

    return ans;
}

int countGoodNumbers1(long long n) // Leetcode 1922
{
    const int MOD = 1e9 + 7;
    long long even = myPow(5 , (n+1)/2 , MOD);
    long long odd = myPow(4 , n/2 , MOD);

    return (int)((odd * even) % MOD);
    // TC = O(log n)
    // SC = O(1)
}
int countGoodNumbers(long long n)
{
    const int MOD = 1e9 + 7;
    int ans = 0;
    if (n % 2 == 0)
    {
        long long power = n / 2;

        long long odd = ((long long)(myPow1(4, power))) % MOD;
        long long even = ((long long)(myPow1(5, power))) % MOD;

        ans = (int)((odd * even) % MOD);
    }
    else
    {
        long long power = n / 2;

        long long odd = ((long long)(myPow1(4, power))) % MOD;
        long long even = ((long long)(myPow1(5, power + 1))) % MOD;

        ans = (int)((odd * even) % MOD);
    }
    return ans;
}
int main()
{

    cout << countGoodNumbers1(50);

    return 0;
}