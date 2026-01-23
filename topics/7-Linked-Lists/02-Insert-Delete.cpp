#include <bits/stdc++.h>
using namespace std;
class node
{
public:
    int data;
    node *next;

    node(int data1)
    {
        data = data1;
        next = nullptr;
    }

    node(int data1, node *next1)
    {
        data = data1;
        next = next1;
    }
};
node *ARR_to_LL(vector<int> &arr)
{
    if (arr.empty())
        return nullptr;

    node *head = new node(arr[0]);
    node *mover = head;
    for (int i = 1; i < arr.size(); i++)
    {
        node *temp = new node(arr[i]);
        mover->next = temp;
        mover = temp;
    }
    return head;
}
//-----------------------------------------------REMOVE------------------------------------------------------------
node *remove_head(node *head)
{
    if (head == nullptr)
        return head;

    node *temp = head;
    head = head->next;
    delete temp;
    return head;
}
node *remove_last(node *head)
{
    if (head == nullptr)
        return nullptr;
    if (head->next == nullptr)
    {
        delete head;
        return nullptr;
    }

    node *temp = head;
    while (temp->next->next != nullptr)
    {
        temp = temp->next;
    }
    delete temp->next;
    temp->next = nullptr;
    return head;
}
void display(node *head)
{
    if (head == nullptr)
        return;
    node *temp = head;
    while (temp)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;
}
node *remove_kth(node *head, int k)
{
    if (head == nullptr)
        return nullptr;
    if (head->next == nullptr)
    {
        delete head;
        return nullptr;
    }
    if (k == 1)
    {
        node *temp = head;
        head = head->next;
        delete temp;
        return head;
    }
    node *temp = head;
    node *prev = nullptr;
    int count = 0;
    while (temp)
    {
        count++;
        if (count == k)
        {
            prev->next = prev->next->next;
            delete temp;
            break;
        }
        prev = temp;
        temp = temp->next;
    }
    return head;
}
node *remove_element(node *head, int ele)
{
    if (head == nullptr)
        return nullptr;
    if (head->next == nullptr)
    {
        delete head;
        return nullptr;
    }
    if (head->data == ele)
    {
        node *temp = head;
        head = head->next;
        delete temp;
        return head;
    }
    node *temp = head;
    node *prev = nullptr;
    while (temp)
    {
        if (temp->data == ele)
        {
            prev->next = prev->next->next;
            delete temp;
            break;
        }
        prev = temp;
        temp = temp->next;
    }
    return head;
}
//-----------------------------------------------INSERT-------------------------------------------------------------
node *insert_front(node *head, int ele)
{
    node *temp = new node(ele, head);
    return temp;
}
node *insert_last(node *head, int ele)
{
    if (head == nullptr)
    {
        return new node(ele);
    }
    node *temp = new node(ele);
    node *mover = head;
    while (mover->next != nullptr)
    {
        mover = mover->next;
    }
    mover->next = temp;
    return head;
}
node *insert_kth(node *head, int k, int ele) // logic is corect but so many memory leaks happen
{
    if (head == nullptr)
    {
        if (k == 1)
        {
            return new node(ele, head);
        }
        else
        {
            return nullptr;
        }
    }
    if (k == 1)
    {
        return new node(ele, head);
    }
    node *temp = head;
    node *mover = new node(ele);
    node *prev = nullptr;
    int cnt = 0;
    while (temp)
    {
        cnt++;
        if (cnt == k)
        {
            prev->next = mover;
            mover->next = temp;
            break;
        }
        prev = temp;
        temp = temp->next;
    }
    return head;
}
node *insert_kth_chatgpt(node *head, int k, int ele)
{
    if (k <= 0)
        return head; // invalid position
    if (head == nullptr)
    {
        if (k == 1)
        {
            return new node(ele, head);
        }
        else
        {
            return nullptr;
        }
    }
    if (k == 1)
        return new node(ele, head);

    node *temp = head;
    int cnt = 0;
 
    while (temp != nullptr)
    {
        cnt++;
        if(cnt == k-1)
        {
            node* n = new node(ele,temp->next);
            temp->next = n;
            break;
        }
        temp = temp->next;
    }
    return head;
}
node *insert_before_value(node *head, int before_value, int ele)
{
    if (head == nullptr)
    {
        return nullptr; 
    }
    if (head->data == before_value)
        return new node(ele, head);

    node *temp = head;
 
    while (temp)
    {
        if(temp->next->data == before_value)
        {
            node* n = new node(ele,temp->next);
            temp->next = n;
            break;
        }
        temp = temp->next;
    }
    return head;
}
int main()
{
    vector<int> arr{10, 20, 30, 40, 50, 60, 70};

    node *head = ARR_to_LL(arr);
    // cout << head->data;  // Prints 10

    // head = remove_head(head);
    // cout << head->data;

    // head = remove_last(head);

    // display(head);

    // head = remove_last(head);

    // display(head);

    // head = remove_kth(head , 3);
    // display(head);

    // head = remove_element(head , 40);
    // display(head);

    // head = insert_front(head , 100);
    // head = insert_last(head , 200);
    // head = insert_kth_chatgpt(head, 5, 500);

    head = insert_before_value(head, 70, 500);
    display(head);

    return 0;
}