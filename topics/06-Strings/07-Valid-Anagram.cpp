#include<bits/stdc++.h>
using namespace std;
bool isAnagram_brute(string s, string t) 
{
    if(s.size() != t.size())return false;

    sort(s.begin() , s.end());
    sort(t.begin() , t.end());

    for (int i = 0; i < s.size(); i++)
    {
        if (s[i] != t[i])
        {
            return false;
        }
    }
    return true;
    //TC = O(N log N)
    //SC = O(1)
}

bool isAnagram_optimal(string s, string t) ///Leetcode 242
{
    if(s.size() != t.size())return false;
    
    int hash[26] = {0};
    for (int i = 0; i < s.size(); i++)
    {
        hash[s[i] - 'a']++;
    }
    for (int i = 0; i < t.size(); i++)
    {
        hash[t[i] - 'a']--;
    }
    for (int i = 0; i < 26; i++)
    {
        if (hash[i] != 0)
        {
            return false;
        }
    }
    return true;
    //TC = O(N)
    //SC = O(1)
}
int main()
{
    // string s = "abc", t = "bac";
    // string s = "car", t = "rat";
    string s = "anagram", t = "nagaram";

    cout << isAnagram_brute(s , t) << endl;
    cout << isAnagram_optimal(s , t) << endl;

    return 0;
}