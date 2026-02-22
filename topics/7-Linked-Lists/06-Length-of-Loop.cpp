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

int Loop_Length(ListNode *head)// Leetcode 141
{
    map<ListNode*, int >mpp;
    ListNode *temp = head;
    int timer = 1;
    while (temp)
    {
        if(mpp.find(temp) != mpp.end())
        {
            return timer - mpp[temp]; 
        }
        mpp[temp] = timer++; 
        temp = temp->next;
    }
    return 0;
}
int Loop_Length(ListNode *head)
{
    ListNode*slow = head;
    ListNode*fast = head;
    int count = 1;
    while (fast != nullptr && fast->next != nullptr)
    {
        slow = slow->next;
        fast = fast->next->next;
        if(slow == fast)
        {
            fast = fast->next;
            while (fast != slow)
            {
                count++;
                fast = fast->next;
            }
            return count;
        }
    }
    return 0;
}
int main()
{


    return 0;
}