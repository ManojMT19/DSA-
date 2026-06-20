#include <bits/stdc++.h>
using namespace std;
string largestOddNumber(string num) // Leetcode 1903
{
    for (int i = num.size() - 1; i >= 0; i--)
    {
        int digit = num[i] - '0';//Using ASCII 
        if (digit % 2 == 1)
        {
            return num.substr(0, i + 1);
        }
    }
    return "";
    //TC = O(n)
    //SC = O(1)
}

int main()
{
    string demo = "1234000";
    cout << largestOddNumber(demo);

    return 0;
}