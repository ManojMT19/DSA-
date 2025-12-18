#include<bits/stdc++.h>
using namespace std;
string reverseWords_brute(string s) //Leetcode 151
{
    vector<string> words ;
    string word = "";  
    for (int i = 0; s[i] != '\0'; i++)
    {
        if(s[i] != ' ')
        {
            word += s[i];
        }
        else
        {
            words.push_back(word);
            word = "";
        }
    }
    if(!word.empty())
    {
        words.push_back(word);
    }
    reverse(words.begin() , words.end());
    string result = "";
    for (int i = 0; i < words.size(); i++)
    {
        result += words[i];
        if(i != words.size() - 1)
        {
            result += " ";
        }
    }
    return result;
    //TC = O(n)
    //SC = O(n)
}
string reverseWords_optimal(string s)
{
    string result = "";
    int i = s.size()-1;
    while (i >= 0)
    {
        while (i >= 0 && s[i] == ' ')
        {
            i--;
        }
        
        if(i < 0)break;

        int end = i;
        while (i >= 0 && s[i] != ' ')
        {
            i--;
        }
        // substr(starting index , length)
        string word = s.substr(i+1 , end-i);

        if(!result.empty())
        {
            result += " ";
        }
        
        result += word;
    }
    return result;
    //TC = O(n)
    //SC = O(n)
}
int main()
{
    // string ss = "  hello world  ";
    // string ss = "the sky is blue";
    string ss = "a good example";
    // cout << reverseWords_brute(ss);

    cout << reverseWords_optimal(ss);

    return 0;
}
