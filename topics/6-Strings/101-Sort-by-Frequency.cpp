#include <bits/stdc++.h>
using namespace std;
string frequencySort(string s) //Leetcode 451
{
    unordered_map<char,int>m;
    string ans;
    int n = s.size();
    for (char c : s)
    {
        m[c]++;
    }
    vector<pair<char,int>> fs(m.begin() , m.end());
    sort(fs.begin() , fs.end() , [](auto &a , auto &b){return a.second > b.second;});
    for (auto &it : m)
    {
        ans.append(it.second , it.first);
        // syntax :   .append(count , element)
    }

    return ans;
    // TC = O(n + k log k)  , where k = number of unique characters
    // SC = O(k)
}
string frequencySort_Optimal(string s) // Bucket Sort method
{
    unordered_map<char,int>m;
    string ans;
    int n = s.size();
    for (char c : s)
    {
        m[c]++;
    }
    vector<vector<char>>bucket(s.size()+1);
    for(auto &it : m)
    {
        bucket[it.second].push_back(it.first);
    }
    for (int i = s.size() ; i >= 0; i--)
    {
        for(char c : bucket[i])
        {
            ans.append(i,c);
        }
    }
    return ans;
    //TC = O(n)
    //SC = O(n)
}
int main()
{
    string s = "tree";
    // string s = "aaAbb";
    cout << frequencySort_Optimal(s); 

    return 0;
}