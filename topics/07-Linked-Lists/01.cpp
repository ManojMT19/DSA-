#include <bits/stdc++.h>
using namespace std;
class node
{
    public:
    int data;
    node *next;

    node(int data1 , node* next1)
    {
        data = data1;
        next = next1;
    }

    node(int data1)
    {
        data = data1;
        next = nullptr;
    }
};
node* ARR_to_LL(vector<int> &arr)
{
    node*head = new node(arr[0]);
    node*mover = head;
    for(int i = 1 ; i < arr.size() ; i++)
    {
        node*temp = new node(arr[i]);
        mover->next = temp; 
        mover = temp;
    }
    return  head;
}
void traversal(node* head)
{
    node*temp = head;
    while (temp)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }
}
int find_length(node* head)
{
    int len = 0;
    node*temp = head;
    while (temp)
    {
        len++;
        temp = temp->next;
    }
    return  len;
    
}
bool search_value(node* head , int  value)
{
    node*temp = head;
    while (temp)
    {
        if (temp->data == value)
        {
            return true;
        }
        temp = temp->next;
    }
    return false;
}
int main()
{
    
    vector<int>arr1{10,20,30,40};

    node *y = new node(arr1[0] , nullptr); //Observe the diff
    // cout << y->data;

    node y1 = node(arr1[0] , nullptr);  //Observe the diff
    // cout << y1.data;

    node*head = ARR_to_LL(arr1);
    // cout << head->data;

    // traversal(head);

    // cout << endl << "Length : " << find_length(head);

    cout << search_value(head , 30);


    return 0;
}