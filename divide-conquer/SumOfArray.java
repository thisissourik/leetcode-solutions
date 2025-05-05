public class SumOfArray {
    public static void main(String[] args) {
        int arr[] = { 78, 98, 56, 74, 12, -1, 254, 544, 100, 159, 354, 28, 12, 300, 312, 1445, 758 };

        System.out.println(sumOfArray(arr, 0, arr.length - 1));
        System.out.println(sumOfArray1(arr, 0, arr.length - 1));

    }

    public static int sumOfArray(int arr[], int i, int j) {
        if (i == j)
            return arr[i];

        int m = (i + j) / 2;
        return sumOfArray(arr, i, m) + sumOfArray(arr, m + 1, j);

    }

    public static int sumOfArray1(int arr[], int i, int j) {
        if (i == j)
            return arr[i];
        if (i == j - 1)
            return arr[i] + arr[j];

        int m = (i + j) / 2;
        return sumOfArray(arr, i, m) + sumOfArray(arr, m + 1, j);
    }
}