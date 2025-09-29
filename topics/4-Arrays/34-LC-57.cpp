#include <bits/stdc++.h>
using namespace std;
vector<vector<int>> insert_1(vector<vector<int>> &intervals, vector<int> &newInterval)
{
    intervals.push_back(newInterval);
    vector<vector<int>> answer;
    sort(intervals.begin(), intervals.end());
    int n = intervals.size();
    for (int i = 0; i < n; i++)
    {
        if (answer.empty() || intervals[i][0] > answer.back()[1])
        {
            answer.push_back(intervals[i]);
        }
        else
        {
            answer.back()[1] = max(answer.back()[1], intervals[i][1]);
        }
    }

    return answer;
}
vector<vector<int>> insert(vector<vector<int>> &intervals, vector<int> &newInterval)
{
    int n = intervals.size(), i = 0;
    vector<vector<int>> res;
    // case 1: no overlapping case before the merge intervals
    // compare ending point of intervals to starting point of newInterval
    while (i < n && intervals[i][1] < newInterval[0])
    {
        res.push_back(intervals[i]);
        i++;
    }
    // case 2: overlapping case and merging of intervals
    while (i < n && newInterval[1] >= intervals[i][0])
    {
        newInterval[0] = min(newInterval[0], intervals[i][0]);
        newInterval[1] = max(newInterval[1], intervals[i][1]);
        i++;
    }
    res.push_back(newInterval);
    // case 3: no overlapping of intervals after newinterval being merged
    while (i < n)
    {
        res.push_back(intervals[i]);
        i++;
    }
    return res;
}
    int main()
    {
        vector<vector<int>> num{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        vector<int> new_num{4, 8};
        vector<vector<int>> r = insert(num, new_num);
        for (int i = 0; i < r.size(); i++)
        {
            for (int j = 0; j < r[i].size(); j++)
            {
                cout << r[i][j] << " ";
            }
            cout << endl;
        }

        return 0;
    }