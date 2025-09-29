#include<iostream>
using namespace std;
void sum_para(int i,int s)//Parameterised Recursion
{ 
    if (i < 1)
    {
        cout << s <<endl;;
        return;
    }
    sum_para(i-1 ,s+i);
}
int sum_func(int n) //Functional Recursion
{
    if (n < 1)
    {
        return 0;
    }
    return n + sum_func(n-1);
}
int fact_para(int n, int f)//Parameterised Recursion
{
    if (n < 1)
    {
        cout << f <<endl; 
        return 1;
    }
    fact_para(n-1 , f*n);
}
int fact_func(int n)//Functional Recursion
{
    if(n < 1) 
    {
        return 1;
    }
    return n*fact_func(n-1);
}
int main()
{
    // sum_para(4,0);
    // cout << sum_func(4);
    fact_para(4 , 1);

    return 0;
}