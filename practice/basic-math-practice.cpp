#include <iostream>
#include <cmath>
using namespace std;
void count(int n)
{
    int count = 0;
    while (n > 0)
    {
        count++;
        n = n / 10;
    }
    cout << count;
}
int reverse_leetcode(int n)
{
    int r = 0;
    while (n != 0)
    {
        int x = n % 10;
        r = (r * 10) + x;
        n = n / 10;

        if (r > INT32_MAX || r < INT32_MIN)
        {
            return 0;
        }
    }
    return r;
}
void palindrome(int n)
{
    int r = 0;
    int q = n;
    while (n != 0)
    {
        int l = n % 10;
        r = (r * 10) + l;
        n = n / 10;
        if (n > INT32_MAX || r < INT32_MIN)
        {
            return;
        }
    }
    if (r == q)
        cout << "Palindrome";
    else
        cout << "Not a Palindrome";
}
void armstrong(int n)
{
    int r = 0;
    int q = n;
    while (n > 0)
    {
        int a = n % 10;
        r = r + (a * a * a);
        n = n / 10;
    }
    if (q == r)
        cout << "Armstrong No";
    else
        cout << "Not a Armstrong No";
}
void divisors(int n)
{
    for (int i = 1; i <= n; i++)
    {
        if (n % i == 0)
        {
            cout << i << " ";
        }
    }
}
void prime(int n)
{
    if (n == 1)
    {
        cout << "Prime No";
    }
    else
    {
        for (int i = 2; i < n; i++)
        {
            if (n % i == 0)
            {
                cout << "Not a prime no";
                return;
            }
        }
        cout << "Prime No";
    }
}
void prime_2(int n)
{
    int count = 0;
    for (int i = 1; i <= sqrt(n); i++)
    {
        if (n % i == 0)
        {
            count++;
            if (n % i != i)
            {
                count++;
            }
        }
    }
    if (count == 2)
        cout << "Prime";
    else
        cout << "Not a Prime";
}
int gcdhcf(int a, int b)
{
    while (a > 0 && b > 0)
    {
        if (a > b)
            a = a % b;
        else
            b = b % a;
    }
    return (a == 0) ? b : a;
}
bool palindrome_leetcode(int n)
{
    int o = n;
    int r = 0;
    while (n > 0)
    {
        int l = n%10;
        r = (r*10) + l;
        n = n/10;
    }
    if(o == r)return true;
    else return false;
    
}
int main()
{
    // count(1234);
    // int y = reverse_leetcode(-909020);
    // cout << y;
    // palindrome(1234321);
    // armstrong(371);
    // divisors(12);
    // prime(30);
    // int x = gcdhcf(12,40);
    // cout << x;
    // prime_2(38);

    int a = palindrome_leetcode(-121);
    cout << a;

    return 0;
}