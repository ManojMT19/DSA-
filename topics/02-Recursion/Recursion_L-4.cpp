// This is Reversing of  array normally
/*
#include<iostream>
using namespace std;
void reverse_array_basic(int a[],int n)
{
    for (int i = 0; i < n/2 ; i++)
    {
        int t = a[i];
        a[i] = a[n-i-1];
        a[n-i-1] = t;
    }
    for (int i = 0; i < n; i++)
    {
        cout << a[i]<<" ";
    }
}
void reverse_new_array(int x[] , int n )
{
    int reversed[n];
    for (int i = 0; i < n ;i++)
    {
        reversed[i] = x[n-1-i];
    }
    for (int j = 0; j< n; j++)
    {
        cout << reversed[j] << " ";
    }
}
int main()
{
    int b[] = {1, 2, 3, 4, 5};
    int n = sizeof(b) / sizeof(b[0]);
    int copy[n];
    for (int i = 0; i < n; i++)
    {
        copy[i] = b[i];
    }
    reverse_array_basic(b,n);
    cout << endl;
    reverse_new_array(copy,n);

    return 0;
}*/
//-------------------------------------------------------------------------------------------------------------------
// Using Recursion
#include <bits/stdc++.h>
using namespace std;
void reverse(int l, int r, int x[])
{
    if (l >= r)
        return;
    swap(x[l], x[r]);
    reverse(l + 1, r - 1, x);
}
void reverse_another(int i, int n, int z[])
{
    if (i >= n / 2)
    {
        for (int i = 0; i < n; i++)
        {
            cout << z[i] << " ";
        }
        return;
    }
    swap(z[i], z[n - i - 1]);
    reverse_another(i + 1, n, z);
}
void s_reverse(string a, int n)
{
    string o = a;
    for (int i = 0; i < n / 2; i++)
    {
        swap(a[i], a[n - i - 1]);
    }
    if (o == a)
        cout << "Palindrome" << endl;
    else
        cout << "Not a palindrome" << endl;
}
int ss_reverse(string a, int i)
{
    if (i >= a.length() / 2)
        return true;
    if (a[i] != a[a.length() - i - 1])
        return false;
    return ss_reverse(a, i + 1);
}
bool palindrome_leet(string s)
{
    string o = "";
    for (char c : s)
    {
        if (isalnum(c))
        {
            o += tolower(c);
        }
    }
    string rev = o;
    reverse(rev.begin(), rev.end());
    return o == rev;
}
bool isPalindrome(string &s, int left, int right)
{
    while (left < right)
    {
        if (s[left] != s[right])
            return false;
        left++;
        right--;
    }
    return true;
}
bool validPalindrome(string s)
{
    int left = 0, right = s.length() - 1;

    while (left < right)
    {
        if (s[left] != s[right])
        {
            return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
        }
        left++;
        right--;
    }
    return true;
}
int main()
{
    // int a[] = {1, 2, 3, 4, 5};
    // int n = sizeof(a) / sizeof(a[0]);
    // reverse(0,n-1,a);
    // for (int i = 0; i < n; i++)
    // {
    //     cout << a[i]<< " ";
    // }
    // cout << endl;
    // reverse_another(0,n,a);

    // string s = "MADAM";
    // int size = s.length();
    // s_reverse(s, size);
    // cout << ss_reverse(s, 0);

    // cout << palindrome_leet("MADAM");
    cout << palindrome_leet("abcba");

    return 0;
}
/*
bool pal(string s , int l ,int r)
    {
        while(l < r)
        {
            if(s[l] == s[r])
            {
                return  false;
            }
            l++;
            r--;
        }
        return true;
    }
    bool validPalindrome(string s) 
    {   
        int l = 0 , r = s.length() - 1;
        while(l < r)
        {
            if(s[l] != s[r])
            {
                return pal(s, l+1 , r);
            }
            l++;
            r--;
        }
        return true;


        
    }
*/