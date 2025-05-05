public class SearchInArray {
    public static void main(String[] args) {
        int arr[] = { 78, 98, 56, 74, 12, -1, 254, 544, 100, 159, 354, 28, 12, 300, 312, 1445, 758 };

        System.out.println(search(arr, 0, arr.length - 1, 3102));
    }

    public static boolean search(int arr[], int i, int j, int value) {
        if (i == j) {
            if (arr[i] == value)
                return true;

            else
                return false;
        }
        int m = (i + j) / 2;
        return search(arr, i, m, value) || search(arr, m + 1, j, value);
    }
}
