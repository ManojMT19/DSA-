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

ListNode *oddEvenList_brute(ListNode *head) // Leetcode 328
{ 
    if (head == nullptr || head->next == nullptr)
        return head;

    vector<int> arr;

    ListNode *temp = head;
    while (temp)
    {
        arr.push_back(temp->val);
        if (temp->next == nullptr)
            break;
        temp = temp->next->next;
    }

    temp = head->next;
    while (temp)
    {
        arr.push_back(temp->val);
        if (temp->next == nullptr)
            break;
        temp = temp->next->next;
    }

    temp = head;
    int i = 0;
    while (temp)
    {
        temp->val = arr[i++];
        temp = temp->next;
    }

    return head;
}
ListNode *oddEvenList(ListNode *head)
{
    if (head == nullptr || head->next == nullptr)
        return head;
    ListNode *odd = head;
    ListNode *even = head->next;
    ListNode *evenHead = head->next;
    while (even != nullptr && even->next != nullptr)
    {
        odd->next = odd->next->next;
        odd = odd->next;
        even->next = even->next->next;
        even = even->next;
    }
    odd->next = evenHead;
    return head;
}
int main()
{
    vector<int> arr = {1, 2, 3, 4, 5};
    ListNode *h = ARR_to_LL(arr);
    h = oddEvenList(h);
    display(h);

    return 0;
}