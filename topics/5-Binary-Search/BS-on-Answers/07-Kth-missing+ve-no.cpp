#include <bits/stdc++.h>
using namespace std;
int missing_no_brute(vector<int> &arr, int k)
{
    int j = 0;
    vector<int> temp;
    for (int i = 1; temp.size() <= k; i++) // start from 1 & stop when enough
    {
        if (j < arr.size() && i == arr[j]) // bounds check added
        {
            j++;
        }
        else
        {
            temp.push_back(i);
        }
    }

    return temp[k - 1];
}

int findKthMissing_brute(vector<int> &arr, int k)//this is better than above in terms of TC and SC
{
    for (int i = 0; i < arr.size(); i++)
    {
        if (arr[i] <= k)
        {
            k++;
        }
        else
        {
            break;
        }
    }
    return k;
}
/*
We first assume the k-th missing number is k.
Then we iterate through the array.
Every number that is smaller than or equal to our assumed answer means one missing spot is no longer missing, so we push the answer forward by one.
When we reach a number greater than our current guess, we stop — at that point our guess has already adjusted correctly and is the answer.
*/

int findKthMissing_optimal(vector<int> &arr, int k)
{
    int n = arr.size();
    int low = 0;
    int high = n-1;
    while (low <= high)
    {
        int mid = (low+high)/2;
        int missing = arr[mid] - (mid + 1);
        if(missing < k)
        {
            low = mid+1;
        }
        else
        {
            high = mid-1;
        }
    }
    return k + high + 1;//we can return k+low also bcz low = high + 1 , Dry run if u didnt get
}
int main()
{
    vector<int> demo1{2, 3, 4, 7, 11};
    vector<int> demo2{4, 7, 9, 10};
    vector<int> demo3{2, 3, 4};
    int k = 2;

    cout << missing_no_brute(demo1,k)<<endl;
    cout << findKthMissing_brute(demo1, k)<<endl;
    cout << findKthMissing_optimal(demo2, k);

    return 0;
}