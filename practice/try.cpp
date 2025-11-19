#include<bits/stdc++.h>
using namespace std;
void intersection(vector<int> arr1 , vector<int> arr2)
{
    sort(arr1.begin(),arr1.end());
    sort(arr2.begin(),arr2.end());
    int n1 = arr1.size();
    int n2 = arr2.size();
    int i = 0 , j = 0;
    vector<int>intersection;
    while (i < n1 && j < n2)
    {
        if (arr1[i] < arr2[j])
        {
            i++;
        }
        else if (arr1[i] > arr2[j])
        {
            j++;
        }
        else
        {
            intersection.push_back(arr1[i]);
            i++,j++;
        }
    }
    for (int i = 0; i < intersection.size(); i++)
    {
        cout << intersection[i] << " ";
    }
    
}
int main()
{
    vector<int>num1{1,2,3,4,5,6};
    vector<int>num2{11,2,33,44,5,65};
    intersection(num1,num2);

    return 0;
}