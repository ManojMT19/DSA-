import java.util.Collections;
import java.util.PriorityQueue;

public class H_10_Find_Median_from_Data_Stream  // Leetcode 295
{

}

class MedianFinder
{
    private PriorityQueue<Integer> minheap;
    private PriorityQueue<Integer> maxheap;
    public MedianFinder()
    {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num)
    {
        if(maxheap.isEmpty() || num < maxheap.peek())
        {
            maxheap.offer(num);
        }
        else
        {
            minheap.offer(num);
        }

        if(maxheap.size() > minheap.size() + 1)
        {
            minheap.offer(maxheap.poll());
        }
        else if(minheap.size() > maxheap.size())
        {
            maxheap.offer(minheap.poll());
        }

    }

    public double findMedian()
    {   
        if(maxheap.size() >  minheap.size())
        {
            return maxheap.peek();
        }

        return (maxheap.peek() + minheap.peek()) / 2.0;
    }
}