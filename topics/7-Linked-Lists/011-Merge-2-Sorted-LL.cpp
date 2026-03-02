#include <bits/stdc++.h>
using namespace std;
struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode *ARR_to_LL(vector<int> &arr)
{
    if (arr.empty())
        return nullptr;

    ListNode *head = new ListNode(arr[0]);
    ListNode *mover = head;
    for (int i = 1; i < arr.size(); i++)
    {
        ListNode *temp = new ListNode(arr[i]);
        mover->next = temp;
        mover = temp;
    }
    return head;
}
void display(ListNode *head)
{
    if (head == nullptr)
        return;
    ListNode *temp = head;
    while (temp)
    {
        cout << temp->val << " ";
        temp = temp->next;
    }
    cout << endl;
}
ListNode*Merge_two_sorted_brute(ListNode*head1, ListNode*head2) // Leetcode 21
{
    ListNode*t1 = head1;
    ListNode*t2 = head2;
    vector<int>arr;
    while (t1)
    {
        arr.push_back(t1->val);
        t1 = t1->next;
    }
    while (t2)
    {
        arr.push_back(t2->val);
        t2 = t2->next;
    }
    sort(arr.begin() , arr.end());
    ListNode*head = ARR_to_LL(arr);
    return head;
}
ListNode*Merge_two_sorted_optimal(ListNode*head1, ListNode*head2) // Leetcode 21
{
    ListNode*t1 = head1;
    ListNode*t2 = head2;

    ListNode*dummy = new ListNode(-1);
    ListNode*temp = dummy;
    ListNode*tempHead = temp;
    while (t1 && t2)
    {
        if(t1->val < t2->val)
        {
            temp->next = t1;
            temp = t1;
            t1 = t1->next;
        }
        else
        {
            temp->next = t2;
            temp = t2;
            t2 = t2->next;
        }
    }
    if(t1)
    {
        temp->next = t1;
    }
    if(t2)
    {
        temp->next = t2;
    }
    return tempHead->next;
    // return dummy->next;  // we can returnn this also
    //TC = O(n1 + n2)
    //SC = O(1)
}
int main()
{
    vector<int>arr1 = {1,2,3,7,8,12,20};    
    vector<int>arr2 = {0,1,3,6,12,22,45,100};
    ListNode*head1 = ARR_to_LL(arr1);    
    ListNode*head2 = ARR_to_LL(arr2);
    
    // ListNode*final = Merge_two_sorted_brute(head1 , head2);
    ListNode*final = Merge_two_sorted_optimal(head1 , head2);
    display(final);

    return 0;
}