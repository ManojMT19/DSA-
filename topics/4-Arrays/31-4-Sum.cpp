#include <bits/stdc++.h>
using namespace std;
vector<vector<int>> fourSum_brute(vector<int> &nums, int target) // This will not work due to High Time Complexity
{
    int n = nums.size();
    set<vector<int>> st;
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            for (int k = j + 1; k < n; k++)
            {
                for (int l = k + 1; l < n; l++)
                {
                    long long sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target)
                    {
                        vector<int> temp{nums[i], nums[j], nums[k], nums[l]};
                        sort(temp.begin(), temp.end());
                        st.insert(temp);
                    }
                }
            }
        }
    }
    vector<vector<int>> answer{st.begin(), st.end()};
    return answer;
}
vector<vector<int>> fourSum_better(vector<int> &nums, int target) // Leetcode 18
{
    int n = nums.size();
    set<vector<int>> st;
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            set<int> hashset;
            for (int k = j + 1; k < n; k++)
            {
                long long sum = nums[i] + nums[j] + nums[k];
                int l = target - (sum);
                if (hashset.find(l) != hashset.end())
                {
                    vector<int> temp{nums[i], nums[j], nums[k], nums[l]};
                    sort(temp.begin(), temp.end());
                    st.insert(temp);
                }
                hashset.insert(nums[k]);
            }
        }
    }
    vector<vector<int>> answer{st.begin(), st.end()};
    return answer;
}
vector<vector<int>> fourSum_optimal(vector<int> &nums, int target) // Leetcode 18
{
    vector<vector<int>> answer;
    sort(nums.begin(), nums.end());
    int n = nums.size();
    for (int i = 0; i < n; i++)
    {
        if (i > 0 && nums[i] == nums[i - 1])
            continue;
        for (int j = i + 1; j < n; j++)
        {
            if (j > i + 1 && nums[j] == nums[j - 1])
                continue;
            int k = j + 1;
            int l = n - 1;
            while (k < l)
            {
                long long sum = nums[i] + nums[j];
                sum += nums[k];
                sum += nums[l];
                if (sum > target)
                {
                    l--;
                }
                else if (sum < target)
                {
                    k++;
                }
                else
                {
                    vector<int> temp{nums[i], nums[j], nums[k], nums[l]};
                    answer.push_back(temp);
                    k++;
                    l--;
                    while (k < l && nums[k] == nums[k - 1])
                        k++;
                    while (k < l && nums[l] == nums[l + 1])
                        l--;
                }
            }
        }
    }
    return answer;
}
int main()
{
    vector<int> nnnn{1,0,-1,0,-2,2};
    vector<vector<int>> ans = fourSum_optimal(nnnn,0);
    for (int i = 0; i < ans.size(); i++)
    {
        for (int j = 0; j < ans[i].size(); j++)
        {
            cout << ans[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}