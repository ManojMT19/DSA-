#include <bits/stdc++.h>
using namespace std;
void merging(vector<int> &arr, int low, int high, int mid)
{
    vector<int> temp;
    int left = low;
    int right = mid + 1;
    while (left <= mid && right <= high)
    {
        if (arr[left] <= arr[right])
        {
            temp.push_back(arr[left]);
            left++;
        }
        else
        {
            temp.push_back(arr[right]);
            right++;
        }
    }
    while (left <= mid)
    {
        temp.push_back(arr[left]);
        left++;
    }
    while (right <= high)
    {
        temp.push_back(arr[right]);
        right++;
    }
    for (int i = low; i <= high; i++)
    {
        arr[i] = temp[i - low];
    }
}
void ms(vector<int> &arr, int low, int high)
{
    if (low == high)
        return;
    int mid = (low + high) / 2;
    ms(arr, low, mid);
    ms(arr, mid + 1, high);
    merging(arr, low, high, mid);
}
void merge_sort(vector<int> &arr)
{
    int n = arr.size();
    ms(arr, 0, n - 1);
    for (int j = 0; j < n; j++)
    {
        cout << arr[j] << " ";
    }
}
void merge_1(vector<int> &nums1, int m, vector<int> &nums2, int n)
{
    int j = 0;
    for (int i = m; i < nums1.size(); i++)
    {
        nums1[i] = nums2[j];
        j++;
    }
    merge_sort(nums1);
}
//------------------------------------------------------------------------------------------------------------------------
void merge_2(vector<int> &nums1, int m, vector<int> &nums2, int n)
{
    int i = 0;
    int j = 0;
    vector<int> c;
    while (i < m && j < n)
    {
        if (nums1[i] < nums2[j])
        {
            c.push_back(nums1[i]);
            i++;
        }
        else
        {
            c.push_back(nums2[j]);
            j++;
        }
    }
    while (i < m)
    {
        c.push_back(nums1[i]);
        i++;
    }
    while (j < n)
    {
        c.push_back(nums2[j]);
        j++;
    }

    for (int k = 0; k < m + n; k++)
    {
        nums1[k] = c[k];
    }
    for (int x = 0; x < nums1.size(); x++)
    {
        cout << nums1[x] << " ";
    }
}
int main()
{
    vector<int> m1{1, 2, 3, 0, 0, 0};
    vector<int> m2{2, 5, 6};
    int mm = 3;
    int nn = 3;
    merge_2(m1, 3, m2, 3);

    return 0;
}