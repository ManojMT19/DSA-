#include <bits/stdc++.h>
using namespace std;
vector<int> leader_brute(vector<int> a)
{
    vector<int> answer;
    int n = a.size();
    for (int i = 0; i < n; i++)
    {
        bool leader = true;
        for (int j = i + 1; j < n; j++)
        {
            if (a[j] > a[i])
            {
                leader = false;
                break;
            }
        }
        if (leader == true)
        {
            answer.push_back(a[i]);
        }
    }
    return answer;
}
//Dont get confusre between this and maximum in an array bcz in an array maximum can be only one but leader can be more than 1
vector<int> leader_optimal(vector<int> a)
{
    vector<int> answer;
    int n = a.size();
    int maxx = INT_MIN;
    for (int i = n - 1; i >= 0; i--)
    {
        if (a[i] > maxx)
        {
            answer.push_back(a[i]);
        }
        maxx = max(maxx, a[i]);
    }
    sort(answer.begin(), answer.end());

    return answer;
}
int main()
{
    vector<int> arr{10, 2, 12, 3, 0, 6};
    vector<int> r = leader_optimal(arr);
    int m = *max_element(r.begin(), r.end());
    cout << m;
    
    return 0;
} 