#include <bits/stdc++.h>
using namespace std;
bool isIsomorphic(string s, string t) 
{
    if (s.size() != t.size())
        return false;

    int mapST[256];
    int mapTS[256];

    for (int i = 0; i < 256; i++)
    {
        mapST[i] = -1;
        mapTS[i] = -1;
    }

    for (int i = 0; i < s.size(); i++)
    {
        char a = s[i];
        char b = t[i];

        if (mapST[a] == -1 && mapTS[b] == -1)
        {
            mapST[a] = b;
            mapTS[b] = a;
        }
        else
        {
            if (mapST[a] != b || mapTS[b] != a)
                return false;
        }
    }
    return true;
    //TC = O(n)
    //SC = O(1)
}

bool isomorphicString(string s, string t) //Leetcode 205
{
    int m1[256] = {0}, m2[256] = {0};

    int n = s.size();
    for (int i = 0; i < n; i++)
    {
        if (m1[s[i]] != m2[t[i]])
            return false;

        m1[s[i]] = i + 1;
        m2[t[i]] = i + 1;
    }
    return true;
    //TC = O(n)
    //SC = O(1)
}
int main()
{
    // string s = "egg", t = "add";
    // string s = "paper", t = "title";
    string s = "foo", t = "bar";
    cout << isIsomorphic(s, t);
    // cout << isomorphicString(s, t);

    return 0;
}