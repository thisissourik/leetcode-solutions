/*
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 */

import java.util.HashMap;

public class Maximum_subarray_sum_equal_K {
    public static void main(String args[]) {
        int num[] = { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
        int k = 3;
        System.out.println(subarraySum(num, k));
    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int prefix_sum = 0;
        int count = 0;

        map.put(0, 1);

        for (int num : nums) {
            prefix_sum += num;
            int target = prefix_sum - k;

            System.out.println("prefix-sum : " + prefix_sum + " prefix-sum - k : " + target);
            // if target is in map -> all ready exist a subarray where the sum of elements
            // upto current is K
            if (map.containsKey(target)) {
                count += map.get(target);
                System.out.println("count : " + count);
            }
            // if target is not in map -> add prefixsum : count
            map.put(prefix_sum, map.getOrDefault(prefix_sum, 0) + 1);
            System.out.println("---------------------------------");
            System.out.println("Putting in map :" + prefix_sum + " -> " + map.get(prefix_sum));
            System.out.println("---------------------------------");
        }
        System.out.println(map);
        return count;
    }
}