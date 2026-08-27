import java.util.Arrays;

public class H_03_SJF
{
    public static int CPU_Scheduling(int []bt)
    {
        Arrays.sort(bt);

        int wt[] = new int[bt.length];

        wt[0] = 0;
        int time = 0;

        for(int i = 1 ; i < bt.length ; i++)
        {
            wt[i] = wt[i-1] + bt[i-1];
            time += wt[i];
        }
        return time/wt.length;
    }
    

    public static void main(String[] args) 
    {
        // int bt[] = {4,3,7,1,2};
        int bt[] = {1,2,3,4};

        System.out.println(CPU_Scheduling(bt));

    }
}
