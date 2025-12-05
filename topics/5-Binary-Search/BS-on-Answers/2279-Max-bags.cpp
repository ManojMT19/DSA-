#include<bits/stdc++.h>
using namespace std;
int maximumBags(vector<int>& capacity, vector<int>& rocks, int additionalRocks) 
{
    int n = capacity.size();
    vector<int> need(n);
    
    for (int i = 0; i < n; i++) 
    {
        need[i] = capacity[i] - rocks[i];
    }
    
    sort(need.begin(), need.end()); 
    int count = 0;
    for (int x : need) 
    {
        if (x == 0) 
        {
            count++;
        } else if (additionalRocks >= x) 
        { 
            additionalRocks -= x;
            count++;
        } else 
        {
            break;
        }
    }
    return count;
}
int main()
{
    vector<int> cap1{2,3,4,5};
    vector<int> roc1{1,2,4,4};
    int add1 = 2;

    vector<int> cap2{10,2,2};
    vector<int> roc2{2,2,0};
    int add2 = 100;

    vector<int> cap3{91,54,63,99,24,45,78};
    vector<int> roc3{35,32,45,98,6,1,25};
    int add3 = 17;

    // cout << maximumBags(cap1 , roc1 , add1) << endl;
    cout << maximumBags(cap2 , roc2 , add2) << endl;
    // cout << maximumBags(cap3 , roc3 , add3) ;
    
    return 0;
}