#include <iostream>
using namespace std;
int fabi(int n)
{
    int a = 0, b = 1;
    if (n == 0)
        return 0;
    if (n == 1)
        return 1;
    for (int i = 2; i < n; i++)
    {
        int x = a + b;
        a = b;
        b = x;
    }
    return b;
}
int fabbb(int n)
{
    if (n == 0)
        return 0;
    if (n == 1)
        return 1;
    return fabbb(n - 2) + fabbb(n - 1);
}
int main()
{
    // cout << fabi(2);
    cout << fabbb(2);
    return 0;
}