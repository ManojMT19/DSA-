import java.util.*;

public class A15_Arrays_L1 {

    /*
     * -------------------------------------------------------
     * 1. FIND LARGEST ELEMENT IN ARRAY
     * -------------------------------------------------------
     */
    public static int findLargest(int[] arr) {
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /*
     * -------------------------------------------------------
     * 2. SECOND LARGEST (BETTER APPROACH)
     * Time: O(2N)
     * -------------------------------------------------------
     */
    public static void secondLargestBetter(int[] arr) {
        int largest = findLargest(arr);
        int secondLargest = Integer.MIN_VALUE; // handles negative numbers

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        System.out.println("Second Largest (Better): " + secondLargest);
    }

    /*
     * -------------------------------------------------------
     * 3. SECOND LARGEST (OPTIMAL)
     * Time: O(N)
     * -------------------------------------------------------
     */
    public static void secondLargestOptimal(int[] arr) {
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }

            else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        System.out.println("Second Largest (Optimal): " + secondLargest);
    }

    /*
     * -------------------------------------------------------
     * 4. SECOND SMALLEST (OPTIMAL)
     * -------------------------------------------------------
     */
    public static void secondSmallestOptimal(int[] arr) {
        int smallest = arr[0];
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            }

            else if (arr[i] > smallest && arr[i] < secondSmallest) {
                secondSmallest = arr[i];
            }
        }

        System.out.println("Second Smallest: " + secondSmallest);
    }

    /*
     * -------------------------------------------------------
     * 5. CHECK IF ARRAY IS SORTED
     * -------------------------------------------------------
     */
    public static boolean isSorted(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            // if any element is greater than next → not sorted
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    /*
     * -------------------------------------------------------
     * 6. CHECK SORTED AND ROTATED (Leetcode 1752)
     * Example: [3,4,5,1,2]
     * -------------------------------------------------------
     */
    public static boolean isSortedAndRotated(List<Integer> nums) {

        int count = 0;
        int n = nums.size();

        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                count++;
            }
        }

        if (nums.get(n - 1) > nums.get(0)) {
            count++;
        }

        return count <= 1;
    }

    /*
     * -------------------------------------------------------
     * 7. REMOVE DUPLICATES (BRUTE FORCE - O(N^2))
     * -------------------------------------------------------
     */
    public static List<Integer> removeDuplicatesBrute(List<Integer> arr) {

        for (int i = 0; i < arr.size() - 1; i++) {

            if (arr.get(i).equals(arr.get(i + 1))) {
                arr.remove(i);
                i--; // recheck same index
            }
        }

        return arr;
    }

    /*
     * -------------------------------------------------------
     * 8. REMOVE DUPLICATES (TWO POINTER - O(N))
     * returns count of unique elements
     * -------------------------------------------------------
     */
    public static int removeDuplicatesOptimal(int[] arr) {

        int i = 0;

        for (int j = 1; j < arr.length; j++) {

            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }

        return i + 1;
    }

    /*
     * -------------------------------------------------------
     * 9. REMOVE DUPLICATES USING SET
     * -------------------------------------------------------
     */
    public static int removeDuplicatesUsingSet(List<Integer> nums) {

        Set<Integer> set = new HashSet<>(nums);

        nums.clear();
        nums.addAll(set);

        return nums.size();
    }

    /*
     * -------------------------------------------------------
     * 10. REMOVE ELEMENT (TWO POINTER)
     * -------------------------------------------------------
     */
    public static int removeElement(int[] nums, int val) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    /*
     * -------------------------------------------------------
     * 11. CHECK IF POSSIBLE TO SPLIT ARRAY
     * (No element appears more than 2 times)
     * -------------------------------------------------------
     */
    public static boolean canSplitArray(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count > 2) {
                return false;
            }
        }

        return true;
    }

    /*
     * -------------------------------------------------------
     * MAIN METHOD (TESTING)
     * -------------------------------------------------------
     */
    public static void main(String[] args) {

        int[] arr = {-1, -50, 120, 120, 30, 330, 74, 30, 555};

        System.out.println("Largest: " + findLargest(arr));
        secondLargestBetter(arr);
        secondLargestOptimal(arr);
        secondSmallestOptimal(arr);

        System.out.println("Is Sorted: " + isSorted(arr));

        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5, 6));
        System.out.println("Sorted & Rotated: " + isSortedAndRotated(nums));

        int[] dupArr = {1, 1, 2, 2, 3, 3, 4};
        System.out.println("Unique Count: " + removeDuplicatesOptimal(dupArr));

        int[] splitArr = {1, 1, 2, 2, 3, 4, 5, 5};
        System.out.println("Can Split: " + canSplitArray(splitArr));
    }
}