#include<bits/stdc++.h>
using namespace std;
bool searchMatrix_brute(vector<vector<int>>& matrix, int target) 
{
    for (int i = 0; i < matrix.size(); i++)
    {
        for (int j = 0; j < matrix[i].size(); j++)
        {
            if (matrix[i][j] == target)
            {
                return true;
            }
        }
    }
    return false;
    //TC = O(n sq)
    //SC = O(1)
}
int binary_search(vector<int>&nums , int target)
{
    int n = nums.size();
    int low = 0;
    int high = n-1;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (target == nums[mid])
        {
            return mid;
        }
        else if (target > nums[mid])
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }
    return -1;
}
bool searchMatrix_binary(vector<vector<int>>& matrix, int target) 
{
    for (int i = 0; i < matrix.size(); i++)
    {
        int n = matrix[i].size();
        if (matrix[i][0] <= target && matrix[i][n-1] >= target)
        {
            int x = binary_search(matrix[i],target);//Binary search returns the index of the value
            if(x != -1)return true;
        }
    }
    return false;
    //TC = O(n*log m)
    //SC = O(1)
}
bool searchMatrix_optimal(vector<vector<int>>& matrix, int target) 
{
    int n = matrix.size();
    int m = matrix[0].size();
    int low = 0 , high = (m*n-1);
    //These low n high r the index when this matrix is merged into single array
    while (low <= high)
    {
        int mid = (low + high) / 2;
        int row = mid/m;
        int col = mid%m;
        if (matrix[row][col] == target)
        {
            return true;
        }
        else if (matrix[row][col] > target)
        {
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return false;
    //TC = O(log(n*m))
    //SC = O(1)
}
bool searchMatrix_opt(vector<vector<int>>& matrix, int target)
{
    int n = matrix.size();
    int m = matrix[0].size();
    int row = 0 , col = (m-1);
    while (row < n && col > 0)
    {
        if (matrix[row][col] == target)
        {
            return true;
        }
        else if (matrix[row][col] > target)
        {
            col--;
        }
        else
        {
            row++;
        }
    }
    return false;
    //TC = O(m+n)
    //SC = O(1)
}
int main()
{
    vector<vector<int>>ex1 {{1,4,7,11,15},
                            {2,5,8,12,19},
                            {3,6,9,16,22},
                            {10,13,14,17,24},
                            {18,21,23,26,30}};
    // cout << searchMatrix_brute(ex1 , 22);
    // cout << searchMatrix_binary(ex1 , 23);
    // cout << searchMatrix_optimal(ex1 , 23);
    cout << searchMatrix_opt(ex1 , 23);

    return 0;
}