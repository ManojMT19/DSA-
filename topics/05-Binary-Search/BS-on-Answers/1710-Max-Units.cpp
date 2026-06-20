#include <bits/stdc++.h>
using namespace std;
int maximumUnits(vector<vector<int>> &boxTypes, int truckSize)
{

    // Sort by units per box in descending order
    sort(boxTypes.begin(), boxTypes.end(),
         [](vector<int> &a, vector<int> &b)
         {
            return a[1] > b[1];
         });

    int totalUnits = 0;
    for (auto &box : boxTypes)
    {
        int numberOfBoxes = box[0];
        int unitsPerBox = box[1];

        int boxesToTake = min(truckSize, numberOfBoxes);

        totalUnits += boxesToTake * unitsPerBox;

        truckSize -= boxesToTake;

        if (truckSize == 0)
            break;
    }

    return totalUnits;
}
int main()
{
    vector<vector<int>>box = {{1,3},{2,2},{3,1}};
    int truckSize = 4;

    cout << maximumUnits(box , truckSize);


    return 0;
}