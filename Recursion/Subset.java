
// The solution set must not contain duplicate subsets. Return the solution in any order.

// Example 1:

// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]

import java.util.ArrayList;

public class Subset {
    public static void main(String[] args) {
        int num[] = { 1, 2, 3 };
        ArrayList<Integer> subset = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subset2(num, 0, subset, ans);
        System.out.println(ans);
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        return helper(nums, 0);
    }

    public static void subset2(int nums[], int i, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> ans) {
        // base case
        if (i >= nums.length) {
            ans.add(subset);
            return;
        }
        // include nums[i]
        subset.add(nums[i]);
        subset2(nums, i + 1, subset, ans);
        // exclude subset[i]
        subset.remove(nums[i]);
        subset2(nums, i + 1, subset, ans);
    }

    public static ArrayList<ArrayList<Integer>> helper(int nums[], int i) {
        // base case
        if (i >= nums.length) {
            ArrayList<ArrayList<Integer>> baseCase = new ArrayList<>();
            // adding empty subset []
            baseCase.add(new ArrayList<>());
            return baseCase;
        }

        // store next recursion helper(i+1)
        ArrayList<ArrayList<Integer>> tmp = helper(nums, i + 1);
        // create new arraylist to store the final ans
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // copy tmp to ans
        for (ArrayList<Integer> lst : tmp)
            ans.addLast(new ArrayList<>(lst));

        // add nums[i] to ans
        for (ArrayList<Integer> lst : tmp) {
            ArrayList<Integer> newSubset = new ArrayList<>(lst);
            newSubset.addFirst(nums[i]);
            ans.addLast(newSubset);
        }

        return ans;

    }
}
