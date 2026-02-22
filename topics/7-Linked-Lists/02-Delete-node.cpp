#include <bits/stdc++.h>
using namespace std;

// Definition for singly-linked list.
struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

void deleteNode(ListNode *node)
{
    ListNode *temp = node->next;
    node->val = temp->val;
    node->next = temp->next;
}

// we this we r not deleting the node we just Copying next node’s value into current node and Skipping the next node

int main()
{
    vector<int>a {4,5,1,9};

    return 0;
}