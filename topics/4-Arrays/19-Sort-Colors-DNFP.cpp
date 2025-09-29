#include <iostream>
#include <bits/stdc++.h>
using namespace std;
void sortColors_brute(vector<int> &nums)
{
    int n = nums.size();
    int count_0 = 0;
    int count_1 = 0;
    int count_2 = 0;
    for (int i = 0; i < n; i++)
    {
        if (nums[i] == 0)
            count_0++;
        else if (nums[i] == 1)
            count_1++;
        else
            count_2++;
    }
    for (int i = 0; i < count_0; i++)
    {
        nums[i] = 0;
    }
    for (int i = count_0; i < count_0 + count_1; i++) 
    {
        nums[i] = 1;
    }
    for (int i = count_1 + count_0; i < n; i++)
    {
        nums[i] = 2;
    }
    for (int i = 0; i < n; i++)
    {
        cout << nums[i] << " ";
    }
}
void sortColors_optimal(vector<int> &nums) // Dutch National Flag Algorithm
{
    int n = nums.size();
    int low = 0;
    int mid = 0;
    int high = n - 1;
    while(mid <= high)
    {
        if (nums[mid] == 0)
        {
            swap(nums[mid], nums[low]);
            low++;
            mid++;
        }
        else if (nums[mid] == 1)
        {
            mid++;
        }
        else
        {
            swap(nums[mid], nums[high]);  
            high--;
        }
    }
    for (int i = 0; i < n; i++)
    {
        cout << nums[i] << " ";
    } 
}
int main()
{
    vector<int> color{0, 2, 1, 0, 2, 1, 1, 2, 2};
    sortColors_optimal(color);

    return 0;
}