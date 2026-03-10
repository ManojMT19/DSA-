#include <bits/stdc++.h>
using namespace std;

//  * Definition for singly-linked list.
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

ListNode *removeElements(ListNode *head, int val) // Leetcode 203
{
    if (head == nullptr)
    {
        return nullptr;
    }
    if (head->val == val)
    {
        ListNode *temp = head;
        head = head->next;
        delete temp;
        return removeElements(head, val);
    }
    ListNode *temp = head;
    ListNode *prev = nullptr;
    while (temp)
    {
        if (temp->val == val)
        {
            prev->next = temp->next;
            delete temp;
            return removeElements(head, val);
            break;
        }
        prev = temp;
        temp = temp->next;
    }
    return head;
}

ListNode *reverseList_Brute(ListNode *head) // Leetcode 206
{
    ListNode *t1 = head;
    ListNode *t2;
    vector<int> x;
    while (t1)
    {
        x.push_back(t1->val);
        t1 = t1->next;
    }
    t1 = head;
    for (int i = x.size() - 1; i >= 0; i--)
    {
        t1->val = x[i];
        if (i == x.size() - 1)
        {
            head = t1;
        }
        t1 = t1->next;
    }
    return head;
}

ListNode *reverseList_Iterative(ListNode *head)
{
    ListNode *t1 = head;
    ListNode *prev = nullptr;
    ListNode *front = t1;
    while (t1)
    {
        front = t1->next;
        t1->next = prev;
        prev = t1;
        t1 = front;
    }
    head = prev;
    return head;
}

ListNode *reverseList_Recursion(ListNode *head)
{
    if(head == nullptr || head->next == nullptr)
    {
        return head;
    }
    ListNode*NewNode = reverseList_Recursion(head->next);
    ListNode*front = head->next;
    front->next = head;
    head->next = nullptr;

    return NewNode;
}
int main()
{
    // vector<int> arr{1, 2, 3, 4, 5, 6};
    vector<int> arr{1, 2, 3, 4, 5};
    ListNode *head = ARR_to_LL(arr);

    // head = removeElements(head, 6);
    head = reverseList_Iterative(head);
    display(head);

    return 0;
}