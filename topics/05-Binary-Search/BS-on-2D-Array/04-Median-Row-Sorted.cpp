#include<bits/stdc++.h>
using namespace std;
int row_sorted_median_Brute(vector<vector<int>>&mat)
{
    vector<int>temp;
    int n = mat.size();
    int m = mat[0].size();
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            temp.push_back(mat[i][j]);
        }
    }
    sort(temp.begin() , temp.end());
    return temp[(n*m) / 2];
}
int count_lesser(vector<int>& row, int mid) 
{
    // Using upper_bound to find count efficiently
    return upper_bound(row.begin(), row.end(), mid) - row.begin();
}
int row_sorted_median_optimal(vector<vector<int>>&mat)//I didnt understand
{
    int rows = mat.size();
    int col = mat[0].size();

    int low = mat[0][0];
    int high = mat[0][col-1];

    for (int i = 0; i < rows; i++)
    {
        low = min(low , mat[i][0]);
        high = max(high , mat[i][col-1]);
    }

    while (low <= high)
    {
        int mid = (low + high) / 2;
        int count = 0;
        for (int i = 0; i < rows; i++)
        {
            count += count_lesser(mat[i] , mid);
        }
        if (count < (rows*col+1)/2)
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }
    return low;
}

int main()
{
    vector<vector<int>> demo {{1,4,9} , {2,5,6} , {3,7,8}};
    cout << row_sorted_median_optimal(demo);

    return 0;
}