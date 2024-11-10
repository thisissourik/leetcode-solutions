public class Merge_sorted_array {
    public static void main(String[] args) {
        int nums1[] = { 7, 6, 8, 0, 0, 0 };
        int m = 3;
        int nums2[] = { 2, 5, 6 };
        int n = 3;
        merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void merge(int nums1[], int m, int nums2[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                System.out.println("Larger element present in nums1 shifted to k");
                // larger element present in nums1
                nums1[k] = nums1[i];
                i--;
            } else {
                // larger element present in nums2
                System.out.println("Larger element present in nums2 shifted to k");
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        // shift remaining elements of nums2 to nums1
        while (j >= 0) {
            System.out.println("Shifting remaining elements of nums2");
            nums1[k--] = nums2[j--];
        }
    }

    public static void shift(int[] nums1, int ptr1) {
        for (int i = ptr1; i < nums1.length; i++) {
            nums1[i + 1] = nums1[i];
        }
    }
}
