import java.util.PriorityQueue;

public class H_08_Minimum_Cost_Connect_Ropes // Leetcode 1167
{
    public static int Minimum_Cost_Connect(int nums[])
    {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for(int n : nums)
        {
            minheap.add(n);
        }

        int  result = 0;
        while (minheap.size() > 1) 
        {
            int a = minheap.poll();
            int b = minheap.poll();
            
            int sum = a+b;

            result += sum;

            minheap.add(sum);
        }
        return result;
    }

    public static void main(String[] args) 
    {
        int nums[] = {2,1,3,5,4};

        System.out.println(Minimum_Cost_Connect(nums));

    }
}
