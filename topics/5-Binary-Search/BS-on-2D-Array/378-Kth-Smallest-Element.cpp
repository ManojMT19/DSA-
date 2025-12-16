#include<bits/stdc++.h>
using namespace std;
int kthSmallest_brute(vector<vector<int>>& matrix, int k) 
{
    int n = matrix.size();
    vector<int>temp;
    for (int i = 0; i < n ; i++)
    {
        for (int j = 0; j < n; j++)
        {
            temp.push_back(matrix[i][j]);
        }
    }
    sort(temp.begin(),temp.end());

    return temp[k-1];
}
int count_lesser(vector<int>& row, int mid) 
{
    // Using upper_bound to find count efficiently
    return upper_bound(row.begin(), row.end(), mid) - row.begin();
}
int kthSmallest(vector<vector<int>>&mat , int k)
{
    int rows = mat.size();
    int col = mat[0].size();
    if(rows == 1 && col == 1)return mat[0][0];

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
        if (count < k)
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
    // vector<vector<int>> ex {{1,5,9},{10,11,13},{12,13,15}};
    vector<vector<int>> ex {{-5}};
    int k = 1;
    // cout << kthSmallest_brute(ex , k);
    cout << kthSmallest(ex , k);

    return 0;
}