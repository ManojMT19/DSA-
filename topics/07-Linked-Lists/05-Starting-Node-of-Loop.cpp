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

ListNode *detectCycle_brute(ListNode *head) // Leetcode 142
{
    map<ListNode* , int>mpp;
    ListNode*temp = head;
    while (temp)
    {
        if(mpp.find(temp) != mpp.end())
        {
            return temp;
        }
        mpp[temp] = 1;
        temp = temp->next;
    }
    return nullptr;
}
ListNode *detectCycle_optimal(ListNode *head) // Leetcode 142
{
    ListNode *slow = head;
    ListNode *fast = head;
    while (fast != nullptr && fast->next != nullptr)
    {
        slow = slow->next;
        fast = fast->next->next;
        if (fast == slow)
        {
            slow = head;
            while (slow != fast)
            {
                slow = slow->next;
                fast = fast->next;
            }
            return fast;
        }
    }
    return nullptr;
}
int main()
{

    return 0;
}