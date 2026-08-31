import java.util.*;

public class H_10_Minimum_Platforms_Required
{
    public static int minPlatform_Brute(int arr[], int dep[])
    {
        int[][] trains = new int[arr.length][2];
        int index = 0;

        while (index < arr.length)
        {
            trains[index][0] = arr[index];
            trains[index][1] = dep[index];
            index++;
        }

        int maxPlatforms = 0;

        for (int[] currentTrain : trains)
        {
            int arrivalTime = currentTrain[0];
            int currentPlatforms = 0;

            for (int[] train : trains)
            {
                if (train[0] <= arrivalTime && arrivalTime <= train[1])
                {
                    currentPlatforms++;
                }
            }

            maxPlatforms = Math.max(maxPlatforms, currentPlatforms);
        }

        return maxPlatforms;

        // TC = O(n sq)
        // SC = O(n)
    }

    public static int minPlatform_2(int arr[], int dep[])
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int maxPlatforms = 0;
        int platformsNeeded = 0;

        int i = 0;
        int j = 0;

        while (i < arr.length)
        {
            if (arr[i] <= dep[j])
            {
                platformsNeeded++;
                maxPlatforms = Math.max(platformsNeeded, maxPlatforms);
                i++;
            } else
            {
                platformsNeeded--;
                j++;
            }
        }
        return maxPlatforms;
        // TC = O(n log n)
        // SC = O(1)
    }

    public static void main(String[] args)
    {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

        System.out.println(minPlatform_Brute(arr, dep));
        System.out.println(minPlatform_2(arr, dep));

        System.out.println();

        int arr2[] = { 900, 1235, 1100 };
        int dep2[] = { 1000, 1240, 1200 };
        System.out.println(minPlatform_Brute(arr2, dep2));
        System.out.println(minPlatform_2(arr2, dep2));
    }
}
