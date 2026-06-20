#include <bits/stdc++.h>
using namespace std;

int myAtoi(string s) // this iterative approach
{
    int n = s.size();
    int i = 0;
    while (i < n && s[i] == ' ')
        i++;

    int sign = 1;
    if (i < n && s[i] == '+')
    {
        i++;
    }
    else if (i < n && s[i] == '-')
    {
        sign = -1;
        i++;
    }
    long long num = 0;
    while (i < n && s[i] >= '0' && s[i] <= '9')
    {
        int digit = s[i] - '0';
        num = num * 10 + digit;

        if (num > INT_MAX)
        {
            return sign == 1 ? INT_MAX : INT_MIN;
        }
        i++;
    }
    return (int)num * sign;
}

int func(string &s, int i, long long num, int sign)
{
    if (i >= s.size() || !isdigit(s[i]))
        return (int)num * sign;

    num = num * 10 + (s[i] - '0');

    if (sign * num >= INT_MAX)
        return INT_MAX;
    if (sign * num <= INT_MIN)
        return INT_MIN;

    return func(s, i + 1, num, sign);
}

int myAtoi_recur(string s) // this recursive approach
{
    int n = s.size();
    int i = 0;
    int sign = 1;
    while (i < n && s[i] == ' ')
        i++;

    if (i < n && s[i] == '-')
    {
        sign = -1;
        i++;
    }
    else if (i < n && s[i] == '+')
    {
        i++;
    }

    return func(s, i, 0, sign);
}

int main()
{
    string s = "      -53";
    // cout << myAtoi_recur(s) << endl;
    cout << myAtoi(s);

    return 0;
}