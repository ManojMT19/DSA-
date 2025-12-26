#include <bits/stdc++.h>
using namespace std;
void longest_subarray_brute(vector<int> a, int k)
{
    int n = a.size();
    int len = 0;
    for (int i = 0; i < n; i++)
    {
        int sum = 0;
        for (int j = i; j < n; j++)
        {
            sum += a[j];
            if (sum == k) 
            {
                len = max(len, j - i + 1);// we use j-i+1 to find the array length
            }
        }
    }
    cout << len;
}
//⬇️⬇️This is called prefix sum method
int longsubarraywithsum_k_better(vector<int> a, long long k) //This works for both positive and negative 
{
    unordered_map<long long, int> premap;
    long long sum = 0;
    int maxlen = 0;
    for (int i = 0; i < a.size(); i++)
    {
        sum += a[i];
        if (sum == k)
        {
            maxlen = max(maxlen, i + 1);
        }
        long long rem = sum - k;
        if (premap.find(rem) != premap.end())
        {
            int len = i - premap[rem];
            maxlen = max(maxlen, len);
        }
        if (premap.find(sum) == premap.end())
        {
            premap[sum] = i; 
        }
    }
    return maxlen;
    // TC = O(n)  or O(n²) (theoretical worst case) since we r using unordered_map for this quuestion
    // SC = O(n)
}
int longsubarraywithsum_k_optimal(vector<int> a, long long k) //Only positive
{
    int left = 0, right = 0;
    long long sum = a[0];
    int maxlen = 0;
    int n = a.size();
    while (right < n)
    {
        while (left <= right && sum > k)   
        {
            sum -= a[left];
            left++;
        }
        if (sum == k)  
        {
            maxlen = max(maxlen, right - left + 1);   
        }
        right++;
        if (right < n)
        {
            sum += a[right];
        }
    }
    return maxlen;
}
int main()
{
    vector<int> v1{1, 2, 8, 1, 1, -1, 3};
    // longest_subarray_brute(v1, 9);
    // cout << longsubarraywithsum_k_optimal(v1, 1); 
    cout << longsubarraywithsum_k_better(v1,1);

    return 0;
}