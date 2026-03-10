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
ListNode *getIntersectionNode_Nested_loop(ListNode *headA, ListNode *headB) // Leetcode 160
{
    ListNode *t1 = headA;
    ListNode *ans = nullptr;
    int stop = 0;
    while (t1)
    {
        ListNode *t2 = headB;
        while (t2)
        {
            if (t1 == t2)
            {
                ans = t1;
                stop = 1;
                break;
            }
            t2 = t2->next;
        }
        if (stop)
            break;
        t1 = t1->next;
    }
    return ans;
}
ListNode *getIntersectionNode_Hashing(ListNode *headA, ListNode *headB)
{
    map<ListNode *, int> mppp;
    ListNode *t1 = headA;
    ListNode *t2 = headB;
    while (t1)
    {
        mppp[t1] = 1;
        t1 = t1->next;
    }
    while (t2)
    {
        if (mppp.find(t2) != mppp.end())
        {
            return t2;
        }
        t2 = t2->next;
    }
    return nullptr;
}
ListNode *getIntersectionNode_optimal(ListNode *headA, ListNode *headB) // Leetcode 160
{
    if (headA == nullptr || headB == nullptr)
        return nullptr;

    ListNode *t1 = headA;
    ListNode *t2 = headB;

    while (t1 != t2)
    {
        if (t1 == nullptr)
            t1 = headB;
        else
            t1 = t1->next;

        
        if (t2 == nullptr)
            t2 = headA;
        else
            t2 = t2->next;
    }

    return t1; // intersection node OR nullptr 
    // TC = O(n1 + n2)
    // SC = O(1)
}
int main()
{

    return 0;
}