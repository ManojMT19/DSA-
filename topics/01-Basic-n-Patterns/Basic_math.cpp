#include <bits/stdc++.h>
using namespace std;
void count_number(int n)
{
    int count = 0;
    while (n > 0)
    {
        count = count + 1;
        n = n / 10;
    }
    cout << count;
}
void reverse(int n)
{
    int r = 0;
    while (n > 0)
    {
        int l = n % 10;
        r = (r * 10) + l;
        n = n / 10;
    }
    cout << r;
}
void palindrome(int n)
{
    int o = n;
    int r = 0;
    while (n > 0)
    {
        int l = n % 10;
        r = (r * 10) + l;
        n = n / 10;
    }
    if (o == r)
        cout << "Palindrome";
    else
        cout << "Not a palindrome";
}
void armstrong(int n)
{
    int sum = 0;
    int o = n;
    while (n > 0)
    {
        int l = n % 10;
        sum = sum + (l * l * l);
        n = n / 10;
    }
    if (sum == o)
    {
        cout << o << " is an armstrong no" << endl;
    }
    else
    {
        cout << o << " is not an armstrong no" << endl;
    }
}
void divisors_1(int n)
{
    for (int i = 1; i <= n; i++)
    {
        if (n % i == 0)
        {
            cout << i << " ";
        }
    }
}
void divisors_2(int n)
{
    vector<int> v;
    for (int i = 1; i <= sqrt(n); i++)
    // for (int i = 1; i*i <= n; i++)  // this is also correct
    {
        if (n % i == 0)
        {
            v.push_back(i);
            if (n / i != i)
            {
                v.push_back(n / i);
            }
        }
    }
    sort(v.begin(), v.end());
    for (auto t : v)
    {
        cout << t << " ";
    }
}
void prime_1(int n)
{
    if (n == 1)
    {
        cout << n << " is a prime no" << endl;
    }
    else
    {
        for (int i = 2; i < n; i++)
        {
            if (n % i == 0)
            {
                cout << n << " is not a prime no" << endl;
                return;
            }
        }
        cout << n << " is a prime no" << endl;
    }
}
void prime_2(int n)
{
    int count = 0;
    for (int i = 1; i * i <= n; i++)
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
        cout << "Prime No";
    else
        cout << "Not a Prime No";
}
int reverse_leetcode(int x)
{
    int r = 0;
    while (x != 0)
    {
        int l = x % 10;
        r = r * 10 + l;
        x = x / 10;

        if (r > INT_MAX || r < INT_MIN)
            return 0;
    }
    return r;
}
void GCD_1(int a, int b)
{
    int gcd = 0;
    for (int i = 1; i <= min(a, b); i++)
    {
        if (a % i == 0 && b % i == 0)
        {
            gcd = i;
        }
    }
    cout << gcd;
}
int GCD_2(int a, int b)
{
    while (a > 0 && b > 0)
    {
        if (a > b)
            a = a % b;
        else
            b = b % a;
    }
    if (a == 0)
        return b;
    else
        return a;
}
int main()
{
    
    return 0;
}