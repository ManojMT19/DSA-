import java.util.Arrays;

public class H_20_Max_Units_on_Trucks
{
    public static int maximumUnits(int[][] boxTypes, int truckSize) 
    {
        Arrays.sort(boxTypes,(a,b) -> Integer.compare(b[1], a[1]));

        int remainingCapacity = truckSize;
        int totalUnits = 0;

        for(int box[] : boxTypes)
        {
            int size = box[0];
            int units = box[1];

            int take = Math.min(remainingCapacity, size);

            totalUnits += take*units;
            remainingCapacity -= take;
        }
        return totalUnits;
    }
    public static void main(String[] args)
    {
        int boxTypes[][] = {{1,3},{2,2},{3,1}};
        int trucksize = 4;
        System.out.println(maximumUnits(boxTypes, trucksize));
    }
}
