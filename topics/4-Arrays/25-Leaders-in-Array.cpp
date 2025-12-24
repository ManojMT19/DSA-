#include <bits/stdc++.h>
using namespace std;
/*
Problem Statement
Given an array of integers, a leader is an element that is greater than or equal to all the elements to its right side.
The rightmost element is always a leader.
Your task is to find all the leaders in the array and return them in the same order as they appear in the array.
*/
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
    //TC = O(n square)
    //SC = O(1)
}
//Dont get confuse between this and maximum in an array bcz in an array maximum can be only one but leader can be more than 1
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
    // reverse(answer.begin(), answer.end()); // We should based on the required output

    return answer;
    //TC = O(n)
    //SC = O(1)
}
int main()
{
    vector<int> arr{10, 2, 12, 3, 0, 6};
    vector<int> r = leader_optimal(arr);
    for(int x : r)
    {
        cout << x << " ";
    }
    
    return 0;
} 