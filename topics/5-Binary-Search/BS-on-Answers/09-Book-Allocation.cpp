#include<bits/stdc++.h>
using namespace std;
//Leetcode 410 - HARD  -- Split Array Largest Sum    
int check(vector<int>&arr , long long limit)
{
    int student = 1;
    long long pageholder = 0;
    for (int i = 0; i < arr.size(); i++)
    {
        if (pageholder + arr[i] <= limit)
        {
            pageholder += arr[i];
        }
        else
        {
            pageholder = arr[i];
            student++;
        }
    }
    return student;
}
int book_allocation_brute(vector<int> & arr , int no_of_students)
// TC = O(n × R) = O(n × (Sum - maxBook))
{
    int n = arr.size();
    
    if(n < no_of_students)return -1;

    int max = *max_element(arr.begin(),arr.end());
    int sum = accumulate(arr.begin(),arr.end(),0);
    for (int limit = max ; limit <= sum; limit++)
    {
        if (check(arr, limit) == no_of_students)
        {
            return limit;
        }
    }
    return -1;   
}
int book_allocation_optimal(vector<int>&arr , int no_of_students)
{
    //Time Complexity: O(N * log(sum(arr[])-max(arr[])+1))
    int n = arr.size();
    
    if(n < no_of_students)return -1;

    int low = *max_element(arr.begin(),arr.end());
    int high = accumulate(arr.begin(),arr.end(),0);
    int ans = -1;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        int temp = check(arr,mid);
        if (temp <= no_of_students)
        {
            ans = mid;
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return ans;
}
int main()
{
    // vector<int> b_stall{12, 34, 67, 90};
    vector<int> b_stall{1,2,3,4,5};
    int stu = 2;

    // cout <<  book_allocation_brute(b_stall , stu);
    cout <<  book_allocation_optimal(b_stall , stu);

    return 0;
}