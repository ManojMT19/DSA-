#include <bits/stdc++.h>
using namespace std;
double myPow(double x, int n)
{
    if (n == 1)
        return x;

    return (myPow(x, n - 1)) * x;
}
double myPow_optimal(double x, int n)
{
    long long N = n; 
    if (N < 0)
    {
        x = 1 / x;
        N = -N;
    }

    double result = 1.0;
    while (N)
    {
        if (N % 2 == 1)
            result *= x;
        x *= x;
        N /= 2;
    }

    return result;
}
double myPow1(double x, int n)
{
    long long nn = n;
    if (nn < 0)
        nn = nn * (-1);

    double ans = 1.0;


    //If nn is even multiply x*x and divide nn by 2
    //If nn is odd we multiply the ans*x and we reduce the nn by 1
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
        ans = (double)1.0 / (double)ans;
    }
    return ans;
}



int main()
{
    cout << myPow_optimal(2, 10);

    // cout << power(2, -3);

    return 0;
}