#include <bits/stdc++.h>
using namespace std;

// Definition for singly-linked list.
struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode *middleNode_brute(ListNode *head) // Leetcode 876
{
    if (head == nullptr)
    {
        return nullptr;
    }
    int count = 0;
    ListNode *temp = head;
    while (temp)
    {
        count++;
        temp = temp->next;
    }
    int a = (count / 2) + 1;
    temp = head;
    while (temp)
    {
        a--;
        if (a == 0)
            break;
        temp = temp->next;
    }
    ListNode *ans = temp;
    return ans;
}

ListNode *middleNode_optimal(ListNode *head)
{
    if (head == nullptr)
        return nullptr;

    ListNode *slow = head;
    ListNode *fast = head;

    while (fast != nullptr && fast->next != nullptr)
    {
        slow = slow->next;
        fast = fast->next->next;
    }
    return slow;
}



int main()
{

    return 0;
}