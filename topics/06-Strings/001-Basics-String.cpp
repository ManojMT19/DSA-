#include<bits/stdc++.h>
using namespace std;
int validate(string s)
{
    for (int i = 0; s[i] != '\0'; i++)
    {
        if ( !(s[i] >= 65 && s[i] <= 90) && !(s[i] >= 97 && s[i] <= 122) && !(s[i] >= 48 && s[i] <= 57))
        {
            return 0;
        }
    }
    return 1;
}
void string_reversal(char s[])
{
    int i = 0, j = 0;

    while (s[j] != '\0')
    {
        j++;
    }
    j--;   // last valid index

    while (i < j)
    {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        i++;
        j--;
    }
    cout << s << endl;
}
void duplicates(string  s)
{
    int hash[26] = {0};
    for (int i = 0; i < s.length(); i++)
    {
        hash[s[i]-97]++;
    }
    for (int j = 0; j < 26; j++)
    {
        if (hash[j] > 1)
        {
            cout << char(j + 'a') << " " << hash[j] << " times " << endl;
        }
    }
}
int main()
{
    string ss = "manoj123";
    // string ss = "manoj123??";
    // cout << validate(ss);

    char s[] = "programming";
    string_reversal(s);
    // duplicates(s);


    return 0;
}