#include <bits/stdc++.h>
using namespace std;
class ListNode
{
public:
    int data;
    ListNode *next;
    ListNode *prev;

    ListNode(int data1, ListNode *next1, ListNode *prev1)
    {
        data = data1;
        next = next1;
        prev = prev1;
    }

    ListNode(int data1)
    {
        data = data1;
        next = nullptr;
        prev = nullptr;
    }
};

ListNode *Arr_to_DLL(vector<int> arr)
{
    ListNode *head = new ListNode(arr[0]);
    ListNode *prev = head;

    for (int i = 1; i < arr.size(); i++)
    {
        ListNode *temp = new ListNode(arr[i], nullptr, prev);
        prev->next = temp;
        prev = prev->next;
    }
    return head;
}

void display(ListNode *head)
{
    ListNode *temp = head;
    while (temp)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;
}

//------------------------------------ DELETE-----------------------------------

ListNode *delete_head_DLL(ListNode *head)
{
    if (head == nullptr || head->next == nullptr)
        return nullptr;

    ListNode *del = head;
    head = head->next;
    del->next = nullptr;
    head->prev = nullptr;
    delete (del);

    return head;
}

ListNode *delete_last_DLL(ListNode *head)
{
    if (head == nullptr || head->next == nullptr)
        return nullptr;

    ListNode *temp = head;
    while (temp->next->next)
    {
        temp = temp->next;
    }
    ListNode *del = temp->next;
    temp->next = nullptr;
    del->prev = nullptr;
    delete (del);

    return head;
}

ListNode *delete_kth(ListNode *head, int k)
{
    ListNode *temp = head;
    int count = 0;
    while (temp)
    {
        count++;
        if (count == k)
            break;
        temp = temp->next;
    }
    ListNode *back = temp->prev;
    ListNode *front = temp->next;

    back->next = front;
    front->prev = back;
    delete (temp);

    return head;
}

ListNode *delete_kth_DLL(ListNode *head, int k)
{
    if (head == nullptr)
        return head;
    ListNode *temp = head;

    int count = 0;
    while (temp)
    {
        count++;
        if (count == k)
            break;
        temp = temp->next;
    }

    if (temp == nullptr)
        return head;

    if (temp == head)
    {
        head = head->next;
        if (head)
            head->prev = NULL;
        delete temp;
        return head;
    }

    ListNode *back = temp->prev;
    ListNode *front = temp->next;

    back->next = front;

    if (front)
        front->prev = back;

    delete temp;

    return head;
}

void delete_node(ListNode *node)
{
    ListNode *prev = node->prev;
    ListNode *front = node->next;

    if (front == nullptr)
    {
        prev->next = nullptr;
        node->next = nullptr;
        delete (node);
        return;
    }
    prev->next = front;
    front->prev = prev;

    node->next = node->prev = nullptr;
    delete (node);
}

//---------------------------------------INSERT--------------------------------------------------------

ListNode *insert_before_head(ListNode *head, int data)
{
    ListNode *temp = new ListNode(data, head, nullptr);

    if (head != nullptr)
        head->prev = temp;

    return temp;
}

ListNode *insert_before_tail(ListNode *head, int data)
{
    if (head->next == nullptr)
    {
        ListNode *temp = new ListNode(data, head, nullptr);
        if (head != nullptr)
            head->prev = temp;

        return temp;
    }
    ListNode *temp = head;
    while (temp->next)
    {
        temp = temp->next;
    }
    ListNode *back = temp->prev;
    ListNode *newNode = new ListNode(data, temp, back);

    back->next = newNode;
    temp->prev = newNode;

    return head;
}
ListNode *insert_last(ListNode *head, int data)
{
    ListNode *newNode = new ListNode(data, nullptr, nullptr);

    if (head == nullptr)
        return newNode;

    ListNode *temp = head;
    while (temp->next)
    {
        temp = temp->next;
    }

    temp->next = newNode;
    newNode->prev = temp;

    return head;
}

ListNode *insert_kth_node(ListNode *head, int data, int k)
{
    if (k == 1)
    {
        ListNode *newNode = new ListNode(data, head, nullptr);
        if (head)
            head->prev = newNode;
        return newNode;
    }

    if (head == nullptr)
        return head;

    ListNode *temp = head;
    int count = 0;

    while (temp)
    {
        count++;
        if (count == k - 1)
            break;
        temp = temp->next;
    }

    if (temp == nullptr)
        return head;

    ListNode *newNode = new ListNode(data, temp->next, temp);

    if (temp->next)
        temp->next->prev = newNode;

    temp->next = newNode;

    return head;
}

// -----------------------------------------REVERSE--------------------------------------

ListNode *REVERSE_DLL_brute(ListNode *head)
{
    vector<int> arr;
    ListNode *temp = head;
    while (temp)
    {
        arr.push_back(temp->data);
        temp = temp->next;
    }
    reverse(arr.begin(), arr.end());
    
    temp = head;
    int i = 0;
    while (temp)
    {
        temp->data = arr[i++];
        temp = temp->next;
    }
    return head;
}
ListNode *REVERSE_DLL_Optimal(ListNode *head)
{
    if(head == nullptr || head->next == nullptr)
        return head;

    ListNode *temp = head;
    ListNode*last = nullptr;
    while (temp)
    {
        last = temp->prev;
        temp->prev = temp->next;
        temp->next = last;

        temp = temp->prev;
    }
    return last->prev;

}
int main()
{
    vector<int> arr = {1, 2, 3, 4, 5, 6};
    ListNode *head = Arr_to_DLL(arr);
    display(head);

    // head = delete_head_DLL(head);
    // display(head);

    // head = delete_last_DLL(head);
    // display(head);

    // head = delete_kth_DLL(head , 3);
    // display(head);

    // delete_node(head->next->next);
    // display(head);

    // head = insert_before_head(head, 10);
    // display(head);

    // head = insert_before_tail(head , 10);
    // display(head);

    // head = insert_last(head, 10);
    // display(head);

    // head = insert_kth_node(head, 10, 3);
    // display(head);

    head = REVERSE_DLL_Optimal(head);
    display(head);

    return 0;
}