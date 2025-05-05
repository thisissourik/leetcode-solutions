public class MedianOf2SortedArray {
    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 4 };
        int nums2[] = {};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return calcMedian(nums2);
        if (nums2.length == 0)
            return calcMedian(nums1);
        else
            return 0;
    }

    public static double calcMedian(int nums[]) {
        if (nums.length % 2 == 0)
            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
        else
            return nums[nums.length / 2];
    }
}
