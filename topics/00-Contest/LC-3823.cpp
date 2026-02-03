#include <bits/stdc++.h>
using namespace std;

string reverseByType(string s)
{
    int n = s.size();
    vector<int> lower;
    vector<int> sym;
    for (int i = 0; i < n; i++)
    {
        if (s[i] >= 97 && s[i] <= 122)
        {
            lower.push_back(s[i]);
        }
        else
        {
            sym.push_back(s[i]);
        }
    }
    reverse(lower.begin(), lower.end());
    reverse(sym.begin(), sym.end());
    int x = 0, y = 0;
    for (int i = 0; i < n; i++)
    {
        if (s[i] >= 97 && s[i] <= 122)
        {
            s[i] = lower[x++];
        }
        else
        {
            s[i] = sym[y++];
        }
    }
    return s;
}

//--------------OPTIMAL BEST SOLN -----------------------------------------------------------------------------

string reverseByType(string s)
{
    int n = s.length();

    // Step 1: Reverse lowercase letters in-place
    // We use two pointers to find letters and swap them
    int i = 0, j = n - 1;
    while (i < j)
    {
        if (!islower(s[i]))
            i++;
        else if (!islower(s[j]))
            j--;
        else
        {
            swap(s[i++], s[j--]);
        }
    }

    // Step 2: Reverse special characters in-place
    // We use two pointers to find NON-letters and swap them
    i = 0, j = n - 1;
    while (i < j)
    {
        if (islower(s[i]))
            i++;
        else if (islower(s[j]))
            j--;
        else
        {
            swap(s[i++], s[j--]);
        }
    }

    return s;
}
int main()
{

    return 0;
}