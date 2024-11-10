/*
 * 
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
 */

public class Product_of_array_except_self {
    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4 };
        int test[] = { -1, 1, 0, -3, 3 };
        int[] productExceptSelf = productExceptSelf(test);
        for (int ele : productExceptSelf) {
            System.out.println(ele);
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int product[] = new int[nums.length];
        int totPro = 1;
        int zeroPos = -1;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroPos = i;
                zeroCount++;
                continue;

            }
            totPro *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            // more than one zero all products are zero
            if (zeroCount > 1) {
                product[i] = 0;
            } else if (zeroCount == 1) {
                // Exactly one zero, only the zeros will have non zero product
                product[i] = (i == zeroPos) ? totPro : 0;
            } else {
                product[i] = totPro / nums[i];
            }

        }
        return product;
    }
}
