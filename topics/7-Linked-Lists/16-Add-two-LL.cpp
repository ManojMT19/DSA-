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

ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
{
    ListNode *t1 = l1;
    ListNode *t2 = l2;

    int carry = 0;

    ListNode *dummy = new ListNode(-1);
    ListNode *temp = dummy;
    while (t1 || t2 || carry)
    {
        int sum = 0;
        if (t1)
        {
            sum += t1->val;
            t1 = t1->next;
        }

        if (t2)
        {
            sum += t2->val;
            t2 = t2->next;
        }

        sum += carry;
        carry = sum / 10;
        ListNode *newNode = new ListNode(sum % 10);
        temp->next = newNode;
        temp = temp->next;
    }
    return dummy->next;
    
    // Time  : O(max(n1, n2))
    // Space : O(max(n1, n2))   (for result list)
}
int main()
{
    // vector<int> arr1 = {2, 4, 3};
    // vector<int> arr2 = {5, 6, 4};

    vector<int> arr1 = {9,9,9};
    vector<int> arr2 = {9,9,9};

    ListNode *l1 = ARR_to_LL(arr1);
    ListNode *l2 = ARR_to_LL(arr2);

    ListNode *head = addTwoNumbers(l1, l2);
    display(head);

    return 0;
}