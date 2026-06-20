#include <bits/stdc++.h>
using namespace std;
string longestCommonPrefix(vector<string> &strs) // Leetcode 14
{
    int n = strs.size();
    if (n == 0)
        return "";

    sort(strs.begin(), strs.end());
    string ans = "";
    string first = strs[0];
    string last = strs[n - 1];
    string ministring = min(first, last);
    for (int i = 0; i < ministring.size(); i++)
    {
        if (first[i] != last[i])
        {
            break;
        }
        ans += first[i];
    }
    return ans;
    /*
    Time Complexity: O(N log N × M), where N is the number of strings and M is the average length of a string. Sorting requires N log N comparisons, and each comparison can take O(M) time.

    Space Complexity: O(M + log N), where M is the length of the longest string used for prefix storage, and log N is the recursion stack space used by sort().
    */
}
string longestCommonPrefix_optimal(vector<string>& strs)//wihout sorting
{
    if (strs.empty()) return "";

    for (int i = 0; i < strs[0].size(); i++)
    {
        char ch = strs[0][i];

        for (int j = 1; j < strs.size(); j++)
        {
            if (i >= strs[j].size() || strs[j][i] != ch)
            {
                return strs[0].substr(0, i);
            }
        }
    }
    return strs[0];
    //TC : O(n × m)
    //SC : O(1)
}
int main()
{
    vector<string> strs = {"flower", "flow", "flight"};
    vector<string> strs1 = {"dog", "racecar", "car"};
    vector<string> strs2 = {"interview", "internet", "internal", "interval"};
    cout << longestCommonPrefix(strs) << endl;
    cout << longestCommonPrefix(strs1) << endl;
    cout << longestCommonPrefix(strs2) << endl;

    return 0;
}