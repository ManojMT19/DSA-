#include <bits/stdc++.h>
using namespace std;
int romanToInt(string s) 
{
    int n = s.size();
    int ans = 0;
    for(int i = 0 ; i < n ; i++)
    {
        if(s[i] == 'I')
        {
            if(i != n-1 && s[i] == 'I' && s[i+1] == 'V')
            {
                ans += 4;
                i++; // we r doing this to skip the next element
            }
            else if(i != n-1 && s[i] == 'I' && s[i+1] == 'X')
            {
                ans += 9;
                i++;
            }
            else
            {
                ans += 1;
            }
        }
        else if(s[i] == 'X')
        {
            if(i != n-1 && s[i] == 'X' && s[i+1] == 'L')
            {
                ans += 40;
                i++;
            }
            else if(i != n-1 && s[i] == 'X' && s[i+1] == 'C')
            {
                ans += 90;
                i++;
            }
            else
            {
                ans += 10;
            }
        }
        else if(s[i] == 'C')
        {
            if(i != n-1 && s[i] == 'C' && s[i+1] == 'D')
            {
                ans += 400;
                i++;
            }
            else if(i != n-1 && s[i] == 'C' && s[i+1] == 'M')
            {
                ans += 900;
                i++;
            }
            else
            {
                ans += 100;
            }
        }
        else if(s[i] == 'V')
        {
            ans += 5;
        }
        else if(s[i] == 'L')
        {
            ans += 50;
        }
        else if(s[i] == 'D')
        {
            ans += 500;
        }
        else if(s[i] == 'M')
        {
            ans += 1000;
        }
    }
    return ans;
    // TC = O(n)
    // SC = O(1)
}
int romanToInt_map(string s) // Use this for interviews -- Leetcode 13
{
/*
    Traverse the Roman string left to right; if the current symbol’s value is less than the next, subtract it, otherwise add it.After the loop, add the value of the last symbol to complete the total.
    That’s the whole logic.
*/
    unordered_map<char,int>sym{{'I',1},{'V',5},{'X',10},{'L',50},{'C',100},{'D',500},{'M',1000}};
    int ans = 0;
    for (int i = 0; i < s.size()-1; i++)
    {
        if(sym[s[i]] < sym[s[i + 1]])
        {
            ans -= sym[s[i]];
        }
        else
        {
            ans += sym[s[i]];
        }
    }
    ans += sym[s.back()];
    return ans;
    // TC = O(n)
    // SC = O(1)
}
int main()
{
    string s = "LVIII";
    // string s = "MCMXCIV";
    // string s = "MMCMXLVIII";
    cout << romanToInt_map(s) << endl;

    return 0;
}