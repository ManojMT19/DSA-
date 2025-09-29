#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int partition_array(vector<int> arr, int low, int high)
{
    int pivot = arr[low];
    int i = low;
    int j = high;
    while (i < j)
    {
        while (arr[i] <= pivot && i <= high - 1)   
        {
            i++;
        }
        while (arr[j] > pivot && j >= low + 1)
        {
            j--;
        }
        if (i < j)
            swap(arr[i], arr[j]);
    }
    swap(arr[low], arr[j]);
    return j;
}
void qs(vector<int> &arr, int low, int high)
{
    if (low < high)
    {
        int pIndex = partition_array(arr, low, high);
        qs(arr, low, pIndex - 1);
        qs(arr, pIndex + 1, high);
    }
}
vector<int> quick_sort(vector<int> arr)
{
    qs(arr, 0, arr.size() - 1);
}
int main()
{

    return 0;
}