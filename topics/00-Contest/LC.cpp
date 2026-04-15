#include <bits/stdc++.h>
using namespace std;

bool uniformArray_2(vector<int> &nums1)
{
    int minOdd = INT_MAX, minEven = INT_MAX;
    int oddCount = 0, evenCount = 0;

    for (int x : nums1) {
        if (x % 2 == 0) {
            evenCount++;
            minEven = min(minEven, x);
        } else {
            oddCount++;
            minOdd = min(minOdd, x);
        }
    }

    bool allEven = (oddCount == 0);

    bool allOdd = (evenCount == 0) || (oddCount > 0 && minOdd < minEven);

    return allEven || allOdd;
}
bool uniformArray(vector<int> &nums1)
{
    int n = nums1.size();
    vector<vector<int>> possible(n);

    for (int i = 0; i < n; i++)
    {
        possible[i].push_back(nums1[i]);
        for (int j = 0; j < n; j++)
        {
            if (i != j)
            {
                possible[i].push_back(nums1[i] - nums1[j]);
            }
        }
    }

    bool allEven = true;
    for (int i = 0; i < n; i++)
    {
        bool canBeEven = false;
        for (int val : possible[i])
        {
            if (val % 2 == 0)
            {
                canBeEven = true;
                break;
            }
        }
        if (!canBeEven)
        {
            allEven = false;
            break;
        }
    }

    bool allOdd = true;
    for (int i = 0; i < n; i++)
    {
        bool canBeOdd = false;
        for (int val : possible[i])
        {
            if (((val % 2) + 2) % 2 == 1)
            {
                canBeOdd = true;
                break;
            }
        }
        if (!canBeOdd)
        {
            allOdd = false;
            break;
        }
    }

    return allEven || allOdd;
}

int main()
{
    vector<int> a = {2, 3};
    cout << uniformArray(a) << endl;

    vector<int> b = {4, 6};
    cout << uniformArray(b) << endl;
    return 0;
}