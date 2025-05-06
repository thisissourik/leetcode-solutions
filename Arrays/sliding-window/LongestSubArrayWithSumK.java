public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int arr[] = { 2, 5, -1, 7, 10 };
        int k = 14;

        System.out.println(bruteForceApproach(arr, k));
        System.out.println(slidingWindow(arr, k));
    }

    public static int bruteForceApproach(int nums[], int k) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum <= k)
                    maxLength = Math.max(maxLength, j - i + 1);
                else if (sum > k)
                    break;

            }
        }

        return maxLength;
    }

    public static int slidingWindow(int nums[], int k) {
        int sum = 0;
        int l = 0, r = 0;
        int maxLength = 0;

        while (r < nums.length) {
            sum += nums[r];
            while (sum > k) {
                sum = sum - nums[l];
                l++;
            }
            if (sum <= k)
                maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
}
