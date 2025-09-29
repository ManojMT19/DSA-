#include <bits/stdc++.h>
using namespace std;
void recur_type_1(vector<int> &ds, vector<int> &nums, vector<vector<int>> &answer, vector<int> &freq)
{
    if (ds.size() == nums.size())
    {
        if (answer.empty() || find(answer.begin(), answer.end(), ds) == answer.end())
        {
            answer.push_back(ds);
            return;
        }
    }
    for (int i = 0; i < nums.size(); i++)
    {
        if (!freq[i])
        {
            ds.push_back(nums[i]);
            freq[i] = 1;
            recur_type_1(ds, nums, answer, freq);
            freq[i] = 0;
            ds.pop_back();
        }
    }
}
vector<vector<int>> permute_type_1(vector<int> nums)
{
    vector<vector<int>> answer;
    vector<int> ds;
    int n = nums.size();
    vector<int> freq(n);
    recur_type_1(ds, nums, answer, freq);
    return answer;
}
//--------------------------------------------------------------------------------------------------------------------------
void recur_type_2(int index, vector<int> &nums, vector<vector<int>> &answer2)
{
    if (index == nums.size())
    {
        if (answer2.empty() || find(answer2.begin(), answer2.end(), nums) == answer2.end())
        {
            answer2.push_back(nums);
            return;
        }
    }
    for (int i = index; i < nums.size(); i++)
    {
        swap(nums[index], nums[i]); //----------->>>> This is the original Swapping
        recur_type_2(index + 1, nums, answer2);
        swap(nums[index], nums[i]); // ------------>>>> This is reswapping
    } // Draw  Recurrsion  Tree if u didnt understand Reswapping
}
vector<vector<int>> permute_type_2(vector<int> &nums)
{
    vector<vector<int>> answer2;
    recur_type_2(0, nums, answer2);
    return answer2;
}

void recur_type_3(vector<int> num, int i, int j, vector<vector<int>> &answer3)
{
    if (i == j - 1)
    {
        answer3.push_back(num);
        return;
    }
    for (int k = i; k < j; k++)
    {
        if (i != k && num[i] == num[k])
            continue;
        swap(num[i], num[k]);
        recur_type_3(num, i + 1, j, answer3);
    }
}
vector<vector<int>> permute_type_3(vector<int> &num)
{
    sort(num.begin(), num.end());
    vector<vector<int>> answer3;
    recur_type_3(num, 0, num.size(), answer3);
    return answer3;
}

int main()
{
    vector<int> p{1, 1, 2};
    vector<vector<int>> r = permute_type_1(p);
    for (auto i : r)
    {
        for (auto j : i)
        {
            cout << j << " ";
        }
        cout << endl;
    }

    return 0;
}