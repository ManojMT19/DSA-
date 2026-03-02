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
ListNode *deleteMiddle_brute(ListNode *head) //Leetcode 2095
{
    int count = 0;
    ListNode*temp = head;
    while (temp)
    {
        count++;
        temp = temp->next;
    }
    int n = count / 2 ;
    temp = head;
    ListNode*prev = nullptr;
    while (temp)
    {
        n--;
        if(n < 0)
        {
            prev->next = prev->next->next;
            delete(temp);
            break;
        }
        prev = temp;
        temp = temp->next;
    }
    return head;
}
ListNode *deleteMiddle_Optimal(ListNode *head)
{
    if (!head || !head->next)return nullptr;
    
    ListNode *slow = head;
    ListNode *fast = head;
    ListNode *prev = nullptr;
    while (fast && fast->next)
    {
        prev = slow;
        slow = slow->next;
        fast = fast->next->next;
    }
    prev->next = slow->next;
    delete slow;
    
    return head;
}
ListNode *deleteMiddle_Optimal_2(ListNode *head)
{
    if (!head || !head->next)return nullptr;
    ListNode*slow = head;
    ListNode*fast = head;
    fast = fast->next->next;
    while (fast && fast->next)
    {
        slow = slow->next;
        fast = fast->next->next;
    }
    slow->next = slow->next->next;
    return head;
}

int main()
{
    vector<int>arr = {1,3,4,7,1,2,6};
    // vector<int>arr = {2,1};
    ListNode*head = ARR_to_LL(arr);
    // head = deleteMiddle_brute(head);
    head = deleteMiddle_Optimal_2(head);
    display(head);


    return 0;
}