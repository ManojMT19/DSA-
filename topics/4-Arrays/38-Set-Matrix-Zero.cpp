#include <bits/stdc++.h>
using namespace std;
void setZeroes_brute(vector<vector<int>> &matrix)
{
    int m = matrix.size();
    int n = matrix[0].size();

    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (matrix[i][j] == 0)
            {
                for (int col = 0; col < n; col++)
                {
                    if (matrix[i][col] != 0)
                        matrix[i][col] = -1;
                }
                for (int row = 0; row < m; row++)
                {
                    if (matrix[row][j] != 0)
                        matrix[row][j] = -1;
                }
            }
        }
    }
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (matrix[i][j] == -1)
                matrix[i][j] = 0;
        }
    }
}
void setZeroes_better(vector<vector<int>> &matrix)
{
    int n = matrix.size();
    int m = matrix[0].size();
    vector<int> row(n, 0);
    vector<int> col(m, 0);
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (matrix[i][j] == 0)
            {
                row[i] = 1;
                col[j] = 1;
            }
        }
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (row[i] == 1 || col[j] == 1)
            {
                matrix[i][j] = 0;
            }
        }
    }
    // TC = O(n+m)+O(n*m)+O(n*m) Nearly equal to O(m*n)
    // SC = O(n+m)​
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }
}
int main()
{
    vector<vector<int>> mat{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    setZeroes_brute(mat);

    return 0;
}