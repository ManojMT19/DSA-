#include <bits/stdc++.h>
using namespace std;

// ===============================
// SUBSTRING & SUBARRAY PATTERNS
// (COMPLETE REFERENCE – C++)
// ===============================

// 1. TOTAL NUMBER OF SUBSTRINGS (NO CONDITION)

int totalSubstrings(int n)
{
    return n * (n + 1) / 2;
}

// 2.1 COUNT SUBSTRINGS WITH ALL UNIQUE CHARACTERS

int countUniqueSubstrings(string s)
{
    vector<int> freq(256, 0);
    int left = 0, ans = 0;

    for (int right = 0; right < s.size(); right++)
    {
        freq[s[right]]++;

        while (freq[s[right]] > 1)
        {
            freq[s[left]]--;
            left++;
        }
        ans += (right - left + 1);
    }
    return ans;
}

// 2.2 COUNT SUBSTRINGS WITH AT MOST K DISTINCT CHARACTERS

int atMostKDistinct(string s, int k)
{
    vector<int> freq(256, 0);
    int left = 0, distinct = 0, ans = 0;

    for (int right = 0; right < s.size(); right++)
    {
        if (freq[s[right]] == 0)
            distinct++;
        freq[s[right]]++;

        while (distinct > k)
        {
            freq[s[left]]--;
            if (freq[s[left]] == 0)
                distinct--;
            left++;
        }
        ans += (right - left + 1);
    }
    return ans;
}

// 2.3 COUNT SUBSTRINGS WITH EXACTLY K DISTINCT CHARACTERS

int exactlyKDistinct(string s, int k)
{
    return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
}

// 3.1 SUBARRAYS WITH SUM = K (NON-NEGATIVE NUMBERS ONLY)

int subarraySumK(vector<int> &nums, int k)
{
    int left = 0, sum = 0, count = 0;

    for (int right = 0; right < nums.size(); right++)
    {
        sum += nums[right];

        while (sum > k)
        {
            sum -= nums[left];
            left++;
        }
        if (sum == k)
            count++;
    }
    return count;
}

// 3.2 SUBARRAYS WITH SUM = K (NEGATIVES ALLOWED)

int subarraySumK(vector<int> &nums, int k)
{
    unordered_map<int, int> mp;
    mp[0] = 1;

    int prefixSum = 0, count = 0;

    for (int x : nums)
    {
        prefixSum += x;
        if (mp.count(prefixSum - k))
            count += mp[prefixSum - k];
        mp[prefixSum]++;
    }
    return count;
}

// 4. FREQUENCY-BASED SUBSTRINGS (LC 1781 – BEAUTY SUM)

int beautySum(string s)
{
    int n = s.size(), ans = 0;

    for (int i = 0; i < n; i++)
    {
        vector<int> freq(26, 0);

        for (int j = i; j < n; j++)
        {
            freq[s[j] - 'a']++;

            int maxi = 0, mini = INT_MAX;
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

// 5.1 LONGEST SUBSTRING WITH ALL UNIQUE CHARACTERS

int longestUniqueSubstring(string s)
{
    vector<int> freq(256, 0);
    int left = 0, maxLen = 0;

    for (int right = 0; right < s.size(); right++)
    {
        freq[s[right]]++;

        while (freq[s[right]] > 1)
        {
            freq[s[left]]--;
            left++;
        }
        maxLen = max(maxLen, right - left + 1);
    }
    return maxLen;
}

// 5.2 LONGEST SUBSTRING WITH AT MOST K DISTINCT CHARACTERS

int longestAtMostKDistinct(string s, int k)
{
    vector<int> freq(256, 0);
    int left = 0, distinct = 0, maxLen = 0;

    for (int right = 0; right < s.size(); right++)
    {
        if (freq[s[right]] == 0)
            distinct++;
        freq[s[right]]++;

        while (distinct > k)
        {
            freq[s[left]]--;
            if (freq[s[left]] == 0)
                distinct--;
            left++;
        }
        maxLen = max(maxLen, right - left + 1);
    }
    return maxLen;
}

// 6.1 FIXED WINDOW – MAXIMUM SUM SUBARRAY OF SIZE K

int maxSumSubarrayK(vector<int> &nums, int k)
{
    int sum = 0, maxSum = 0;

    for (int i = 0; i < nums.size(); i++)
    {
        sum += nums[i];

        if (i >= k - 1)
        {
            maxSum = max(maxSum, sum);
            sum -= nums[i - k + 1];
        }
    }
    return maxSum;
}

// 6.2 FIXED WINDOW – MINIMUM SUM SUBARRAY OF SIZE K

int minSumSubarrayK(vector<int> &nums, int k)
{
    int sum = 0, minSum = INT_MAX;

    for (int i = 0; i < nums.size(); i++)
    {
        sum += nums[i];

        if (i >= k - 1)
        {
            minSum = min(minSum, sum);
            sum -= nums[i - k + 1];
        }
    }
    return minSum;
}

// 6.3 FIRST NEGATIVE NUMBER IN EVERY WINDOW OF SIZE K

vector<int> firstNegative(vector<int> &nums, int k)
{
    queue<int> q;
    vector<int> ans;

    for (int i = 0; i < nums.size(); i++)
    {
        if (nums[i] < 0)
            q.push(i);

        if (i >= k - 1)
        {
            while (!q.empty() && q.front() < i - k + 1)
                q.pop();

            if (q.empty())
                ans.push_back(0);
            else
                ans.push_back(nums[q.front()]);
        }
    }
    return ans;
}

// 6.4 MAXIMUM OF ALL SUBARRAYS OF SIZE K (DEQUE)

vector<int> maxOfSubarrays(vector<int> &nums, int k)
{
    deque<int> dq;
    vector<int> ans;

    for (int i = 0; i < nums.size(); i++)
    {
        while (!dq.empty() && dq.front() < i - k + 1)
            dq.pop_front();

        while (!dq.empty() && nums[dq.back()] <= nums[i])
            dq.pop_back();

        dq.push_back(i);

        if (i >= k - 1)
            ans.push_back(nums[dq.front()]);
    }
    return ans;
}

// 6.5 COUNT ANAGRAMS (LC 438)

int countAnagrams(string s, string p)
{
    vector<int> freq(26, 0);
    for (char c : p)
        freq[c - 'a']++;

    int left = 0, count = p.size(), ans = 0;

    for (int right = 0; right < s.size(); right++)
    {
        if (freq[s[right] - 'a']-- > 0)
            count--;

        if (right - left + 1 == p.size())
        {
            if (count == 0)
                ans++;

            if (++freq[s[left] - 'a'] > 0)
                count++;
            left++;
        }
    }
    return ans;
}

int main()
{

    return 0;
}