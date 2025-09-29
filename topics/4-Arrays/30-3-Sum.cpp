#include <bits/stdc++.h>
using namespace std;
vector<vector<int>> threeSum_brute(vector<int> &nums) // For this Time limit will be exceeded, So this will not run
{
    int n = nums.size();
    set<vector<int>> hashset;
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            for (int k = j + 1; k < n; k++)
            {
                if (nums[i] + nums[j] + nums[k] == 0)
                {
                    vector<int> temp{nums[i], nums[j], nums[k]};
                    sort(temp.begin(), temp.end());
                    hashset.insert(temp);
                }
            }
        }
    }
    vector<vector<int>> answer{hashset.begin(), hashset.end()};
    return answer;
}
vector<vector<int>> threeSum_better(vector<int> &nums)
{
    int n = nums.size();
    set<vector<int>> st;
    for (int i = 0; i < n; i++)
    {
        set<int> hashset;
        for (int j = i + 1; j < n; j++)
        {
            int k = -(nums[i] + nums[j]);
            if (hashset.find(k) != hashset.end())
            {
                vector<int> temp{nums[i], nums[j], k};
                sort(temp.begin(), temp.end());
                st.insert(temp);
            }
            hashset.insert(nums[j]);
        }
    }
    vector<vector<int>> answer{st.begin(), st.end()};
    return answer;
}
vector<vector<int>> threeSum_optimal(vector<int> &nums)//Leetcode 15
{
    vector<vector<int>> answer;
    sort(nums.begin(), nums.end());
    int n = nums.size();
    for (int i = 0; i < n; i++)
    {
        if(i > 0 && nums[i] == nums[i-1]) continue;
        int j = i + 1;
        int k = n - 1;
        while (j < k)
        {
            int sum = nums[i] + nums[j] + nums[k];
            if (sum < 0)
            {
                j++;
            }
            else if (sum > 0)
            {
                k--;
            }
            else
            {
                vector<int> temp{nums[i], nums[j], nums[k]};
                answer.push_back(temp);
                j++;
                k--;
                while(j < k && nums[j] == nums[j-1])j++;  
                while(j < k && nums[k] == nums[k+1])k--;
            }
        }
    }
    return answer;
}
int main()
{
    vector<int> numss{-1, 0, 1, 2, -1, -4};
    // vector<int> numss{-2,-2,-2,-2,-1,-1,-1,0,0,0,2,2,2,2};
    // vector<vector<int>> ans = threeSum_brute(numss);
    vector<vector<int>> ans = threeSum_optimal(numss);
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