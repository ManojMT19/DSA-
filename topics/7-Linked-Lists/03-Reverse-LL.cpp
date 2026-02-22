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
    

    return 0;
}