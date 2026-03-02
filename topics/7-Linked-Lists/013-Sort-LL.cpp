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
ListNode *sortList_brute(ListNode *head) //Leetcode 148
{
    vector<int>arr;
    ListNode*temp = head;
    while(temp)
    {
        arr.push_back(temp->val);
        temp = temp->next;
    }
    sort(arr.begin() , arr.end());
    temp = head;
    int i = 0;
    while (temp)
    {
        temp->val = arr[i++];
        temp = temp->next;
    }
    return head;
    //TC = O(N + N + N log N)
    //SC = O(N)
}

ListNode *middleNode_optimal(ListNode *head)
{
    if (head == nullptr)
        return nullptr;

    ListNode *slow = head;
    ListNode *fast = head->next; // here we modified bcz we want exactly half in case of even length

    while (fast != nullptr && fast->next != nullptr)
    {
        slow = slow->next;
        fast = fast->next->next;
    }
    return slow;
}

ListNode*Merge_two_sorted_optimal(ListNode*head1, ListNode*head2)
{
    ListNode*t1 = head1;
    ListNode*t2 = head2;

    ListNode*dummy = new ListNode(-1);
    ListNode*temp = dummy;
    ListNode*tempHead = temp;
    while (t1 && t2)
    {
        if(t1->val < t2->val)
        {
            temp->next = t1;
            temp = t1;
            t1 = t1->next;
        }
        else
        {
            temp->next = t2;
            temp = t2;
            t2 = t2->next;
        }
    }
    if(t1)
    {
        temp->next = t1;
    }
    if(t2)
    {
        temp->next = t2;
    }
    return tempHead->next;
    // return dummy->next;  // we can returnn this also
    //TC = O(n1 + n2)
    //SC = O(1)
}
ListNode *sortList_optimal(ListNode *head) //Leetcode 148
{
    if(head == nullptr || head->next == nullptr)
    return head;

    ListNode*middle = middleNode_optimal(head); // modified go n check it
    ListNode*left = head;
    ListNode*right = middle->next;
    middle->next = nullptr;

    left = sortList_optimal(left);
    right = sortList_optimal(right);

    return Merge_two_sorted_optimal(left , right);
}
int main()
{
    vector<int>ex = {4,2,1,3,-1,8,0};
    ListNode*head = ARR_to_LL(ex);
    head = sortList_brute(head);
    display(head);

    return 0;
}