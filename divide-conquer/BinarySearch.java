public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = { -1, 0, 3, 5, 9, 12 };
        int target = 90;

        System.out.println(binarySearch(arr, target, 0, arr.length - 1));
    }

    public static boolean binarySearch(int arr[], int val, int i, int j) {
        if (i == j)
            if (arr[i] == val)
                return true;
            else
                return false;
        int m = (i + j) / 2;
        return binarySearch(arr, val, i, m) || binarySearch(arr, val, m + 1, j);
    }
}
