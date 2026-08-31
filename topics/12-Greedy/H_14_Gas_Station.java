public class H_14_Gas_Station // LeetCode 134
{
    public static int canCompleteCircuit_Brute(int[] gas, int[] cost)
    {
        int n = gas.length;

        for (int startStation = 0; startStation < n; startStation++)
        {
            int currentGas = 0;
            boolean canComplete = true;

            int currentStation = startStation;

            for (int count = 0; count < n; count++)
            {
                currentGas += gas[currentStation];
                currentGas -= cost[currentStation];

                if (currentGas < 0)
                {
                    canComplete = false;
                    break;
                }

                currentStation++;

                if (currentStation == n)
                {
                    currentStation = 0;
                }
            }

            if (canComplete)
            {
                return startStation;
            }
        }

        return -1;
        // TC = O(n sq)
        // SC = O(1)
    }

    public static int canCompleteCircuit_Brute_2(int[] gas, int[] cost)
    {
        int n = gas.length;

        for (int startStation = 0; startStation < n; startStation++)
        {
            int currentGas = 0;
            boolean canComplete = true;

            for (int count = 0; count < n; count++)
            {
                int currentStation = (startStation + count) % n; // only diff is this

                currentGas += gas[currentStation];
                currentGas -= cost[currentStation];

                if (currentGas < 0)
                {
                    canComplete = false;
                    break;
                }
            }

            if (canComplete)
            {
                return startStation;
            }
        }

        return -1;
    }

    public static int canCompleteCircuit_optimal(int[] gas, int[] cost)
    {
        int n = gas.length;
        int totalTank = 0;
        int currentTank = 0;
        int start = 0;

        for (int i = 0; i < n; i++)
        {
            int diff = gas[i] - cost[i];
            totalTank += diff;
            currentTank += diff;

            if (currentTank < 0)
            {
                start = i + 1;
                currentTank = 0;
            }
        }

        return totalTank >= 0 ? start : -1;
    }

    public static void main(String[] args)
    {
        int[] gas = { 1, 2, 3, 4, 5 };
        int[] cost = { 3, 4, 5, 1, 2 };

        System.out.println(canCompleteCircuit_Brute(gas, cost));
        System.out.println(canCompleteCircuit_optimal(gas, cost));
    }
}
