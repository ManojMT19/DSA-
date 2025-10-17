#include <bits/stdc++.h>
using namespace std;
int divisor(vector<int> &nums, int threshold)
{
    int n = nums.size();
    for (int i = 0; i < n; i++)
    {
        vector<int> temp;
        int j = 1;
        temp.push_back(nums[i] / j);
        int count = 0;
        
        for(int x : temp)
            count += temp[x];

        if (count < threshold)
        {
            return j;
        }
        else j++;
    }
    return -1;
}
int main()
{
    vector<int> arr{1,2,5,9};
    cout << divisor(arr , 6);

    return 0;
}