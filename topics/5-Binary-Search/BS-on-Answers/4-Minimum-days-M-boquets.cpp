#include <bits/stdc++.h>
using namespace std;
bool possible(vector<int> &roseplant, int day, int no_of_boques, int no_of_rose)
{
    int count = 0;
    int boques = 0;

    int ans, i, t = 0;
    for (int rose : roseplant)
    {
        if (rose <= day)
        {
            count++;
            if (count == no_of_rose)
            {
                boques += 1;
                count = 0;
            }
        }
        else
        {
            count = 0;
        }
    }
    return boques >= no_of_boques;
}
int boque_brute(vector<int> &roseplant, int no_of_boques, int no_of_roses)
{
    int n = roseplant.size();
    if (n < (no_of_boques * no_of_roses))
        return -1;

    int min = *min_element(roseplant.begin(), roseplant.end());
    int max = *max_element(roseplant.begin(), roseplant.end());
    for (int i = min; i < max; i++)
    {
        if (possible(roseplant, i, no_of_boques, no_of_roses) == true)
        {
            return i;
        }
    }
    return -1;
}
int boque_optimal(vector<int> &roseplant, int no_of_boques, int no_of_roses)
{
    int n = roseplant.size();
    long long total = 1LL * no_of_boques * no_of_roses;
    if (n < total)
        return -1;

    int low = *min_element(roseplant.begin(), roseplant.end());
    int high = *max_element(roseplant.begin(), roseplant.end());
    int ans = -1;

    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (possible(roseplant, mid, no_of_boques, no_of_roses) == true)
        {
            ans = mid;
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return ans;
}
int main()
{
    vector<int> ex{7, 7, 7, 7, 15, 11, 12, 7};
    int no_of_boques = 2;
    int no_of_roses = 3;

    // cout << boque_brute(ex,k,m);
    cout << boque_optimal(ex, no_of_boques, no_of_roses);

    return 0;
}
//---------------------------------------------------------------------------------------------------------------
// this shorter form of the above code

int minDays(vector<int> &bloomDay, int m, int k)
{
    int lo = *min_element(bloomDay.begin(), bloomDay.end());
    int hi = *max_element(bloomDay.begin(), bloomDay.end());
    int ans = -1;

    while (lo <= hi)
    {
        int mid = lo + (hi - lo) / 2;
        long long cnt = 0, bouq = 0;
        for (int i = 0; i < bloomDay.size(); i++)
        {
            if (bloomDay[i] <= mid)
                cnt++;
            else
            {
                bouq += (cnt / k);
                cnt = 0;
            }
        }
        bouq += (cnt / k);

        if (bouq < m)
            lo = mid + 1;
        else
        {
            ans = mid;
            hi = mid - 1;
        }
    }

    return ans;
}