#include<bits/stdc++.h>
using namespace std;
int max_ones_brute(vector<vector<int>>&mat)//This works for sorted n unsorted 
{
    int index = -1;
    int n = mat.size();
    int max_count = -1;
    for(int i = 0 ; i < n ; i++ )
    {
        int count_ones = 0;
        for (int j = 0; j < mat[i].size(); j++)
        {
            count_ones += mat[i][j];
        }
        if (count_ones > max_count)
        {
            max_count = count_ones;
            index = i;
        }
    }
    return index;
    // TC = O(m*n)
}
int lowbound(vector<int>&arr , int m)
{
    int n = arr.size();
    int low = 0 , high = n-1;
    int ans = n;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (arr[mid] >= m)
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
vector<int>max_ones_optimal(vector<vector<int>> &mat)
//This works only for sorted array 
{
    int n  = mat.size();
    int count_max = 0;
    int index = -1;
    vector<int>ans;
    for (int i = 0; i < n; i++)
    {
        int m = mat[i].size();
        int count_ones = m - lowbound(mat[i] , 1);
        if (count_ones > count_max)
        {
            count_max = count_ones;
            index = i;
            ans = {index , count_max};
        }
    }
    return ans;
    
    // TC = O(n*log m)
   
}
vector<int> max_ones_unsorted(vector<vector<int>> &mat)
{
    int n = mat.size();
    int count_max = 0;
    int index = -1;//we can take index = 0 based on question

    for(int i = 0; i < n; i++)
    {
        int count_ones = 0; 
        int m = mat[i].size(); 

        for(int j = 0; j < m; j++)
        {
            if(mat[i][j] == 1)
                count_ones++;
        }

        if(count_ones > count_max)
        {
            count_max = count_ones;
            index = i;
        }
    }
    return {index, count_max};
}

int main()
{
    vector<vector<int>>ex1 = {{0,1},{1,0}};
    vector<vector<int>>ex2 = {{0,0,0},{0,1,1}};
    vector<vector<int>>ex3 = {{0,0},{1,1},{0,0}};
    vector<vector<int>>ex4 = {{1,0,1},{0,1,0}};

    // cout << max_ones_brute(ex2) << endl;
    // vector<int> r = max_ones_optimal(ex3);
    // vector<int> r = max_ones_optimal(ex3);
    vector<int> r = max_ones_unsorted(ex4);
    for(int x : r)
    {
        cout << x <<  " ";
    }


    return 0;
}