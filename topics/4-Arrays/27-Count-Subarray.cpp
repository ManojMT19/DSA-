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
    //TC = O(n square)
    //SC = O(1)
}
int count_subarray_optimal(vector<int> &a, int k) // Prefix sum method -- Refer Question No 18
{
    // In Question 18 we return length the longest subarray length with sum = k
    // In this question we return Count how many subarrays have sum = k
    unordered_map<int, int> mpp;
    mpp[0] = 1;  // Very important
    int presum = 0, count = 0;
    int n = a.size();
    for (int i = 0; i < n; i++)
    {
        presum += a[i];
        int remove = presum - k;
        count += mpp[remove];
        mpp[presum] += 1;      // bery important += 1 not i
    }
    return count;
    //TC = O(n) or O(n²) (theoretical worst case)
    //SC = O(n)
}

int main()
{
    vector<int> v{1,2,3,-3,1,1,1,4,2,-3};
    cout << count_subarray_optimal(v, 3);

    return 0;
}