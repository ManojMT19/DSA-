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
ListNode *sort_zero_one_two_brute(ListNode *head)
{
    int c0 = 0;
    int c1 = 0;
    int c2 = 0;
    ListNode *temp = head;
    while (temp)
    {
        if (temp->val == 0)
            c0++;
        else if (temp->val == 1)
            c1++;
        else
            c2++;

        temp = temp->next;
    }
    temp = head;
    while (temp)
    {
        if (c0 != 0)
        {
            temp->val = 0;
            c0--;
        }
        else if (c1 != 0)
        {
            temp->val = 1;
            c1--;
        }
        else
        {
            temp->val = 2;
            c2--;
        }
        temp = temp->next;
    }
    return head;
}
ListNode *sort_zero_one_two_optimal(ListNode *head)
{
    ListNode *temp = head;

    // Here we created a dummy node all these and having value -1 and its next pointer points to nullptr
    ListNode *zerohead = new ListNode(-1);
    ListNode *onehead = new ListNode(-1);
    ListNode *twohead = new ListNode(-1);

    ListNode *zero = zerohead;
    ListNode *one = onehead;
    ListNode *two = twohead;
    while (temp)
    {
        if (temp->val == 0)
        {
            zero->next = temp;
            zero = temp;
            temp = temp->next;
        }
        else if (temp->val == 1)
        {
            one->next = temp;
            one = temp;
            temp = temp->next;
        }
        else
        {
            two->next = temp;
            two = temp;
            temp = temp->next;
        } 
    }
    zero->next = (onehead->next) ? onehead->next : twohead->next;
    one->next = (twohead->next) ? twohead->next : nullptr; 
    two->next = nullptr;

    ListNode *Node = zerohead->next;

    delete (zerohead);
    delete (onehead);
    delete (twohead);

    return Node;
}
int main()
{
    vector<int> arr = {1, 0, 0,  1, 0,  1, 0, 1,0, 1};
    ListNode *head = ARR_to_LL(arr);
    // head = sort_zero_one_two_brute(head);
    head = sort_zero_one_two_optimal(head);
    display(head);

    return 0;
}