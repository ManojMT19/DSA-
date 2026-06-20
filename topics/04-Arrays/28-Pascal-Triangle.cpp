#include<bits/stdc++.h>
using namespace std;
int factorial(int x)
{
    int fact = 1;
    for (int i = 1; i <= x; i++)
    {
        fact *= i;
    }
    return fact;
}
//Type 1 -- by taking input of row and column it will tell the number
int pascal_type_1_Extreme_Brute_nCr(int r ,int c) 
{
    int n = factorial(r-1);
    int rr = factorial(c-1);
    int nr = factorial(r-c);
    int ans = n / (rr * nr);
    return ans;
}
int pascal_type_1_Brute_nCr(int n ,int r) 
{
    long long res = 1;  
    for (int i = 0; i < r; i++)
    {
        res = res * (n-i);
        res = res / (i+1);
    }
    return res;
}

//Type 2 -- If we tell the row it will all the elements in that row
void pascal_type_2_brute(int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << pascal_type_1_Brute_nCr(5 , i) << " ";
    }
}
void pascal_type_2_better(int n)
{
    long long ans = 1;
    cout << ans << " ";
    for (int i = 1; i < n; i++)  
    {
        ans = ans * (n - i);
        ans = ans / i;
        cout << ans << " ";
    }
}
//Type 3 -- Whole Pascal Triangle 
vector<vector<int>> pascal_type_3_brute(int n )
{
    vector<vector<int>> answer;
    for (int row = 0; row <= n; row++)
    {
        vector<int> temp;
        for (int col = 1 ; col <= row ; col++)
        {
            temp.push_back(pascal_type_1_Brute_nCr(row - 1 , col - 1));
        }
        answer.push_back(temp);
    }
    return answer;
}
vector<int> generate_row(int n )
{
    vector<int> a;
    long long ans = 1;  
    a.push_back(ans);
    for (int i = 1; i <= n; i++)
    {
        ans = ans * (n-i+1);
        ans = ans / i;
        a.push_back(ans);
    }
    return a;
}
vector<vector<int>>pascal_type_3_better(int n )
{
    vector<vector<int>> answer;
    for (int row = 1; row <= n; row++)
    {
        answer.push_back(generate_row(row));
    }
    return answer;
}
int main()
{
    int a = pascal_type_1_Brute_nCr(4,2); ///(r-1, c-1)
    // cout << a;

    pascal_type_2_better(6);

    vector<vector<int>> ans = pascal_type_3_brute(6);
    // vector<vector<int>> ans = pascal_type_3_better(5);
    for (int i = 0; i < ans.size(); i++)
    {
        for (int j = 0; j < ans[i].size(); j++)
        {
            // cout << ans[i][j] << " ";
        }
        // cout << endl;
    }

    return 0;
}