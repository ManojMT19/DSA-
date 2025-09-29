#include<iostream>
using namespace std;
void name(int i ,int n)
{
    if(i > n)
    {   
        return;
    }
    cout << "MANOJ"<<endl;
    name(i+1,n);
}
void oneton(int i ,int n)
{
    if(i > n)return;
    cout << i << endl;
    oneton(i+1,n);
}
void ntoone(int n ,int i)
{
    if(n<i)return;
    cout << n << endl;
    ntoone(n-1,i);
}
void onetonback(int n ,int i)
{
    if (n<i)
    {
        return;
    }
    onetonback(n-1,i);
    cout << n << endl;;
}
void ntooneback(int n ,int i)
{
    if (n > i)
    {
        return;
    }
    ntooneback(n+1,i);
    cout << n << endl;
}
int main()
{
    // name(1,5);
    // oneton(1,5);
    // ntoone(5,1);
    // onetonback(5,1);
    ntooneback(1,5);

    return 0;
}