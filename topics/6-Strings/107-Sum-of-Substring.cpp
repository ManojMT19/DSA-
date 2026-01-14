#include <bits/stdc++.h>
using namespace std;
int beautySum(string s) 
{
    int n = s.size();
    int ans = 0;

    for (int i = 0; i < n; i++) 
    {
        vector<int> freq(26, 0);

        for (int j = i; j < n; j++) 
        {
            freq[s[j] - 'a']++;

            int maxi = 0;
            int mini = INT_MAX;

            for (int k = 0; k < 26; k++)
            {
                if (freq[k] > 0) 
                {
                    maxi = max(maxi, freq[k]);
                    mini = min(mini, freq[k]);
                }
            }

            ans += (maxi - mini);
        }
    }
    return ans;           
}
int main()
{
    string s = "aabcbaa";
    cout << beautySum(s) << endl;

    string s1 = "aabcb";
    cout << beautySum(s1) << endl;

    return 0;
}