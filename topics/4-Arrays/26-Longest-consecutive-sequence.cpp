#include <bits/stdc++.h>
using namespace std;
bool linear_search(vector<int> a, int num)
{
    int n = a.size();
    for (int i = 0; i < n; i++)
    {
        if (a[i] == num)
        {
            return true;
        }
    }
    return false;
}
int longest_brute(vector<int> a)
{
    int longest = 1;
    int n = a.size();
    for (int i = 0; i < n; i++)
    {
        int s = a[i];
        int count = 1;
        while (linear_search(a, s + 1) == true)
        {
            s = s + 1;
            count += 1;
        }
        longest = max(longest, count);
    }
    return longest;
}
int longest_better(vector<int> &nums) //Leetcode 128
{
    if (nums.size() == 0)
    {
        return 0;
    }
    sort(nums.begin(), nums.end());
    int n = nums.size();
    int lastsmaller = INT_MIN;
    int count = 0;
    int longest = 1;
    for (int i = 0; i < n; i++)
    {
        if (nums[i] - 1 == lastsmaller)
        {
            count += 1;
            lastsmaller = nums[i];
        }
        else if (nums[i] != lastsmaller)
        {
            count = 1;
            lastsmaller = nums[i];
        }
        longest = max(longest, count);
    }
    return longest;
}
int longest_optimal(vector<int> nums)//Leetcode 128
{
    if (nums.size() == 0)
    {
        return 0;
    }
    int n = nums.size();
    unordered_set<int> s(nums.begin(), nums.end());
    int longest = 1;
    for (auto it : s)
    {
        if (s.find(it - 1) == s.end()) // This is similar to  below line
        // if (s.count(it - 1) == 0) // We usee this bcz we have to find the base element 
        {
            int count = 1;
            int x = it;
            while (s.find(x + 1) != s.end())
            {
                x += 1;
                count += 1;
            }
            longest = max(longest, count);
        }
    }
    return longest;
}
int main()
{
    vector<int> a = {100, 101, 102, 103, 1, 2, 4, 5, 6};
    int r = longest_optimal(a);
    cout << r << endl;

    return 0;
}