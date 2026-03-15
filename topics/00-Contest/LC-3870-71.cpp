#include <bits/stdc++.h>
using namespace std;
int countCommas_1(int n)
{
    if (n < 1000)
        return 0;

    int count = 0;
    while (n > 1000)
    {
        n = n - 1000;
        if (n > 1000)
            count += 1000;
        else
            count = count + n + 1;
    }
    return count;
}
int countCommas_2(int n)
{
    if (n < 1000)
        return 0;

    return n - 1000 + 1;
}

long long countCommas_ll(long long n) 
{
    long long count = 0;
    long long min = 1000;
    while(n > min)
    {
        count += (n - min + 1);
        min *= 1000;
    }
    return count;
}
int main()
{
    int r1 = countCommas_1(12345);
    int r2 = countCommas_2(12345);
    cout << r1 << endl;
    cout << r2 << endl;


    long long rl = countCommas_ll(1234567890);
    cout << rl << endl;

    return 0;
}