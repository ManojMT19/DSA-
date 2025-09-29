#include<iostream>
#include<bits/stdc++.h>
using namespace std;
void merging(vector <int>  &arr , int low ,int high ,int mid)
{
    vector <int> temp;
    int left = low;
    int right = mid + 1;
    while(left <= mid && right <= high)
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
void ms(vector <int> &arr , int low , int high)  
{
    if(low == high)return;
    int mid = (low + high) / 2;
    ms(arr , low , mid);
    ms(arr , mid+1 , high);
    merging(arr , low ,high , mid);
}
void merge_sort(vector <int> &arr , int n)
{
    ms(arr, 0, n-1);
    for (int j = 0; j < n; j++)
    {
        cout << arr[j] << " ";
    }
}
int main()
{
    int n;
    cin >> n;
    vector<int>arr;
    for (int i = 0; i < n; i++)
    {
        int nn;
        cin >> nn;
        arr.push_back(nn);
    }
    merge_sort(arr , n);

    return 0;
}
