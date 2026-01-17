#include <bits/stdc++.h>
using namespace std;
string getPermutation(int n, int k)
{
    int fact = 1;
    vector<int> num;
    for (int i = 1; i < n ; i++)
    {
        fact = fact * i;
        num.push_back(i);
    }
    num.push_back(n);

    k = k - 1;
    string ans = "";
    while (1)
    {
        ans += to_string(num[k/fact]);
        num.erase(num.begin() + k/fact);
        if(num.size() == 0)break;

        k = k % fact;
        fact = fact / num.size();
    }
    return ans;
}
int main()
{
    cout << getPermutation(3 , 4);

    return 0;
}