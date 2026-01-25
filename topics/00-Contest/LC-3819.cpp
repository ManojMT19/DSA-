#include <bits/stdc++.h>
using namespace std;
// Leetcode 3819 Rotate Non Negative Elements

vector<int> rotate(vector<int> val, int k)
{
    reverse(val.begin(), val.begin() + k);
    reverse(val.begin() + k, val.end());
    reverse(val.begin(), val.end());

    return val;
}
vector<int> rotateElements(vector<int> &nums, int k)
{
    vector<int> val;
    int cnt = 0;
    for (int i = 0; i < nums.size(); i++)
    {
        if (nums[i] >= 0)
        {
            val.push_back(nums[i]);
            cnt++;
        }
    }
    if (cnt == 0)
        return nums;
    k = k % cnt;
    vector<int> ans = rotate(val, k);
    int j = 0;
    for (int i = 0; i < nums.size(); i++)
    {
        if (nums[i] >= 0)
        {
            nums[i] = ans[j];
            j++;
        }
    }

    return nums;
}
int main()
{

    return 0;
}