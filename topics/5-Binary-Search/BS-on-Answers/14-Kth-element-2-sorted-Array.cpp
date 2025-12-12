#include<bits/stdc++.h>
using namespace std;
int kthElement_brute(vector<int> &A, vector<int> &B, int k) 
{
    vector<int> merged;
    int i = 0, j = 0;

    while(i < A.size() && j < B.size()) 
    {
        if(A[i] < B[j]) merged.push_back(A[i++]);
        else merged.push_back(B[j++]);
    }

    while(i < A.size()) 
        merged.push_back(A[i++]);

    while(j < B.size()) 
        merged.push_back(B[j++]);

    return merged[k - 1];
    // TC = O(m+n)
}
int kthElement(vector<int> &A, vector<int> &B, int k) 
{
    int i = 0, j = 0;
    int count = 0;
    int ans = -1;

    while(i < A.size() && j < B.size()) 
    {
        if(A[i] < B[j]) {
            ans = A[i++];
        } else {
            ans = B[j++];
        }
        count++;
        if(count == k) return ans;
    }
    while(i < A.size()) 
    {
        ans = A[i++];
        count++;
        if(count == k) return ans;
    }
    while(j < B.size()) 
    {
        ans = B[j++];
        count++;
        if(count == k) return ans;
    }

    return ans;
    //TC = O(k)
}

//their is one more binary search by partition approach similar to median of 2 sorted arrays i didnt types here bcz i didnt understood

int main()
{
    vector<int>a{2,3,6,7,9};
    vector<int>b{1,4,8,10};
    cout << kthElement_brute(a , b ,5);

    return 0;
}