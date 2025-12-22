#include <bits/stdc++.h>
using namespace std;
bool rotateString(string s, string goal)//Leetcode 796
{
    int n = s.size();
    if(n != goal.size())return false;
    int i = 0;
    while (i != n)
    {   
        string word =  s.substr(i) + s.substr(0,i);
        if(word == goal)
            return true;
        i++;
    }
    return false;
    /*
    Time Complexity (TC) =  Loop runs n times
                            Each iteration:
                            substr(i) → O(n)
                            substr(0, i) → O(n)
                            String concatenation → O(n)
                            String comparison → O(n)
                            So per iteration → O(n)
                            
                            Total TC = O(n²)

    Space Complexity = O(n)
    */
}
bool rotateString_optimal(string s, string goal)
{
    if(s.size() != goal.size())return false;
    s = s+s;
    if(s.find(goal) != string::npos)
    {
        return true;
    }
    return false;
    //Time : O(n) 
    //Space: O(n)
}
int main()
{
    string s = "abcde";
    string goal = "abcde";
    // cout << rotateString_(s , goal);
    cout << rotateString_optimal(s , goal);


    return 0;
}