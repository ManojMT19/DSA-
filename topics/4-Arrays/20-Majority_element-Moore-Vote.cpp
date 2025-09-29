#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int majorityElement_hashing(vector<int> &nums) // Leetcode 169
{
    int n = nums.size();
    int n2 = n / 2;
    unordered_map<int, int> m;
    for (int i = 0; i < n; i++)
    {
        m[nums[i]]++;
    }
    for (auto it : m)
    {
        if (it.second > n2)
        {
            return it.first;
        }
    }
    return {};
}
int majorityElement_sort(vector<int> &nums) // Leetcode 169
{
    sort(nums.begin(), nums.end());
    int n = nums.size();
    return nums[n / 2];
}
int majorityElement_optimal(vector<int> &nums) // Moore Voting Algo  
{
    int count = 0;
    int n = nums.size();
    int element;
    for (int i = 0; i < n; i++)
    {
        if (count == 0)
        {
            count = 1;
            element = nums[i];
        }
        else if (element == nums[i])
        {
            count++;
        }
        else
        {
            count--;
        }
    }
    int count_1 = 0;
    for (int j = 0; j < n; j++)
    {
        if (nums[j] == element)
            count_1++;
    }
    if (count_1 > (n / 2))
        return element;
    return -1;
}
int main()
{
    vector<int> vv{2, 2, 1, 1, 1, 2, 1, 2,2};
    cout << majorityElement_optimal(vv);

    return 0;
}