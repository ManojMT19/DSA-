#include <bits/stdc++.h>
using namespace std;
string removeOuterParentheses(string s) //Leetcode 1021
{
    int count = 0;
    string result = "";
    for (int i = 0; i < s.length(); i++)
    {
        if (s[i] == '(')
        {
            if (count > 0)
            {
                result += s[i];
            }
            count++;
        }
        else
        {
            count--;
            if (count > 0)
            {
                result += s[i];
            }
        }
    }
    return result;
}
int main()
{
    string ss = "(()())(())";
    cout <<  removeOuterParentheses(ss);

    return 0;
}