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

bool hasCycle(ListNode *head) // Leetcode 141
{
    map<ListNode*, int >mpp;
    ListNode *temp = head;
    while (temp)
    {   
        if(mpp.find(temp) != mpp.end())
        {   
            return true;
        }
        mpp[temp] = 1;
        temp = temp->next;
    }
    return false;
}

bool hasCycle(ListNode *head)
{
    ListNode*slow = head;
    ListNode*fast = head;
    while (fast != nullptr && fast->next != nullptr)
    {
        slow = slow->next;
        fast = fast->next->next;
        if(fast == slow)
            return true;
    }
    return false;
}


int main()
{


    return 0;
}