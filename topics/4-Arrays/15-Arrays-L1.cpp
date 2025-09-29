#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int largest_element(int arr[], int n)
{
    int max = arr[0];
    for (int i = 0; i < n; i++)
    {
        if (arr[i] > max)
        {
            max = arr[i];
        }
    }
    return max;
}
void second_largest_better(int arr[], int n)
{
    int max = largest_element(arr, n);
    int second_largest = INT32_MIN; // we take INT_MIN when we have negative numbers in an array
    for (int i = 0; i < n; i++)
    {
        if (arr[i] > second_largest && arr[i] != max)
        {
            second_largest = arr[i];
        }
    }
    cout << second_largest << endl;
}
void second_largest_optimal(int arr[], int n)
{
    int largest = arr[0];
    int second_largest = INT32_MIN;
    for (int i = 1; i < n; i++)
    {
        if (arr[i] > largest)
        {
            second_largest = largest;
            largest = arr[i];
        }
        else if (arr[i] < largest && arr[i] > second_largest)
        {
            second_largest = arr[i];
        }
    }
    cout << second_largest << endl;
}
void second_smallest_optimal(int arr[], int n)
{
    int smallest = arr[0];
    int second_smallest = INT32_MAX;
    for (int i = 1; i < n; i++)
    {
        if (arr[i] < smallest)
        {
            second_smallest = smallest;
            smallest = arr[i];
        }
        else if (arr[i] > smallest && arr[i] < second_smallest)
        {
            second_smallest = arr[i];
        }
    }
    cout << second_smallest << endl;
}
int sorted_or_not(int arr[], int n)
{
    for (int i = 1; i < n; i++)
    {
        if (arr[i] <= arr[i + 1])
        {
        }
        else
        {
            return false;
        }
    }
    return true;
}
bool check_sort_n_rotated(vector<int> &nums) // Leetcode 1752  [3,4,5,1,2]
{
    int n = nums.size();
    int count = 0;
    for (int i = 0; i < n - 1; i++)
    {
        if (nums[i] > nums[i + 1])
        {
            count++;
        }
    }
    if (nums[n - 1] > nums[0])
    {
        count++;
    }
    return count <= 1;
}
vector<int> remove_duplicate_sorted_arr_1(vector<int> &arr) // Return the removed duplicates array
{
    for (int i = 0; i < arr.size() - 1; i++)
    {
        if (arr[i] == arr[i + 1])
        {
            arr.erase(arr.begin() + i); // using __.erase() also takes O(n) complexity
            i--;                        // this is to check again
        }
    }
    return arr;
    // So this whole code is O(n^2) one is for loop and another is .erase()
}
int remove_dup_in_sorted_arr_2(vector<int> arr) // Return the no unique elements
{
    int n = arr.size();
    int i = 0;
    for (int j = 1; j < n; j++)
    {
        if (arr[j] != arr[i])
        {
            i++;
            arr[i] = arr[j];
        }
    }
    return i + 1; // this whole code takes only O(n)
}
int removeDuplicates_set(vector<int> &nums) // Leetcode 26
{
    set<int> s(nums.begin(), nums.end());
    nums.assign(s.begin(), s.end());
    return nums.size();
}
int removeDuplicates_two_pointer_method(vector<int> &nums) // Leetcode 26
{
    if (nums.empty())
        return 0;
    int k = 0;
    for (int i = 1; i < nums.size(); i++)
    {
        if (nums[i] != nums[k])
        {
            k++;
            nums[k] = nums[i];
        }
    }
    return k + 1;
}
int removeElement_erase(vector<int> &nums, int val) // Leetcode 27
{
    nums.erase(remove(nums.begin(), nums.end(), val), nums.end());
    return nums.size();
}
int removeElement_two_pointer(vector<int> &nums, int val)// Two pointer method
{
    int k = 0;
    for (int i = 0; i < nums.size(); i++)
    {
        if (nums[i] != val)
        {
            nums[k] = nums[i];
            k++;
        }
    }
    return k;
}
int main()
{
    // int arr[] = {-1, -50, 120, 120, 30, 330, 74, 30, 555};
    // int n = sizeof(arr) / sizeof(arr[0]);
    // cout << largest_element(arr, n);
    // second_largest_better(arr , n);
    // second_largest_optimal(arr , n);
    // second_smallest_optimal(arr , n);
    // cout << sorted_or_not(arr , n);
    
    vector<int> nums{1, 2, 3, 3, 4, 5, 6};
    // cout << check_sort_n_rotated(nums);  //[3,4,5,1,2]

    // vector <int> r =  remove_duplicate_sorted_arr_1(nums);
    // for(int x : r)
    // {
    //     cout << x << " ";
    // }
    // cout << remove_dup_in_sorted_arr_2(nums);
    // cout << removeDuplicates_set(nums);
    // cout << removeDuplicates_two_pointer_method(nums);

    cout << removeElement_two_pointer(nums, 3);

    return 0;
}