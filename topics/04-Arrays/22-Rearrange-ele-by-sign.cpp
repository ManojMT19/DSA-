#include <bits/stdc++.h>
using namespace std;
// Leetcode 2149
vector<int> rearrangeArray_brute(vector<int> &nums) // Positive and Negatiive are EQUAL <<---- Leetcode 2149
{
    vector<int> pos, neg, res;
    for (int i = 0; i < nums.size(); i++)
    {
        if (nums[i] > 0)
            pos.push_back(nums[i]);
        else
            neg.push_back(nums[i]);
    }
    int p = 0, n = 0;
    for (int j = 0; j < nums.size(); j++)
    {
        if (j % 2 == 0)
            res.push_back(pos[p++]);
        else
            res.push_back(neg[n++]);
    }
    nums.assign(res.begin(), res.end());
    return nums;
    //TC = O(n)
    //SC = O(n)

}
vector<int> rearrangeArray_inplace(vector<int> &nums) //Chatgpt
{
    int n = nums.size();

    // Even indices → positive
    // Odd indices → negative
    int posIndex = 0; // Next even index for positive
    int negIndex = 1; // Next odd index for negative

    while (posIndex < n && negIndex < n)
    {
        // If positive is at correct even index, move to next even index
        if (nums[posIndex] > 0)
        {
            posIndex += 2;
        }
        // If negative is at correct odd index, move to next odd index
        else if (nums[negIndex] < 0)
        {
            negIndex += 2;
        }
        else
        {
            // Swap positive at negIndex with negative at posIndex
            swap(nums[posIndex], nums[negIndex]);
            posIndex += 2;
            negIndex += 2;
        }
    }
    return nums;
    //TC = O(n)
    //SC = O(1)
}
vector<int> rearrangeArray_better(vector<int> &nums) // Positive and Negatiive are EQUAL <<----
{
    // This is under the concept that all positive no will be present in even index only and negative no will be present in odd index

    int nn = nums.size();
    vector<int> ans(nn);
    int postIndex = 0, negIndex = 1;
    for (int i = 0; i < nn; i++)
    {
        if (nums[i] < 0)
        {
            ans[negIndex] = nums[i];
            negIndex += 2;
        }
        else
        {
            ans[postIndex] = nums[i];
            postIndex += 2;
        }
    }
    return ans;
    //TC = O(n)
    //SC = O(n)
}
vector<int> rearrangeArray_type_2(vector<int> &nums) // Positive and Negatiive are NOT EQUAL <<----
{
    // This is under the concept that all positive no will be present in even index only and negative no will be present in odd index
    int n = nums.size();
    vector<int> pos, neg;
    for (int i = 0; i < n; i++)
    {
        if (nums[i] > 0)
            pos.push_back(nums[i]);
        else
            neg.push_back(nums[i]);
    }
    int pn = pos.size(), nn = neg.size();
    if (pn > nn) // Very Important
    {
        for (int i = 0; i < nn; i++)
        {
            nums[2 * i] = pos[i];
            nums[2 * i + 1] = neg[i];
        }
        int index = neg.size() * 2; //*************Important**************
        for (int i = nn; i < pn; i++)
        {
            nums[index] = pos[i];
            index++;
        }
    }
    else
    {
        for (int i = 0; i < pn; i++)
        {
            nums[2 * i] = pos[i];
            nums[2 * i + 1] = neg[i];
        }
        int index = pos.size() * 2; //*************Important**************
        for (int i = pn; i < nn; i++)
        {
            nums[index] = neg[i];
            index++;
        }
    }
    return nums;
    //TC = O(n)
    //SC = O(n)
}
int main()
{
    vector<int> v{3, 1, -2, -5, 2, 4, 8, 10};
    // rearrangeArray_brute(v);
    // vector<int> result = rearrangeArray_better(v);
    // for (int x : result)
    // {
    //     cout << x << " ";
    // }
    rearrangeArray_type_2(v);
    for (int y : v)
    {
        cout << y << " ";
    }

    return 0;
}