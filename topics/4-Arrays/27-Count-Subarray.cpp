#include <bits/stdc++.h>
using namespace std;
int count_subarray_better(vector<int> &a, int k) //Leetcode  560
{
    int n = a.size();
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        int sum = 0;
        for (int j = i; j < n; j++)
        {
            sum += a[j];
            if (sum == k)
            {
                count += 1;
            }
        }
    }
    return count;
}
int count_subarray_optimal(vector<int> &a, int k) // Prefix sum method 
{
    unordered_map<int, int> mpp;
    mpp[0] = 1;
    int presum = 0, count = 0;
    int n = a.size();
    for (int i = 0; i < n; i++)
    {
        presum += a[i];
        int remove = presum - k;
        count += mpp[remove];
        mpp[presum] += 1;
    }
    return count;
}

int main()
{
    vector<int> v{1,2,3,-3,1,1,1,4,2,-3};
    cout << count_subarray_optimal(v, 3);

    return 0;
}