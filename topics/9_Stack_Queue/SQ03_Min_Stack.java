// package topics.9_Stack_Queue;
import java.util.*;
class MinStack_Brute
{
    Stack<Integer> st;

    public MinStack_Brute()
    {
        st = new Stack<>();
    }

    public void push(int val)
    {
        st.push(val);
    }

    public void pop()
    {
        st.pop();
    }

    public int top()
    {
        return st.peek();
    }

    public int getMin()
    {
        int minn = Integer.MAX_VALUE;
        for (int x : st)
        {
            if (x < minn)
            {
                minn = x;
            }
        }
        return minn;
    }
}

class MinStack_better
{
    private Stack<Integer[]> st;

    public MinStack_better()
    {
        st = new Stack<>();
    }

    public void push(int value)
    {
        if (st.isEmpty())
        {
            st.push(new Integer[] { value, value });
            return;
        }

        int mini = Math.min(getMin(), value);
        st.push(new Integer[] { value, mini });
    }

    public void pop()
    {
        st.pop();
    }

    public int top()
    {
        return st.peek()[0];
    }

    public int getMin()
    {
        return st.peek()[1];
    }
}

class MinStack_optimal
{
    private Stack<Integer> st3;
    int minimum = Integer.MAX_VALUE;

    public MinStack_optimal()
    {
        st3 = new Stack<>();
    }

    public void push(int val)
    {
        if (st3.isEmpty())
        {
            st3.push(val);
            minimum = val;
            return;
        }
        else
        {
            st3.push(2*val - minimum);
            minimum = val;
        }
    }

    public void pop()
    {
        int n = st3.peek();
        st3.pop();
        if(n < minimum)
        {
            minimum = (2*minimum - n);
        }
    }

    public int top()
    {
        int n = st3.peek();
        if(minimum < n)return n;

        return minimum;
    }

    public int getMin()
    {
        return minimum;
    }
}
public class SQ03_Min_Stack
{
    public static void main(String[] args)
    {
        MinStack_better mm = new MinStack_better();

        mm.push(10);
        mm.push(8);
        mm.push(15);
        mm.push(2);
        mm.push(20);

        System.out.println("Minimum : "+mm.getMin());
    }
}
