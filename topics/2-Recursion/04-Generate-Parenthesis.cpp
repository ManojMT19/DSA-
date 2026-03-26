#include <bits/stdc++.h>
using namespace std;

bool isValid(string s)
{
    int count = 0;

    for (char c : s)
    {
        if (c == '(')
            count++;
        else
            count--;

        if (count < 0)
            return false; // more ) than (
    }

    return count == 0;
}

void generate(string curr, int length, vector<string> &result)
{
    if (curr.length() == length)
    {
        if (isValid(curr))
        {
            result.push_back(curr);
        }
        return;
    }

    generate(curr + "(", length, result);
    generate(curr + ")", length, result);
}

vector<string> generateParenthesis(int n) // Leetcode 22
{
    vector<string> result;
    generate("", 2 * n, result);
    return result;
}

bool isVal(string s)
{
    int count = 0;
    for(char c : s)
    {
        if(c == '(')
        {
            count++;
        }
        else
        {
            count--;
        }
        if(count < 0)return false;
        
    }
    return count == 0;
}
void gen(string s , int len , vector<string> &r)
{
    if (s.length() == len)
    {
        if(isVal(s))
        {
            r.push_back(s);
        }
        return;
    }

    gen(s + "(" , len , r);
    gen(s + ")" , len , r);
}
vector<string> generateParenthesis_1(int n) // Leetcode 22
{
    vector<string>r;
    gen("" , 2*n , r);
    return r;
}
int main()
{
    // string s = generateParenthesis(3);
    vector<string> s = generateParenthesis_1(2);

    for(string x : s)
    {
        cout << x << endl;
    }

    return 0;
}