#include <bits/stdc++.h>
using namespace std;
vector<int> majorityElement(vector<int> &nums) //Leetcode 229
{
    int n = nums.size();
    int s = (n / 3);
    vector<int> answer;
    unordered_map<int, int> mmm;
    for (int i = 0; i < n; i++)
    {
        mmm[nums[i]]++;
    }
    for (auto it : mmm)
    {
        if (it.second > s)
        {
            answer.push_back(it.first);
        }
    }
    return answer;
    //TC = O(n)
    //SC = O(n)
}
vector<int> majorityElement_moore(vector<int> &nums)
{
    int n = nums.size();
    int count_1 = 0;
    int count_2 = 0;
    int ele_1 = INT_MIN;
    int ele_2 = INT_MIN;
    vector<int> final;
    for (int i = 0; i < n; i++)
    {
        if (count_1 == 0 && ele_2 != nums[i])
        {
            count_1 = 1;
            ele_1 = nums[i];
        }
        else if (count_2 == 0 && ele_1 != nums[i])
        {
            count_2 = 1;
            ele_2 = nums[i];
        }
        else if (ele_1 == nums[i])
        {
            count_1++;
        }
        else if (ele_2 == nums[i])
        {
            count_2++;
        }
        else
        {
            count_1--;
            count_2--;
        }
    }
    int c1 = 0, c2 = 0;
    for (int i = 0; i < n; i++)
    {
        if (nums[i] == ele_1)
        {
            c1++;
        }
        if (nums[i] == ele_2)
        {
            c2++;
        }
    }
    int xx = (n / 3) + 1;
    if (c1 >= xx)
    {
        final.push_back(ele_1);
    }
    if (c2 >= xx)
    {
        final.push_back(ele_2);
    }
    return final;
}
int main()
{
    vector<int> maj{1, 2};
    // vector<int> r = majorityElement(maj);
    vector<int> r = majorityElement_moore(maj);
    for (int x : r)
    {
        cout << x << " ";
    }
    return 0;
}