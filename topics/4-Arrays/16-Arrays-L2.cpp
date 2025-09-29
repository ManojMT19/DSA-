#include <iostream>
#include <bits/stdc++.h>
using namespace std;
void rotate_array_by_1_place(int arr[], int n)
{
    int temp = arr[0];
    for (int i = 1; i < n; i++)
    {
        arr[i - 1] = arr[i];
    }
    arr[n - 1] = temp;
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
}
void rotate_d_places(int arr[], int n, int d)
{
    d = d % n;
    int temp[d];
    for (int k = 0; k < d; k++)
    {
        temp[k] = arr[k];
    }
    for (int i = d; i < n; i++)
    {
        arr[i - d] = arr[i];
    }
    int k = 0;
    for (int j = n - d; j < n; j++)
    {
        arr[j] = temp[k];
        k++;
    }
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
}
void rotate_d_places_optimal(int arr[], int n, int d)
{
    d = d % n;
    reverse(arr, arr + d);
    reverse(arr + d, arr + n);
    reverse(arr, arr + n);
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
}
void rotate_leftside(vector<int> &nums, int k)
{
    int n = nums.size();
    k = k % n;
    reverse(nums.begin(), nums.begin() + k);
    reverse(nums.begin() + k, nums.begin() + n);
    reverse(nums.begin(), nums.begin() + n);
}
void rotate(vector<int> &nums, int k) // Leetcode 189 --->>> this rotating right side
{
    int n = nums.size();
    k = k % n;
    k = n - k;  //To Rotate Right Side
    reverse(nums.begin(), nums.begin() + k);
    reverse(nums.begin() + k, nums.begin() + n);
    reverse(nums.begin(), nums.end());
}
void move_zero_to_last_basic(vector<int> arr, int n)
{
    vector<int> temp;
    for (int i = 0; i < n; i++)
    {
        if (arr[i] != 0)
        {
            temp.push_back(arr[i]);
        }
    }
    int nn = temp.size();
    for (int j = 0; j < nn; j++)
    {
        arr[j] = temp[j];
    }
    for (int i = nn; i < n; i++)
    {
        arr[i] = 0;
    }
    for (int k = 0; k < n; k++)
    {
        cout << arr[k];
    }
}
void move_zero_to_last_optimal(vector<int> &arr, int n) // Leetcode 283
{
    int j = 0;
    for (int i = 0; i < n; i++)
    {
        if (arr[i] != 0)
        {
            swap(arr[i], arr[j]);
            j++;
        }
    }
    for (int k = 0; k < n; k++)
    {
        cout << arr[k];
    }
}
int linear_search(vector<int> arr, int n, int k)
{
    for (int i = 0; i < n; i++)
    {
        if (arr[i] == k)
        {
            return i;
        }
    }
    return -1;
}
void union_of_array_set(vector<int> arr1, vector<int> arr2)
{
    set<int> s1(arr1.begin(), arr1.end());
    set<int> s2(arr2.begin(), arr2.end());
    vector<int> arr3;
    set<int> s3(s1.begin(), s1.end());
    s3.insert(s2.begin(), s2.end());
    arr3.assign(s3.begin(), s3.end());
    int n = arr3.size();
    for (int i = 0; i < n; i++)
    {
        cout << arr3[i] << " ";
    }
}
vector<int> union_of_array_optimal(vector<int> arr1, vector<int> arr2)
{
    int n1 = arr1.size();
    int n2 = arr2.size();
    int i = 0, j = 0;
    vector<int> unionArr;
    while (i < n1 && j < n2)
    {
        if (arr1[i] <= arr2[j])
        {
            if (unionArr.size() == 0 || unionArr.back() != arr1[i])// if we didnt use unionArr.size() == 0 bcz we will get runtime error
            {
                unionArr.push_back(arr1[i]);
            }
            i++;
        }
        else
        {
            if (unionArr.size() == 0 || unionArr.back() != arr2[j])
            {
                unionArr.push_back(arr2[j]);
            }
            j++;
        }
    }
    while (i < n1)
    {
        if (arr1[i] <= arr2[j])
        {
            if (unionArr.size() == 0 || unionArr.back() != arr1[i])
            {
                unionArr.push_back(arr1[i]);
            }
            i++;
        }
    }
    while (j < n2)
    {
        {
            if (unionArr.size() == 0 || unionArr.back() != arr2[j])
            {
                unionArr.push_back(arr2[j]);
            }
            j++;
        }
    }
    return unionArr;
}
vector<int> intersection_basic(vector<int> a, vector<int> b)
{
    int n1 = a.size();
    int n2 = b.size();
    vector<int> vision(n2,0);
    vector<int> answer;
    for (int i = 0; i < n1; i++)
    {
        for (int j = 0; j < n2; j++)
        {
            if (a[i] == b[j] && vision[j] == 0)
            {
                answer.push_back(a[i]);
                vision[j] = 1;
                break;
            }
        }
    }
    return answer;
}
vector<int> intersection_optimal(vector<int> a, vector<int> b)
{
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());
    int n1 = a.size();
    int n2 = b.size();
    int i = 0, j = 0;
    vector<int> answer;
    while (i < n1 && j < n2)
    {
        if (a[i] < b[j] )
        {
            i++;
        }
        else if (a[i] > b[j])
        {
            j++;
        }
        else
        {
            answer.push_back(a[i]); // Here we can push a[j] also
            i++;
            j++;
        }
    }
    return answer;
}
int main()
{
    // vector <int> ar;
    // int in,n;
    // cin >> n;
    // for(int i = 0 ; i < n ; i++)
    // {
    //     cin >> in;
    //     ar.push_back(in);
    // }
    // rotate_array(ar ,nn);

    // int d = 1;
    // rotate_d_places(ar , nn , d);
    // rotate_d_places_optimal(ar, nn, d);

    // move_zero_to_last_basic(ar , n);
    // move_zero_to_last_optimal(ar,n);

    // cout << linear_search(ar , n , 4);

    vector<int> ar1{1,2,4,6,7};
    vector<int> ar2{0,2,33,4,5,6,54};
    vector<int> r = intersection_basic(ar1, ar2);
    for(int x : r)
    {
        cout << x << " ";
    }
    // union_of_array_set(ar1, ar2);
    return 0;
}