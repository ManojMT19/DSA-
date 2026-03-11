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

ListNode *Add_1_to_LL(ListNode *head)
{
    head = reverseList_Iterative(head);
    ListNode *temp = head;
    int carry = 1;
    while (temp)
    {
        temp->val += carry;
        if (temp->val < 10)
        {
            carry = 0;
            break;
        }
        else
        {
            temp->val = 0;
            carry = 1;
        }
        temp = temp->next;
    }
    if (carry)
    {
        ListNode *node = new ListNode(1);
        head = reverseList_Iterative(head);
        node->next = head;
        return node;
    }
    
    head = reverseList_Iterative(head);
    return head;
    
    //TC = O(3N)
    //SC = O(1)
}

int helper(ListNode*temp)
{
    if(temp == nullptr)
    {
        return 1;
    }
    int carry = helper(temp->next);
    temp->val += carry;
    if(temp->val < 10)
    {
        return 0;
    }
    temp->val = 0;
    return 1;
}
ListNode *Add_1_to_LL_recursion(ListNode *head)
{
    ListNode*temp = head;
    int carry = helper(temp);
    if(carry == 1)
    {
        ListNode*newNode = new ListNode(1);
        newNode->next = head;
        head = newNode;
    }
    return head;
    //TC = O(N)
    //SC = O(N)
}

ListNode* Add_1_to_LL_Chatgpt(ListNode* head) // This is easy to understand
{
    ListNode* lastNot9 = nullptr;
    ListNode* temp = head;

    // find rightmost non-9
    while(temp)
    {
        if(temp->val != 9)
            lastNot9 = temp;

        temp = temp->next;
    }

    // all digits are 9
    if(lastNot9 == nullptr)
    {
        ListNode* newHead = new ListNode(1);
        newHead->next = head;

        temp = head;
        while(temp)
        {
            temp->val = 0;
            temp = temp->next;
        }

        return newHead;
    }

    // increment last non-9
    lastNot9->val++;

    temp = lastNot9->next;

    while(temp)
    {
        temp->val = 0;
        temp = temp->next;
    }

    return head;
    //TC = O(N)
    //SC = O(1)
}
int main()
{
    

    return 0;
}