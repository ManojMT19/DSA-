import java.util.*;

// ===============================
// SUBSTRING & SUBARRAY PATTERNS
// (COMPLETE REFERENCE – Java)
// ===============================

public class Subarray_patterns{

    // ─────────────────────────────────────────────
    // 1. TOTAL NUMBER OF SUBSTRINGS (NO CONDITION)
    // Formula: n*(n+1)/2
    // ─────────────────────────────────────────────
    static int totalSubstrings(int n) {
        return n * (n + 1) / 2;
    }

    // ─────────────────────────────────────────────────────────────────
    // 2.1 COUNT SUBSTRINGS WITH ALL UNIQUE CHARACTERS
    // Sliding window: shrink from left when a duplicate enters
    // For each valid right pointer, (right - left + 1) new substrings end at right
    // ─────────────────────────────────────────────────────────────────
    static int countUniqueSubstrings(String s) {
        int[] freq = new int[256];
        int left = 0, ans = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right)]++;

            // Shrink window until no duplicate
            while (freq[s.charAt(right)] > 1) {
                freq[s.charAt(left)]--;
                left++;
            }
            ans += (right - left + 1);
        }
        return ans;
    }

    // ─────────────────────────────────────────────────────────────────────
    // 2.2 COUNT SUBSTRINGS WITH AT MOST K DISTINCT CHARACTERS
    // Sliding window: track distinct count, shrink when distinct > k
    // ─────────────────────────────────────────────────────────────────────
    static int atMostKDistinct(String s, int k) {
        int[] freq = new int[256];
        int left = 0, distinct = 0, ans = 0;

        for (int right = 0; right < s.length(); right++) {
            if (freq[s.charAt(right)] == 0) distinct++;
            freq[s.charAt(right)]++;

            while (distinct > k) {
                freq[s.charAt(left)]--;
                if (freq[s.charAt(left)] == 0) distinct--;
                left++;
            }
            ans += (right - left + 1);
        }
        return ans;
    }

    // ──────────────────────────────────────────────────────────────────────
    // 2.3 COUNT SUBSTRINGS WITH EXACTLY K DISTINCT CHARACTERS
    // Key trick: exactly(k) = atMost(k) - atMost(k-1)
    // ──────────────────────────────────────────────────────────────────────
    static int exactlyKDistinct(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    // ──────────────────────────────────────────────────────────────────────
    // 3.1 SUBARRAYS WITH SUM = K  (NON-NEGATIVE NUMBERS ONLY)
    // Two pointers work here because all numbers are non-negative,
    // so adding an element always increases/maintains the sum.
    // ──────────────────────────────────────────────────────────────────────
    static int subarraySumKPositive(int[] nums, int k) {
        int left = 0, sum = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > k && left <= right) {
                sum -= nums[left++];
            }
            if (sum == k) count++;
        }
        return count;
    }

    // ──────────────────────────────────────────────────────────────────────
    // 3.2 SUBARRAYS WITH SUM = K  (NEGATIVES ALLOWED)
    // Prefix sum + HashMap trick:
    //   if prefixSum[j] - prefixSum[i] = k, then subarray (i+1 to j) has sum k
    //   => look for (prefixSum - k) in map
    // ──────────────────────────────────────────────────────────────────────
    static int subarraySumK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // empty prefix

        int prefixSum = 0, count = 0;

        for (int x : nums) {
            prefixSum += x;
            count += map.getOrDefault(prefixSum - k, 0);
            map.merge(prefixSum, 1, Integer::sum);
        }
        return count;
    }

    // ──────────────────────────────────────────────────────────────────────
    // 4. BEAUTY SUM (LC 1781)
    // For each substring, beauty = max_freq - min_freq of characters
    // O(n^2 * 26) brute force — not worth optimizing, just know the pattern
    // ──────────────────────────────────────────────────────────────────────
    static int beautySum(String s) {
        int n = s.length(), ans = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int max = 0, min = Integer.MAX_VALUE;
                for (int f : freq) {
                    if (f > 0) {
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                }
                ans += (max - min);
            }
        }
        return ans;
    }

    // ─────────────────────────────────────────────────────────────────
    // 5.1 LONGEST SUBSTRING WITH ALL UNIQUE CHARACTERS
    // Same shrink logic as 2.1, but track max window size
    // ─────────────────────────────────────────────────────────────────
    static int longestUniqueSubstring(String s) {
        int[] freq = new int[256];
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right)]++;

            while (freq[s.charAt(right)] > 1) {
                freq[s.charAt(left)]--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // ─────────────────────────────────────────────────────────────────
    // 5.2 LONGEST SUBSTRING WITH AT MOST K DISTINCT CHARACTERS
    // Same as 2.2, but track max window size
    // ─────────────────────────────────────────────────────────────────
    static int longestAtMostKDistinct(String s, int k) {
        int[] freq = new int[256];
        int left = 0, distinct = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            if (freq[s.charAt(right)] == 0) distinct++;
            freq[s.charAt(right)]++;

            while (distinct > k) {
                freq[s.charAt(left)]--;
                if (freq[s.charAt(left)] == 0) distinct--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // ─────────────────────────────────────────────────────────────────
    // 6.1 FIXED WINDOW – MAXIMUM SUM SUBARRAY OF SIZE K
    // Slide a window of exactly size k; add right, drop left
    // ─────────────────────────────────────────────────────────────────
    static int maxSumSubarrayK(int[] nums, int k) {
        int sum = 0, maxSum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (i >= k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[i - k + 1]; // drop the element going out of window
            }
        }
        return maxSum;
    }

    // ─────────────────────────────────────────────────────────────────
    // 6.2 FIXED WINDOW – MINIMUM SUM SUBARRAY OF SIZE K
    // ─────────────────────────────────────────────────────────────────
    static int minSumSubarrayK(int[] nums, int k) {
        int sum = 0, minSum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (i >= k - 1) {
                minSum = Math.min(minSum, sum);
                sum -= nums[i - k + 1];
            }
        }
        return minSum;
    }

    // ─────────────────────────────────────────────────────────────────
    // 6.3 FIRST NEGATIVE NUMBER IN EVERY WINDOW OF SIZE K
    // Queue stores indices of negative numbers inside the current window
    // ─────────────────────────────────────────────────────────────────
    static int[] firstNegative(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) q.add(i);

            if (i >= k - 1) {
                // Remove indices that have fallen outside the window
                while (!q.isEmpty() && q.peek() < i - k + 1) q.poll();

                ans[idx++] = q.isEmpty() ? 0 : nums[q.peek()];
            }
        }
        return ans;
    }

    // ─────────────────────────────────────────────────────────────────
    // 6.4 MAXIMUM OF ALL SUBARRAYS OF SIZE K (MONOTONIC DEQUE)
    // Deque stores indices in decreasing order of their values.
    // Front = index of max element in current window.
    // ─────────────────────────────────────────────────────────────────
    static int[] maxOfSubarrays(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            // Remove out-of-window index from front
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) dq.pollFirst();

            // Maintain decreasing order: remove smaller elements from back
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();

            dq.addLast(i);

            if (i >= k - 1) ans[idx++] = nums[dq.peekFirst()];
        }
        return ans;
    }

    // ─────────────────────────────────────────────────────────────────────
    // 6.5 COUNT ANAGRAMS IN STRING S OF PATTERN P (LC 438)
    // Fixed window of size p.length(); use a "count" variable to
    // track how many characters still need to be "satisfied".
    // count == 0 means the current window is an anagram.
    // ─────────────────────────────────────────────────────────────────────
    static int countAnagrams(String s, String p) {
        int[] freq = new int[26];
        for (char c : p.toCharArray()) freq[c - 'a']++;

        int left = 0, count = p.length(), ans = 0;

        for (int right = 0; right < s.length(); right++) {
            // If this char is needed (freq > 0), reduce count
            if (freq[s.charAt(right) - 'a']-- > 0) count--;

            if (right - left + 1 == p.length()) {
                if (count == 0) ans++;

                // Slide left: restore the outgoing character
                if (++freq[s.charAt(left) - 'a'] > 0) count++;
                left++;
            }
        }
        return ans;
    }

    // ─────────────────────────────────────────────────────────────────────
    // MAIN – quick sanity checks
    // ─────────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println(totalSubstrings(5));                          // 15
        System.out.println(countUniqueSubstrings("abcabc"));             // 10
        System.out.println(exactlyKDistinct("aabbcc", 2));               // 10
        System.out.println(subarraySumK(new int[]{1, 2, 3, 0, -1, 2}, 3)); // with negatives
        System.out.println(longestUniqueSubstring("abcabcbb"));          // 3
        System.out.println(maxSumSubarrayK(new int[]{2, 1, 5, 1, 3, 2}, 3)); // 9
        System.out.println(Arrays.toString(maxOfSubarrays(new int[]{1,3,-1,-3,5,3,6,7}, 3))); // [3,3,5,5,6,7]
        System.out.println(countAnagrams("cbaebabacd", "abc"));          // 2
    }
}