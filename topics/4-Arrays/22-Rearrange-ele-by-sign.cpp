#include <bits/stdc++.h>
using namespace std;
// Leetcode 2149
vector<int> rearrangeArray_brute(vector<int> &nums) //Positive and Negatiive are EQUAL <<---- Leetcode 2149
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
}
vector<int> rearrangeArray_better(vector<int> &nums) //Positive and Negatiive are EQUAL <<----
{
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
}
vector<int> rearrangeArray_type_2(vector<int> &nums) //Positive and Negatiive are NOT EQUAL <<----
{                                                    // Very Important
    int ns = nums.size();
    vector<int> pos, neg;
    for (int i = 0; i < ns; i++)
    {
        if (nums[i] > 0)
            pos.push_back(nums[i]);
        else
            neg.push_back(nums[i]);
    }
    int pn = pos.size(), nn = neg.size();
    if (pn > nn)
    {
        for (int i = 0; i < nn; i++)
        {
            nums[2*i] = pos[i];
            nums[2*i+1] = neg[i];
        }
        int index = neg.size()*2; //*************Important**************  
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
            nums[2*i] = pos[i];
            nums[2*i+1] = neg[i];
        }
        int index = pos.size()*2;  //*************Important**************
        for (int i = pn; i < nn; i++)
        {
            nums[index] = neg[i];
            index++;
        }
    }
    return nums; 
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
    for(int y : v)
    {
        cout << y << " ";
    }

    return 0;
}