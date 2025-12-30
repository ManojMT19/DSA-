#include <bits/stdc++.h>
using namespace std;
vector<int> spiral(vector<vector<int>> &mat)
{
    int n = mat.size();
    int m = mat[0].size();
    int left = 0, right = m - 1;
    int top = 0, bottom = n - 1;
    vector<int> ans;

    while (top <= bottom && left <= right)
    {

        for (int i = left; i <= right; i++)
        {
            ans.push_back(mat[top][i]);
        }
        top++;
        for (int i = top; i <= bottom; i++)
        {
            ans.push_back(mat[i][right]);
        }
        right--;
        if (top <= bottom)// to check whether this is single-row matrix or not
        {
            for (int i = right; i >= left; i--)
            {
                ans.push_back(mat[bottom][i]);
            }
            bottom--;
        }
        if (left <= right)// to check whether this is single-column matrix or not
        {
            for (int i = bottom; i >= top; i--)
            {
                ans.push_back(mat[i][left]);
            }
            left++;
        }
    }
    return ans;
}
int main()
{
    vector<vector<int>>ex{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    vector<int>r = spiral(ex);
    for (int i = 0; i < r.size(); i++)
    {
        cout << r[i] << " ";
    }
    
    return 0;
}