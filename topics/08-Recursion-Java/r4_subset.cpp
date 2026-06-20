#include <bits/stdc++.h>
using namespace std;
void solve(int index , vector<int>& nums , vector<int>&current ,vector<vector<int>>&ans)
{
    ans.push_back(current);
    for(int i = index ; i < nums.size() ; i++)
    {
        if(i > index && nums[i] == nums[i-1])continue;

        current.push_back(nums[i]);
        solve(i+1 , nums , current, ans);
        current.pop_back();
    }
}
vector<vector<int>> subsetsWithDup(vector<int>& nums) 
{
    sort(nums.begin() , nums.end());
    vector<int>current;
    vector<vector<int>>ans;
    solve(0 , nums , current , ans);
        
    return ans;    
}
vector<vector<int>> subsets(vector<vector<int>> result, vector<int>& nums, vector<int> current)
{
    int x = nums[0];
    vector<int> n(nums.begin() + 1, nums.end());

    // push first  then pass
    current.push_back(x);
    result = subsets(result, n, current);  // include x
    current.pop_back();                    // backtrack 

    return subsets(result, n, current);    // exclude x
}

vector<vector<int>> subsets_1(vector<int>nums)
{
    vector<int>current;
    vector<vector<int>>r ;
    r = subsets(r , nums , current);

    return r;
}

int main()
{
    vector<int>nums = {1,2,2};
    vector<vector<int>>result;
    vector<int>current;

    // result = subsets(result , nums , current);
    // result = subsets_1(nums);
    result = subsetsWithDup(nums);

    for(int i = 0 ; i < result.size() ; i++)
    {
        cout << "[";
        for(int j = 0 ; j < result[i].size() ; j++)
        {
            cout << result[i][j];
        }
        cout << "]\n";
    }
    return 0;
}