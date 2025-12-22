#include <bits/stdc++.h>
using namespace std;
vector<int> twoSum(vector<int> &numbers, int target)   // Dont refer this
{
    int n = numbers.size();
    vector<pair<int, int>> v;
    for (int i = 0; i < n; i++)
    {
        v.push_back({numbers[i], i});
    }
    int l = 0;
    int r = n - 1;
    while (l < r)
    {
        int sum = v[l].first + v[r].first;
        if (sum == target)
        {
            return {v[l].second + 1, v[r].second + 1}; // Bcz they mentioned as 1 indexed array
        }
        else if (sum > target)
        {
            r--;
        }
        else
        {
            l++;
        }
    }
    return {};
}
vector<int> twoSum_simplest(vector<int> &numbers, int target) // Leetcode 167
{
    int l = 0;
    int r = numbers.size() - 1;
    while (l < r)
    {
        if (numbers[l] + numbers[r] == target)
        {
            return {l + 1, r + 1};
        }
        else if (numbers[l] + numbers[r] > target)
        {
            r--;
        }
        else
        {
            l++;
        }
    }
    return {};
    // TC = O(n)
    // SC = O(1)
}
int main()
{
    vector<int> num{2, 7, 11, 15};
    vector<int> r = twoSum(num, 9);
    for (int i = 0; i < r.size(); i++)
    {
        cout << r[i] << " ";
    }

    return 0;
}