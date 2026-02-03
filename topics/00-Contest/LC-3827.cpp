#include <bits/stdc++.h>
using namespace std;
/*
The logic used is:

Bit Extraction: The code uses n % 2 to check the last binary digit and n / 2 to remove it, effectively scanning the binary representation from right to left using decimal math.

Monobit Validation: Since all positive binary numbers must start with a 1, the function rejects any number that contains a 0 remainder, identifying only numbers composed entirely of 1s (like 1, 3, 7, 15).
*/
bool Mono(int n)
{
    if (n == 0)
        return true;

    while (n > 0)
    {
        int bit = n % 2;
        if (bit == 0)
        {
            return false;
        }
        n = n / 2;
    }
    return true;
}
int countMonobit(int n)
{
    int count = 0;
    for (int i = 0; i <= n; i++)
    {
        if (Mono(i))
        {
            count++;
        }
    }
    return count;
}

int main()
{

    return 0;
}