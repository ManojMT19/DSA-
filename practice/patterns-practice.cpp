#include <iostream>
using namespace std;
void patt2(int n)
{
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            cout << "* ";
        }
        cout << endl;
    }
}
void patt3(int n)
{
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            cout << j << " ";
        }
        cout << endl;
    }
}
void patt5(int n)
{
    for (int i = 1; i <= n; i++)
    {
        for (int j = n; j >= i; j--)
        {
            cout << "* ";
        }
        cout << endl;
    }
}
void patt4(int n)
{
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            cout << i << " ";
        }
        cout << endl;
    }
}
void patt6(int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 1; j <= n - i; j++)
        {
            cout << j << " ";
        }
        cout << endl;
    }
}
void patt7(int n)
{
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n - i; j++)
        {
            cout << "  ";
        }
        for (int k = 1; k <= 2 * i - 1; k++)
        {
            cout << "* ";
        }
        for (int j = 1; j <= n - i; j++)
        {
            cout << "  ";
        }
        cout << endl;
    }
}
void patt8(int n)
{
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j < i; j++)
        {
            cout << "  ";
        }
        for (int k = 1; k <= 2 * n - (2 * i - 1); k++)
        {
            cout << "* ";
        }
        for (int j = 1; j < i; j++)
        {
            cout << "  ";
        }
        cout << endl;
    }
}
void patt9(int n)
{
    patt7(n);
    patt8(n);
}
void patt10(int n)
{
    for (int i = 1; i <= 2 * n - 1; i++)
    {
        int star = (i > n) ? 2 * n - i : i;
        for (int j = 1; j <= star; j++)
        {
            cout << "* ";
        }
        cout << endl;
    }
}
void papp10(int n)
{
    for (int i = 1; i <= 2 * n - 1; i++)
    {
        int star = (i <= n) ? i : 2 * n - i;
        int space = (i <= n) ? n - i : i - n;
        for (int j = 1; j <= space; j++)
        {
            cout << "  ";
        }
        for (int k = 1; k <= star; k++)
        {
            cout << "* ";
        }
        cout << endl;
    }
}
void patt12(int n)
{
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            cout << j;
        }
        for (int k = 1; k <= 2 * n - (2 * i - 1); k++)
        {
            cout << " ";
        }

        for (int j = i; j >= 1; j--)
        {
            cout << j;
        }
        cout << endl;
    }
}
void patt13(int n)
{
    int num = 1;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            cout << num << " ";
            num++;
        }
        cout << endl;
    }
}
void patt14(int n)
{
    for (int i = 1; i <= 2 * n - 1; i++)
    {
        int space = (i <= n) ? n - i : i - n;
        int star = (i <= n) ? 2 * i - 1 : 2 * (2 * n - i) - 1;
        for (int a = 1; a <= space; a++)
        {
            cout << "  ";
        }
        for (int b = 1; b <= star; b++)
        {
            cout << "* ";
        }
        cout << endl; 
    }
}
int main()
{
    patt14(5);

    return 0;
}