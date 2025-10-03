#include <iostream>
#include <bits/stdc++.h>
using namespace std;
void selection_sort(int arr[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        int minim = i;
        for (int j = i + 1; j < n; j++)
        {
            if (arr[j] < arr[minim])
            {
                minim = j;
            }
        }
        swap(arr[minim], arr[i]);
    }
    for (int k = 0; k < n; k++)
    {
        cout << arr[k] << " ";
    }
}
void bubble_sort(int arr[], int n)
{
    for (int i = n - 1; i >= 1; i--)
    {
        for (int j = 0; j <= i - 1; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                swap(arr[j], arr[j + 1]);
            }
        }
    }
    for (int j = 0; j < n; j++)
    {
        cout << arr[j] << " ";
    }
}
void bubbleSort_chatgpt(int arr[], int n)
{
    for (int i = 1; i <= n - 1; i++)
    {
        for (int j = 0; j < n-i ; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                swap(arr[j], arr[j + 1]);
            }
        }
    }
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
}
void insertion_sort(int arr[], int n)
{
    for (int i = 0; i < n ; i++)
    {
        int j = i;
        while (j > 0 && arr[j - 1] > arr[j])
        {
            swap(arr[j - 1], arr[j]);
            j--;
        }
    }
    for (int k = 0; k < n; k++)
    {
        cout << arr[k] << " ";
    }
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
vector<int> twoSum_better(vector<int> &nums, int target) // Leetcode 1 
{
    unordered_map<int,int>m;  // this is also optimum bcz 
    // map<int,int>m;
    int n = nums.size();
    for (int i = 0; i < n; i++)
    {
        int a = nums[i];
        int x = target - a;
        if(m.find(x) != m.end())
        {
            return{m[x],a};//returnig the index
        }
        m[a] = i;
    }
    return {};
}
vector<int> twoSum_twoPointer(vector<int> &nums, int target) //Leetcode 1
{
    int n = nums.size();
    vector<pair<int,int>> arr;  

    for (int i = 0; i < n; i++)
        arr.push_back({nums[i], i});

    sort(arr.begin(), arr.end());

    int l = 0, r = n-1;
    while (l < r) 
    {
        int sum = arr[l].first + arr[r].first;
        if (sum == target) 
        {
            return {arr[l].second, arr[r].second}; 
        }
        else if (sum < target) l++;
        else r--;
    }
    return {};
}
int main()
{
    int arr[] = {19, 43, 555, 20, 15, 39, 2};
    int n = sizeof(arr) / sizeof(arr[0]);
    insertion_sort(arr,n);
    // selection_sort(arr, n);
    return 0;
}

