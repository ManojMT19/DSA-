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
ListNode *removeNthFromEnd_brute(ListNode *head, int n)
{
    if (head == nullptr || head->next == nullptr)
        return nullptr;

    ListNode *temp = head;
    int count = 0;
    while (temp)
    {
        count++;
        temp = temp->next;
    }
    int nth = count - n + 1;
    if (nth == 1)
    {
        delete head;
        return nullptr;
    }
    temp = head;
    ListNode *prev = nullptr;
    count = 0;
    while (temp)
    {
        count++;
        if (count == nth)
        {
            prev->next = prev->next->next;
            delete temp;
            break;
        }
        prev = temp;
        temp = temp->next;
    }
    return head;
    // TC = O(2N)
    // SC = O(N)
}
ListNode *removeNthFromEnd_Optimal(ListNode *head, int n)
{
    ListNode *fast = head;
    ListNode *slow = head;
    for (int i = 1; i <= n; i++)
    {
        fast = fast->next;
    }
    if (fast == nullptr)
        return head->next;
    while (fast->next != nullptr)
    {
        slow = slow->next;
        fast = fast->next;
    }
    ListNode *del = slow->next;
    slow->next = slow->next->next;
    delete (del);
    return head;
    // TC = O(N)
    // SC = O(1)
}
int main()
{
    vector<int> arr = {1, 2, 3, 4, 5};
    int n = 2;

    ListNode *head = ARR_to_LL(arr);
    // head = removeNthFromEnd_Optimal(head , n);
    head = removeNthFromEnd_brute(head, n);
    display(head);

    return 0;
}