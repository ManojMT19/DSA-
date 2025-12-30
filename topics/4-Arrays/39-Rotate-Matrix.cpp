#include <bits/stdc++.h>
using namespace std;
void rotate_brute(vector<vector<int>>& matrix)
{
    int n = matrix.size();
    vector<vector<int>>ans(n,vector<int>(n));
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            ans[j][n-i-1] = matrix[i][j];
        }
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << ans[i][j] << " ";
        }
        cout << endl;
    }
    //TC = O(n square)
    //SC = O(n square)
}
void rotate_optimal(vector<vector<int>>& matrix)
{
    int n = matrix.size();
    for (int i = 0; i < n; i++)
    {
        for (int j = i+1; j < n; j++)
        {
            swap(matrix[i][j] , matrix[j][i]);
        }
    }
    for(int i = 0 ; i < n ; i++)
    {
        reverse(matrix[i].begin(), matrix[i].end());
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }
    //TC = O(n square)
    //SC = O(1)
}
int main()
{
    vector<vector<int>>ex{{1,2,3},{4,5,6},{7,8,9}};
    rotate_optimal(ex);

    return 0;
}