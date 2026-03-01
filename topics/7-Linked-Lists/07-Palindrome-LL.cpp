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

bool isPalindrome(ListNode *head) // Leetcode 234
{
    vector<int> t1;
    ListNode *t2 = head;
    while (t2)
    {
        t1.push_back(t2->val);
        t2 = t2->next;
    }
    int n = t1.size() - 1;
    for (int i = 0; i < t1.size() / 2; i++)
    {
        if (t1[i] != t1[n - i])
        {
            return false;
        }
    }
    return true;
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
bool isPalindrome(ListNode *head)
{
    if (head == nullptr || head->next == nullptr)
        return true;
    ListNode *slow = head;
    ListNode *fast = head;
    while (fast->next != nullptr && fast->next->next != nullptr)
    {
        slow = slow->next;
        fast = fast->next->next;
    }
    ListNode *newHead = reverseList_Iterative(slow->next);
    ListNode *first = head;
    ListNode *second = newHead;
    while (second != nullptr)
    {
        if (first->val != second->val)
        {
            reverseList_Iterative(newHead);
            return false;
        }
        first = first->next;
        second = second->next;
    }
    return true;
}
int main()
{

    return 0;
}