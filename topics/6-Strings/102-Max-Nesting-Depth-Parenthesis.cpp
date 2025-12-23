#include <bits/stdc++.h>
using namespace std;
int maxDepth(string s) // Leetcode 1614
{
    int n = s.size();
    int count = 0;
    int ans = 0;
    for (int i = 0; i < n; i++)
    {
        if(s[i] == '(')count++;
        else if(s[i] == ')')count--;
        ans = max(ans,count);
    }
    return ans;
    //TC = O(n)
    //SC = O(1)
}
int main()
{
    // string s = "(1)+((2))+(((3)))";
    // string s = "(1+(2*3)+((8)/4))+1";
    string s = "()(())((()()))";
    cout << maxDepth(s);

    return 0;
}