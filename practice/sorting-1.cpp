#include <iostream>
#include <bits/stdc++.h>
using namespace std;
void selection_sort(int arr[], int n, int k)
{
    for (int i = 0; i < k; i++)
    {
        int m = i;
        for (int j = i + 1; j < n; j++)
        {
            if (arr[j] < arr[m])
            {
                m = j;
            }
        }
        swap(arr[m], arr[i]);
        if (i == k - 1)
        {
            cout << arr[i];
            return;
        }
    }
}
void bubble_sort(int arr[], int n, int k)
{
    for (int i = n - 1; i >= n - k; i--)
    {
        for (int j = 0; j < i; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                swap(arr[j + 1], arr[j]);
            }
        }
    }
    cout << arr[n - k];
}
vector<int> sortArray(vector<int> &nums)
{
    int n = nums.size();
    // for (int i = n-1; i >= 1; i--)
    // {
    //     for (int j = 0; j < i; j++)
    //     {
    //         if(nums[j] > nums[j+1])
    //         {
    //             swap(nums[j] , nums[j+1]);
    //         }
    //     }
    // }
    // return nums;
    for (int i = 0; i <= n - 1; i++)
    {
        int j = i;
        while (j > 0 && nums[j - 1] > nums[j])
        {
            swap(nums[j - 1], nums[j]);
            j--;
        }
    }
}
vector<string> sortPeople(vector<string> &names, vector<int> &heights) // Leetcode 2418
{
    int n = heights.size();
    for (int i = 0; i <= n - 1; i++)
    {
        int minim = i;
        for (int j = i + 1; j < n; j++)
        {
            // if(heights[j] < heights[minim]) // to get in ascending order
            if (heights[j] > heights[minim])
            {
                minim = j;
            }
        }
        swap(heights[i], heights[minim]);
        swap(names[i], names[minim]);
    }
    return names;
}
vector<int> frequencySort(vector<int> &nums) // Leetcode 1636
{
    map<int, int> freq;
    int n = nums.size();
    for (int i = 0; i < n; i++)
    {
        freq[nums[i]]++;
    }
    sort(nums.begin(), nums.end(), [&](int a, int b)
         {   
        if (freq[a] == freq[b])
        {
            return a > b;
        }
        return freq[a] < freq[b]; });

    return nums;
}
vector<vector<int>> sortTheStudents(vector<vector<int>> &score, int k) // Leetcode 2545
{
    sort(score.begin(), score.end(), [&](const vector<int> &a, const vector<int> &b)
         { return a[k] > b[k]; });
    return score;
}
// string sortSentence(string s) // Leetcode 1859
void sortSentence(string s) // Leetcode 1859
{
    stringstream ss(s);
    vector<string> w;
    string m;
    while (ss >> m)
    {
        w.push_back(m);
    }
    sort(w.begin(), w.end(), [](string &a, string &b)
         { return a[a.length() - 1] < b[b.length() - 1]; });
    for (int k = 0; k < w.size(); k++)
    {
        w[k].pop_back();
    }
    string original = "";
    for (int i = 0; i < w.size(); i++)
    {
        original = original + w[i];
        if(i != w.size()-1)
        {
            original += " ";
        }
    }
    cout << original;
    // return original;
}
int main()
{
    // int arr[] = {7, 4, 9, 1, 5};
    // int n = sizeof(arr) / sizeof(arr[0]);
    // bubble_sort(arr, n, 2);

    //----------------------------------------------------------------------------------------

    // vector<string> names = {"Alice", "Bob", "Charlie", "David"};
    // vector<int> heights = {150, 180, 160, 170};
    // vector<string> sortedNames = sortPeople(names, heights);
    // for (const auto &name : sortedNames)
    //     cout << name << " ";

    //-----------------------------------------------------------------------------------------

    // vector<int> nums = {1,1,2,2,2,4,3,4};
    // vector<int> frequencySort(vector<int> &nums);
    // for (int num : frequencySort(nums))
    // {
    //     cout << num << " ";
    // }

    //-------------------------------------------------------------------------------------------

    sortSentence("z1 z2 z3");
    return 0;
}