#include <bits/stdc++.h>
using namespace std;
string longestPalindrome_brute(string s) //Leetcode 5
{
    int n = s.size();
    int maxLen = 0;
    string ans = "";

    for (int i = 0; i < n; i++)
    {
        for (int j = i; j < n; j++)
        {
            int left = i, right = j;
            bool isPal = true;

            while (left < right)
            {
                if (s[left] != s[right])
                {
                    isPal = false;
                    break;
                }
                left++;
                right--;
            }

            if (isPal && (j - i + 1) > maxLen)
            {
                maxLen = j - i + 1;
                ans = s.substr(i, maxLen);
            }
        }
    }

    return ans;
    // TC = O(n cube)
    // SC = O(1)
}

// Helper function to expand around center
int expandFromCenter(string &s, int left, int right)
{
    int n = s.size();

    while (left >= 0 && right < n && s[left] == s[right])
    {
        left--;
        right++;
    }

    // length of palindrome
    return right - left - 1;
}
/*
Why we use right - left - 1 in center expansion

In the center expansion approach, the pointers left and right are expanded outward as long as the characters match.
When the loop stops, it means the pointers have already moved one position outside the palindrome boundary (either due to mismatch or going out of range).
So:
The actual palindrome lies between left + 1 and right - 1
The length of this valid palindrome is  =   (right - 1) - (left + 1) + 1
Simplifying gives:   right - left - 1

Hence, we use  right - left - 1.
*/
string longestPalindrome_optimal(string s) //Leetcode 5
{
    int n = s.size();
    if (n == 0)
        return "";

    int start = 0;
    int maxLen = 1;

    for (int center = 0; center < n; center++)
    {
        int len1 = expandFromCenter(s, center, center);  // odd length palindrome

        int len2 = expandFromCenter(s, center, center + 1);  // even length palindrome

        int currLen = max(len1, len2);

        if (currLen > maxLen)
        {
            maxLen = currLen;
            start = center - (currLen - 1) / 2;  // Very Important 
            /*
            This line simply means:
            “From the center, go left by half the palindrome length.”
            It works for both odd and even palindromes.
            */
        }
    }

    return s.substr(start, maxLen);
    // TC = O(n square)
    // SC = O(1)
}

int main()
{
    string s = "babad";
    cout << longestPalindrome_brute(s);

    return 0;
}
