#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;
void number_hash(int n)
{
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        cout << "Enter the  element " << i + 1 << " : ";
        cin >> arr[i];
    }
    int hash[13] = {0};
    for (int i = 0; i < n; i++)
    {
        hash[arr[i]] += 1;
    }
    int q;
    cout << "Enter no of elements u want to search : ";
    cin >> q;
    while (q--)
    {
        int num;
        cin >> num;
        cout << hash[num] << endl;
    }
}
void string_hash(string s)
{
    int hash[256] = {0};
    for (int i = 0; i < s.length(); i++)
    {
        hash[s[i]]++;
    }
    int q;
    cout << "Enter no of elements u want to search : ";
    cin >> q;
    while (q--)
    {
        char c;
        cin >> c;
        cout << hash[c] << endl;
    }
}
// Unordered map is faster than ordered map
void using_map(int n)
{
    int arr[n];
    map<int, int> mpp;
    for (int i = 0; i < n; i++)
    {
        cout << "Enter the  element " << i + 1 << " : ";
        cin >> arr[i];
        mpp[arr[i]]++;
    }

    // iterate in the map
    for(auto  it : mpp)
    {
        cout << it.first << " --> "<<it.second << endl;
    }
    int q;
    cout << "Enter no of elements u want to search : ";
    cin >> q;
    while (q--)
    {
        int num;
        cin >> num;
        cout << mpp[num] << endl;
    }
}
void strin_using_map(string s)
{
    // map<char,int> mppp;
    unordered_map<char, int> mppp;
    for (int i = 0; i < s.length(); i++)
    {
        mppp[s[i]]++;
    }
    for (auto it : mppp)
    {
        cout << it.first << " --> " << it.second << endl;
    }
    // int q;
    // cout << "Enter no of elements u want to search : ";
    // cin >> q;
    // while (q--)
    // {
    //     char num;
    //     cin >> num;
    //     cout << mppp[num] << endl;
    // }
}
void homework(int n)
{
    int arr[n];
    map<int, int> m;
    for (int i = 0; i < n; i++)
    {
        cout << "Enter the  element " << i + 1 << " : ";
        cin >> arr[i];
        m[arr[i]]++;
    }
    int max_f = 0, min_f = n;
    for (auto &p : m)
    {
        max_f = max(max_f, p.second);
        min_f = min(min_f, p.second);
    }
    for (auto &p : m)
    {
        if (p.second == max_f)
            cout << "Highest Freq : " << p.first << " ";
        if (p.second == min_f)
            cout << "Lowest Freq : " << p.first << " ";
    }
}
void homework_type_2(int n)
{
    // Using hash
    int arr[n];
    int hash[1001] = {0};

    for (int i = 0; i < n; i++)
        cin >> arr[i], hash[arr[i]]++;

    int maxFreq = 0, minFreq = n;
    for (int i = 0; i <= 1000; i++)
    {
        if (hash[i] > 0)
        {
            maxFreq = max(maxFreq, hash[i]);
            minFreq = min(minFreq, hash[i]);
        }
    }

    cout << "Max frequency elements: ";
    for (int i = 0; i <= 1000; i++)
        if (hash[i] == maxFreq)
            cout << i << " ";
    cout << "\n";

    cout << "Min frequency elements: ";
    for (int i = 0; i <= 1000; i++)
        if (hash[i] == minFreq)
            cout << i << " ";
    cout << "\n";
}
int maxFrequency(vector<int> &nums, int k) // Leetcode 1838
{
    
}
vector<int> twoSum(vector<int> &nums, int target) // Leetcode 1
{
    for (int i = 0; i < nums.size(); i++)
    {
        for (int j = 1; j < nums.size(); j++)
        {
            if (nums[i] + nums[j] == target)
            {
                if (i != j)
                {
                    return {i, j};
                }
            }
        }
    }
    return {};
}
int findMaxK(vector<int> &nums)
{
    int m = -1;
    int n = nums.size();
    for (int i = 0; i < n; i++)
    {
        if (nums[i] > 0 && find(nums.begin(), nums.end(), -nums[i]) != nums.end())
        {
            m = max(m, nums[i]);
        }
    }
    return m;
}
int findmaxk_2(vector<int> &nums)
{
    int maxNum = 0;
    for (int num : nums)
    {
        if (num > maxNum)
        {
            for (int num2 : nums)
            {
                if (num2 == (-1 * num))
                {
                    maxNum = num;
                }
            }
        }
    }
    if (maxNum == 0)
        return -1;
    else
        return maxNum;
}
int main()
{
    // number_hash(5);
    // string_hash("Manoj 123 ?");
    // strin_using_map("Manoj 123 - += ?");
    // homework(6);
    // int mm = maxFrequency(n , 5);
    // cout << mm;

    // vector<int> nums = {-1, 2, -2, 3, 4, 5, 10, 25, -10};
    // cout << findMaxK(nums);

    using_map(5);

    return 0;
}
