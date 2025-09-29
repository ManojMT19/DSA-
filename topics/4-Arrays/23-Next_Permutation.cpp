#include <bits/stdc++.h>
using namespace std;
vector<int> nextpurmut(vector<int> arr)
{
    int index = -1;
    int n = arr.size();
    for (int i = n - 2; i >= 0; i--)
    {
        if (arr[i] < arr[i + 1])
        {
            index = i;
            break;
        }
    }
    if (index == -1)
    {
        reverse(arr.begin(), arr.end());     
        return arr;
    } 
    for (int i = n-1; i >= 0; i--)
    {
        if(arr[i] > arr[index])
        {
            swap(arr[i] , arr[index]);
            break;
        }
    }
    sort(arr.begin() + index + 1, arr.end());   
    return arr;   
}
int main()
{
    vector<int> permut{1,2,3};
    vector <int> r = nextpurmut(permut);
    for(int x : r)
    {
        cout << x << " ";
    }
    return 0;
}