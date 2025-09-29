#include<iostream>
using namespace std;
void something(int a[] , int nn)
{
    a[0] += 100;
    cout << "Value in function : "<<a[0]<<endl;
}
int main()
{   
    int n=5;
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    something(arr , n);
    cout << "Value in main : "<<arr[0]<<endl;

    
    

    return 0;
} 