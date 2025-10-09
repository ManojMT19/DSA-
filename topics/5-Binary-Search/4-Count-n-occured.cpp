#include <bits/stdc++.h>
using namespace std;
vector<int> firstandlast3(vector<int> &arr, int target) // Binary search
{
    int n = arr.size();
    int low = -1;
    int high = -1;
    int first = 0;
    int last = n - 1;
    while (first <= last)
    {
        int mid = (first + last) / 2;
        if (arr[mid] >= target)
        {
            low = mid;
            last = mid - 1;
        }
        else
            first = mid + 1;
    }
    if (low == -1 || arr[low] != target)
    {
        return {-1, -1};
    }
    first = 0;
    last = n - 1;
    while (first <= last)
    {
        int mid = (first + last) / 2;
        if (arr[mid] <= target)
        {
            high = mid;
            first = mid + 1;
        }
        else
            last = mid - 1;
    }

    return {low, high};
}
void count_n1(vector<int> arr, int target, int n)
{
    vector<int> result = firstandlast3(arr, target );
    int a = result[0];
    int b = result[1];

    cout << b - a + 1 << endl;

}
int count_n2(const vector<int> &arr, int target) 
{
    auto low = lower_bound(arr.begin(), arr.end(), target);
    auto high = upper_bound(arr.begin(), arr.end(), target);

    return high - low; 
}
int main()
{
    vector<int> arr{1, 2, 3, 4, 4, 4, 4, 6, 7, 8};
    int size = arr.size();

    count_n1(arr, 4 , size);

    cout << count_n2(arr, 4);

    return 0;
}