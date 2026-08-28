import java.util.ArrayList;
import java.util.List;

public class H_04_Fractional_Knapsack
{
    public static double fractionalKnapsack(int[] values, int[] weights, int capacity)
    {
        List<List<Double>> items = new ArrayList<>();

        for (int i = 0; i < values.length; i++)
        {
            List<Double> item = new ArrayList<>();

            item.add((double) values[i]);
            item.add((double) weights[i]);
            item.add((double) values[i] / weights[i]);

            items.add(item);
        }

        items.sort((item1, item2) -> Double.compare(item2.get(2), item1.get(2)));

        double totalValue = 0;

        for (int i = 0; i < items.size(); i++)
        {
            double itemWeight = items.get(i).get(1);

            if (capacity >= itemWeight)
            {
                totalValue += items.get(i).get(0);
                capacity -= itemWeight;
            } 
            else
            {
                double value = items.get(i).get(0);
                double weight = items.get(i).get(1);
                
                double fractionValue = (value * capacity) / weight;
                totalValue += fractionValue;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args)
    {
        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        int capacity = 50;

        System.out.println(fractionalKnapsack(values, weights, capacity));
    }
}
