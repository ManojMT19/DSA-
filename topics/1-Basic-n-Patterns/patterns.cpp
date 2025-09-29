#include <iostream>
using namespace std;
void patt1(int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << " *";
        }
        cout << endl;
    }
    /*
    * * * * *
    * * * * *
    * * * * *
    * * * * *
    * * * * *
    */
}
void patt2(int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            cout << "* ";
        }
        cout << endl;
    }
            /*
* 
* *
* * *
* * * *
* * * * *
            */
}
void patt3(int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            cout << j + 1 << " ";
        }
        cout << endl;
    }
    /*
    1 
    1 2
    1 2 3
    1 2 3 4
    1 2 3 4 5
    */
}
void patt4(int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            cout << i + 1 << " ";
        }
        cout << endl;
    }
    /*
1 
2 2
3 3 3
4 4 4 4
5 5 5 5 5    
    */
}
void patt5(int n)
{
    for (int i = 1; i <= n; i++)
    {
        for (int j = n; j >= i; j--)
        {
            cout << " *";
        }
        cout << endl;
    }/*
    
 * * * * *
 * * * *
 * * *
 * *
 *    
    */
}
void patt6(int n)
{
    for (int i = 1; i <= n; i++)
    {
        // for (int j = n; j > i ; j--)
        for (int j = 1; j <= n - i + 1; j++)
        {
            cout << " *";
        }
        cout << endl;
    }
    /*
        * * * * *
        * * * *
        * * *
        * *
        *
 */
}
void patt7(int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 1; j <= n - i; j++)
        // for (int j = 1; j < n-i+1 ; j++)
        {
            cout << j << " ";
        }
        cout << endl;
    }
    /*
    1 2 3 4 5 
    1 2 3 4
    1 2 3
    1 2
    1
    */
}
void patt8(int n)
{
    // for (int i = 1; i <= n; i++)
    // {
    //     //Space
    //     for (int j = 1; j <= n-i ; j++)
    //     // for (int j = 1; j < n-i+1 ; j++)
    //     {
    //         cout << " ";
    //     }
    //     //Star
    //     for (int k = 1; k <= i; k++)
    //     {
    //         cout << "*";
    //     }
    //     //Star
    //     for (int m = 1; m <= i-1 ; m++)
    //     {
    //         cout << "*";
    //     }
    //     cout <<  endl;
    // }
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
        for (int l = 1; l <= n - i; l++)
        {
            cout << "  ";
        }
        cout << endl;
    } /*
               *
             * * *
           * * * * *
         * * * * * * *
       * * * * * * * * *               */
}
void ppp8(int n)
{
    // for (int i = 1; i <= n; i++)
    // {
    //     //Space
    //     for (int j = 1; j <= i ; j++)
    //     {
    //         cout << "  ";
    //     }
    //     //Star
    //     for (int k = n; k >= i; k--)
    //     {
    //         cout << "* ";
    //     }
    //     //Star
    //     for (int m = n; m > i ; m--)
    //     {
    //         cout << "* ";
    //     }
    //     cout <<  endl;
    // }
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j < i; j++)
        {
            cout << "  ";
        }
        for (int k = 1; k <= 2 * n - (2 * i - 1); k++) // remember this
        {
            cout << "* ";
        }
        for (int l = 1; l < i; l++)
        {
            cout << "  ";
        }
        cout << endl;
    }

    /*
     * * * * * * * * *
       * * * * * * *
         * * * * *
           * * *
             *
     */
}
void ppp9(int n)
{
    // Upside
    //     for (int i = 1; i <= n; i++)
    //     {
    //         //Space
    //         for (int j = 0; j <= n-i ; j++)
    //         // for (int j = 1; j < n-i+1 ; j++)
    //         {
    //             cout << "  ";
    //         }
    //         //Star
    //         for (int k = 1; k <= i; k++)
    //         {
    //             cout << "* ";
    //         }
    //         //Star
    //         for (int m = 1; m <= i-1 ; m++)
    //         {
    //             cout << "* ";
    //         }
    //         cout <<  endl;
    //     }
    //     //Downside
    //     for (int i = 2; i <= n; i++)
    //     {
    //         //Space
    //         for (int j = 1; j <= i ; j++)
    //         {
    //             cout << "  ";
    //         }
    //         //Star
    //         for (int k = n; k >= i; k--)
    //         {
    //             cout << "* ";
    //         }
    //         //Star
    //         for (int m = n; m > i ; m--)
    //         {
    //             cout << "* ";
    //         }
    //         cout <<  endl;
    //     }
    patt8(n);
    ppp8(n);
}
void ppp10(int n)
{
    for (int i = 1; i <= 2 * n - 1; i++)
    {
        int star = i <= n ? i : 2 * n - i;
        for (int j = 1; j <= star; j++)
        {
            cout << "* ";
        }
        cout << endl;
    } /*
       *
       * *
       * * *
       * * * *
       * * * * *
       * * * *
       * * *
       * *
       *
       */
}
void patt10(int n)
{
    for (int i = 1; i <= 2 * n - 1; i++)
    {
        int space = i <= n ? n - i : i - n;
        int star = i <= n ? i : 2 * n - i;
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
/*
        * 
      * *
    * * *
  * * * *
* * * * *
  * * * *
    * * *
      * *
        *
*/}
void ppp11(int n)
{
    for (int i = 1; i <= n; i++)
    {
        int start = (i % 2 == 0) ? 1 : 0;
        for (int j = 1; j <= start; j++)
        {
            cout << start;
            start = 1 - start;
        }
        cout << endl;
    }
}
void ppp12(int n)
{
    int space = 2 * n - 2;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            cout << j << " ";
        }
        for (int k = 1; k <= space; k++)
        {
            cout << "  ";
        }
        space -= 2;
        // for (int k = 1; k <= 2*n-(2*i-1); k++)
        // {
        //     cout << "  ";
        // }
        for (int l = i; l >= 1; l--)
        {
            cout << l << " ";
        }
        cout << endl;
    }
    /*
1               1
1 2           2 1
1 2 3       3 2 1
1 2 3 4   4 3 2 1
*/
}
void ppp13(int n)
{
    int start = 1;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 0; j < i; j++)
        {
            cout << start << " ";
            start += 1;
        }
        cout << endl;
    } /*
 1
 2 3
 4 5 6
 7 8 9 10
 11 12 13 14 15          */
}
void ppp14(int n)
{
    for (int i = 1; i <= n; i++)
    {
        char a = 'A';
        for (int j = 1; j <= i; j++)
        {
            cout << a << " ";
            a += 1;
        }
        cout << endl;
    }
    /*
    A
    A B
    A B C
    A B C D
    A B C D E
*/
}
void ppp15(int n)
{
    for (int i = 1; i <= n; i++)
    {
        char a = 'A';
        for (int j = n; j >= i; j--)
        {
            cout << a << " ";
            a += 1;
        }
        cout << endl;
    }
    /*
        A B C D E
        A B C D
        A B C
        A B
        A
     */
}
void ppp16(int n)
{
    char a = 'A';
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            cout << a << " ";
        }
        cout << endl;
        a = a + 1;
    }
    /*
        A
        B B
        C C C
        D D D D
        E E E E E
     */
}
void patt17(int n)
{
    for (int i = 1; i <= n; i++)
    {
        char a = 'A';
        for (int j = 1; j <= n - i; j++)
        {
            cout << "  ";
        }
        for (int k = 1; k <= 2 * i - 1; k++)
        {
            cout << a << " ";
            a += 1;
        }
        for (int l = 1; l <= n - i; l++)
        {
            cout << "  ";
        }
        cout << endl;
    }
    /*
            A
          A B C
        A B C D E
      A B C D E F G
    A B C D E F G H I
    */
}
void ppp17(int n)
{
    for (int i = 1; i <= n; i++)
    {
        char a = 'A';
        for (int j = 1; j <= n - i; j++)
        {
            cout << "  ";
        }
        for (int k = 1; k <= 2 * i - 1; k++)
        {
            cout << a << " ";
            if (k < i)
                a += 1;
            else
                a -= 1;
        }
        for (int j = 1; j <= n - i; j++)
        {
            cout << "  ";
        }
        cout << endl;
    } /*             A
                   A B A
                 A B C B A
               A B C D C B A
             A B C D E D C B A
 */
}
void ppp18(int n)
{
    for (int i = 1; i <= n; i++)
    {
        char ch = 'A';
        ch = ch + (n - i);
        for (int j = 1; j <= i; j++)
        {
            cout << ch << " ";
            ch++;
        }
        cout << endl;
    } /*
     E
     D E
     C D E
     B C D E
     A B C D E */
}
void ppp19(int n)
{
    int space = 0;
    int star = n;
    for (int i = 1; i <= 2 * n - 1; i++)
    {
        for (int j = 1; j <= star; j++)
        {
            cout << "* ";
        }
        for (int m = 1; m <= space; m++)
        {
            cout << "  ";
        }
        for (int k = 1; k <= star; k++)
        {
            cout << "* ";
        }
        cout << endl;
        if (i < n)
        {
            star--;
            space += 2;
        }
        else
        {
            star++;
            space -= 2;
        }
    }
}
void ppp20(int n)
{
    for (int i = 1; i <= 2 * n - 1; i++)
    {
        int ss = (i <= n) ? 2 * (n - i) : 2 * (i - n);
        int star = i <= n ? i : 2 * n - i;
        for (int j = 1; j <= star; j++)
        {
            cout << "* ";
        }
        // int space  = 2*(n-star);
        // for(int k = 1; k <= space ; k++)
        // {
        //     cout << "  ";
        // }
        for (int s = 1; s <= ss; s++)
        {
            cout << "  ";
        }

        for (int j = 1; j <= star; j++)
        {
            cout << "* ";
        }
        cout << endl;
    } /*
       *                 *
       * *             * *
       * * *         * * *
       * * * *     * * * *
       * * * * * * * * * *
       * * * *     * * * *
       * * *         * * *
       * *             * *
       *                 *         */
}
void ppp21(int n)
{
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            if (i == 1 || i == n || j == 1 || j == n)
            {
                cout << "* ";
            }
            else
            {
                cout << "  ";
            }
        }
        cout << endl;
    } /*
       * * * * *
       *       *
       *       *
       *       *
       * * * * *           */
}
void ppp22(int n)
{
    for (int i = 1; i <= 2 * n - 1; i++)
    {
        for (int j = 1; j <= 2 * n - 1; j++)
        {
            int top = i;
            int left = j;
            int right = 2 * n - j;
            int bottom = 2 * n - i;
            cout << (n - min(min(top, bottom), min(right, left))) << " ";
        }
        cout << endl;
    } /*
    4 4 4 4 4 4 4 4 4
    4 3 3 3 3 3 3 3 4
    4 3 2 2 2 2 2 3 4
    4 3 2 1 1 1 2 3 4
    4 3 2 1 0 1 2 3 4
    4 3 2 1 1 1 2 3 4
    4 3 2 2 2 2 2 3 4
    4 3 3 3 3 3 3 3 4
    4 4 4 4 4 4 4 4 4
     */
}
int main()
{
    int n = 5;
    // ppp8(n);
    patt5(n);

    return 0;
}