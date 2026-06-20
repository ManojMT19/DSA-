#include <iostream>
#include <bits/stdc++.h>
using namespace std;
void missing(int a[], int k)// Only in Sorted Array
{
    for (int i = 0; i < k; i++)
    {
        if (a[i] != i + 1)
        {
            cout << i + 1;
            break;
        }
    }
}
int missingNumber_basic(vector<int> &nums)  
{
    int n = nums.size();
    sort(nums.begin(), nums.end());
    for (int i = 0; i <= n; i++)
    {
        int missing = 0;
        for (int j = 0; j < n - 1; j++)
        {
            if (nums[j] == i)
            {
                missing = 1;
                break;
            }
        }
        if (missing == 0)
        {
            return i;
        }
    }
}
int missing_hash(vector<int> &nums)
{
    int n = nums.size();
    int hash[n + 1] = {0};
    sort(nums.begin(), nums.end());  
    for (int i = 0; i < n; i++)
    {
        hash[nums[i]] = 1;
    }
    for (int j = 0; j < n; j++)
    {
        if (hash[j] == 0)
        {
            return j;
        }
    }
}
int missing_optimal_sum(vector<int> &a) //Leetcode 268
{
    int n = a.size();
    int sum = n * (n + 1) / 2;
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        count += a[i];
    }
    return sum - count;
}
int missing_optimal_xor(vector<int> &a)
{
    int xor1 = 0, xor2 = 0;
    int N = a.size() + 1;
    for (int i = 0; i < a.size(); i++)
    {
        xor2 = xor2 ^ a[i];
    }
    for (int i = 0; i < N; i++)
    {
        xor1 = xor1 ^ i;
    }
    return xor1 ^ xor2;
}
int max_consecutive(vector<int> a) // Leetcode 485, Only 0 and 1 --->>> [1,1,0,1,1,1]
{
    int maxx = 0;
    int count = 0;
    for (int i = 0; i < a.size(); i++)
    {
        if (a[i] == 1)
        {
            count++;
            maxx = max(maxx, count);
        }
        else
        {
            count = 0;
        }
    }
    return maxx;
}
int single_number_hash(vector<int> a)  //Leetcode 136 
{
    int m = *max_element(a.begin(), a.end());
    int hash[m + 1] = {0};
    int n = a.size();
    for (int i = 0; i < n; i++)
    {
        hash[a[i]]++;
    }
    for (int j = 0; j < n; j++)
    {
        if (hash[a[j]] == 1)
        {
            return a[j];
        }
    }
}
int single_number_map(vector<int> a)
{
    unordered_map<long long, long long> m;
    int n = a.size();
    for (int i = 0; i < n; i++)
    {
        m[a[i]]++;
    }
    for (int i = 0; i < n; i++)
    {
        if (m[a[i]] == 1)
        {
            return a[i];
        }
    }
}
int single_number_xor(vector<int> a) //This is the best Optimised solution 
{
    int xor1 = 0;
    int n = a.size();
    for (int i = 0; i < n; i++)
    {
        xor1 = xor1 ^ a[i];
    }
    return xor1;
}
vector<int> singleNumber(vector<int> &nums)
{
    unordered_map<int,int> m;
    vector<int> answer;
    for (int nu : nums)
        m[nu]++;

    for (auto &p : m)
    {
        if (p.second == 1)
        {
            answer.push_back(p.first);
        }
    }
    return answer;
}
int findDuplicate(vector<int> &nums) // Leetcode 287
{
    int n = nums.size();
    int m = *max_element(nums.begin(), nums.end());
    vector<int> hash(m + 1);
    int answer;
    for (int i = 0; i < n; i++)
    {
        hash[nums[i]]++;
    }
    for (int j = 0; j < n; j++)
    {
        if (hash[nums[j]] > 1)
        {
            answer = nums[j];
        }
    }
    return answer;
}
int main()
{
    // int a[] = {1, 3, 4, 5};
    // int k = 5;
    // missing(a, k);

    // vector<int> ar{0, 1, 0, 1, 3, 4, 3, 5, 4, 5, 11};
    // int in, n;
    // cin >> n;
    // for (int i = 0; i < n; i++)
    // {
    //     cin >> in;
    //     ar.push_back(in);
    // }
    // cout << missingNumber_basic(ar);
    // cout << missing_hash(ar);
    // cout << missing_optimal_sum(ar);

    // cout << max_consecutive(ar);

    // cout << ones_n_twice_hash(ar);
    // cout << ones_n_twice_map(ar);

    // vector<int> abc{1,3,4,2,2};
    // cout << findDuplicate(abc);

    vector<int> abc{1, 2, 1, 3, 2,3,9,10}; 
    vector<int> result =  singleNumber(abc);
    for(int x : result)
    {
        cout << x << " ";
    }  
    

    return 0;
}