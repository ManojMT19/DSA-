#include <bits/stdc++.h>
using namespace std;
int myAtoi(string s) // Leetcode 8
{
    int n = s.size();
    int i = 0;
    while(i<n && s[i] == ' ')i++;

    int sign = 1;
    if(i<n && s[i] == '+')
    {
        i++;
    }
    else if(i<n && s[i] == '-')
    {
        sign = -1;
        i++;
    }
    int num = 0;
    while (i<n && s[i] >= '0' && s[i] <= '9')
    {
        int digit = s[i] - '0';
        if(num > (INT_MAX - digit) / 10)// Checking overflow BEFORE updating num
        {
            if(sign == 1)
                return INT_MAX;
            else
                return INT_MIN;
        }
        num = num * 10 + digit;
        i++;
    }
    return num*sign;
    //TC = O(n)
    //SC = O(1)
}
int main()
{
    string  s = " 12  34ab";
    cout << myAtoi(s);
    

    return 0;
}