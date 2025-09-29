#include <bits/stdc++.h>
using namespace std;
vector<int> findMissingAndRepeatedValues(vector<vector<int>> &grid)
{
    int n = grid.size();
    map<int, int> mm;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            mm[grid[i][j]]++;
        }
    }
    int missing, repeat;
    for (int i = 1; i <= n * n; i++)
    {
        if (mm[i] == 0)
            missing = i;
        if (mm[i] == 2)
            repeat = i;
    }
    vector<int> answer{repeat, missing};
    return answer;
}
vector<int> findMissingAndRepeatedValues_2(vector<vector<int>> &grid)
{
    int n = grid.size();
    int num = n * n;
    int sum_1 = (num * (num + 1)) / 2;
    int sum_2 = 0;

    int square_1 = (num * (num + 1) * (2 * num + 1)) / 6;
    int square_2 = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            sum_2 += grid[i][j];
            square_2 += (grid[i][j] * grid[i][j]);
        }
    }
    int missing = sum_1 - sum_2;
    int repeat = square_1 - square_2;
    vector<int> answer{repeat, missing};
    return answer;
}
vector<int> findMissingAndRepeatedValues_3(vector<vector<int>> &grid)
{
    vector<int> g;
    g.push_back(0);
    for (int i = 0; i < grid.size(); i++)
        for (int j = 0; j < grid[0].size(); j++)
            g.push_back(grid[i][j]);
    sort(g.begin(), g.end());
    vector<int> ans(2);
    int i = 1; // 0 1 2 2 3
    for (; i < g.size(); i++)
    {
        if (g[i] != i)
            break;
    }
    if (g[i] > i)
        ans[1] = i;
    else
        ans[0] = g[i];
    for (i = g.size() - 1; i >= 0; i--)
    {
        if (g[i] != i)
            break;
    }
    if (g[i] < i)
        ans[1] = i;
    else
        ans[0] = g[i];
    return ans;
}
int main()
{
    vector<vector<int>> neww{{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
    vector<int> result = findMissingAndRepeatedValues_2(neww);
    for (int x : result)
    {
        cout << x << " ";
    }

    return 0;
}