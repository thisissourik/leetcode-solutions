public class MaximumOfArray {
    public static void main(String[] args) {
        int arr[] = { 78, 98, 56, 74, 12, -1, 254, 544, 100, 159, 354, 28, 12, 300, 312, 1445, 758 };

        // int max = maxArray(arr);
        int max = maxArrayDivideConquer(arr, 0, arr.length - 1);
        System.out.println("Maximum : " + max);
    }

    public static int maxArrayDivideConquer(int arr[], int i, int j) {

        if (i == j)
            return arr[i];

        int m = (i + j) / 2;
        int u = maxArrayDivideConquer(arr, i, m);
        int v = maxArrayDivideConquer(arr, m + 1, j);

        return Math.max(u, v);

    }

    public static int maxArray(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}