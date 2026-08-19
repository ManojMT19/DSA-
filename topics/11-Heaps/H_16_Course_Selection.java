import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class H_16_Course_Selection
{
    public static int scheduleCourse(int[][] courses)
    {
        int n = courses.length;
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 0; i < n; i++)
        {
            minheap.offer(new int[] { courses[i][0], courses[i][1] });
        }

        int currentDay = 0;
        int count = 0;
        while (minheap.size() > 0)
        {
            if (currentDay + minheap.peek()[0] <= minheap.peek()[1])
            {
                currentDay += minheap.poll()[0];
                count++;
            }
            else
            {
                return count;
            }
        }
        return count;
    }

    public static int scheduleCourse_optimal(int[][] courses)
    {
        Arrays.sort(courses,(a,b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        int time = 0;

        for (int i = 0; i < courses.length; i++)
        {
            int duration = courses[i][0];
            int deadline = courses[i][1];

            maxheap.offer(duration);
            time += duration;

            if(time > deadline)
            {
                time -= maxheap.poll();
            }
        }
        return maxheap.size();
    }

    public static void main(String[] args) 
    {
        int [][]courses = {{100,200},{200,1300},{1000,1250},{2000,3200}};
        
        System.out.println(scheduleCourse(courses));
        
    }
}
