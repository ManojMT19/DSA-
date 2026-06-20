#include <bits/stdc++.h>
using namespace std;
vector<vector<int>> merge_1(vector<vector<int>> &intervals)
{
    vector<vector<int>> answer;
    sort(intervals.begin(), intervals.end());
    int n = intervals.size();
    for (int i = 0; i < n; i++)
    {
        int start = intervals[i][0];
        int end = intervals[i][1];
        if (!answer.empty() && end <= answer.back()[1])
            continue;
        for (int j = i + 1; j < n; j++)
        {
            if (intervals[j][0] <= end)
            {
                end = max(end, intervals[j][1]);
            }
            else
            {
                break;
            }
        }

        answer.push_back({start, end});
    }
    return answer;
}
vector<vector<int>> merge_2(vector<vector<int>> &intervals)
{
    vector<vector<int>> answer;
    if (intervals.empty())
        return answer;

    sort(intervals.begin(), intervals.end());
    vector<int> current = intervals[0];
    for (int i = 1; i < intervals.size(); i++)
    {
        if (intervals[i][0] <= current[1])
        {
            // Overlap, merge
            current[1] = max(current[1], intervals[i][1]);
        }
        else
        {
            // No overlap, push current and move to next
            answer.push_back(current);
            current = intervals[i];
        }
    }
    answer.push_back(current); // push the last interval
    return answer;
}
vector<vector<int>> merge_3(vector<vector<int>> &num)
{
    vector<vector<int>> answer;
    sort(num.begin(), num.end());
    int n = num.size();
    for (int i = 0; i < n; i++)
    {
        if (answer.empty() || num[i][0] > answer.back()[1])
        {
            answer.push_back(num[i]);
        }
        else
        {
            answer.back()[1] = max(answer.back()[1], num[i][1]);
        }
    }

    return answer;
}
int main()
{
    vector<vector<int>> nums{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    vector<vector<int>> result = merge_3(nums);
    for (int i = 0; i < result.size(); i++)
    {
        for (int j = 0; j < result[i].size(); j++)
        {
            cout << result[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}