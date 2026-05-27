package topics.9-Stack-Queue;

import java.util.*;

class Stack_Array
{
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor
    public Stack(int size)
    {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    // Push operation
    public void push(int value)
    {
        if (top == maxSize - 1)
        {
            System.out.println("Stack Overflow");
        } else
        {
            stackArray[++top] = value;
            System.out.println(value + " pushed into stack");
        }
    }

    // Pop operation
    public int pop()
    {
        if (top == -1)
        {
            System.out.println("Stack Underflow");
            return -1;
        } else
        {
            return stackArray[top--];
        }
    }

    // Peek operation
    public int peek()
    {
        if (top == -1)
        {
            System.out.println("Stack is empty");
            return -1;
        } else
        {
            return stackArray[top];
        }
    }

    // Check if stack is empty
    public boolean isEmpty()
    {
        return top == -1;
    }

    // Display stack
    public void display()
    {
        if (top == -1)
        {
            System.out.println("Stack is empty");
        } else
        {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--)
            {
                System.out.println(stackArray[i]);
            }
        }
    }
}

class Queue_Array
{
    int[] arr;
    int front, rear, currentSize, maxSize;

    // Constructor
    Queue(int maxSize)
    {
        this.maxSize = maxSize;
        arr = new int[maxSize];

        front = -1;
        rear = -1;
        currentSize = 0;
    }

    // Insert element
    void push(int value)
    {

        if (currentSize == maxSize)
        {
            System.out.println("Queue Overflow");
            return;
        }

        // First element
        if (front == -1)
        {
            front = 0;
        }

        rear = (rear + 1) % maxSize;
        arr[rear] = value;

        currentSize++;

        System.out.println(value + " inserted");
    }

    // Delete element
    int pop()
    {

        if (currentSize == 0)
        {
            System.out.println("Queue Underflow");
            return -1;
        }

        int value = arr[front];

        // If only one element
        if (front == rear)
        {
            front = -1;
            rear = -1;
        } else
        {
            front = (front + 1) % maxSize;
        }

        currentSize--;

        return value;
    }

    // Peek front element
    int peek()
    {

        if (currentSize == 0)
        {
            System.out.println("Queue is empty");
            return -1;
        }

        return arr[front];
    }

    // Display queue
    void display()
    {

        if (currentSize == 0)
        {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Queue elements:");

        for (int i = 0; i < currentSize; i++)
        {
            System.out.println(arr[(front + i) % maxSize]);
        }
    }
}

class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class Stack_LL
{
    Node top;

    // Push operation
    void push(int value)
    {
        Node newNode = new Node(value);

        newNode.next = top;
        top = newNode;

        System.out.println(value + " pushed");
    }

    // Pop operation
    int pop()
    {
        if (top == null)
        {
            System.out.println("Stack Underflow");
            return -1;
        }

        int value = top.data;
        top = top.next;

        return value;
    }

    // Peek operation
    int peek()
    {

        if (top == null)
        {
            System.out.println("Stack is empty");
            return -1;
        }

        return top.data;
    }

    // Display stack
    void display()
    {

        if (top == null)
        {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Stack elements:");

        Node temp = top;

        while (temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

class Queue_LL
{
    Node front, rear;

    void push(int value)
    {
        Node newnode = new Node(value);

        if (front == null && rear == null)
        {
            front = rear = newnode;
        } else
        {
            rear.next = newnode;
            rear = newnode;
        }
        System.out.println(value + " Inserted");
    }

    int pop()
    {
        if (front == null)
        {
            System.out.println("Queue underflow");
            return -1;
        }

        int value = front.data;

        if (front == rear)
        {
            front = rear = null;
        } else
        {
            front = front.next;
        }
        return value;
    }

    int peek()
    {
        if (front != null)
        {
            return front.data;
        }
        return -1;
    }

    void display()
    {
        if (front == null)
        {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Queue elements:");

        Node temp = front;
        while (temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

class stack_using_queue
{
    Queue<Integer> q = new LinkedList<>();

    void push(int n)
    {
        int s = q.size();
        q.add(n);

        for (int i = 0; i < s; i++)
        {
            q.add(q.peek());
            q.remove();
        }
    }

    void pop()
    {
        q.remove();
    }

    void top()
    {
        return q.peek();
    }

}

class queue_using_stack_1
{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    int push(int n)
    {
        while (s1.size())
        {
            s2.push(s1.top());
            s1.pop();
        }
        s1.push(n);

        while (s2.size())
        {
            s1.push(s2.top());
            s2.pop();
        }
    }

    void pop()
    {
        s1.pop();
    }

    void top()
    {
        s1.top();
    }

}

class queue_using_stack_2
{
    Stack<Integer> s1, s2;

    void push(int n)
    {
        s1.push(n);
    }

    void pop()
    {
        if (s2.size() != 0)
        {
            s2.pop();
        } else
        {
            while (s1.size())
            {
                s2.push(s1.top());
                s1.pop();
            }
            s2.pop();
        }
    }

    int top()
    {
        if (s2.empty() != 0)
        {
            s2.pop();
        } else
        {
            while (s1.size())
            {
                s2.push(s1.top());
                s1.pop();
            }
            return s2.pop();
        }
    }

}

class MyStack
{
    Queue<Integer> q;

    public MyStack()
    {
        q = new LinkedList<>();
    }

    public void push(int x)
    {
        int s = q.size();
        q.add(x);

        for (int i = 0; i < s; i++)
        {
            int zz = q.peek();
            q.add(zz);
            q.remove();
        }
    }

    public int pop()
    {
        return q.remove();
    }

    public int top()
    {
        return q.peek();
    }

    public boolean empty()
    {
        return q.isEmpty();
    }
}

class MyQueue
{

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue()
    {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x)
    {
        while (s1.size() != 0)
        {
            s2.push(s1.peek());
            s1.pop();
        }
        s1.push(x);
        while (s2.size() != 0)
        {
            s1.push(s2.peek());
            s2.pop();
        }
    }

    public int pop()
    {
        return s1.pop();
    }

    public int peek()
    {
        return s1.peek();
    }

    public boolean empty()
    {
        return s1.isEmpty();
    }
}

public class SQ01
{

}