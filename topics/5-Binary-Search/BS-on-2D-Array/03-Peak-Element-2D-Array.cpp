#include <bits/stdc++.h>
using namespace std;
vector<int> find_Peak_Grid_brute(vector<vector<int>> &matrix)
{
    int maaxx = 0;
    vector<int> index;
    for (int i = 0; i < matrix.size(); i++)
    {
        for (int j = 0; j < matrix[i].size(); j++)
        {
            if (matrix[i][j] > maaxx)
            {
                maaxx = matrix[i][j];
                index = {i, j};
            }
        }
    }
    return index;
}
int maxRow(vector<vector<int>> &arr, int col)
{
    int n = arr.size();
    int max_val = INT_MIN;
    int index = -1;
    for (int i = 0; i < n; i++)
    {
        if (arr[i][col] > max_val)
        {
            max_val = arr[i][col];
            index = i;
        }
    }
    return index;
}
vector<int> findPeakGrid(vector<vector<int>> &mat)
{
    int row_size = mat.size();
    int col_size = mat[0].size();
    int low = 0, high = col_size - 1;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        int row = maxRow(mat, mid);
        /*
            We can use this also

            // Determine the elements to the left and right of
            // the middle element in the found row
            int left = mid - 1 >= 0 ? mat[row][mid - 1] : INT_MIN;
            int right = mid + 1 < col_size ? mat[row][mid + 1] : INT_MIN;

            // Check if the middle element is greater than its neighbors
            if (mat[row][mid] > left && mat[row][mid] > right)
            {
                return {row, mid};
            }
        */
        if ((mid == 0 || mat[row][mid] > mat[row][mid - 1]) && (mid == col_size - 1 || mat[row][mid] > mat[row][mid + 1]))
        {
            return {row, mid};
        }
        else if (mat[row][mid] > mat[row][mid - 1])
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }
    return {-1, -1};
}
int main()
{
    vector<vector<int>> ex{{10, 0, 15}, {2, 3, 14}, {7, 16, 32}};
    // vector<int> result = findPeakGrid(ex);
    vector<int> result = find_Peak_Grid_brute(ex);
    cout << result[0] << " " << result[1];

    return 0;
}