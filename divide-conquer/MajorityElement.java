import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class MajorityElement {
    public static void main(String[] args) {
        // int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
        int arr[] = { 6,5,5 };
        int majorityElement = majorityElement(arr);
        System.out.println(majorityElement);
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int majority = nums[0];
        int maxCount = 1;

        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);

            if (count > maxCount) {
                maxCount = count;
                majority = num;
            }
        }
        return majority;
    }
}
